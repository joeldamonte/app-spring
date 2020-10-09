package com.prueba.tecnica;

import java.util.Properties;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@ComponentScan(basePackages = "com.prueba.tecnica")
@EnableJpaRepositories(basePackages = "com.prueba.tecnica.dao")
public class CarritoConfig {

	
	@Value("${datasource.driver-class-name}")
	private String databaseDriverSqlServer;
	@Value("${datasource.url}")
	private String databaseUrlSqlServer;
	@Value("${datasource.data-username}")
	private String databaseUsernameSqlServer;
	@Value("${datasource.data-password}")
	private String databasePasswordSqlServer;	
	
	
	@Bean(name = "DataSource")
	public DataSource dataSourceSqlServer() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(databaseDriverSqlServer);
		dataSource.setUrl(databaseUrlSqlServer);
		dataSource.setUsername(databaseUsernameSqlServer);
		dataSource.setPassword(databasePasswordSqlServer);
		
		return dataSource;
	}
	
	@Bean
	public JpaVendorAdapter jpaVendorAdapter2() {
		HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		jpaVendorAdapter.setDatabase(Database.SQL_SERVER);
		jpaVendorAdapter.setGenerateDdl(true);
		jpaVendorAdapter.setShowSql(false);
		jpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.SQLServer2008Dialect");
		return jpaVendorAdapter;
	}

	@Bean(name="entityManagerFactorySqlServer")
	@Qualifier(value="entityManagerFactorySqlServer")
	public LocalContainerEntityManagerFactoryBean entityManagerFactorySqlServer() throws NamingException {

		LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
		lef.setPackagesToScan("com.prueba.tecnica.entity");
		lef.setDataSource(dataSourceSqlServer());
		lef.setJpaVendorAdapter(jpaVendorAdapter2());
		lef.setJpaProperties(new Properties());
		
		return lef;
	}
	
}
