package com.juran.examplemovie.module.d3case.reader;

import com.juran.core.web.response.BasePageRespBean;
import com.juran.examplemovie.module.d3case.bean.D3CasePO;
import com.juran.examplemovie.module.d3case.service.D3Service;
import com.juran.examplemovie.module.utils.ConfigUtil;
import com.juran.examplemovie.module.utils.LogBase;
import com.juran.examplemovie.module.utils.ThreadLocalUtil;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @version V1.0
 * @Author pengbo
 * @Title: 新3d案例数据导入
 * @date 12:13 2017/10/25
 */
@Component
public class D3caseNewItemReader extends LogBase implements ItemReader<List<D3CasePO>> {

    @Autowired
    ConfigUtil configUtil;
    @Autowired
    ThreadLocalUtil threadLocalUtil;
    @Autowired
    D3Service d3Service;

    protected StepExecution stepExecution;

    @BeforeStep
    public void saveStepExecution(StepExecution stepExecution) {
        this.stepExecution = stepExecution;
    }

    @Override
    public List<D3CasePO> read() throws Exception {

        JobParameters jobParameters = stepExecution.getJobParameters();
        String channel = jobParameters.getString("channel");
        Integer limit = configUtil.getLimit();
        Integer currentOffset = threadLocalUtil.getOffset();
        logger.info("---------------------------新导入3D读,渠道:{},OFFSET:{}-------------------------------------", channel, currentOffset);
        BasePageRespBean page = new BasePageRespBean();
        page.setLimit(limit);
        page.setOffset(currentOffset);
        D3CasePO d3CasePO = new D3CasePO();
        d3CasePO.setHandleStatus(0);
        BasePageRespBean<D3CasePO> basePageRespBean = d3Service.getMongoObjectList(d3CasePO, page);
        List<D3CasePO> d3list = basePageRespBean.getData();
        threadLocalUtil.setOffset(currentOffset + limit);
        if (CollectionUtils.isEmpty(d3list)) {
            logger.info("获取新3d案例数量:0,Batch处理结束,渠道:{}.", channel);
            return null;
        }
        logger.info("新3D精选:limit和offset以及size数量:{},{},{},渠道:{}", limit, currentOffset, d3list.size(), channel);
        return d3list;
    }
}
