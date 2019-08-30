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
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.ConversionServiceExposingInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="bnote")

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
}
