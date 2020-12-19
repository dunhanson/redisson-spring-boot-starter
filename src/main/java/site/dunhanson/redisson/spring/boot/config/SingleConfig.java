package site.dunhanson.redisson.spring.boot.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 单节点配置
 * 2020-12-18
 * @author dunhanson
 */
@Data
@ConfigurationProperties(prefix = "redisson.single-server-config")
public class SingleConfig extends BasicConfig{
    /**
     * 数据库编号
     */
    protected Integer database;
    /**
     * 密码
     */
    private String password;
    /**
     * 节点地址
     */
    private String address;
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
     * DNS监控间隔，单位：毫秒
     */
    private Integer dnsMonitoringInterval;
}
