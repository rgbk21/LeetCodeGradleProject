package easy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// https://leetcode.com/problems/binary-tree-inorder-traversal/
public class BinaryTreeInOrderTraversal {

    public static void main(String[] args) {

    }

    public List<Integer> inorderTraversal_review(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        if (root == null) return list;
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            list.add(curr.val);
            curr = curr.right;
        }
        return list;
    }

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();

        if (root == null) return list;

        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            list.add(curr.val);
            curr = curr.right;
        }

        return list;
    }

}
