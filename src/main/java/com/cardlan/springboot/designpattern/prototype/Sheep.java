package com.cardlan.springboot.designpattern.prototype;

public class Sheep {

    private String name;

    private Integer age;

    private String color;

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

//    @Override
//    public String toString() {
//        return "Sheep{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                ", color='" + color + '\'' +
//                '}';
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Sheep sheep = (Sheep) o;
//        return Objects.equals(name, sheep.name) &&
//                Objects.equals(age, sheep.age) &&
//                Objects.equals(color, sheep.color);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name, age, color);
//    }
}
