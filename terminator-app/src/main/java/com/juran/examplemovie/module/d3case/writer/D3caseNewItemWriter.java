package com.juran.examplemovie.module.d3case.writer;

import com.juran.examplemovie.module.d3case.bean.D3CasePO;
import com.juran.examplemovie.module.d3case.bean.NewD3CasePo;
import com.juran.examplemovie.module.d3case.service.D3NewService;
import com.juran.examplemovie.module.d3case.service.D3Service;
import com.juran.examplemovie.module.utils.LogBase;
import com.juran.examplemovie.module.utils.ThreadLocalUtil;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @version V1.0
 * @Author pengbo
 * @Title:
 * @date 12:13 2017/10/25
 */
@Component
public class D3caseNewItemWriter extends LogBase implements ItemWriter<List<NewD3CasePo>> {

    @Autowired
    D3NewService d3Service;
    @Autowired
    D3Service d3Services;
    @Autowired
    ThreadLocalUtil threadLocalUtil;

    protected StepExecution stepExecution;

    @BeforeStep
    public void saveStepExecution(StepExecution stepExecution) {
        this.stepExecution = stepExecution;
    }

    @Override
    public void write(List<? extends List<NewD3CasePo>> list) throws Exception {
        JobParameters jobParameters = stepExecution.getJobParameters();
        String channel = jobParameters.getString("channel");
        if (CollectionUtils.isEmpty(list)) {
            logger.info("新3D案例写入数据的大小为0");
            return;
        }
        int count = 0;
        int repeatCount = 0;
        for (List<NewD3CasePo> cList : list) {
                for (NewD3CasePo newD3CasePo : cList) {
                    Boolean res = d3Service.insertD3Bean(newD3CasePo);
                    Long caseId = newD3CasePo.getCaseId();
                    D3CasePO d3CasePO = new D3CasePO();
                    d3CasePO.setDesignAssetId(caseId);
                    d3CasePO.setHandleStatus(1);
                    int i = d3Services.updateD3Bean(d3CasePO);
                    if (!res) {
                        repeatCount++;
                    }
                    count = count + list.size();
                }
                //如果操作量=重复量，设置offset500000，目的是让程序停止（全部相同表示之后的所有数据都导入过，没有必要继续进行）
                if (repeatCount == count) {
                    threadLocalUtil.setOffset(500000);
                }
                logger.info("新3D案例操作完成,处理总量:{},成功量:{},重复量:{},渠道:{}.", count, count - repeatCount, repeatCount, channel);

        }
    }
}
