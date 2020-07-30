package medium;

import easy.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class DecodeString {

    public static void main(String[] args) {

        String input1 = "3[a]2[bc]";
        String input2 = "3[a2[c]]";
        decodeString(input1);

    }

    public static String decodeString(String s) {

        Deque<String> characterStack = new ArrayDeque<>();
        Deque<String> countStack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {

            char currentChar = s.charAt(i);

            if (Character.isDigit(currentChar)){
                countStack.push(String.valueOf(currentChar));
            } else if (Character.isAlphabetic(currentChar)) {
                int nextIdx = s.indexOf(']', i);
                String substr = s.substring(i, nextIdx);
                characterStack.push(substr);
                i = nextIdx;
            }
        }





    }
}
