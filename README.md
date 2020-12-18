# redisson-spring-boot-starter

## 配置方式

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

哨兵模式


## 参考资料
[Redisson实现分布式锁(2)—RedissonLock](https://www.cnblogs.com/qdhxhz/p/11055426.html)
