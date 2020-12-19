package site.dunhanson.redisson.spring.boot.config;

import lombok.Data;
import org.redisson.client.codec.Codec;
import org.redisson.config.TransportMode;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 单节点配置
 * 2020-12-18
 * @author dunhanson
 */
@Data
@ConfigurationProperties(prefix = "redisson")
public class RedissonConfig {
    private SingleConfig singleServerConfig;
    private SentinelConfig sentinelConfig;
    private Integer threads;
    private Integer nettyThreads;
    private Codec codec;
    private TransportMode transportMode;
}
