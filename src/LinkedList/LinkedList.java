package LinkedList;

// All Node based operation is in this clas
public class LinkedList {
    private Node firstNode;
    private Node lastNode;
    private String name; // string like "list" to display
    private int count;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Constructors

    // Construct empty List with unspecified
    public LinkedList(){
        name="Unnamed List";
        firstNode = lastNode = null;
        count = 0;
    }
    // Construct empty List with specified name
    public LinkedList(String listName){
        name=listName;
        firstNode = lastNode = null;
        count = 0;
    }

    // End Constructors
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Getters and Setters

    // Get First Node
    public Node getFirstNode() {
        return firstNode;
    }

    // Set First Node
    public Object setFirstNode(Node firstNode) {
        this.firstNode = firstNode;
        return null;
    }

    // Get Last Node
    public Node getLastNode() {
        return lastNode;
    }

    // Set Last Node
    public void setLastNode(Node lastNode) {
        this.lastNode = lastNode;
    }

    public int getCount() {
        return count;
    }

    // Get Name of the List
    public String getName() {
        return name;
    }

    // End Getters and Setters
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



    // Insert object Node in front
    public<T> void Prepend(T data){
        if (IsEmpty()){
            firstNode=lastNode = new Node(data);
            count ++;

        }else{
            firstNode = new Node(data,firstNode);
            firstNode.getNext().setPrev(firstNode); // Updated with doubly linked list
            count++;
        }

    }

    // Insert object Node at back
    public<T> void Postpend(T data){
        if (IsEmpty()){
            firstNode = lastNode = new Node(data);
            count++;
        }
        else {
            lastNode = lastNode.next= new Node(data,null,lastNode); // Updated for doubly linked list
            count++;
        }
    }

    // Remove first node from List
    public <T> T RemoveFromFront() throws Exceptions {
        if (IsEmpty()){
            throw new Exceptions("Empty List",
            "The List is empty, please make sure there are items in list first.");
        }

        T removeItem = (T)firstNode.getData();
        // If first node is the last node, then set it to null, else, the next node becomes the first node.
        firstNode = (firstNode==lastNode)?lastNode=null:firstNode.next;
        firstNode.setPrev(null);
        count--;
        return removeItem;
    }

    // Remove last node from List -- Singly Linked List, Reenable if working on singly linked list
    /*
    public <T> T RemoveFromBack() throws Exceptions {
        if (IsEmpty()){
            throw new Exceptions("Empty List",
                    "The List is empty, please make sure there are items in list first.");
        }

        T removeItem = (T)lastNode.getData();
        // If first node is the last node, then set it to null, else, the next node becomes the first node.
        if(firstNode == lastNode){
            firstNode = lastNode =null;
        }
        else{
            Node current = firstNode;
            // Loop throw list until current node is the one before l;ast node
            while (current.next != lastNode){
                current = current.next; // move to next node
            }
            lastNode = current; // set last node to current node
            current.next = null; // empty last node
        }

        return removeItem;
    } End Method
    */

    // Remove last node from list -- Doubly Linked List
    public <T> T RemoveFromBack() throws Exceptions {
        if (IsEmpty()){
            throw new Exceptions("Empty List",
                    "The List is empty, please make sure there are items in list first.");
        }

        T removeItem = (T)lastNode.getData();
        // If first node is the last node, then set it to null, else, the next node becomes the first node.
        if(firstNode == lastNode){
            firstNode = lastNode =null;
            count--;
        }
        else{
            lastNode=lastNode.getPrev();
            lastNode.setNext(null);
            count--;
        }

        return removeItem;
    }


    // Search for a node by node in the list
    public Node SearchNode(Node node) throws Exceptions {
        if (IsEmpty()){
            throw new Exceptions("Empty List",
                    "The List is empty, please make sure there are items in list first.");
        }
        Node current = firstNode;
        // Loop through the list till node is found
        while (current!=lastNode){
            if (current == node)
                return current;
            else {
                current = current.next;
            }
        }
        return null;
    }
    public Node SearchPrev(Node node) throws Exceptions {
        if (IsEmpty()){
            throw new Exceptions("Empty List",
                    "The List is empty, please make sure there are items in list first.");
        }
        Node current = firstNode;

            while (current!=lastNode){
                if (current.next == node)
                    return current;
                else {
                    current = current.next;
                }
            }
            return null;

        }

