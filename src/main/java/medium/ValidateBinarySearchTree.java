package medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ValidateBinarySearchTree {

    public static void main(String[] args) {

    }

    // ************************************************************************************************************************************************
    // Iterative Solution
    // ************************************************************************************************************************************************
    public boolean isValidBST(TreeNode root) {
        List<Integer> inOrderTraversalList = new ArrayList<>();
        return createInorderTraversalList(root, inOrderTraversalList);
    }

    private boolean createInorderTraversalList(TreeNode root, List<Integer> list) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;
        TreeNode prev = null;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (prev != null && curr.val <= prev.val) return false;
            prev = curr;
            curr = curr.right;
        }
        return true;
    }


    // ************************************************************************************************************************************************
    // Recursive Solution
    // ************************************************************************************************************************************************

    // Debug this solution in order to understand what is going on in this case
    public boolean validate(TreeNode root, Integer low, Integer high) {
        // Empty trees are valid BSTs.
        if (root == null) {
            return true;
        }
        // The current node's value must be between low and high.
        if ((low != null && root.val <= low) || (high != null && root.val >= high)) {
            return false;
        }
        // The left and right subtree must also be valid.
        return validate(root.right, root.val, high) && validate(root.left, low, root.val);
    }

    public boolean isValidBST_LCSoln(TreeNode root) {
        return validate(root, null, null);
    }

    public boolean isValidBST_recursive(TreeNode root) {
        if (root == null) return false;
        boolean rightSubtree = checkIfNodesAreInOrder_v2(root.right, true, root.val);
        boolean leftSubtree = checkIfNodesAreInOrder_v2(root.left, false, root.val);
        return rightSubtree && leftSubtree;
    }

    // 77 / 80 test cases passed.
    // I give up. Recursion is not for me.
    // If you get a binary tree, and you do not know what to do with it,
    // do an inorder traversal, throw everything into a list and then go from there
    // I have nothing else to say to you
    private boolean checkIfNodesAreInOrder_v2(TreeNode node, boolean isNodeRightChild, int limitVal) {

        if (node == null) return true;
        if (isNodeRightChild && node.val <= limitVal) return false;
        if (!isNodeRightChild && node.val >= limitVal) return false;
        if (node.left == null && node.right == null) return true;
        if ((node.left != null && node.left.val >= node.val) || (node.left != null && isNodeRightChild && node.left.val <= limitVal)) {
            return false;
        }
        if ((node.right != null && node.right.val <= node.val) || (node.right != null && !isNodeRightChild && node.right.val >= limitVal)) {
            return false;
        }

        return checkIfNodesAreInOrder_v2(node.left, false, node.val) && checkIfNodesAreInOrder_v2(node.right, true, node.val);
    }

    // This is wrong because you are not checking the limits of the node values
    // Check the LeetCode explanation to understand why this will not work
    private boolean checkIfNodesAreInOrder(TreeNode node) {

        if (node == null) return true;
        if (node.left == null && node.right == null) return true;
//        if (node.left == null && node.right.val <= node.val) return false;
//        if (node.right == null && node.left.val >= node.val) return false;
        if (node.left != null && node.left.val >= node.val) return false;
        if (node.right != null && node.right.val <= node.val) return false;

        return checkIfNodesAreInOrder(node.left) && checkIfNodesAreInOrder(node.right);
    }

}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}