package LinkedQueueADT;

import LinkedList.LinkedList;
import LinkedList.Exceptions;

public class LinkedQueue<E> {

    private LinkedList l1;

    public LinkedQueue(){
        l1 = new LinkedList();
    }

    public void push(E data){
        l1.Postpend(data);
    }

    public E pop() throws Exceptions {
        E result;
        if ((l1.getCount() == 0)) {
            System.out.println("Queue is empty.");
            result = null;
        } else {
            System.out.println("Removing First element: " + l1.getFirstNode() + "\tValue: " + l1.getFirstNode().getData());
                result = (E) l1.getFirstNode();
                l1.RemoveFromFront();
            }
            return result;
        }

    public E peek(){
        E result;
        System.out.println("Peek First element: " + l1.getFirstNode() + "\tValue: " + l1.getFirstNode().getData());
        result = (E) l1.getFirstNode();
        return result;
    }

    public void empty(){
        l1.setFirstNode(null);
    }

    public void displayQueue(){
        l1.Display();
    }

    // Exercise 1
    public void concatenate(LinkedQueue<E> Q2){
        l1.getLastNode().setNext(Q2.l1.getFirstNode());
        l1.setLastNode(Q2.l1.getLastNode());
        Q2.empty();
    }
}
