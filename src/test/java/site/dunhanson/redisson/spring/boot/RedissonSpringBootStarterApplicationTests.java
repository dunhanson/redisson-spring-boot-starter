package site.dunhanson.redisson.spring.boot;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedissonSpringBootStarterApplicationTests {
    @Resource
    private RedissonClient redissonClient;
    @Test
    public void start() {
        RLock lock = redissonClient.getLock("test");
        try {
            // 等待时间
            long waitTime = 3;
            // 锁有效时间
            long leaseTime = 10;
            // 获取锁
            boolean tryLock = lock.tryLock(waitTime, leaseTime, TimeUnit.SECONDS);
            log.info("tryLock:{}", tryLock);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if(lock.isLocked()) {
                lock.unlock();
            }
        }
    }
}
