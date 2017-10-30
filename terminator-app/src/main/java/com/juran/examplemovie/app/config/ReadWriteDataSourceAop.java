package com.juran.examplemovie.app.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.juran.core.springboot.starter.configs.mysql.ReadWriteDataSourceContextHolder;


@Component
@Aspect
public class ReadWriteDataSourceAop {
	@Before("execution(* com.juran.examplemovie.app.service.impl..*.find*(..)) or execution(* com.juran.examplemovie.app.service.impl..*.get*(..))  or execution(* com.juran.examplemovie.app.service.impl..*.list*(..))")
	public void setReadDataSourceType() {
		ReadWriteDataSourceContextHolder.read();
	}

	@Before("execution(* com.juran.examplemovie.app.service.impl..*.insert*(..)) or execution(* com.juran.examplemovie.app.service.impl..*.update*(..))")
	public void setWriteDataSourceType() {
		ReadWriteDataSourceContextHolder.write();
	}
}
