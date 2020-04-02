package com.cardlan.springboot.designpattern.factory.simple.order;

import com.cardlan.springboot.designpattern.factory.simple.DurianPizza;
import com.cardlan.springboot.designpattern.factory.simple.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OrderPizza extends DurianPizza {
    String orderType;
    Pizza pizza=null;
//    public OrderPizza() {
//        do{
//            orderType= getType();
//            if("durian".equals(orderType)){
//                pizza=new DurianPizza();
//                pizza.setName("榴莲披萨");
//            }else if("cheese".equals(orderType)){
//                pizza=new CheesePizza();
//                pizza.setName("起司披萨");
//            }else {
//                break;
//            }
//            pizza.perpare();
//            pizza.cut();
//            pizza.bake();
//            pizza.box();
//        }while (true);
//    }


    public OrderPizza(SimpleFactory simpleFactory) {
        setSimpleFactory(simpleFactory);
    }

    SimpleFactory simpleFactory;

    public void setSimpleFactory(SimpleFactory simpleFactory) {

        this.simpleFactory = simpleFactory;
        do {
            orderType = getType();
            pizza = this.simpleFactory.createPizza(orderType);

            //输出pizza
            if (pizza != null) { //订购成功
                pizza.perpare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            } else {
                System.out.println(" 订购披萨失败 ");
                break;
            }
        }while (true) ;

    }

    private String getType(){
        String str= null;
        try {
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
            System.out.println("输入披萨的种类:");
            str = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
