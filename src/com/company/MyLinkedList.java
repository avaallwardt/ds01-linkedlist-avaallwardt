package com.company;

public class MyLinkedList {

    private Node head;
    private boolean isDoubly;
    private boolean isCircly;
    private Node tail;

    /*
    public MyLinkedList(boolean isDoubly, boolean isCircly){
        this.isDoubly = isDoubly;
        this.isCircly = isCircly;
    }

     */

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
            System.out.println("The head is null and/or the index provided is negative.");
            return;
        }
        Node newNode = new Node(object);
        if ((head == null) && (index == 0)) {
            head = newNode;
        }
        else if((head == null) && (index != 0)){
            System.out.println("The head is null, but the index provided is not 0.");
            return;
        }
        else {
            Node node = head;
            int currentIndex = 0;
            Node currentNode = head;
            Node previousNode = null;
            while((currentIndex < index) && (currentNode.getNextNode() != null)){
                previousNode = currentNode;
                currentNode = currentNode.getNextNode();
                currentIndex++;
            }
            if((currentIndex == index) && (index == 0)){
                newNode.setNextNode(head);
                head = newNode;
            }
            else if(currentIndex == index){
                previousNode.setNextNode(newNode);
                newNode.setNextNode(currentNode);
            }
            // will get here if currentNode is the last node of the list
            else if(currentIndex == index - 1){
                add(object);
            }
            // else, index provided is too high for the list, so nothing happens
            else{
                System.out.println("Index provided is too high!");
            }
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

    public void clear() {
        //Empties LL
        // yes - can you assume that all objects in the linked list are not null? otherwise, you can't call .getNextNode bc can't call a method on a null object
        head = null;

        /* Previous attempt
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
        if(object == null){
            return false;
        }
        if(head == null){
            return false;
        }
        Node currentNode = head;
        while(currentNode != null){
            // yes - so if we cannot assess by memory value, then we have to use .equals right bc == compares memory locations?
            if(currentNode.getData().equals(object)){
                return true;
            }
            currentNode = currentNode.getNextNode();
        }
        return false;
    }

    public Object get(int index){
        // doesn't matter - do you return the node itself or the data/object the node holds?
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
            // is it ok if sys.out.prints are inconsistently provided?
            return -1;
        }
        if(head == null){
            return -1;
        }
        int currentIndex = 0;
        Node currentNode = head;
        while(currentNode != null){
            // use == here right? bc it does not specify to not compare memory locations
            if(currentNode.getData().equals(object)){
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
            if(currentNode.getData().equals(object)){
                currentFoundIndex = currentIndex;
            }
            currentIndex++;
            currentNode = currentNode.getNextNode();
        }
        return currentFoundIndex;
    }
    // return index of the last place it saw that object


    public Object poll() { //Returns head element -- the old head element, right??, should it return the data of the head node or the node itself?
        if(head == null){
            return null;
        }
        Node oldHead = head;
        head = head.getNextNode();
        return oldHead;
    }
    // the second thing becomes the first IF there is a second element
    // so otherwise does it just leave the head to be null???

    public Object pollLast() { //Returns tail element
        if(head == null){
            return null;
        }
        Node currentNode = head;
        // bc of short circuit evaluation, if the next node is null, it wont even try to call getNextNode on that null object -- in case the second object is null
        while((currentNode.getNextNode() != null) && (currentNode.getNextNode().getNextNode() != null)){
            currentNode = currentNode.getNextNode();
        }
        // this will happen when the node after the head is null
        if(currentNode.getNextNode() == null){
            Node lastNode = head;
            head = null;
            return lastNode;
        }
        // this takes the finalNode out of the linked list but does not delete it in memory (java may auto garbage it tho), does this work?
        Node finalNode = currentNode.getNextNode();
        currentNode.setNextNode(null);
        return finalNode;
    }

    // this method was in the rubric but not in here
    public Object remove(int index) {
        // just pull out - do you need to null the object or just pull it out of the linked list?

        if(index < 0){
            return null;
        }
        if(head == null){
            return null;
        }
        int currentIndex = 0;
        Node currentNode = head;
        Node previousNode = null;

        while((currentIndex < index) && (currentNode.getNextNode() != null)){
            previousNode = currentNode;
            currentNode = currentNode.getNextNode();
            currentIndex++;
        }
        if((currentIndex == index) && (index == 0)){
            head = currentNode.getNextNode();
            return currentNode;
        }
        // still works if want to get node at last index
        else if(currentIndex == index){
            // this makes it so that the previous node now points to the node after currentNode (removes currentNode from the linked list, but currentNode still exists in memory)
            previousNode.setNextNode(currentNode.getNextNode());
            return currentNode;
        }
        // will get here if currentNode is the last node of the list
        else{
            System.out.println("Index provided is too high!");
            return null;
        }
    }

    public Object remove(Object object) {
        // removes the first instance right??
        if(object == null){
            return null;
        }
        if(head == null){
            return null;
        }
        // if the head holds the object
        if(head.getData().equals(object)){
            Node node = head;
            head = head.getNextNode();
            return node;
        }
        Node currentNode = head;
        Node previousNode = null;

        // wont evaluate if the object is at the head
        while(currentNode != null){
            if(currentNode.getData().equals(object)){
                previousNode.setNextNode(currentNode.getNextNode());
                return currentNode;
            }
            previousNode = currentNode;
            currentNode = currentNode.getNextNode();
        }
        System.out.println("Object not found in linked list.");
        return null;
    }
    // de-link the node and repair the link
    // want the object of the node itself to be returned // must use a get method

    public Object set(int index, Object object) {
        //Return value should be item being replaced
        // doesn't matter - return the node or the data held by the node?
        // no - if the index given is beyond the length of the list, do we add null objects until the index wanted is reached or just return null???
        // no - do we need to do sys.out.prints for every error (i.e. invalid index provided, head is null, etc)
        if(index < 0){
            System.out.println("Negative index provided.");
            return null;
        }
        if(head == null){
            return null;
        }

        Node newNode = new Node(object);

        int currentIndex = 0;
        Node currentNode = head;
        Node previousNode = null;

        while((currentIndex < index) && (currentNode.getNextNode() != null)){
            previousNode = currentNode;
            currentNode = currentNode.getNextNode();
            currentIndex++;
        }
        if((currentIndex == index) && (index == 0)){
            head = newNode;
            head.setNextNode(currentNode.getNextNode());
            return currentNode;
        }
        // still works if want to replace node at last index
        else if(currentIndex == index){
            // this makes it so that the previous node now points to the node after currentNode (removes currentNode from the linked list, but currentNode still exists in memory)
            Node nextNode = currentNode.getNextNode();
            previousNode.setNextNode(newNode);
            newNode.setNextNode(nextNode);
            return currentNode;
        }
        else{
            System.out.println("Index provided is too high!");
            return null;
        }
    }

    public int size() {
        if(head == null){
            return 0;
        }
        int numObjects = 0;
        Node currentNode = head;
        while(currentNode != null){
            numObjects++;
            currentNode = currentNode.getNextNode();
        }
        return numObjects;
    }

    public Object get(Object object){
        if(object == null){
            return null;
        }
        if(head == null) {
            return null;
        }
        Node currentNode = head;
        while(currentNode != null){
            if(currentNode.getData().equals(object)){
                return currentNode;
            }
            currentNode = currentNode.getNextNode();
        }
        System.out.println("A node in the linked list does not contain the object provided.");
        return null;
    }


    // extra method for me to test my code
    public void print(){
        Node currentNode = head;
        int index = 0;
        while(currentNode != null){
            System.out.println(currentNode.getData().toString() + " - " + index);
            currentNode = currentNode.getNextNode();
            index++;
        }
    }

    // Node class must be in the Linked List itself
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

