package com.cardlan.springboot.designpattern.prototype.improve;

public class Sheep implements Cloneable{

    private String name;

    private Integer age;

    private String color;

    public Sheep sheepFriend;

    public Sheep(String name, Integer age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public Sheep() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    /**
     * 克隆该实体，使用默认clone方法
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected  Object clone(){

        Object sheep=null;
        try {
            sheep=super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return sheep;
    }

}
