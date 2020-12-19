package site.dunhanson.redisson.spring.boot.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.annotation.Resource;

import site.dunhanson.redisson.spring.boot.config.RedissonConfig;
import site.dunhanson.redisson.spring.boot.config.SentinelConfig;
import site.dunhanson.redisson.spring.boot.config.SingleConfig;
import site.dunhanson.redisson.spring.boot.utils.RedissonUtils;

/**
 * 创建Bean配置
 * 2020-12-18
 * @author dunhanson
 */
@Configuration
@EnableConfigurationProperties(value = {RedissonConfig.class, SingleConfig.class, SentinelConfig.class})
public class BeanConfig {
    @Resource
    private RedissonConfig redissonConfig;

    /**
     * RedissonClient初始化
     * @return
     */
    @Bean
    public RedissonClient redissonClient() {
        Config config = RedissonUtils.createConfig(redissonConfig);
        return Redisson.create(config);
    }
}
