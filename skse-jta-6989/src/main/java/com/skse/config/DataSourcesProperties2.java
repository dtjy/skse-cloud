package com.skse.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author jiangyao
 * @Date 2021/2/7 9:13
 **/
@Data
@Component(value = "dataSourcesProperties2")
@ConfigurationProperties(prefix = "mysql.datasource.test2")
public class DataSourcesProperties2 {
    private String url;
    private String username;
    private String password;
    private int minPoolSize;
    private int maxPoolSize;
    private int maxLifetime;
    private int borrowConnectionTimeout;
    private int loginTimeout;
    private int maintenanceInterval;
    private int maxIdleTime;
    private String testQuery;
}
