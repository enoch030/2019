package bnote.config;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

/*
 * WebApplicationInitializer 를 상속하면, 서블릿 컨테이너가 실행될 때 onStartup() 메소드가 자동으로 호출된다.
 * 이 클래스는 web.xml 의 역할을 대신하거나 보충한다.
 *
 */

public class Initializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletCtx) throws ServletException {
		AnnotationConfigWebApplicationContext rootCtx = new AnnotationConfigWebApplicationContext();
		rootCtx.register(Root.class);

		// Manage the lifecycle of the root application context
		servletCtx.addListener(new ContextLoaderListener(rootCtx));
		
		this.addDispatcherServlet(servletCtx);
		this.addUtf8CharacterEncodingFilter(servletCtx);
	}
	
/*
 *  Dispatcher Servlet 추가.
 *  CORS 를 가능하게 하기 위해서 dispatchOptionsRequest 설정을 true 로 한다. (난 안 함! CORS(Cross-Origin Resource Sharing)이 뭐하는 건데?)
 */

	private void addDispatcherServlet(ServletContext servletCtx) {
		AnnotationConfigWebApplicationContext app = new AnnotationConfigWebApplicationContext();
		app.getEnvironment().addActiveProfile("production");
		app.register(MvcConfig.class);
		
		// Register and map the dispatcher servlet
		ServletRegistration.Dynamic dispatcher = servletCtx.addServlet("dispatcher",	 new DispatcherServlet(app));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
//		dispatcher.setInitParameter("dispatchOptionsRequest", "true"); // CORS를 위해 option request 도 받아들인다.
	}
	
/*
 *  UTF-8 캐릭터 인코딩 필터 추가.
 */
	
	private void addUtf8CharacterEncodingFilter(ServletContext servletCtx) {
		FilterRegistration.Dynamic filter = servletCtx.addFilter("CHARACTER_ENCODING_FILTER",CharacterEncodingFilter.class);
		filter.setInitParameter("encoding", "UTF-8");
		filter.setInitParameter("forceEncoding", "true");
		filter.addMappingForUrlPatterns(null, false, "/*");
	}
}


