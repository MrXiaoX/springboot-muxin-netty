package com.cardlan.springboot.designpattern.builder;

public abstract class AbstractHouse {

    //打地基
    protected abstract void buildBacic();
    //封墙
    protected abstract void buildWalls();
    //封顶
    protected abstract void roofed();

    public void build(){
        buildBacic();
        buildWalls();
        roofed();
    }
}
