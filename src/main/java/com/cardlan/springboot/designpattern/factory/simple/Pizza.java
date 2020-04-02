package com.cardlan.springboot.designpattern.factory.simple;

public abstract class Pizza {

    protected String name;

    public abstract void perpare();

    public void bake(){
        System.out.println(name+" 烘烤");
    }

    public void cut(){
        System.out.println(name+" 切割");
    }


    public void box(){
        System.out.println(name+" 打包");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
