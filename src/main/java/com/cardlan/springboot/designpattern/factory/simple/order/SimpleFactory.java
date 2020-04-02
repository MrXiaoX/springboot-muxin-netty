package com.cardlan.springboot.designpattern.factory.simple.order;

import com.cardlan.springboot.designpattern.factory.simple.CheesePizza;
import com.cardlan.springboot.designpattern.factory.simple.DurianPizza;
import com.cardlan.springboot.designpattern.factory.simple.Pizza;

public class SimpleFactory {
    //更加orderType 返回对应的Pizza 对象
    public Pizza createPizza(String orderType) {

        Pizza pizza = null;

        System.out.println("使用简单工厂模式");
        if("durian".equals(orderType)){
            pizza=new DurianPizza();
            pizza.setName("榴莲披萨");
        }else if("cheese".equals(orderType)){
            pizza=new CheesePizza();
            pizza.setName("起司披萨");
        } else if (orderType.equals("pepper")) {
            pizza = new PepperPizza();
            pizza.setName("胡椒披萨");
        }
        return pizza;
    }
}
