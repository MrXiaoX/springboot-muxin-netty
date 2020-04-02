package com.cardlan.springboot.designpattern.factory.simple;

import com.cardlan.springboot.designpattern.factory.simple.order.OrderPizza;
import com.cardlan.springboot.designpattern.factory.simple.order.SimpleFactory;

public class PizzaStore {

    public static void main(String[] args) {
        new OrderPizza(new SimpleFactory());
        System.out.println("退出程序");
    }
}
