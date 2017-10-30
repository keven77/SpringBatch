package com.juran.examplemovie.module.d2case.reader;

import com.juran.examplemovie.app.service.IAcsD2CasesService;
import com.juran.examplemovie.client.bean.domain.D2CaseRetrieveRsp;
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
 * @author pengbo
 * @version V1.0
 * @Title: 读取成功的2d案例
 * @date 2017/09/28 10:00
 */
@Component
public class D2caseSucItemReader extends LogBase implements ItemReader<List<D2CaseRetrieveRsp>> {

    protected StepExecution stepExecution;

    @BeforeStep
    public void saveStepExecution(StepExecution stepExecution) {
        this.stepExecution = stepExecution;
    }

    @Autowired
    private IAcsD2CasesService d2CasesService;
    @Autowired
    ConfigUtil configUtil;
    @Autowired
    ThreadLocalUtil threadLocalUtil;

    @Override
    public List<D2CaseRetrieveRsp> read() throws Exception {

        JobParameters parameters = stepExecution.getJobParameters();
        String channel = parameters.getString("channel");

        int currentOffset = threadLocalUtil.getOffset();
        logger.info("---------------------------2D成功案例普通读,渠道:{},OFFSET:{}-------------------------------------", channel, currentOffset);
        List<D2CaseRetrieveRsp> auditReturnCases = d2CasesService.getAuditSuccessCases(configUtil.getLimit(), currentOffset);
        threadLocalUtil.setOffset(currentOffset + configUtil.getLimit());

        if (CollectionUtils.isEmpty(auditReturnCases)) {
            logger.info("获取成功的2d案例数量:0,Batch处理结束.");
            return null;
        }

        logger.info("2D成功案例普通:limit和offset以及size数量:{},{},{},渠道:{}", configUtil.getLimit(), currentOffset, auditReturnCases.size(), channel);
        return auditReturnCases;
    }
}
