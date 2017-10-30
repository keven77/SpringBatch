package com.juran.examplemovie.module.d3case.processor;

import com.juran.examplemovie.client.bean.domain.D3CaseRetrieveRsp;
import com.juran.examplemovie.module.d3case.bean.D3CasePO;
import com.juran.examplemovie.module.utils.LogBase;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @version V1.0
 * @Author pengbo
 * @Title: 处理3d精选案例数据
 * @date 18:09 2017/9/28
 */
@Component
public class D3caseAdminProcessor extends LogBase implements ItemProcessor<List<D3CaseRetrieveRsp>, List<D3CasePO>> {

    @Override
    public List<D3CasePO> process(List<D3CaseRetrieveRsp> d3CaseRetrieveRsps) throws Exception {
        List<D3CasePO> resultList = D3caseBaseProcessorUtil.transformData(d3CaseRetrieveRsps, "brilliant");
        logger.info("3D精选案例处理之前数据量:{},处理后数据量:{}", d3CaseRetrieveRsps.size(), resultList.size());
        return resultList;
    }
}
