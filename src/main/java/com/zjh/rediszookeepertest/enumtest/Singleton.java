package com.zjh.rediszookeepertest.enumtest;

/**
 * 类的说明
 *
 * @author 张江浩
 * @version 1.00
 * @date 2020/1/30 16:30
 */
public class Singleton {
    private Singleton(){

    }

    //避免指令重排序 ， 返回未初始化的singleton
    //正确模式 1.分配内存地址M 2.初始化singleton 3.将内存地址M赋予singleton
    //但cpu可能会指令重排序 让2，3换位执行。这时候就会返回未初始化的singleton（代码21 ，28行）
    private static volatile Singleton singleton = null;


    //思路
    //A B两个线程同时调用该方法，A、B均判断为null（25），A加锁这个类，A再次判断为null，A初始化这个类，A释放锁
    //B线程进来获得锁的时候再次判断不为null（27），直接返回
    public Singleton getSingleton(){
        if (singleton == null){
            synchronized (Singleton.class){
               if (singleton == null){
                   return new Singleton();
               }
            }
        }
        return singleton;
    }
}
