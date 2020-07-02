package easy;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {

    public static void main(String[] args) {



    }

    public boolean isValid(String s) {

        if (s.isEmpty()) return true;
        Deque<String> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++){
            String charInStr = String.valueOf(s.charAt(i)) ;
            if(charInStr.equals("}") || charInStr.equals("]") || charInStr.equals(")")){
                String charInStack = stack.poll();
                if (charInStack == null || charInStack.isEmpty()) return false;
                if (charInStr.equals("}") && !charInStack.equals("{")) return false;
                if (charInStr.equals("]") && !charInStack.equals("[")) return false;
                if (charInStr.equals(")") && !charInStack.equals("(")) return false;
            }
            if(charInStr.equals("{") || charInStr.equals("[") || charInStr.equals("(")){
                stack.offerFirst(charInStr);
            }
        }
        if (stack.size() != 0) return false;

        return true;

    }

}
