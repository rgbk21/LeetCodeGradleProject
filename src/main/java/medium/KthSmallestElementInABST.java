package medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class KthSmallestElementInABST {

    public static void main(String[] args) {

    }

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        populateInOrderTraversalOfNodes(root, list);
        return list.get(k-1);
    }

    private void populateInOrderTraversalOfNodes(TreeNode root, List<Integer> list) {

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;
        if (root == null) return;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            list.add(curr.val);
            curr = curr.right;
        }
    }

}
