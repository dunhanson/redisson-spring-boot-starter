package site.dunhanson.redisson.spring.boot.config;

import lombok.Data;

/**
 * 单节点配置
 * 2020-12-18
 * @author dunhanson
 */
@Data
public class SingleConfig {
    /**
     * 连接空闲超时，单位：毫秒
     */
    private Integer idleConnectionTimeout;
    /**
     * 连接超时，单位：毫
     */
    private Integer connectTimeout;
    /**
     * 命令等待超时，单位：毫秒
     */
    private Integer timeout;
    /**
     * 命令失败重试次数
     */
    private Integer retryAttempts;
    /**
     * 命令重试发送时间间隔，单位：毫秒
     */
    private Integer retryInterval;
    /**
     * 密码
     */
    private String password;
    /**
     * 单个连接最大订阅数量
     */
    private Integer subscriptionsPerConnection;
    /**
     * 客户端名称
     */
    private String clientName;
    /**
     * 节点地址
     */
    private String address;
    /**
     * 发布和订阅连接的最小空闲连接数
     */
    private Integer subscriptionConnectionMinimumIdleSize;
    /**
     * 发布和订阅连接池大小
     */
    private Integer subscriptionConnectionPoolSize;
    /**
     * 最小空闲连接数
     */
    private Integer connectionMinimumIdleSize;
    /**
     * 发布和订阅连接池大小
     */
    private Integer connectionPoolSize;
    /**
     * 数据库编号
     */
    private Integer database;
    /**
     * DNS监控间隔，单位：毫秒
     */
    private Integer dnsMonitoringInterval;
}
