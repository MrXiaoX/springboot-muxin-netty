package com.cardlan.springboot.collction;

import java.util.ArrayList;
import java.util.List;

public class HashMapDemo<K,V> implements MapDemo<K,V> {

    List<Node<K, V>> list = new ArrayList<>();


    @Override
    public int size() {
        return 0;
    }

    @Override
    public V put(K key, V value) {
        return null;
    }

    @Override
    public V get(K key) {
        return null;
    }

    static class Node<K, V> implements MapDemo.Entry<K, V> {
        final int hash;
        final K key;
        V value;
        Node<K, V> next;

        Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }


        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            return null;
        }
    }
}