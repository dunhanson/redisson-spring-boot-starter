package site.dunhanson.redisson.spring.boot.config;

import lombok.Data;

/**
 * 公用配置
 * 2020-12-19
 * @author dunhanson
 */
@Data
public class BasicConfig {
    /**
     * 连接空闲超时，单位：毫秒
     */
    protected Integer idleConnectionTimeout;
    /**
     * 连接超时，单位：毫秒
     */
    protected Integer connectTimeout;
    /**
     * 命令等待超时，单位：毫秒
     */
    protected Integer timeout;
    /**
     * 命令失败重试次数
     */
    protected Integer retryAttempts;
    /**
     * 命令重试发送时间间隔，单位：毫秒
     */
    protected Integer retryInterval;
    /**
     * 密码
     */
    protected String password;
    /**
     * 单个连接最大订阅数量
     */
    protected Integer subscriptionsPerConnection;
    /**
     * 客户端名称
     */
    protected String clientName;
    /**
     * 发布和订阅连接的最小空闲连接数
     */
    protected Integer subscriptionConnectionMinimumIdleSize;
    /**
     * 发布和订阅连接池大小
     */
    protected Integer subscriptionConnectionPoolSize;
    /**
     * DNS监控间隔，单位：毫秒
     */
    protected Long dnsMonitoringInterval;
}
