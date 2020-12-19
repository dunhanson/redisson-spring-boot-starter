# redisson-spring-boot-starter

基于redisson原生配置，减少学习成本

spring boot中开箱即用redisson

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

## 配置方式

配置文件，使用application.yml

配置查找方式，左侧优先级最高

> 集群(哨兵) -> 单节点 -> 默认(127.0.0.1)

参数完整描述以及介绍可以参考[Redisson](https://github.com/redisson/redisson)

1. 单节点

基础

```yaml
redisson:
  single_server_config:
    password: null
    address: "redis://127.0.0.1:6379"
```

完整

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

2. 集群(哨兵)

基础

```yaml
redisson:
  sentinel-servers-config:
    master-name: "mymaster"
    sentinel-address:
      - "redis://192.168.2.170:26377"
      - "redis://192.168.2.170:26378"
      - "redis://192.168.2.170:26379"
    password: bxkc2016
```

完整

```yaml
sentinel_servers_config:
  idle_connection_timeout: 10000
  connect_timeout: 10000
  timeout: 3000
  retry_attempts: 3
  retry_interval: 1500
  failed_slave_reconnection_interval: 3000
  failed_slave_check_interval: 60000
  password: null
  subscriptions_per_connection: 5
  client_name: null
  subscription_connection_minimum_idle_size: 1
  subscription_connection_pool_size: 50
  slave_connection_minimum_idle_size: 24
  slave_connection_pool_size: 64
  master_connection_minimum_idle_size: 24
  master_connection_pool_size: 64
  read_mode: "SLAVE"
  subscription_mode: "SLAVE"
  sentinel_addresses:
    - "redis://192.168.2.170:26377"
    - "redis://192.168.2.170:26378"
    - "redis://192.168.2.170:26379"
  master_name: "mymaster"
  database: 0
threads: 16
netty_threads: 32
transport_mode: "NIO"
```

## 开发计划

功能模块开发情况

* ~~single_server_config~~ 已完成
* ~~sentinel_servers_config~~ 进行中

## 参考资料

[GitHub Redisson](https://github.com/redisson/redisson)

[GitHub Redisson Wiki](https://github.com/redisson/redisson/wiki)

