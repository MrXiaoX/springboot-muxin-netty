package com.cardlan.springboot.designpattern.prototype.improve;

import java.util.ArrayList;
import java.util.List;

public class SheeepClient {
    public static void main(String[] args) {
        Sheep sheep=new Sheep("喜羊羊",3,"白色");
        List<Sheep> list=new ArrayList<>();
        List<Integer> listCode=new ArrayList<>();
        Sheep sheepi;
        sheep.sheepFriend=new Sheep("沸羊羊",4,"棕色");
        for (int i = 0; i <10 ; i++) {
            sheepi= (Sheep) sheep.clone();
            list.add(sheepi);
            listCode.add(sheepi.hashCode());
            System.out.println(sheepi.sheepFriend.hashCode());
        }
        System.out.println(list);
        System.out.println(listCode);
    }
}
