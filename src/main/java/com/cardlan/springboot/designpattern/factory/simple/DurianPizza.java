package com.cardlan.springboot.designpattern.factory.simple;

public class DurianPizza extends Pizza {
    @Override
    public void perpare() {
        System.out.println("给榴莲披萨准备原材料");
    }
}
