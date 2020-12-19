package site.dunhanson.redisson.spring.boot.config;

import lombok.Data;
import org.redisson.config.ReadMode;
import org.redisson.config.SubscriptionMode;
import org.redisson.connection.balancer.LoadBalancer;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 哨兵模式配置
 * 2020-12-19
 * @author dunhanson
 */
@Data
@ConfigurationProperties(prefix = "redisson.sentinel-servers-config")
public class SentinelConfig extends BasicConfig{
    /**
     * 数据库编号
     */
    protected Integer database;
    /**
     * dnsMonitoringInterval（DNS监控间隔，单位：毫秒）
     */
    private Integer dnsMonitoringInterval;
    /**
     * masterName（主服务器的名称）
     */
    private String masterName;
    /**
     * sentinelAddress（添加哨兵节点地址）
     */
    private String[] sentinelAddress;
    /**
     * readMode（读取操作的负载均衡模式）
     */
    private ReadMode readMode;
    /**
     * subscriptionMode（订阅操作的负载均衡模式）
     */
    private SubscriptionMode subscriptionMode;
    /**
     * loadBalancer（负载均衡算法类的选择）
     */
    private LoadBalancer loadBalancer;
    /**
     * subscriptionConnectionMinimumIdleSize（从节点发布和订阅连接的最小空闲连接数）
     */
    private Integer subscriptionConnectionMinimumIdleSize;
    /**
     * subscriptionConnectionPoolSize（从节点发布和订阅连接池大小）
     */
    private Integer subscriptionConnectionPoolSize;
    /**
     * slaveConnectionMinimumIdleSize（从节点最小空闲连接数）
     */
    private Integer slaveConnectionMinimumIdleSize;
    /**
     * slaveConnectionPoolSize（从节点连接池大小）
     */
    private Integer slaveConnectionPoolSize;
    /**
     * masterConnectionMinimumIdleSize（主节点最小空闲连接数）
     */
    private Integer masterConnectionMinimumIdleSize;
    /**
     * masterConnectionPoolSize（主节点连接池大小）
     */
    private Integer masterConnectionPoolSize;
}