    // Search for a node by data in the list
    public<T> Node SearchNode(T data) throws Exceptions {
        if (IsEmpty()){
            throw new Exceptions("Empty List",
                    "The List is empty, please make sure there are items in list first.");
        }
        Node current = firstNode;
        // Loop through the list till node is found
        while (current!=lastNode&&current.next!=null&&!current.getData().equals(data)){
                current = current.next;
            }
        return ((current.getData()).equals(data))?current:null;
    }

    // Assignment #1 Addon: Swap Nodes -- Only using Node prev and Node next due to restrictions of singly linked list
    public<T> void SwapNodes(T data1, T data2) throws Exceptions {
        if(data1==data2){
            throw new Exceptions("Same Value",
                    "The two values searching for are the same, please specify node or input different values"
                            + "");
        }

        //Storing all node in Temp Positions

        Node node1Prev = SearchPrev(SearchNode(data1)) ;
        Node node1 = SearchNode(data1);
        Node node1Next = SearchNode(data1).next ;
        Node node2Prev = SearchPrev(SearchNode(data2)) ;
        Node node2 = SearchNode(data2);
        Node node2Next = SearchNode(data2).next ;

        // Find Initial Position
        if(node1!=null) System.out.println(data1+"'s Initial Node Address is: " +node1);
        if(node2!= null) System.out.println(data2+"'s Initial Node Address is: "+node2);

        if (node1 == firstNode && node2 == lastNode){
            node2.setNext(node1Next);
            firstNode = node2;
            node1.next = null;
            lastNode =  node1;
            node2Prev.setNext(node1);
        }
        else if(node2 == firstNode && node1 == lastNode){
            node1.setNext(node2Next);
            firstNode = node1;
            node2.next = null;
            lastNode = node2;
            node1Prev.setNext(lastNode);
        }
        else if (node1==firstNode){
            if(node1.getNext() == node2){
                node1.setNext(node2Next);
                node2.setNext(node1);
                firstNode = node2;
            }
            else{
            node2.setNext(node1Next);
            firstNode = node2;
            node1.setNext(node2Next);
            node2Prev.setNext(node1);
        }}
        else if (node1==lastNode){
            if(node2.getNext() == node1){
                node2.setNext(null);
                node1.setNext(node2);
                node1Prev.setNext(node1);
                lastNode = node2;
            }else{
            node2.setNext(null);
            lastNode = node2;
            node1.setNext(node2Next);
            node2Prev.setNext(node1);
            node1Prev.setNext(node2);
        }}
        else if (node2 == firstNode){
            if(node2.getNext() == node1){
                node2.setNext(node1Next);
                node1.setNext(node2);
                firstNode = node1;
            }
            else{
            node1.setNext(node2Next);
            firstNode = node1;
            node2.setNext(node1Next);
            node1Prev.setNext(node2);}
        }
        else if (node2 == lastNode){
            if(node1.getNext() == node2){
                node1.setNext(null);
                node2.setNext(node1);
                node1Prev.setNext(node2);
                lastNode = node1;
            }else{
            node1.setNext(null);
            lastNode = node1;
            node2.setNext(node1Next);
            node1Prev.setNext(node2);
            node2Prev.setNext(node1);
            }
        }
        else{
            node1.setNext(node2Next);
            node2.setNext(node1Next);
            node1Prev.setNext(node2);
            node2Prev.setNext(node1);
        }
    }



    // Check for empty list
    public boolean IsEmpty(){
        return firstNode == null;
    }

    // Output List contents
    public void Display()
    {
        if (IsEmpty()){System.out.println(name+" is Empty");}
        else
        {
            Node current = firstNode;
            // output current node data while not at end of list
            while (current != null)
            {
                System.out.print(current.getData() + " ");
                current = current.next;
            }
            System.out.println("\n");
        }
    }

    // Display Circular List Contents
    public void DisplayCircular( int iteration){
        if (IsEmpty()){System.out.println(name+" is Empty");}
        else
        {
            Node current = firstNode;
            int counter = 0;
            // output current node data while not at end of list
            while (current != null && counter<iteration)
            {
                counter = current==lastNode?counter+1:counter+0;
                System.out.print(current.getData() + " ");
                current = current.next;
            }
            System.out.println("\n");
        }
    }

}
