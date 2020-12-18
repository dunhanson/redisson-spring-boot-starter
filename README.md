# redisson-spring-boot-starter

redisson spring boot 项目开箱即用

## 配置方式

使用application.yml配置

单节点模式

```yaml
redisson:
  singleServerConfig:
    idleConnectionTimeout: 10000
    connectTimeout: 10000
    timeout: 3000
    retryAttempts: 3
    retryInterval: 1500
    password: null
    subscriptionsPerConnection: 5
    clientName: null
    address: "redis://127.0.0.1:6379"
    subscriptionConnectionMinimumIdleSize: 1
    subscriptionConnectionPoolSize: 50
    connectionMinimumIdleSize: 24
    connectionPoolSize: 64
    database: 0
    dnsMonitoringInterval: 5000
  threads: 16
  nettyThreads: 32
  # codec: !<org.redisson.codec.FstCodec> {}
  transportMode: "NIO"
```

## 使用方法

```java
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
```

## 开发计划

功能模块开发情况

* ~~singleServerConfig~~ 已完成
* sentinelServersConfig 进行中

## 参考资料

[GitHub Redisson](https://github.com/redisson/redisson)

[GitHub Redisson Wiki](https://github.com/redisson/redisson/wiki)

[Redisson实现分布式锁(2)—RedissonLock](https://www.cnblogs.com/qdhxhz/p/11055426.html)

