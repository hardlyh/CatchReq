package com.req.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages= {"com.req.controller","com.req.filter"})
public class CatchReqConfiguration {

//	@Bean
//	@SuppressWarnings({ "rawtypes", "unchecked" })
//	public FilterRegistrationBean timerFilter() {
//		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//		filterRegistrationBean.setFilter(new CatrhReqFilter());
//		filterRegistrationBean.addUrlPatterns("/*");
//		return filterRegistrationBean;
//	}

}
