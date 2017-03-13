package com.template.property;

import org.apache.log4j.Logger;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by pgolovenkov on 06.03.2017.
 */
@Component
@ConfigurationProperties(prefix = "jpa")
public class JpaConfigProperties {

    private static final Logger LOG = Logger.getLogger(JpaConfigProperties.class);

    private static final String DEFAULT_DEFAULT_SCHEMA = "";
    private static final String DEFAULT_DDL_AUTO = "";
    private static final String DEFAULT_NAMING_STRATEGY = "";
    private static final String DEFAULT_DIALECT = "";

    private String defaultSchema;
    private String ddlAuto;
    private String namingStrategy;
    private String dialect;

    @PostConstruct
    private void init() {
        if (getDefaultSchema() == null) {
            LOG.warn("Default Schema is not set. Setting default value.");
            setDefaultSchema(DEFAULT_DEFAULT_SCHEMA);
        }
        if (getDdlAuto() == null) {
            LOG.warn("DDL AUTO is not set. Setting default value.");
            setDdlAuto(DEFAULT_DDL_AUTO);
        }
        if (getNamingStrategy() == null) {
            LOG.warn("Naming Strategy is not set. Setting default value.");
            setNamingStrategy(DEFAULT_NAMING_STRATEGY);
        }
        if (getDialect() == null) {
            LOG.warn("Dialect is not set. Setting default value.");
            setDialect(DEFAULT_DIALECT);
        }
    }

    public String getDefaultSchema() {
        return defaultSchema;
    }

    public void setDefaultSchema(String defaultSchema) {
        this.defaultSchema = defaultSchema;
    }

    public String getDdlAuto() {
        return ddlAuto;
    }

    public void setDdlAuto(String ddlAuto) {
        this.ddlAuto = ddlAuto;
    }

    public String getNamingStrategy() {
        return namingStrategy;
    }

    public void setNamingStrategy(String namingStrategy) {
        this.namingStrategy = namingStrategy;
    }

    public String getDialect() {
        return dialect;
    }

    public void setDialect(String dialect) {
        this.dialect = dialect;
    }
}
