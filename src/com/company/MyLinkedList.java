package com.company;

public class MyLinkedList {

    private Node head;
    private boolean isDoubly;
    private boolean isCircly;

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public boolean isDoubly() {
        return isDoubly;
    }

    public void setDoubly(boolean doubly) {
        isDoubly = doubly;
    }

    public boolean isCircly() {
        return isCircly;
    }

    public void setCircly(boolean circly) {
        isCircly = circly;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    // always use tail, but it is most important for circly
    private Node tail;


    // SHOULD I ALSO HAVE A CONSTRUCTOR FOR A NORMAL LINKED LIST (like the auto-generated constructur from pt 1)
    // previousNode can only be used with doubly LLs!!!
    // if a circly only has one node, does previous and next node just both point to itself??? -- yes

    public MyLinkedList(boolean isDoubly, boolean isCircly){
        this.isDoubly = isDoubly;
        this.isCircly = isCircly;
    }

    public MyLinkedList(){

    }


    //done
    public boolean add(Object object) {
        if(object == null){
            System.out.println("The object provided is null.");
            return false;
        }
        Node newNode = new Node(object);
        boolean atEnd = false;
        if(head != null){
            Node node = head;
            while(node.getNextNode() != null && atEnd == false){
                node = node.getNextNode();
                if(node == tail){
                    atEnd = true;
                }
            }
            node.setNextNode(newNode);
            tail = newNode;
            if(isDoubly){
                newNode.setPreviousNode(node);
            }
            if(isCircly){
                newNode.setNextNode(head);
            }
            if(isCircly && isDoubly){
                head.setPreviousNode(newNode);
            }
        }
        else{
            head = newNode;
            tail = newNode;
            if(isCircly){
                head.setNextNode(tail);
                tail.setNextNode(head);
            }
            if(isCircly && isDoubly){
                head.setNextNode(tail);
                tail.setNextNode(head);
                head.setPreviousNode(tail);
                tail.setPreviousNode(head);
            }
        }
        // if you had a size limit, it would return false
        return true;
    }

    //DONE
    public void add(int index, Object object) {
        if ((object == null) || (index < 0)) {
            // if the passed through object is null, don't need to try to add a null object into the linked list
            System.out.println("The head is null and/or the index provided is negative.");
            return;
        }
        Node newNode = new Node(object);
        if ((head == null) && (index == 0)) {
            head = newNode;
            tail = newNode;
            if(isCircly){
                head.setNextNode(tail);
                tail.setNextNode(head);
            }
            if(isCircly && isDoubly){
                head.setNextNode(tail);
                tail.setNextNode(head);
                head.setPreviousNode(tail);
                tail.setPreviousNode(head);
            }
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
            boolean atEnd = false;
            while((currentIndex < index) && (currentNode.getNextNode() != null) && atEnd == false){
                previousNode = currentNode;
                currentNode = currentNode.getNextNode();
                currentIndex++;
                if(currentNode == tail){
                    atEnd = true;
                }
            }
            if((currentIndex == index) && (index == 0)){
                newNode.setNextNode(head);
                if(isDoubly){
                    head.setPreviousNode(newNode);
                }
                head = newNode;
                if(isCircly){
                    // necessary because the head has changed
                    tail.setNextNode(head);
                }
            }
            // NOOOO! it could be circly and keep going through the list until it finds the index and the object matching it! oh no!
            else if(currentIndex == index){
                previousNode.setNextNode(newNode);
                newNode.setNextNode(currentNode);
                if(isDoubly){
                    newNode.setPreviousNode(previousNode);
                    currentNode.setPreviousNode(newNode);
                }
            }
            // will get here if currentNode is the last node of the list
            else if(currentIndex == index - 1){
                // the isDoubly and isCircly conditions are taken care of within add()
                add(object);
            }
            // else, index provided is too high for the list, so nothing happens
            else{
                System.out.println("Index provided is too high!");
            }
        }
    }

//DONE //done
    public void addFirst(Object object) {
        if(object == null){
            return;
        }
        Node newNode = new Node(object);
        if(head == null){
            head = newNode;
            tail = newNode;
        }
        else{
            newNode.setNextNode(head);
            if(isDoubly){
                head.setPreviousNode(newNode);
            }
            if(isCircly){
                tail.setNextNode(newNode);
            }
            if(isCircly && isDoubly){
                newNode.setPreviousNode(tail);
            }
            head = newNode;
        }
    }

    //DONE //done
    public void addLast(Object object) { //Identical to add but with a void return type
        add(object);
    }

    //DONE //done
    public void clear() {
        //Empties LL
        // yes - can you assume that all objects in the linked list are not null? otherwise, you can't call .getNextNode bc can't call a method on a null object
        head = null;

        // is it necessary to null the tail so that the linked list cant be identified at all?
        tail = null;

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

    //DONE //done - must consider that a circly would result in an infinite loop
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
            // after it checks if the tail has the data, it will end the method so that it doesn't go in an infinite loop if it is circular
            if(currentNode == tail){
               return false;
            }
            currentNode = currentNode.getNextNode();
        }
        return false;
    }

