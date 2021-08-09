package Collections.Deques;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeTest {

    public static void main(String[] args) {

        // *************************************************************************
        // Using a Deque as a FIFO Queue
        // *************************************************************************

        Deque<String> queue = new ArrayDeque<>();
        queue.offerLast("Alice");
        queue.offerLast("Bob");
        queue.offerLast("Charlie");

        System.out.println("queue: " + queue); // [Alice, Bob, Charlie]

        System.out.println("queue.peekFirst(): " + queue.peekFirst()); // Alice
        System.out.println("queue.pollFirst(): " + queue.pollFirst()); // Alice

        System.out.println("queue.peekFirst(): " + queue.peekFirst()); // Bob
        System.out.println("queue.pollFirst(): " + queue.pollFirst()); // Bob

        System.out.println("queue.peekFirst(): " + queue.peekFirst()); // Charlie
        System.out.println("queue.pollFirst(): " + queue.pollFirst()); // Charlie

        // Queue is empty now. We are using the version which does not throw exception but returns null.
        System.out.println("queue.peekFirst(): " + queue.peekFirst()); // null
        System.out.println("queue.pollFirst(): " + queue.pollFirst()); // null

        // *************************************************************************
        // Using a Deque as a Stack
        // *************************************************************************

        Deque<String> stack = new ArrayDeque<>();
        stack.push("Alice");
        stack.push("Bob");
        stack.push("Charlie");

        System.out.println("stack: " + stack); // [Charlie, Bob, Alice]

        System.out.println("stack.peek(): " + stack.peek()); // Charlie
        System.out.println("stack.poll(): " + stack.poll()); // Charlie

        System.out.println("stack.peek(): " + stack.peek()); // Bob
        System.out.println("stack.poll(): " + stack.poll()); // Bob

        System.out.println("stack.peek(): " + stack.peek()); // Alice
        System.out.println("stack.poll(): " + stack.poll()); // Alice

        // Stack is empty now. We are using the version which does not throw exception but returns null.
        System.out.println("stack.peek(): " + stack.peek()); // null
        System.out.println("stack.poll(): " + stack.poll()); // null
    }
}
