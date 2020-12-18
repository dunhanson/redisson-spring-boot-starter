package site.dunhanson.redisson.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import site.dunhanson.redisson.spring.boot.config.RedissonConfig;

@Configuration
@SpringBootApplication
@EnableConfigurationProperties(value = {RedissonConfig.class})
public class RedissonSpringBootStarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedissonSpringBootStarterApplication.class, args);
    }

}
