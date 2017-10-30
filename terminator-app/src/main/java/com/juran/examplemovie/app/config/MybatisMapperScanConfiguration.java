package com.juran.examplemovie.app.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = { "com.juran.examplemovie.app.dao.mapper" })
public class MybatisMapperScanConfiguration {
	
}
