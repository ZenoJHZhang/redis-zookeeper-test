package com.zjh.rediszookeepertest.zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

/**
 * 类的说明
 *
 * @author 张江浩
 * @version 1.00
 * @date 2020/1/29 15:49
 */
public class WatcherExample implements Watcher {
    @Override
    public void process(WatchedEvent watchedEvent) {
        if (watchedEvent.getPath() == null) { //连接时会触发None的事件
            System.out.println("初始化连接" + watchedEvent.getType());
        } else if (watchedEvent.getType() == Watcher.Event.EventType.NodeDeleted) {
            System.out.println("[节点删除]" + watchedEvent.getPath() + ":" + watchedEvent.getType());
        } else if (watchedEvent.getType() == Watcher.Event.EventType.NodeCreated) {
            System.out.println("[节点创建]" + watchedEvent.getPath() + ":" + watchedEvent.getType());
        } else if (watchedEvent.getType() == Watcher.Event.EventType.NodeDataChanged) {
            System.out.println("[节点更新]" + watchedEvent.getPath() + ":" + watchedEvent.getType());
        } else if (watchedEvent.getType() == Watcher.Event.EventType.NodeChildrenChanged) {
            System.out.println("[子节点更新(父增删子节点)]" + watchedEvent.getPath() + ":" + watchedEvent.getType());
        }
    }
}
