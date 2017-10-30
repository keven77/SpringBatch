package com.juran.examplemovie.module.d3case.processor;

import com.google.common.collect.Lists;
import com.juran.examplemovie.module.d3case.bean.*;
import com.juran.examplemovie.module.utils.LogBase;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

/**
 * @version V1.0
 * @Author pengbo
 * @Title: 新3d案例数据处理
 * @date 14:40 2017/10/25
 */
@Component
public class NewD3caseProcessor extends LogBase implements ItemProcessor<List<D3CasePO>, List<NewD3CasePo>> {
    @Override
    public List<NewD3CasePo> process(List<D3CasePO> d3CasePOS) throws Exception {
        List<NewD3CasePo> targetList = Lists.newArrayList();
        for (D3CasePO source : d3CasePOS) {
            NewD3CasePo target = new NewD3CasePo();
            BeanUtils.copyProperties(source, target);
            target.setCaseId(source.getDesignAssetId());
            target.setStorageStatus(source.getCustomStringIsStorage().equals("Y") ? 0 : 1);
            target.setDisplay(source.getDisplay() ? 1 : 0);
            target.setCaseCover(source.getThumbnailMainPath());
            target.setBrilliant(source.getSampleRoom() ? 1 : 0);
            target.setHandleStatus(1);

            List<D3FileInfo> naviList = source.getNaviPanos();
            if (!CollectionUtils.isEmpty(naviList)) {
                D3FileInfo num = naviList.get(0);
                List<NewD3FileInfo> newlist = Lists.newArrayList();
                NewD3FileInfo targetFile = new NewD3FileInfo();
                targetFile.setDescription(num.getDescription());
                targetFile.setSelectedImageIds(num.getSourceId());
                newlist.add(targetFile);
                target.setNaviPanos(newlist);
            } else {
                target.setNaviPanos(Collections.emptyList());
            }

            List<D3SpaceInfo> list = source.getRenderingImages();
            List<NewD3SpaceInfo> resultList = Lists.newArrayList();
            for (D3SpaceInfo sourceSpace : list) {
                NewD3SpaceInfo targetSpace = new NewD3SpaceInfo();
                targetSpace.setRoomTypeCode(sourceSpace.getTypeKey());
                targetSpace.setDescription(sourceSpace.getDescription());
                List<D3FileInfo> d3fileInfoList = sourceSpace.getData();
                targetSpace.setSelectedImageIds(this.transform(d3fileInfoList));
                resultList.add(targetSpace);
            }
            target.setSpaceDetails(resultList);
            targetList.add(target);
        }
        return targetList;
    }

    public String transform(List<D3FileInfo> list) {
        StringBuffer sb = new StringBuffer();
        for (D3FileInfo d3FileInfo : list) {
            String sourceId = d3FileInfo.getSourceId();
            sb.append(sourceId + ",");
        }
        return sb.toString().substring(0, sb.toString().length() - 1);
    }
}
