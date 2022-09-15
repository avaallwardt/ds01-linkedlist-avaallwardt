package com.company;

public class MyLinkedList {

    private Node head;

    // check index

    public boolean add(Object object) {
        if(object == null){
            return false;
        }
        Node newNode = new Node(object);
        if(head != null){
            Node node = head;
            while(node.getNextNode() != null){
                node = node.getNextNode();
            }
            node.setNextNode(newNode);
        }
        else{
            head = newNode;
        }
        // if you had a size limit, it would return false
        return true;
    }

    public void add(int index, Object object) {
        if(object == null){
        }
        Node newNode = new Node(object);
        if(head == null){
            head = newNode;
        }
        else{
            Node node = head;
            int count = -1;
            while(node.getNextNode() != null){
                if(count + 1 == index){
                   // while(){

                    }
                   // node.setNextNode(newNode);
                }
                node = node.getNextNode();
                count++;
            }
            //node.setNextNode(newNode);;
        }
    //}

    public void addFirst(Object object) {
        if(object == null){
            return;
        }
    }

    public void addLast(Object object) { //Identical to add but with a void return type
        add(object);
    }

    public void clear() { //Empties LL

    }

    public boolean contains(Object object) {
        return false;
    }

    public Object get(int index){
        return null;
    }

    public Object getFirst() {
        return null;
    }

    public Object getLast() {
        return null;
    }

    public int indexOf(Object object) {
        return 0;
    }
    // first index that of that object that it finds
    // -1 if the object doesn't exist in the linked list

    public int lastIndexOf(Object object) {
        return 0;
    }
    // return index of the last place it saw that object


    public Object poll() { //Returns head element
        return null;
    }
    // the second thing becomes the first IF there is a second element

    public Object pollLast() { //Returns tail element
        return null;
    }

    public Object remove(Object object) {
        return null;
    }
    // de-link the node and repair the link
    // want the object of the node itself to be returned // must use a get method

    public Object set(int index, Object object) { //Return value should be item being replaced
        return null;
    }

    public int size() {
        return 0;
    }

    // Node class must be in the class itself
    public class Node {
        private Object data;
        private Node nextNode;

        public Node(Object data){
            this.data = data;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public Node getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }
    }



}

