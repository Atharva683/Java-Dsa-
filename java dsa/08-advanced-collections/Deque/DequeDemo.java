/**
 * Demonstrates the usage of Deque in Java.
 */

import java.util.*;

public class DequeDemo {

    public static void main(String[] args) {
        System.out.println("=== Deque - Double-Ended Queue ===");

        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(10);
        deque.addLast(20);
        deque.addFirst(5);
        deque.addLast(30);

        System.out.println("Deque: " + deque);
        System.out.println("Remove first: " + deque.removeFirst());
        System.out.println("Remove last: " + deque.removeLast());
        System.out.println("After removals: " + deque);

        // Using Deque as Stack
        Deque<String> stack = new ArrayDeque<>();
        stack.push("Bottom");
        stack.push("Middle");
        stack.push("Top");

        System.out.println("Deque as Stack: " + stack);
        System.out.println("Pop: " + stack.pop());
        System.out.println("After pop: " + stack);
    }
}