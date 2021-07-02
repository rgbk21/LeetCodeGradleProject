package easy;

import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.com/problems/valid-parentheses/
public class ValidParentheses {

    public static void main(String[] args) {

        // How to use a deque as a stack
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.peek()); // Prints: 3
        System.out.println(stack.pop()); // Prints: 3
        System.out.println(stack.peek()); // Prints: 2
        System.out.println(stack.pop()); // Prints: 2
        System.out.println(stack.peek()); // Prints: 1
        System.out.println(stack.pop()); // Prints: 1

        // How to use a deque as a queue
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.remove()); // Prints: 1
        System.out.println(queue.remove()); // Prints: 2
        System.out.println(queue.remove()); // Prints: 3
        // System.out.println(queue.remove()); // Trying to remove element from empty queue Throws java.util.NoSuchElementException

        // When using poll() instead of remove()
        Deque<Integer> queue2 = new ArrayDeque<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.poll()); // Prints: 1
        System.out.println(queue.poll()); // Prints: 2
        System.out.println(queue.poll()); // Prints: 3
        System.out.println(queue.poll()); // Trying to remove element from empty queue prints null

        // Question: what do you do when the queue contains null elements as well?
        // If you remove an element and the returned element is null, does that mean it is the end of the queue
        // or does it mean that there was just a null element and there are other non-null elements after that?

    }

    public boolean isValid_v2(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        return false;
    }

    public boolean isValid(String s) {

        if (s.isEmpty()) return true;
        Deque<String> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++){

            // How to convert a character to a string
            String charInStr = String.valueOf(s.charAt(i));

            if(charInStr.equals("}") || charInStr.equals("]") || charInStr.equals(")")){
                String charInStack = stack.poll();
                if (charInStack == null || charInStack.isEmpty()) return false;
                if (charInStr.equals("}") && !charInStack.equals("{")) return false;
                if (charInStr.equals("]") && !charInStack.equals("[")) return false;
                if (charInStr.equals(")") && !charInStack.equals("(")) return false;
            }
            if(charInStr.equals("{") || charInStr.equals("[") || charInStr.equals("(")){
                stack.push(charInStr);
            }
        }
        if (stack.size() != 0) return false;

        return true;

    }

}
