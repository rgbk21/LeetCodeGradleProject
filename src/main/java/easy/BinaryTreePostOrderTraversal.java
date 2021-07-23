package easy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreePostOrderTraversal {

    public static void main(String[] args) {

    }

    // The algorithm is that we push each node twice onto the stack. Each time we pop a node out,
    // if we see that there is a same node on the stack, we know that we have not done traversing yet,
    // and need to keep pushing the current node's children onto the stack.
    // However, if the stack is empty, or the top element is not the same as the current element,
    // we know that we're done searching with this node, thus we can add this node to the result.
    public List<Integer> postorderTraversal(TreeNode root) {

        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        TreeNode cur = null;
        stack.push(root);
        stack.push(root);

        while (!stack.isEmpty()) {
            cur = stack.pop();
            if (!stack.isEmpty() && stack.peek() == cur) {
                if (cur.right != null) {
                    stack.push(cur.right);
                    stack.push(cur.right);
                }
                if (cur.left != null) {
                    stack.push(cur.left);
                    stack.push(cur.left);
                }
            } else {
                result.add(cur.val);
            }
        }
        return result;
    }

}
