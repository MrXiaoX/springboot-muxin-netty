package com.cardlan.springboot.designpattern.prototype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SheeepClient {
    public static void main(String[] args) {

        // TODO Auto-generated method stub
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MonsterConfiguration.class);
        // 获取monster[通过id获取monster]
        Object bean = applicationContext.getBean("getMonster");
        System.out.println("bean" + bean); // 输出 "牛魔王" .....
//
        Object bean2 = applicationContext.getBean("getMonster");
        System.out.println(bean==bean2);
//        Sheep sheep=new Sheep("tom",1,"白色");
//        List<Sheep> list=new ArrayList<>();
//        List<Integer> listCode=new ArrayList<>();
//        Sheep sheepi;
//        for (int i = 0; i <10 ; i++) {
//            sheepi=new Sheep();
//            sheepi.setAge(sheep.getAge());
//            sheepi.setName(sheep.getName());
//            sheepi.setColor(sheep.getColor());
//            list.add(sheepi);
//            listCode.add(sheepi.hashCode());
//        }
//        System.out.println(list);
//        System.out.println(listCode);
    }
}
