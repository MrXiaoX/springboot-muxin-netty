package com.cardlan.springboot.collction;

public interface MapDemo<K,V> {

    int size();

    V put(K key,V value);

    V get(K key);



    //存放键值对
    interface Entry<K,V> {

        K getKey();

        V getValue();

        V setValue(V value);
    }
}
