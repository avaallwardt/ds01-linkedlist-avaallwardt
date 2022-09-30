package com.company;

public class Main {

    public static void main(String[] args) {

        MyLinkedList singlyLinkedList = new MyLinkedList();
        MyLinkedList linkedList = new MyLinkedList(false, true);



        for(int i = 0; i < 10; i++){
          linkedList.add(1);
        }



        linkedList.addFirst(5);
        linkedList.print();


        //linkedList.add(1);
        System.out.println(linkedList.getHead());
        //System.out.println(linkedList.getHead().getNextNode());
        System.out.println();
        System.out.println(linkedList.getHead().getPreviousNode());

        /*
        MyLinkedList.Node node = (MyLinkedList.Node) (linkedList.get(10));
        System.out.println(node.getNextNode());
        System.out.println(linkedList.getHead());
        System.out.println(linkedList.getHead().getPreviousNode());
        System.out.println(node);

         */






    }






}
