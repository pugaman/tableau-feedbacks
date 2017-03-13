package com.template.property;

import org.apache.log4j.Logger;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by pgolovenkov on 06.03.2017.
 */
@Component
@ConfigurationProperties(prefix = "datasource")
public class DataSourceProperties {

    private static final Logger LOG = Logger.getLogger(DataSourceProperties.class);

    private static String DEFAULT_URL = "";
    private static String DEFAULT_USERNAME = "";
    private static String DEFAULT_PASSWORD = "";
    private static String DEFAULT_DRIVER_CLASS_NAME = "";

    private String url;
    private String username;
    private String password;
    private String driverClassName;

    @PostConstruct
    private void init(){
        if(getUrl() == null){
            LOG.warn("Url is not set. Setting default value.");
            setUrl(DEFAULT_URL);
        }
        if(getUsername() == null){
            LOG.warn("Username is not set. Setting default value.");
            setUsername(DEFAULT_USERNAME);
        }
        if(getPassword() == null){
            LOG.warn("Password is not set. Setting default value.");
            setPassword(DEFAULT_PASSWORD);
        }
        if(getDriverClassName() == null){
            LOG.warn("Driver Class Name is not set. Setting default value.");
            setDriverClassName(DEFAULT_DRIVER_CLASS_NAME);
        }
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }
}
