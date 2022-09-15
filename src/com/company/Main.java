package com.company;

public class Main {

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        for(int i = 0; i < 100000; i++){
           linkedList.add(1);
        }
        System.out.println("wow");
    }
}
