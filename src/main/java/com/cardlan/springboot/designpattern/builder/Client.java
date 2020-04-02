package com.cardlan.springboot.designpattern.builder;

public class Client {

    public static void main(String[] args) {
        AbstractHouse commonHouse=new CommonHouse();
        commonHouse.build();
    }
}
