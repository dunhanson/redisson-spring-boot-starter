package site.dunhanson.redisson.spring.boot.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import site.dunhanson.redisson.spring.boot.utils.RedissonUtils;

/**
 * 创建Bean配置
 * 2020-12-18
 * @author dunhanson
 */
@Component
public class BeanConfig {
    @Resource
    private RedissonConfig redissonConfig;

    @Bean
    public RedissonClient redissonClient() {
        Config config = RedissonUtils.createConfig(redissonConfig);
        return Redisson.create(config);
    }
}
