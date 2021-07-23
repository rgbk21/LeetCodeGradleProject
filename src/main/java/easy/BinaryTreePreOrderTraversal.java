package easy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// https://leetcode.com/problems/binary-tree-preorder-traversal/
public class BinaryTreePreOrderTraversal {

    public static void main(String[] args) {

    }

    public List<Integer> preorderTraversal(TreeNode root) {

        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode currNode = stack.pop();
            result.add(currNode.val);
            // Note that the right node is being pushed into the stack before the left node
            if (currNode.right != null) stack.push(currNode.right);
            if (currNode.left != null) stack.push(currNode.left);
        }

        return result;
    }
}
