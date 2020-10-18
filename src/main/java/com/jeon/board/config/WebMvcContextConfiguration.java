package com.jeon.board.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages= {"com.jeon.board.controller"})
public class WebMvcContextConfiguration extends WebMvcConfigurerAdapter{

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/js/**").addResourceLocations("classpath:/js/").setCachePeriod(600000);
		registry.addResourceHandler("/image/**").addResourceLocations("classpath:/image/").setCachePeriod(600000);
		registry.addResourceHandler("/css/**").addResourceLocations("classpath:/css/").setCachePeriod(600000);
//		registry.addResourceHandler("/js/**").addResourceLocations("classpath:/js/").setCachePeriod(600000).resourceChain(true);
//		registry.addResourceHandler("/image/**").addResourceLocations("classpath:/image/").setCachePeriod(600000).resourceChain(true);
//		registry.addResourceHandler("/css/**").addResourceLocations("classpath:/css/").setCachePeriod(600000).resourceChain(true);
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("main");
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/views/", ".jsp");
	}
//	@Bean
//  public InternalResourceViewResolver getInternalResourceViewResolver() {
//      InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//      resolver.setPrefix("/WEB-INF/views/");
//      resolver.setSuffix(".jsp");
//      return resolver;
//  }
	
	

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginIntercepter());
	}
	

	
}
