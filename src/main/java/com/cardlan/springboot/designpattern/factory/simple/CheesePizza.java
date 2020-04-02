package com.cardlan.springboot.designpattern.factory.simple;

public class CheesePizza extends Pizza {
    @Override
    public void perpare() {
        System.out.println("给起司披萨准备原材料");
    }
}
