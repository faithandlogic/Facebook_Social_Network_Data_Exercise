package graphs;

/*
 * LinkedQueue.java
 * Professors Prompt: Create a class LinkedQueue. A class that implements the ADT queue by using a chain of nodes that has both head and tail references.
 */
// class is made final because it is meant to be a data structure that should not be extended by other classes or overridden by other classes.
// <T> is a generic type that is used to allow the class to be used with any type of data.
// The class implements the QueueInterface interface.
public final class LinkedQueue<T> implements QueueInterface<T> {
    // as mentioned in the prompt, the class should have both head and tail references.
    private Node firstNode; // References node at front of queue
    private Node lastNode; // References node at back of queue


    // this is the default constructor for the class. It initializes the head and tail references to null. signifying that the queue is freshly created and empty.
    public LinkedQueue() {
        firstNode = null;
        lastNode = null;
    } // end default constructor

    // this method adds a new entry to the back of the queue.
    public void enqueue(T newEntry) {
        // makes a new node based on the Node class below. The new node is given the newEntry as its data and null as its next node.
        Node newNode = new Node(newEntry, null);
        // if the queue is empty, the new node is head.
        if (isEmpty())
            firstNode = newNode;
        else
            lastNode.setNextNode(newNode);
        lastNode = newNode; // if the queue was empty, the new node is head and tail. if the queue was not empty, the new node is the new tail.
    } // end enqueue

    // this method returns the data of generic type T from the front of the queue.
    public T getFront() {
        T front = null;
        if (!isEmpty())
            front = firstNode.getData();
        return front;
    } // end getFront
    
    // this method removes the front of the queue and returns the data of the removed node.
    public T dequeue() {
        T front = null;
        if (!isEmpty()) {
            front = firstNode.getData();
            firstNode = firstNode.getNextNode();
            if (firstNode == null)
                lastNode = null;
        } // end if
        return front;
    } // end dequeue

    public boolean isEmpty() {
        return (firstNode == null) && (lastNode == null);
    } // end isEmpty

    public void clear() {
        firstNode = null;
        lastNode = null;
    } // end clear

    private class Node {
        private T data; // Entry in queue
        private Node next; // Link to next node

        private Node(T dataPortion) {
            this(dataPortion, null);
        } // end constructor

        private Node(T dataPortion, Node linkPortion) {
            data = dataPortion;
            next = linkPortion;
        } // end constructor

        private T getData() {
            return data;
        } // end getData

        private void setData(T newData) {
            data = newData;
        } // end setData

        private Node getNextNode() {
            return next;
        } // end getNextNode

        private void setNextNode(Node nextNode) {
            next = nextNode;
        } // end setNextNode
    } // end Node
} // end LinkedQueue
    
