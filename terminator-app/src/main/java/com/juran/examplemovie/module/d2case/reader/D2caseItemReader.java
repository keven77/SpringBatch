package com.juran.examplemovie.module.d2case.reader;

import com.juran.examplemovie.app.service.IAcsD2CasesService;
import com.juran.examplemovie.client.bean.domain.D2CaseRetrieveRsp;
import com.juran.examplemovie.module.utils.LogBase;
import com.juran.examplemovie.module.utils.ThreadLocalUtil;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author pengbo
 * @version V1.0
 * @Title: 读取审核中的2d案例
 * @date 2017/09/27
 */
@Component
public class D2caseItemReader extends LogBase implements ItemReader<List<D2CaseRetrieveRsp>> {

    @Autowired
    private IAcsD2CasesService d2CasesService;

    @Autowired
    ThreadLocalUtil threadLocalUtil;

    @Override
    public List<D2CaseRetrieveRsp> read() throws Exception {

        List<D2CaseRetrieveRsp> auditReturnCases = d2CasesService.getAuditWatingCases();

        if (CollectionUtils.isEmpty(auditReturnCases)) {
            logger.info("获取2d案例数量:0,终止Batch处理.");
            return null;
        }

        int currentOffset = threadLocalUtil.getOffset();
        logger.info("获取2d审核中案例数量:{},OFFSET:{}.", auditReturnCases.size(), currentOffset);
        if (currentOffset == 500000) {
            logger.info("D2审核中案例-reader执行完毕.");
            return null;
        }
        return auditReturnCases;
    }
}
