package com.cardlan.springboot.designpattern.factory.simple.order;

import com.cardlan.springboot.designpattern.factory.simple.Pizza;

public class PepperPizza extends Pizza {
    @Override
    public void perpare() {
        System.out.println("胡椒披萨 准备材料");
    }
}
