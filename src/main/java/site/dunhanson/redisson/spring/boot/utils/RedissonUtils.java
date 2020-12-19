package site.dunhanson.redisson.spring.boot.utils;

import org.apache.commons.lang3.StringUtils;
import org.redisson.client.codec.Codec;
import org.redisson.config.*;
import site.dunhanson.redisson.spring.boot.config.BasicConfig;
import site.dunhanson.redisson.spring.boot.config.RedissonConfig;
import site.dunhanson.redisson.spring.boot.config.SentinelConfig;
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
        if(redissonConfig.getSentinelConfig() != null) {
            // 哨兵模式
            SentinelServersConfig sentinelServersConfig = config.useSentinelServers();
            SentinelConfig sentinelConfig = redissonConfig.getSentinelConfig();
            initSentinelServerConfig(sentinelServersConfig, sentinelConfig);
            initBasicConfig(sentinelServersConfig, sentinelConfig);
        } else if(redissonConfig.getSingleServerConfig() != null) {
            // 单节点模式
            SingleServerConfig singleServerConfig = config.useSingleServer();
            SingleConfig singleConfig = redissonConfig.getSingleServerConfig();
            initSingleServerConfig(singleServerConfig, singleConfig);
            initBasicConfig(singleServerConfig, singleConfig);
        } else {
            // 默认模式
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
     * 初始化单节点模式
     * @param singleServerConfig SingleServerConfig
     * @param singleConfig 单节点配置
     */
    public static void initSingleServerConfig(SingleServerConfig singleServerConfig, SingleConfig singleConfig) {
        // address（节点地址）
        String address = singleConfig.getAddress();
        if(StringUtils.isNotBlank(address)) {
            singleServerConfig.setAddress(address);
        }
        // subscriptionConnectionMinimumIdleSize（发布和订阅连接的最小空闲连接数）
        Integer subscriptionConnectionMinimumIdleSize = singleConfig.getSubscriptionConnectionMinimumIdleSize();
        if(subscriptionConnectionMinimumIdleSize != null) {
            singleServerConfig.setSubscriptionConnectionMinimumIdleSize(subscriptionConnectionMinimumIdleSize);
        }
        // subscriptionConnectionPoolSize（发布和订阅连接池大小）
        Integer subscriptionConnectionPoolSize = singleConfig.getSubscriptionConnectionPoolSize();
        if(subscriptionConnectionPoolSize != null) {
            singleServerConfig.setSubscriptionConnectionPoolSize(subscriptionConnectionPoolSize);
        }
        // connectionMinimumIdleSize（最小空闲连接数）
        Integer connectionMinimumIdleSize = singleConfig.getConnectionMinimumIdleSize();
        if(connectionMinimumIdleSize != null) {
            singleServerConfig.setConnectionMinimumIdleSize(connectionMinimumIdleSize);
        }
        // connectionPoolSize
        Integer connectionPoolSize = singleConfig.getConnectionPoolSize();
        if(connectionPoolSize != null) {
            singleServerConfig.setConnectionPoolSize(connectionPoolSize);
        }
        // database（数据库编号）
        Integer database = singleConfig.getDatabase();
        if(database != null) {
            singleServerConfig.setDatabase(database);
        }
        // dnsMonitoringInterval（DNS监控间隔，单位：毫秒）
        Integer dnsMonitoringInterval = singleConfig.getDnsMonitoringInterval();
        if(dnsMonitoringInterval != null) {
            singleServerConfig.setDnsMonitoringInterval(dnsMonitoringInterval);
        }
    }

    /**
     * 初始化哨兵模式
     * @param sentinelServersConfig
     * @param sentinelConfig
     */
    public static void initSentinelServerConfig(SentinelServersConfig sentinelServersConfig, SentinelConfig sentinelConfig) {
        // dnsMonitoringInterval（DNS监控间隔，单位：毫秒）
        Integer dnsMonitoringInterval = sentinelConfig.getDnsMonitoringInterval();
        if(dnsMonitoringInterval != null) {
            sentinelServersConfig.setDnsMonitoringInterval(dnsMonitoringInterval);
        }
        // masterName（主服务器的名称）
        String masterName = sentinelConfig.getMasterName();
        if(masterName != null) {
            sentinelServersConfig.setMasterName(masterName);
        }
        // sentinelAddress（添加哨兵节点地址）
        String[] sentinelAddress = sentinelConfig.getSentinelAddress();
        if(sentinelAddress != null) {
            sentinelServersConfig.addSentinelAddress(sentinelAddress);
        }
        // readMode（读取操作的负载均衡模式）
        ReadMode readMode = sentinelConfig.getReadMode();
        if(readMode != null) {
            sentinelServersConfig.setReadMode(readMode);
        }
        // subscriptionMode（订阅操作的负载均衡模式）
        SubscriptionMode subscriptionMode = sentinelConfig.getSubscriptionMode();
        if(subscriptionMode != null) {
            sentinelServersConfig.setSubscriptionMode(subscriptionMode);
        }
        // subscriptionConnectionMinimumIdleSize（从节点发布和订阅连接的最小空闲连接数）
        Integer subscriptionConnectionMinimumIdleSize = sentinelConfig.getSubscriptionConnectionMinimumIdleSize();
        if(subscriptionConnectionMinimumIdleSize != null) {
            sentinelServersConfig.setSubscriptionConnectionMinimumIdleSize(subscriptionConnectionMinimumIdleSize);
        }
        // subscriptionConnectionPoolSize（从节点发布和订阅连接池大小）
        Integer subscriptionConnectionPoolSize = sentinelConfig.getSubscriptionConnectionPoolSize();
        if(subscriptionConnectionPoolSize != null) {
            sentinelServersConfig.setSubscriptionConnectionPoolSize(subscriptionConnectionPoolSize);
        }
        // slaveConnectionMinimumIdleSize（从节点最小空闲连接数）
        Integer slaveConnectionMinimumIdleSize = sentinelConfig.getSlaveConnectionMinimumIdleSize();
        if(slaveConnectionMinimumIdleSize != null) {
            sentinelServersConfig.setSlaveConnectionMinimumIdleSize(slaveConnectionMinimumIdleSize);
        }
        // slaveConnectionPoolSize（从节点连接池大小）
        Integer slaveConnectionPoolSize = sentinelConfig.getSlaveConnectionMinimumIdleSize();
        if(slaveConnectionPoolSize != null) {
            sentinelServersConfig.setSlaveConnectionPoolSize(slaveConnectionPoolSize);
        }
        // masterConnectionMinimumIdleSize（主节点最小空闲连接数）
        Integer masterConnectionMinimumIdleSize = sentinelConfig.getMasterConnectionMinimumIdleSize();
        if(masterConnectionMinimumIdleSize != null) {
            sentinelServersConfig.setMasterConnectionMinimumIdleSize(masterConnectionMinimumIdleSize);
        }
        // masterConnectionPoolSize（主节点连接池大小）
        Integer masterConnectionPoolSize = sentinelConfig.getMasterConnectionPoolSize();
        if(masterConnectionPoolSize != null) {
            sentinelServersConfig.setMasterConnectionPoolSize(masterConnectionPoolSize);
        }
        // database（数据库编号）
        Integer database = sentinelConfig.getDatabase();
        if(database != null) {
            sentinelServersConfig.setDatabase(database);
        }
    }

    /**
     * 初始化BaseConfig, 共同参数
     * @param baseConfig
     * @param basicConfig
     */
    public static void initBasicConfig(BaseConfig baseConfig, BasicConfig basicConfig) {
        // idleConnectionTimeout（连接空闲超时，单位：毫秒）
        Integer idleConnectionTimeout = basicConfig.getIdleConnectionTimeout();
        if(idleConnectionTimeout != null) {
            baseConfig.setIdleConnectionTimeout(idleConnectionTimeout);
        }
        // connectTimeout（连接超时，单位：毫秒）
        Integer connectTimeout = basicConfig.getConnectTimeout();
        if(connectTimeout != null) {
            baseConfig.setConnectTimeout(connectTimeout);
        }
        // timeout（命令等待超时，单位：毫秒）
        Integer timeout = basicConfig.getTimeout();
        if(timeout != null) {
            baseConfig.setTimeout(timeout);
        }
        // retryAttempts（命令失败重试次数）
        Integer retryAttempts = basicConfig.getRetryAttempts();
        if(retryAttempts != null) {
            baseConfig.setRetryAttempts(retryAttempts);
        }
        // retryInterval（命令失败重试次数）
        Integer retryInterval = basicConfig.getRetryInterval();
        if(retryInterval != null) {
            baseConfig.setRetryInterval(retryInterval);
        }
        // password（密码）
        String password = basicConfig.getPassword();
        if(StringUtils.isNotBlank(password)) {
            baseConfig.setPassword(password);
        }
        // subscriptionsPerConnection（单个连接最大订阅数量）
        Integer subscriptionsPerConnection = basicConfig.getSubscriptionsPerConnection();
        if(subscriptionsPerConnection != null) {
            baseConfig.setSubscriptionsPerConnection(subscriptionsPerConnection);
        }
        // clientName（客户端名称）
        String clientName = basicConfig.getClientName();
        if(StringUtils.isNotBlank(clientName)) {
            baseConfig.setClientName(clientName);
        }
    }
}
