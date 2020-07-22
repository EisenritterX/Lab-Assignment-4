package LinkedQueueADT;

import LinkedList.Exceptions;

public class LinkedQueueTest {
    private static LinkedQueue lq1 =  new LinkedQueue();
    private static LinkedQueue lq2 = new LinkedQueue();

    public static void main(String[] args) throws Exceptions {
        System.out.println("Q1");
        lq1.push(10);
        lq1.displayQueue();
        lq1.push(20);
        lq1.displayQueue();
        lq1.push(30);
        lq1.displayQueue();
        lq1.push(40);
        lq1.displayQueue();
        lq1.push(50);
        lq1.displayQueue();

        System.out.println("Q2");
        lq2.push("George");
        lq2.displayQueue();
        lq2.push("Michael");
        lq2.displayQueue();
        lq2.push("Jonathan");
        lq2.displayQueue();
        lq2.push("Maria");
        lq2.displayQueue();
        lq2.push("Lucy");
        lq2.displayQueue();

        // Exercise 1 Test
        System.out.println("Concatenating Q1 with Q2");
        lq1.concatenate(lq2);
        System.out.print("Q1 is: ");
        lq1.displayQueue();
        System.out.print("Q2 is: ");
        lq2.displayQueue();
        System.out.println();

        lq1.pop();
        lq1.displayQueue();

        lq1.peek();
        lq1.displayQueue();
    }
}
