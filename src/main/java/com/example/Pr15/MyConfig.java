package com.example.Pr15;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableAutoConfiguration
//@EntityScan(basePackageClasses=User.class)
public class MyConfig {

    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/nastya");
        config.setUsername("nastya");
        config.setPassword("1234");
        return new HikariDataSource(config);
    }

    @Bean(name="entityManagerFactory")
    public LocalSessionFactoryBean factoryBean(DataSource
                                                       dataSource) {
        LocalSessionFactoryBean sessionFactoryBean = new
                LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setPackagesToScan("com.example.Pr15");
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect",
                "org.hibernate.dialect.PostgreSQLDialect");
        sessionFactoryBean.setHibernateProperties(properties);
        return sessionFactoryBean;
    }


    @Bean
    public PlatformTransactionManager platformTransactionManager(LocalSessionFactoryBean factoryBean){
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(factoryBean.getObject());
        return transactionManager;
    }

    Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        return properties;
    }
}
