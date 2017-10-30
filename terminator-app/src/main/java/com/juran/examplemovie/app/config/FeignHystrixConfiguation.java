package com.juran.examplemovie.app.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages={"com.juran.exampleuser.client.feign","com.juran.search.mdm.client.feign"})
public class FeignHystrixConfiguation {

}
