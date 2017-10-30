package com.juran.examplemovie.module.controller;

import com.juran.examplemovie.module.dictionary.bean.DictionaryPO;
import com.juran.examplemovie.module.dictionary.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by dell on 2017/10/10.
 */
@Controller
@RequestMapping("/dic")
public class DictionaryController {

    @Autowired
    DictionaryService dictionaryService;

    /**
     * 字典新增
     * @param source
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public String add(DictionaryPO source){
        dictionaryService.insertBean(source);
        return "ok";
    }

}
