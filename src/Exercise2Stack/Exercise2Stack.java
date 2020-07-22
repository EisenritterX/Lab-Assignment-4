package Exercise2Stack;

import java.util.Stack;

public class Exercise2Stack {
    // Initialize Stack Memory
    private static Stack s1 = new Stack();
    private static Stack s2 = new Stack();

    public static void main(String[] args) {
        // Populating Stack 1
        System.out.println("Stack 1");
        s1.push(10);
        s1.push(20);
        s1.push(30);
        s1.push(40);
        s1.push(50);
        System.out.println(s1.toString());

        // Populating Stack 2
        System.out.println("Stack 2");
        s2.push("George");
        s2.push("Michael");
        s2.push("Reza");
        s2.push("Corsair K68");
        s2.push("Corsair Vengeance");
        System.out.println(s2.toString());

        // Testing Exercise 2
        System.out.println("Transferring Stack 2 onto Stack 1");
        transfer(s1,s2);
        System.out.println(s1.toString());
    }

    public static void transfer(Stack S, Stack T){
        // Push the top of T to S while emptying T
        while (!T.isEmpty()){ S.push(T.pop());}
    }
}
