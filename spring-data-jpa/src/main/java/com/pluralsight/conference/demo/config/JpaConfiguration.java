package com.pluralsight.conference.demo.config;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.dialect.Oracle12cDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.jdbc.DataSourceBuilder;

@Configuration
public class JpaConfiguration {
    @Value("${db.username}")
    private String username;

    @Value("${db.password}")
    private String password;

    @Bean
    public DataSource customDataSource() {
        DataSourceBuilder builder = DataSourceBuilder.create();
        builder.url("jdbc:oracle:thin:@localhost:1521:xe");
        builder.username(username);
        builder.password(password);

        System.out.println("customDataSource() bean has been initialized...");
        return builder.build();
    }


    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(Oracle12cDialect.class.getName());
        dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        System.out.println("getDataSource() bean has been initialized...");
        return dataSource;
    }

    @Bean
    public Map<String, Object> jpaProperties() {
        Map<String, Object> props = new HashMap<String, Object>();
        props.put("hibernate.dialect", Oracle12cDialect.class.getName());
		//props.put("hibernate.cache.provider_class", HashtableCacheProvider.class.getName());
        return props;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setShowSql(true);
        hibernateJpaVendorAdapter.setGenerateDdl(true);
        hibernateJpaVendorAdapter.setDatabase(Database.H2);
        return hibernateJpaVendorAdapter;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager( entityManagerFactory().getObject() );
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
        lef.setDataSource(this.getDataSource());
        lef.setJpaPropertyMap(this.jpaProperties());
        lef.setJpaVendorAdapter(this.jpaVendorAdapter());
        return lef;
    }
}
