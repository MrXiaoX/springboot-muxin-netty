package com.cardlan.springboot.designpattern.builder;

public class CommonHouse extends AbstractHouse {
    @Override
    protected void buildBacic() {
        System.out.println("给房子打地基");
    }

    @Override
    protected void buildWalls() {
        System.out.println("给房子砌墙");
    }

    @Override
    protected void roofed() {
        System.out.println("给房子封顶");
    }
}
