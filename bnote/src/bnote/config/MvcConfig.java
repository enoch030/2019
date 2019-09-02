package bnote.config;

import org.springframework.context.annotation.Bean;

/*
 * MVC 설정용 클래스.
 * 스프링의 sevlet-context.xml을 대신함.
 *  
 */

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.ConversionServiceExposingInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="bnote.config")
@ComponentScan(basePackages="bnote.controller")
@ComponentScan(basePackages="bnote.service")

public class MvcConfig extends WebMvcConfigurerAdapter { // 인터셉터 추가 하기 위해 상속.

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/view/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
//	
//	// 인터셉터 추가
//	@Override
//		public void addInterceptors(InterceptorRegistry registry) {
//			registry.addInterceptors(new CorsInterceptor());
//		}
	
//	 resource 매핑
	@Override
		public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/images/**").addResourceLocations("/images/","/WEB-INF/resources/images/");
		registry.addResourceHandler("/js/**").addResourceLocations("/js/","/WEB-INF/resources/js/");
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/","/WEB-INF/resources/");
	}
	
	@Bean
	public TilesViewResolver tilesViewResolver() {
//		tilesViewResolver()
		return null;
		
	}
	
}
