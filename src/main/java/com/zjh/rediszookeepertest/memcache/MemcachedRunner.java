package com.zjh.rediszookeepertest.memcache;

import net.spy.memcached.MemcachedClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.net.InetSocketAddress;

/**
 * 类的说明
 *
 * @author 张江浩
 * @version 1.00
 * @date 2020/1/30 13:12
 */
@Component
public class MemcachedRunner implements CommandLineRunner {

    private MemcachedClient client = null;

    private String ip = "127.0.0.1";

    private int port = 11211;

    @Override
    public void run(String... args) throws Exception {
        client = new MemcachedClient(new InetSocketAddress(ip,port));
    }

    public MemcachedClient getClient() {
        return client;
    }
}
