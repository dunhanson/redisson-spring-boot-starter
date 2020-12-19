package site.dunhanson.redisson.spring.boot.utils;

import org.apache.commons.lang3.StringUtils;
import org.redisson.client.codec.Codec;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.redisson.config.TransportMode;
import site.dunhanson.redisson.spring.boot.config.RedissonConfig;
import site.dunhanson.redisson.spring.boot.config.SingleConfig;
import site.dunhanson.redisson.spring.boot.constant.RedissonConstant;

/**
 * redisson工具类
 * 2020-12-18
 * @author dunhanson
 */
public class RedissonUtils {

    /**
     * 创建Config通过RedissonConfig
     * @param redissonConfig
     * @return
     */
    public static Config createConfig(RedissonConfig redissonConfig) {
        Config config = new Config();
        initConfig(config, redissonConfig);
        if(redissonConfig.getSingleServerConfig() != null) {
            initSingleServerConfig(config.useSingleServer(), redissonConfig.getSingleServerConfig());
        } else {
            config.useSingleServer().setAddress(RedissonConstant.DEFAULT_ADDRESS);
        }
        return config;
    }

    /**
     * 初始化Config
     * @param config
     * @param redissonConfig
     */
    public static void initConfig(Config config, RedissonConfig redissonConfig) {
        Integer threads = redissonConfig.getThreads();
        // threads（线程池数量）
        if(threads != null) {
            config.setThreads(threads);
        }
        // nettyThreads （Netty线程池数量）
        Integer nettyThreads = redissonConfig.getNettyThreads();
        if(nettyThreads != null) {
            config.setNettyThreads(nettyThreads);
        }
        // nettyThreads （Netty线程池数量）
        TransportMode transportMode = redissonConfig.getTransportMode();
        if(transportMode != null) {
            config.setTransportMode(transportMode);
        }
        Codec codec = redissonConfig.getCodec();
        if(codec != null) {
            config.setCodec(codec);
        }
    }

    /**
     * 初始化单节点服务
     * @param serverConfig SingleServerConfig
     * @param singleConfig 单节点配置
     */
    public static void initSingleServerConfig(SingleServerConfig serverConfig, SingleConfig singleConfig) {
        // idleConnectionTimeout（连接空闲超时，单位：毫秒）
        Integer idleConnectionTimeout = singleConfig.getIdleConnectionTimeout();
        if(idleConnectionTimeout != null) {
            serverConfig.setIdleConnectionTimeout(idleConnectionTimeout);
        }
        // connectTimeout（连接超时，单位：毫秒）
        Integer connectTimeout = singleConfig.getConnectTimeout();
        if(connectTimeout != null) {
            serverConfig.setConnectTimeout(connectTimeout);
        }
        // timeout（命令等待超时，单位：毫秒）
        Integer timeout = singleConfig.getTimeout();
        if(timeout != null) {
            serverConfig.setTimeout(timeout);
        }
        // retryAttempts（命令失败重试次数）
        Integer retryAttempts = singleConfig.getRetryAttempts();
        if(retryAttempts != null) {
            serverConfig.setRetryAttempts(retryAttempts);
        }
        // retryInterval（命令失败重试次数）
        Integer retryInterval = singleConfig.getRetryInterval();
        if(retryInterval != null) {
            serverConfig.setRetryInterval(retryInterval);
        }
        // password（密码）
        String password = singleConfig.getPassword();
        if(StringUtils.isNotBlank(password)) {
            serverConfig.setPassword(password);
        }
        // subscriptionsPerConnection（单个连接最大订阅数量）
        Integer subscriptionsPerConnection = singleConfig.getSubscriptionsPerConnection();
        if(subscriptionsPerConnection != null) {
            serverConfig.setSubscriptionsPerConnection(subscriptionsPerConnection);
        }
        // clientName（客户端名称）
        String clientName = singleConfig.getClientName();
        if(StringUtils.isNotBlank(clientName)) {
            serverConfig.setClientName(clientName);
        }
        // address（节点地址）
        String address = singleConfig.getAddress();
        if(StringUtils.isNotBlank(address)) {
            serverConfig.setAddress(address);
        }
        // subscriptionConnectionMinimumIdleSize（发布和订阅连接的最小空闲连接数）
        Integer subscriptionConnectionMinimumIdleSize = singleConfig.getSubscriptionConnectionMinimumIdleSize();
        if(subscriptionConnectionMinimumIdleSize != null) {
            serverConfig.setSubscriptionConnectionMinimumIdleSize(subscriptionConnectionMinimumIdleSize);
        }
        // subscriptionConnectionPoolSize（发布和订阅连接池大小）
        Integer subscriptionConnectionPoolSize = singleConfig.getSubscriptionConnectionPoolSize();
        if(subscriptionConnectionPoolSize != null) {
            serverConfig.setSubscriptionConnectionPoolSize(subscriptionConnectionPoolSize);
        }
        // connectionMinimumIdleSize（最小空闲连接数）
        Integer connectionMinimumIdleSize = singleConfig.getConnectionMinimumIdleSize();
        if(connectionMinimumIdleSize != null) {
            serverConfig.setConnectionMinimumIdleSize(connectionMinimumIdleSize);
        }
        // connectionPoolSize
        Integer connectionPoolSize = singleConfig.getConnectionPoolSize();
        if(connectionPoolSize != null) {
            serverConfig.setConnectTimeout(connectionPoolSize);
        }
        // database（数据库编号）
        Integer database = singleConfig.getDatabase();
        if(database != null) {
            serverConfig.setDatabase(database);
        }
        // dnsMonitoringInterval（DNS监控间隔，单位：毫秒）
        Integer dnsMonitoringInterval = singleConfig.getDnsMonitoringInterval();
        if(dnsMonitoringInterval != null) {
            serverConfig.setDnsMonitoringInterval(dnsMonitoringInterval);
        }
    }
}
