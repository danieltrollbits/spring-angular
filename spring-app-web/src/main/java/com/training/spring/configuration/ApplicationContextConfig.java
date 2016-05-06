package com.training.spring.configuration;
 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.hibernate.SessionFactory;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder; 
import org.springframework.beans.factory.annotation.Autowired;
import com.training.spring.model.Person;
import com.training.spring.model.Contact;
import com.training.spring.model.Role;
import com.training.spring.model.PersonAudit;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import com.training.spring.aspect.AuditPersonAspect;
import java.util.Properties;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.context.annotation.Import;

@Import({ SecurityConfig.class })
@EnableAspectJAutoProxy
@Configuration
@EnableTransactionManagement
@ComponentScan({"com.training.spring.dao","com.training.spring.service","com.training.spring.configuration"})
public class ApplicationContextConfig {

	@Bean
     public AuditPersonAspect getAuditPersonAspect() {
         return new AuditPersonAspect();
     }

     @Bean
     public SimpleMappingExceptionResolver getSimpleMappingExceptionResolver(){
     	SimpleMappingExceptionResolver simple = new SimpleMappingExceptionResolver();
     	Properties mappings = new Properties();
     	mappings.setProperty("java.lang.RuntimeException","error");
     	simple.setExceptionMappings(mappings);
     	simple.setDefaultErrorView("error");
     	return simple;
     }

	@Bean(name = "dataSource")
	public BasicDataSource getDataSource() {
	    BasicDataSource dataSource = new BasicDataSource();
	    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	    dataSource.setUrl("jdbc:mysql://localhost/exercisedb");
	    dataSource.setUsername("root");
	    dataSource.setPassword("password");
	    return dataSource;
	}
	
	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(BasicDataSource dataSource) {
	    LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
	    sessionBuilder.scanPackages("com.training.spring.model");
	    sessionBuilder.setProperty("hibernate.show_sql", "true");
	    // sessionBuilder.setProperty("hibernate.hbm2dll.auto","create");
	    // sessionBuilder.setProperty("hibernate.hbm2ddl.import_files","admin.sql");
	    sessionBuilder.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
	    return sessionBuilder.buildSessionFactory();
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
	    HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
	    return transactionManager;
	}
 
}