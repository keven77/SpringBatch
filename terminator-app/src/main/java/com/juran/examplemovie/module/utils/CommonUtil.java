package com.juran.examplemovie.module.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.juran.core.log.contants.LoggerName;
import com.juran.core.utils.http.HttpSendUtil;
import com.juran.core.utils.http.bean.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

/**
 * Created by dell on 2017/10/11.
 */
public class CommonUtil {

    private static final Logger logger = LoggerFactory.getLogger(LoggerName.INFO);

    public static String getAvatarByUid(String uid) {
        String accessUrl = "http://admin.shejijia.com/ums/v1.0/user/" + uid;
        HttpResponse response = HttpSendUtil.sendHttpGet(accessUrl);
        int status = response.getStatus();
        if (status == 200) {
            JSONObject object = JSON.parseObject(response.getContent());
            JSONObject pObject = (JSONObject) object.get("profile");
            if (!StringUtils.isEmpty(pObject)) {
                String avatar = (String) pObject.get("avatar");
                if (StringUtils.isEmpty(avatar)) {
                    logger.info("返回数据无头像,uid:{}", uid);
                    return "http://img.shejijia.com/img/59ddc45be4b0bb9dc532e466.img";//默认头像
                }
                return avatar;
            } else {
                logger.info("接口返回错误");
                return null;
            }
        } else {
            logger.info("请求接口错误,请求地址:{}", accessUrl);
            return null;
        }
    }

}
