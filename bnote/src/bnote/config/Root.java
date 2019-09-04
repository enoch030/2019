package bnote.config;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * 루트 설정용 클래스.
 * 이 클래스는 스프링의 root-context.xml 의 역할을 대신한다.
 */

@Configuration
public class Root {

	@Value("${jdbc.driverClassName}")
	private String jdbcDriverClassName;
	
	@Value("${jdbc.url}")
	private String jdbcUrl;
	
	@Value("${jdbc.usernave}")
	private String jdbcUsername;
	
	@Value("${jdbc.password}")
	private String jdbcPassword;

//	private static final String APP_CONFIG_FILE_PATH = "applicatrion.xml";
	
    /**
     * 프로퍼티 홀더는 다른 빈들이 사용하는 프로퍼티들을 로딩하기 때문에, static 메소드로 실행된다.
     * 다른 일반 빈들이 만들어지기전에 먼저 만들어져야 한다.
     */
/*	
	@Bean
	public static PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
		PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
		ppc.setLocations(new Resource[] {new ClassPathResource(APP_CONFIG_FILE_PATH)});
		return ppc;
	}
*/

/*	public DataSource dataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(this.jdbcDriverClassName);
		ds.setUrl(this.jdbcUrl);
		ds.setUsername(this.jdbcUsername);
		ds.setPassword(this.jdbcPassword);
		return ds;
	}*/

	public DataSource driverManagerDataSource() {
		
		return null;
	}
}
