package com.juran.examplemovie.module.d3case.reader;

import com.juran.examplemovie.app.service.IAcsD3CasesService;
import com.juran.examplemovie.client.bean.domain.D3CaseRetrieveRsp;
import com.juran.examplemovie.module.utils.ConfigUtil;
import com.juran.examplemovie.module.utils.LogBase;
import com.juran.examplemovie.module.utils.ThreadLocalUtil;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @version V1.0
 * @Author pengbo
 * @Title: 获取普通3d案例
 * @date 17:16 2017/9/28
 */
@Component
@EnableConfigurationProperties(ConfigUtil.class)
public class D3caseNorItemReader extends LogBase implements ItemReader<List<D3CaseRetrieveRsp>> {

    @Autowired
    IAcsD3CasesService d3CasesService;
    @Autowired
    ConfigUtil configUtil;
    @Autowired
    ThreadLocalUtil threadLocalUtil;

    protected StepExecution stepExecution;

    @BeforeStep
    public void saveStepExecution(StepExecution stepExecution) {
        this.stepExecution = stepExecution;
    }

    @Override
    public List<D3CaseRetrieveRsp> read() throws Exception {

        JobParameters parameters = stepExecution.getJobParameters();
        String channel = parameters.getString("channel");

        int currentOffset = threadLocalUtil.getOffset();
        logger.info("---------------------------3D普通读,渠道:{},OFFSET:{}-------------------------------------", channel, currentOffset);
        List<D3CaseRetrieveRsp> allDesignersCases = d3CasesService.getAllDesignersCases(configUtil.getLimit(), currentOffset);
        threadLocalUtil.setOffset(currentOffset + configUtil.getLimit());

        if (CollectionUtils.isEmpty(allDesignersCases)) {
            logger.info("获取普通3d案例数量:0,Batch处理结束,渠道:{}.", channel);
            return null;
        }
        logger.info("3D普通:limit和offset以及size数量:{},{},{},渠道:{}", configUtil.getLimit(), currentOffset, allDesignersCases.size(), channel);
        return allDesignersCases;
    }
}
