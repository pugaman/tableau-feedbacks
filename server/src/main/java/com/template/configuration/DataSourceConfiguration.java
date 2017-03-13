package com.template.configuration;

import com.template.property.DataSourceProperties;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created by pgolovenkov on 06.03.2017.
 */
@Configuration
public class DataSourceConfiguration {

    private static final Logger LOG = Logger.getLogger(DataSourceConfiguration.class);

    @Autowired
    DataSourceProperties dataSourceProperties;

    @Bean
    DataSource dataSource() {
        LOG.info("Getting data source.");

        org.apache.tomcat.jdbc.pool.DataSource dataSource = new org.apache.tomcat.jdbc.pool.DataSource();

        dataSource.setUrl(this.dataSourceProperties.getUrl());
        dataSource.setUsername(this.dataSourceProperties.getUsername());
        dataSource.setPassword(this.dataSourceProperties.getPassword());
        dataSource.setDriverClassName(this.dataSourceProperties.getDriverClassName());

        dataSource.setTestOnBorrow(true);
        dataSource.setValidationQuery("Select 1");

        LOG.info("Data source is successfully created.");

        return dataSource;
    }


}
