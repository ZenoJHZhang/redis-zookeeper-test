package com.zjh.rediszookeepertest.zookeeper;

import org.apache.zookeeper.*;

import java.io.IOException;

/**
 * 类的说明
 *
 * @author 张江浩
 * @version 1.00
 * @date 2020/1/29 15:22
 */
public class Main {
    public void test1() throws IOException, KeeperException, InterruptedException {
        ZooKeeper zk = new ZooKeeper("localhost:2181", 10000, new WatcherExample());
        zk.getChildren("/",true);
        zk.create("/root", new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println(1);
        zk.getChildren("/root",true);
        zk.setData("/root","3".getBytes(),-1);
        zk.setData("/root","3".getBytes(),-1);
        zk.delete("/root", -1);
        zk.create("/root", new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        zk.delete("/root", -1);


    }

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.test1();
    }
}
