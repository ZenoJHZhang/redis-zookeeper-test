package com.zjh.rediszookeepertest.enumtest;

import java.util.EnumMap;

/**
 * 类的说明
 *
 * @author 张江浩
 * @version 1.00
 * @date 2020/1/30 15:43
 */
public class Pizza {

    private PizzaStatus pizzaStatus;

    public PizzaStatus getPizzaStatus() {
        return pizzaStatus;
    }

    public void setPizzaStatus(PizzaStatus pizzaStatus) {
        this.pizzaStatus = pizzaStatus;
    }

    public enum PizzaStatus {
        ORDERER,
        READY,
        DELIVERED;
    }

    public static EnumMap<PizzaStatus,String> generate(){
        EnumMap<PizzaStatus,String> enumMap = new EnumMap<>(PizzaStatus.class);
        enumMap.put(PizzaStatus.ORDERER,"准备好了");
        enumMap.put(PizzaStatus.READY,"冲冲冲");
        return enumMap;
    }

}
