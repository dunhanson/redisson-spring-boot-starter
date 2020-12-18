package site.dunhanson.redisson.spring.boot.config;

import lombok.Data;

/**
 * 单节点配置
 * 2020-12-18
 * @author dunhanson
 */
@Data
public class SingleConfig {
    private Integer idleConnectionTimeout;
    private Integer connectTimeout;
    private Integer timeout;
    private Integer retryAttempts;
    private Integer retryInterval;
    private String password;
    private Integer subscriptionsPerConnection;
    private String clientName;
    private String address;
    private Integer subscriptionConnectionMinimumIdleSize;
    private Integer subscriptionConnectionPoolSize;
    private Integer connectionMinimumIdleSize;
    private Integer connectionPoolSize;
    private Integer database;
    private Integer dnsMonitoringInterval;
}
