package com.company;

import java.sql.SQLOutput;

public class Main {

    public static void main(String[] args){

        MyLinkedList linkedList = new MyLinkedList(false, false);

        int num = 0;
        for(int i = 0; i < 10; i++) {
            linkedList.add(1);
            System.out.println(num + ": " + linkedList.getLast());
            num++;
        }


        linkedList.add(5);
        linkedList.add(6);
        /*
        System.out.println(linkedList.getFirst());

        System.out.println("head: " + linkedList.getHead());
        System.out.println("tail: " + linkedList.getTail());

        linkedList.pollLast();
        //System.out.println(linkedList.getTail().getPreviousNode().getData());


        linkedList.print();


        System.out.println("head: " + linkedList.getHead());
        System.out.println("tail: " + linkedList.getTail());

        //System.out.println(linkedList.getHead().getNextNode());
        System.out.println("head previous node: " + linkedList.getHead().getPreviousNode());
        System.out.println("tail next node: " + linkedList.getTail().getNextNode());
        System.out.println("tail previous node: " + linkedList.getTail().getPreviousNode());
        System.out.println("2nd node previous node: " + linkedList.getHead().getNextNode().getPreviousNode());
        //System.out.println("node the 2nd to last is pointing to " + linkedList.getTail().getPreviousNode().getNextNode());

        System.out.println();
        MyLinkedList.Node index4 = (MyLinkedList.Node) (linkedList.get(4));
        System.out.println(index4.getNextNode());
        System.out.println(index4.getNextNode().getPreviousNode());

         */


        /*
        MyLinkedList.Node node = (MyLinkedList.Node) (linkedList.get(10));
        System.out.println(node.getNextNode());
        System.out.println(linkedList.getHead());
        System.out.println(linkedList.getHead().getPreviousNode());
        System.out.println(node);

         */






    }






}
