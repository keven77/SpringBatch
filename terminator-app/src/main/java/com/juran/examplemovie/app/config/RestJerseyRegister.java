package com.juran.examplemovie.app.config;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

import com.juran.core.springboot.starter.configs.jersey.ExtendJacksonJsonProvider;
import com.juran.examplemovie.app.resource.v1.AcsD2CasesResource;
import com.juran.examplemovie.app.resource.v1.AcsD3CasesResource;
import com.juran.examplemovie.app.resource.v1.AcsDemandResource;

import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;

/**
 * 
 * @author 王云龙
 * @date 2017年4月21日 上午11:56:08
 * @version 1.0
 * @description jersey服务注册
 *
 */
public class RestJerseyRegister extends ResourceConfig {

	public RestJerseyRegister() {
		register(RequestContextFilter.class);
		//Jersey2和SpringBoot集成有bug,Jersey无法加载scanPackage获得结果
//		packages("com.juran.example.app.resource");
		registerClasses(findRegisterV1Resources());
		
	}
	
	@PostConstruct
	public void initSwagger(){
		//swagger2与Jersey2集成需要添加如下话
		register(ApiListingResource.class);
		register(SwaggerSerializers.class);
		
		register(ExtendJacksonJsonProvider.class);
	}
	
	private Set<Class<?>> findRegisterV1Resources(){
		Set<Class<?>> registerResources=new HashSet<Class<?>>();
		registerResources.add(AcsD2CasesResource.class);
		registerResources.add(AcsD3CasesResource.class);
		registerResources.add(AcsDemandResource.class);
		return registerResources;
	}
}
