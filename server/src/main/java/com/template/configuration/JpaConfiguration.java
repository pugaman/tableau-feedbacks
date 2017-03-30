package com.template.configuration;

import com.template.property.JpaConfigProperties;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.AbstractEntityManagerFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.AbstractPlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by pgolovenkov on 06.03.2017.
 */
//@Configuration
//@EnableJpaRepositories(basePackages = {"com.template.dao.repository"})
//@EnableTransactionManagement
public class JpaConfiguration {

    private static final Logger LOG = Logger.getLogger(JpaConfiguration.class);

    private static final String JPA_PROPERTY_NAME_DEFAULT_SCHEMA = "hibernate.default_schema";
    private static final String JPA_PROPERTY_NAME_DDL_AUTO = "hibernate.hbm2ddl.auto";
    private static final String JPA_PROPERTY_NAME_NAMING_STRATEGY = "hibernate.ejb.naming_strategy";
    private static final String JPA_PROPERTY_NAME_DIALECT = "hibernate.dialect";

    private static final String[] PACKAGES_TO_SCAN_ENTITIES = {"com.template.dao.entity"};

    @Autowired
    JpaConfigProperties jpaConfigProperties;
    @Autowired
    DataSource dataSource;

    @Bean
    AbstractEntityManagerFactoryBean entityManagerFactoryBean(){
        LOG.info("Getting entity manager factory.");

        JpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();

        Properties jpaProperties = new Properties();
        jpaProperties.setProperty(JPA_PROPERTY_NAME_DEFAULT_SCHEMA, this.jpaConfigProperties.getDefaultSchema());
        jpaProperties.setProperty(JPA_PROPERTY_NAME_DDL_AUTO, this.jpaConfigProperties.getDdlAuto());
        jpaProperties.setProperty(JPA_PROPERTY_NAME_NAMING_STRATEGY, this.jpaConfigProperties.getNamingStrategy());
        jpaProperties.setProperty(JPA_PROPERTY_NAME_DIALECT, this.jpaConfigProperties.getDialect());

        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();

        factoryBean.setDataSource(this.dataSource);
        factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        factoryBean.setJpaProperties(jpaProperties);
        factoryBean.setPackagesToScan(PACKAGES_TO_SCAN_ENTITIES);

        LOG.info("Entity manager factory is successfully created.");
        return factoryBean;
    }

    @Bean
    PlatformTransactionManager transactionManager(){
        LOG.info("Getting transaction manager.");
        AbstractPlatformTransactionManager jpaTransactionManager = new JpaTransactionManager(entityManagerFactoryBean().getObject());
        LOG.info("Transaction manager is successfully created.");
        return jpaTransactionManager;
    }


}
