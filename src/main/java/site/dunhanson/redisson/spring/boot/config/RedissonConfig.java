package site.dunhanson.redisson.spring.boot.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 单节点配置
 * 2020-12-18
 * @author dunhanson
 */
@Data
@ConfigurationProperties(prefix = "dunhanson.redisson")
public class RedissonConfig {
    private String mode = "single";
    private SingleConfig singleConfig;
    private Integer threads;
    private Integer nettyThreads;
    private String codec;
    private String transportMode;
}