    //DONE //done - must consider that a circly would result in an infinite loop
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
            // prevents an infinite loop going through the linked list over and over if it's a circly
            if(currentNode == tail){
                return null;
            }
            currentIndex++;
            currentNode = currentNode.getNextNode();
        }
        return null;
    }

    //DONE //done - doesn't change because the method doesn't alter the list or go through it (no chance of infinite loop)
    public Object getFirst() {
        if(head == null){
            return null;
        }
        else{
            return head;
        }
    }

    //DONE //done - just returned tail instead but kept o.g. method in the comments
    public Object getLast() {
        return tail;
        /*
        Code from original project where tail instance variable didn't exist:
        if(head == null){
            return null;
        }
        Node currentNode = head;
        while(currentNode.getNextNode() != null){
            currentNode = currentNode.getNextNode();
            if(currentNode == tail){
                return currentNode;
            }
        }
        return currentNode;

         */
    }

    //DONE //done
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
            // after checking the tail, it will return -1 if it's at the tail so that an infinite loop doesn't happen in a circly
            // bc there is no null nextNode in a circly
            if(currentNode == tail){
                return -1;
            }
            currentIndex++;
            currentNode = currentNode.getNextNode();
        }
        return -1;
    }
    // first index that of that object that it finds
    // -1 if the object doesn't exist in the linked list

    //DONE //done
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
        boolean atTail = false;
        while((currentNode != null) && (atTail == false)){
            // NO - use == here right? bc it does not specify to not compare memory locations
            if(currentNode.getData().equals(object)){
                currentFoundIndex = currentIndex;
            }
            // stops it from continuing to go throughout the list if it's a circly
            if(currentNode == tail){
                atTail = true;
            }
            currentIndex++;
            currentNode = currentNode.getNextNode();
        }
        return currentFoundIndex;


    }
    // return index of the last place it saw that object


    //DONE  // done -- need to check with all test cases
    public Object poll() { //Returns head element -- the old head element, right??, should it return the data of the head node or the node itself?
        if(head == null){
            return null;
        }
        if(head == tail){
            Node prevHead = head;
            head = null;
            tail = null;
            return prevHead;
        }
        Node oldHead = head;
        head = head.getNextNode();
        if(isDoubly){
            head.setPreviousNode(null);
        }
        if(isCircly){
            tail.setNextNode(head);
        }
        if(isDoubly && isCircly){
            head.setPreviousNode(tail);
        }
        return oldHead;
    }
    // the second thing becomes the first IF there is a second element
    // so otherwise does it just leave the head to be null???

    //DONE //done
    public Object pollLast() { //Returns tail element
        if(head == null){
            return null;
        }
        if(head == tail){
            Node prevTail = tail;
            head = null;
            tail = null;
            return prevTail;
        }
        /*
        Node prevTail = tail;
        if(isCircly && isDoubly){
           tail.getPreviousNode().setNextNode(head);
           head.setPreviousNode(tail.getPreviousNode());
           return prevTail;
        }
        if(isCircly){

        }

         */


     //isCircly is taken care of later in the method
        if(isCircly && isDoubly){
            Node theTail = tail;
            tail = tail.getPreviousNode();
            tail.setNextNode(head);
            head.setPreviousNode(tail);
            return theTail;
        }
        if(isDoubly){
            Node theTail = tail;
            tail = tail.getPreviousNode();
            tail.setNextNode(null);
            return theTail;
        }

        Node currentNode = head;
        // bc of short circuit evaluation, if the next node is null, it wont even try to call getNextNode on that null object -- in case the second object is null
        while((currentNode.getNextNode() != null) && (currentNode.getNextNode().getNextNode() != null)){
            currentNode = currentNode.getNextNode();
            if(isCircly){
                // otherwise circly would be an infinite loop
                if(currentNode.getNextNode() == tail){
                    Node tailNode = tail;
                    tail = currentNode;
                    tail.setNextNode(head);
                    return tailNode;
                }
            }
        }
        // this will happen when the node after the head is null
        if(currentNode.getNextNode() == null){
            Node lastNode = head;
            head = null;
            tail = null;
            return lastNode;
        }
        // this takes the finalNode out of the linked list but does not delete it in memory (java may auto garbage it tho), does this work?
        Node finalNode = currentNode.getNextNode();
        currentNode.setNextNode(null);
        tail = currentNode;
        return finalNode;
    }

    // this method was in the rubric but not in here
    //done but need to check!
    //don't know if this will work for doubly and circly together
    public Object remove(int index) {
        // just pull out - do you need to null the object or just pull it out of the linked list?
        // consider circly and doubly

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
            if(isCircly){
                // will evaluate if we've reached the tail and the currentIndex still is too low
                if(currentNode == tail){
                    System.out.println("Index provided is too high!");
                    return null;
                }
            }
            previousNode = currentNode;
            currentNode = currentNode.getNextNode();
            currentIndex++;
        }
        // the while loop will not have evaluated here
        // need to check
        if((currentIndex == index) && (index == 0)){
            head = currentNode.getNextNode();
            // deletes the linked list if it is circly and only contains one item (bc the next node would just be null
            if(head == null){
                tail = null;
            }
            if(isCircly){
                if(head == currentNode){
                    head = null;
                    tail = null;
                }
            }
            if(head != null){
                if(isCircly){
                    tail.setNextNode(head);
                }
                if(isDoubly){
                    if(head.getNextNode() != null){
                        head.getNextNode().setPreviousNode(head);
                    }
                    head.setPreviousNode(null);
                }
                if(isCircly && isDoubly){
                    head.setPreviousNode(tail);
                }
            }
            return currentNode;
        }
        // still works if want to get node at last index
        else if(currentIndex == index){
            // this makes it so that the previous node now points to the node after currentNode (removes currentNode from the linked list, but currentNode still exists in memory)
            // already works for circly
            previousNode.setNextNode(currentNode.getNextNode());
            if(currentNode == tail){
                tail = previousNode;
                if(isDoubly && isCircly){
                    previousNode.setNextNode(head);
                    head.setPreviousNode(tail);
                }
                if(isCircly){
                    previousNode.setNextNode(head);
                }
            }
            if(isDoubly){
                if(currentNode.getNextNode() != null){
                    currentNode.getNextNode().setPreviousNode(previousNode);
                }
            }
            return currentNode;
        }
        // will get here if currentNode is the last node of the list
        else{
            System.out.println("Index provided is too high!");
            return null;
        }
    }

      /*
      part of a method i wrote previously. please ignore it.
            if(isCircly){
                if((currentNode == tail) && (currentIndex == index)){
                    Node theTail = tail;
                    tail = previousNode;
                    tail.setNextNode(head);
                    return theTail;
                }
                else if(currentNode == tail){

                }
            }
             */

    //DONE //done
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
            if(head == null){
                tail = null;
                return node;
            }
            if(head == node){
                head = null;
                tail = null;
                return node;
            }
            if(isCircly){
                tail.setNextNode(head);
            }
            if(isDoubly){
               if(head.getNextNode() != null){
                   head.getNextNode().setPreviousNode(head);
               }
               head.setPreviousNode(null);
            }
            if(isDoubly && isCircly){
                head.setPreviousNode(tail);
            }
            return node;
        }
        Node currentNode = head;
        Node previousNode = null;

        // wont evaluate if the object is at the head
        //cone
        while(currentNode != null){
            if(currentNode.getData().equals(object)){
                previousNode.setNextNode(currentNode.getNextNode());

                if(isDoubly){
                    if(currentNode.getNextNode() != null){
                        currentNode.getNextNode().setPreviousNode(previousNode);
                    }
                }
                if(isDoubly && isCircly){
                    if(currentNode == tail){
                        previousNode.setNextNode(head);
                        head.setPreviousNode(previousNode);
                    }
                }
                if(currentNode == tail){
                    tail = previousNode;
                    // for circly, already set the nextNode of the tail/previousNode to the head
                }
                return currentNode;
            }
            if(currentNode == tail){
                System.out.println("Object not found in linked list.");
                return null;
            }
            previousNode = currentNode;
            currentNode = currentNode.getNextNode();
        }
        System.out.println("Object not found in linked list.");
        return null;
    }
    // de-link the node and repair the link
    // want the object of the node itself to be returned // must use a get method

    //DONE //done
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
            if(currentNode == tail){
                //reached the tail in a circly list and the index still hasn't been reached
                System.out.println("Index provided is too high!");
                return null;
            }
            previousNode = currentNode;
            currentNode = currentNode.getNextNode();
            currentIndex++;
        }
        if((currentIndex == index) && (index == 0)){
            if(head == tail && isCircly){
                head = newNode;
                tail = newNode;
                head.setNextNode(tail);
                tail.setNextNode(head);
                if(isDoubly){
                    head.setPreviousNode(tail);
                    tail.setPreviousNode(head);
                }
                return currentNode;
            }
            head = newNode;
            head.setNextNode(currentNode.getNextNode());
            if(isCircly){
                tail.setNextNode(head);
            }
            if(isDoubly){
                if(head.getNextNode() != null){
                    head.getNextNode().setPreviousNode(head);
                }
            }
            if(isCircly && isDoubly){
                head.setPreviousNode(tail);
            }
            return currentNode;
        }
        // still works if want to replace node at last index
        else if(currentIndex == index){
            // this makes it so that the previous node now points to the node after currentNode (removes currentNode from the linked list, but currentNode still exists in memory)
            Node nextNode = currentNode.getNextNode();
            previousNode.setNextNode(newNode);
            newNode.setNextNode(nextNode);
            if(currentNode == tail){
                tail = newNode;
                if(isCircly){
                   tail.setNextNode(head);
                }
            }
            if(isDoubly){
                newNode.setPreviousNode(previousNode);
                if(newNode.getNextNode() != null){
                    newNode.getNextNode().setPreviousNode(newNode);
                }
            }
            if(isCircly && isDoubly){
                head.setPreviousNode(tail);
            }
            return currentNode;
        }
        else{
            System.out.println("Index provided is too high!");
            return null;
        }
    }

    //DONE //done
    public int size() {
        if(head == null){
            return 0;
        }
        int numObjects = 0;
        Node currentNode = head;
        boolean atEnd = false;
        while((currentNode != null) && (atEnd == false)){
            numObjects++;
            if(currentNode == tail){
                atEnd = true;
            }
            currentNode = currentNode.getNextNode();
        }
        return numObjects;
    }

    //done
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
            if(currentNode == tail){
                System.out.println("A node in the linked list does not contain the object provided.");
                return null;
            }
            currentNode = currentNode.getNextNode();
        }
        System.out.println("A node in the linked list does not contain the object provided.");
        return null;
    }

    // returns true if it has a loop, returns false if not
    //done
    public boolean floydAlgorithm(){
        if(head == null){
            return false;
        }
        Node tortoisePointer = head;
        Node harePointer = head.getNextNode();

        while(harePointer != null){
            if(harePointer == tortoisePointer){
                return true;
            }
            if(harePointer.getNextNode() != null){
                harePointer = harePointer.getNextNode().getNextNode();
                tortoisePointer = tortoisePointer.getNextNode();
            }
            else{
                return false;
            }
        }
        return false;
    }



    // extra method for me to test my code
    public void print(){
        Node currentNode = head;
        int index = 0;
        while(currentNode != null){
            System.out.print(currentNode.getData().toString() + " - " + index);
            if(currentNode == head){
                System.out.print(" - head");
            }
            if(currentNode == tail){
                System.out.print(" - tail");
            }
            if(currentNode == tail){
                System.out.println();
                return;
            }
            System.out.println();
            currentNode = currentNode.getNextNode();
            index++;
        }
    }

    // Node class must be in the Linked List itself
    public class Node {
        private Object data;
        private Node nextNode;

        private Node previousNode;

        public Node getPreviousNode() {
            return previousNode;
        }

        public void setPreviousNode(Node previousNode) {
            this.previousNode = previousNode;
        }

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

