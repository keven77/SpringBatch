package com.juran.examplemovie.app;

import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages={"com.juran.exampleuser.client.feign","com.juran.search.mdm.client.feign"})
@EnableCircuitBreaker
@ComponentScan(basePackages = {"com.juran"})
@ComponentScan(basePackageClasses = DefaultBatchConfigurer.class)
public class AcsTerminationApplication {
    public static void main( String[] args ){
    	SpringApplication.run(AcsTerminationApplication.class, args);
    }
}
