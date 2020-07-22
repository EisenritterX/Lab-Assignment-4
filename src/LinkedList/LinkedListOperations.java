package LinkedList;

// All operations that returns a list is in this class
public  class LinkedListOperations {
    // Assignment #1 Exercise 2
    // Concatenate two doubly linked list
    public static LinkedList Concatenate(LinkedList llist1, LinkedList llist2){
        // Set the last node's next node of 1st linked list to the first node of 2nd linked list
        llist1.getLastNode().setNext(llist2.getFirstNode());
        // Set the first node's previous node to 2nd linked list's last node
        llist2.getFirstNode().setPrev(llist1.getLastNode());
        // Resets the last node to the end of 2nd linked list's last node
        llist1.setLastNode(llist2.getLastNode());
        return llist1;
    }
    // End Method

    // Convert any linked list to a circular linked list
    public static LinkedList ConvertToCircular(LinkedList list){
        list.getLastNode().setNext(list.getFirstNode());
        list.getFirstNode().setPrev(list.getLastNode());
        return list;
    }

    /*
    // List cloning -obsolete shallow clone-
    public static LinkedList CloneList(LinkedList list){
        LinkedList clonedList=list;
        return  clonedList;
    }
    */

    // Assignment #1 Exercise 3
    // List Cloning - Deep Copy
    public static LinkedList CloneList(LinkedList list){
        LinkedList clonedList= new LinkedList();
        Node current = list.getFirstNode();
        for (int i=0;i<list.getCount();i++){
            clonedList.Postpend(current.getData());
            System.out.println(current);
            current = current.next;
        }
        // Check for whether original list is circular or not
        if(list.getLastNode().getNext()!=null){
            ConvertToCircular(clonedList);
        }
        return  clonedList;
    }

}
