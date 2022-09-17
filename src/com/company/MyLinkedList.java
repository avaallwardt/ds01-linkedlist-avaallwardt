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
        if ((object == null) || (index < 0)) {
            // if the passed through object is null, don't need to try to add a null object into the linked list
            return;
        }
        Node newNode = new Node(object);
        if ((head == null) && (index == 0)) {
            head = newNode;
        }
        else if((head == null) && (index != 0)){
            System.out.println("There is no head, but you are asking to put an object in index after the head!");
            return;
        }
        else {
            Node node = head;
            int count = 0;
            while ((count < index - 1) && (node.getNextNode()!= null)) {
                node = node.getNextNode();
                count++;
            }
            if((count == index - 1) && (node.getNextNode()== null)){
                node.setNextNode(newNode);
            }
            else if((count < index - 1) && (node.getNextNode()!= null)){
                System.out.println("The index provided is not valid. It is too high.");
                return;
            }
            // now count = 1 less than index -- set next node for the new object to the current nextnode for the conut object, set next node for object at count to the new object
            newNode.setNextNode(node.getNextNode());
            node.setNextNode(newNode);
        }
    }



    public void addFirst(Object object) {
        if(object == null){
            return;
        }
        Node newNode = new Node(object);
        if(head == null){
            head = newNode;
        }
        else{
            newNode.setNextNode(head);
            head = newNode;
        }
    }

    public void addLast(Object object) { //Identical to add but with a void return type
        add(object);
    }

    public void clear() { //Empties LL
        // can you assume that all objects in the linked list are not null? otherwise, you can't call .getNextNode bc can't call a method on a null object
        head = null;
        // check!
        /*
        Node currentNode = head;
        Node nextNode = currentNode;
        while(currentNode.getNextNode() != null){
            nextNode = currentNode.getNextNode();
            currentNode = null;
        }
        currentNode = null;

         */
    }

    public boolean contains(Object object) {
        // is this what you mean by assessing by content instead of memory?
        if(object == null){
            return false;
        }
        if(head == null){
            return false;
        }
        Node currentNode = head;
        while(currentNode != null){
            // so if we cannot assess by memory value, then we have to use .equals right bc == compares memory locations?
            if(currentNode.getData().equals(object)){
                return true;
            }
            currentNode = currentNode.getNextNode();
        }
        return false;
    }

    public Object get(int index){
        // do you return the node itself or the data/object the node holds?
        if(index < 0){
            return null;
        }
        if(head == null) {
            return null;
        }
        int currentIndex = 0;
        Node currentNode = head;
        while(currentNode != null){
            if(currentIndex == index){
                return currentNode;
            }
            currentIndex++;
            currentNode = currentNode.getNextNode();
        }
        return null;
    }

    public Object getFirst() {
        if(head == null){
            return null;
        }
        else{
            return head;
        }
    }

    public Object getLast() {
        if(head == null){
            return null;
        }
        Node currentNode = head;
        while(currentNode.getNextNode() != null){
            currentNode = currentNode.getNextNode();
        }
        return currentNode;
    }

    public int indexOf(Object object) {
        // the object's "content" refers to the data instance variable not the node object itsef, right?

        if(object == null){
            System.out.println("The object provided is null.");
            return -1;
        }
        if(head == null){
            // do we need to find explanations for every check?
            return -1;
        }
        int currentIndex = 0;
        Node currentNode = head;
        while(currentNode != null){
            // use == here right? bc it does not specify to not compare memory locations
            if(currentNode.getData() == object){
                return currentIndex;
            }
            currentIndex++;
            currentNode = currentNode.getNextNode();
        }
        return -1;
    }
    // first index that of that object that it finds
    // -1 if the object doesn't exist in the linked list

    public int lastIndexOf(Object object) {
        if(object == null){
            return -1;
        }
        if(head == null){
            return -1;
        }

        int currentFoundIndex = -1;

        int currentIndex = 0;
        Node currentNode = head;
        while(currentNode != null){
            // use == here right? bc it does not specify to not compare memory locations
            if(currentNode.getData() == object){
                currentFoundIndex = currentIndex;
            }
            currentIndex++;
            currentNode = currentNode.getNextNode();
        }
        return currentFoundIndex;
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

