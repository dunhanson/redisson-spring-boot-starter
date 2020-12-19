# redisson-spring-boot-starter

基于redisson原生配置，减少学习成本

在spring boot项目中redisson开箱即用

使用redisson就这么简单

## 配置方式

使用application.yml配置

单节点模式

基础配置

```yaml
redisson:
  singleServerConfig:
    password: null
    address: "redis://127.0.0.1:6379"
```

完整配置

```yaml
redisson:
  single_server_config:
    idle_connection_timeout: 10000
    connect_timeout: 10000
    timeout: 3000
    retry_attempts: 3
    retry_interval: 1500
    password: null
    subscriptions_per_connection: 5
    client_name: null
    address: "redis://127.0.0.1:6379"
    subscription_connection_minimum_idle_size: 1
    subscription_connection_pool_size: 50
    connection_minimum_idle_size: 24
    connection_pool_size: 64
    database: 0
    dns_monitoring_interval: 5000
  threads: 16
  netty_threads: 32
  transport_mode: "NIO"
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

