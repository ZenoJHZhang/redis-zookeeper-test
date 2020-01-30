package com.zjh.rediszookeepertest;

import com.zjh.rediszookeepertest.memcache.MemcachedRunner;
import net.spy.memcached.CASValue;
import net.spy.memcached.MemcachedClient;
import net.spy.memcached.internal.OperationFuture;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
class RedisZookeeperTestApplicationTests {

    @Resource
    private MemcachedRunner memcachedRunner;


    @Test
    void contextLoads() {
    }

    @Test
    void memCachedTest(){
        MemcachedClient client = memcachedRunner.getClient();
        CASValue<Object> zjh = client.gets("zjh");
        client.cas("zjh",zjh.getCas(),"ttttSSSSSt");
        System.out.println(client.get("zjh"));
    }

}
