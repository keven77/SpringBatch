package com.juran.examplemovie.app.util;

import com.google.common.collect.Lists;
import com.mongodb.BasicDBObject;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.BasicUpdate;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by dell on 2017/6/9.
 */
public class MDQueryUtil {

    private MDQueryUtil() {
    }

    /**
     * 构建普通查询
     *
     * @param valuesMap
     * @return
     */
    public static BasicQuery getDBObjectByValues(Map<String, Object> valuesMap) {
        BasicDBObject basicDBObject = new BasicDBObject();
        for (Map.Entry<String, Object> entry : valuesMap.entrySet()) {
            basicDBObject.put(entry.getKey(), entry.getValue());
        }
        return new BasicQuery(basicDBObject);
    }

    /**
     * 构建模糊查询
     *
     * @param valuesMap
     * @param likeFields 需要进行模糊查询的字段名称（和mongodb中的字段保持一致）
     * @return
     */
    public static BasicQuery getDBObjectByValuesAndLike(Map<String, Object> valuesMap, List<String> likeFields) {
        BasicDBObject basicDBObject = new BasicDBObject();
        if (CollectionUtils.isEmpty(valuesMap))
            return new BasicQuery(basicDBObject);
        for (Map.Entry<String, Object> entry : valuesMap.entrySet()) {
            if (likeFields.contains(entry.getKey()))
                continue;
            basicDBObject.put(entry.getKey(), entry.getValue());
        }

        List<BasicDBObject> likeList = Lists.newArrayList();
        if (!CollectionUtils.isEmpty(likeFields)) {
            for (String field : likeFields) {
                if (!valuesMap.containsKey(field))
                    continue;
                Object fieldValue = valuesMap.get(field);
                if (fieldValue == null)
                    continue;
                Pattern pattern = Pattern.compile(fieldValue.toString(), Pattern.CASE_INSENSITIVE);
                likeList.add(new BasicDBObject(field, pattern));
                basicDBObject.remove(field);
            }
            if (!CollectionUtils.isEmpty(likeList)) {
                basicDBObject.put("$or", likeList);
            }
        }
        return new BasicQuery(basicDBObject);
    }

    /**
     * 构造普通更新
     *
     * @param valuesMap
     * @return
     */
    public static BasicUpdate getUpdateByValues(Map<String, Object> valuesMap) {
        BasicDBObject basicDBObject = new BasicDBObject();
        BasicDBObject valueObject = new BasicDBObject();
        for (Map.Entry<String, Object> entry : valuesMap.entrySet()) {
            valueObject.put(entry.getKey(), entry.getValue());
        }
        basicDBObject.put("$set", valueObject);
        return new BasicUpdate(basicDBObject);
    }

}
