package LinkedList;

public class Node<T> {

    private T data;
    // Getter for Data
    public T getData() {
        return data;
    }
    // Setter for Data
    public void setData(T data) {
        this.data = data;
    }

    // Reference for Previous node
    public Node<T> prev;
    // Getter of Next
    public Node<T> getPrev() {
        return prev;
    }
    // Setter for Next
    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }

    // Reference for Next node
    public Node<T> next;
    // Getter of Next
    public Node<T> getNext() {
        return next;
    }
    // Setter for Next
    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node(T dataValue){
        data = dataValue;
    }
    //Constructor Overloading if has nextNode
    public Node(T dataValue, Node<T> nextNode){
        data = dataValue;
        next = nextNode;
    }
    // Constructor for building Doubly Linked List
    public  Node(T dataValue, Node<T> nextNode, Node<T> prevNode){
        data = dataValue;
        next = nextNode;
        prev = prevNode;
    }
}
