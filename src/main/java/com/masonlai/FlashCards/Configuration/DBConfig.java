package com.masonlai.FlashCards.Configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.sqlite.SQLiteConfig;

@Configuration
@EnableJpaRepositories(basePackages = "com.masonlai.FlashCards.Model.Repositories")
public class DBConfig {

    @Autowired
    private Environment env;

    @Bean
    public DataSource dataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(env.getProperty("driverClassName"));
        dataSource.setUrl(env.getProperty("url"));
        dataSource.setUsername(env.getProperty("username"));
        dataSource.setPassword(env.getProperty("password"));

        if (env.getProperty("sqlite.config.date_string_format") != null) {
            SQLiteConfig sqLiteConfig = new SQLiteConfig();
            sqLiteConfig.setDateStringFormat(env.getProperty("sqlite.config.date_string_format"));
            dataSource.setConnectionProperties(sqLiteConfig.toProperties());
        }


        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan(new String[]{env.getProperty("dataEntities.location")});
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        em.setJpaProperties(additionalProperties());
        return em;
    }

    final Properties additionalProperties() {
        final Properties properties = new Properties();
        if (env.getProperty("hibernate.hbm2ddl.auto") != null) {
            properties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        }
        if (env.getProperty("hibernate.dialect") != null) {
            properties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
        }
        if (env.getProperty("hibernate.show_sql") != null) {
            properties.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
        }
        if (env.getProperty("hibernate.time_zone") != null) {
            properties.setProperty("hibernate.jdbc.time_zone", env.getProperty("hibernate.time_zone"));
        }
        return properties;
    }

}

