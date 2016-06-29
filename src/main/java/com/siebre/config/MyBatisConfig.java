package com.siebre.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ 
	MyBatisAnnotationConfig.class/*,
	MyBatisXmlConfig.class*/
	})
public class MyBatisConfig {
	
	/*@Autowired
	private DataSource dataSource;
	
	@Bean
	SqlSessionFactoryBean sqlSessionFactory() {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		System.out.println("sqlSessionFactory dataSource config " + dataSource);
		factoryBean.setDataSource(dataSource);
		return factoryBean;
	}*/
}
