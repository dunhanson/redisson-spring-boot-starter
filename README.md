# redisson-spring-boot-starter

配置方式

1、默认配置

读取spring.redis

1.1 单节点模式

```yaml
redis:
  host: 127.0.0.1
  password:
```
1.2 集群哨兵模式

```yaml
redis:
  sentinel:
    master: mymaster
    nodes: 192.168.2.170:26377,192.168.2.170:26378,192.168.2.170:26379
  password: bxkc2016
```

2、专属配置

2.1 单节点模式

```yaml
dunhanson:
  redisson:
    single:
      ...
```

2.2 集群哨兵模式

```yaml
dunhanson:
  redisson:
    sentinel:
      ...
```


## 参考资料
[Redisson实现分布式锁(2)—RedissonLock](https://www.cnblogs.com/qdhxhz/p/11055426.html)
