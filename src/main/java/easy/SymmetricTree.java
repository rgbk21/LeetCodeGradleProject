package easy;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class SymmetricTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        root.left.left.left = new TreeNode(5);
        root.left.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(8);

        root.right.left.left = new TreeNode(8);
        root.right.left.right = new TreeNode(7);
        root.right.right.left = new TreeNode(6);
        root.right.right.right = new TreeNode(5);

        SymmetricTree.isSymmetric_v2(root);

        // How does the Deque implementation differ between LinkedList and ArrayDeque?
        Deque<String> linkedListDequeue = new LinkedList<>();
         linkedListDequeue.add(null);
         linkedListDequeue.add(null);
        System.out.println(linkedListDequeue); // Prints: [null, null]

        Deque<String> arrayDeque = new ArrayDeque<>();
//        arrayDeque.add(null); // Throws a Null Pointer Exception

        SymmetricTree.isSymmetric_v3(root);

    }

    public boolean isSymmetric_review(TreeNode root){
        if (root == null) return true;
        boolean result = isMirrorImage_review(root.left, root.right);
        return result;
    }

    private boolean isMirrorImage_review(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null) return false;

        if (node1.val != node2.val) return false;
        boolean left = isMirrorImage_review(node1.left, node2.right);
        boolean right = isMirrorImage_review(node1.right, node2.left);
        return left && right;
    }


    // Recursive Solution
    public static boolean isSymmetric_v3(TreeNode root){
        return isMirrorImage(root.left, root.right);
    }

    private static boolean isMirrorImage(TreeNode node1, TreeNode node2) {

        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null) return false;
        if (node1.val != node2.val) return false;

        boolean isLeftAMirrorImage = isMirrorImage(node1.left, node2.right);
        boolean isRightAMirrorImage = isMirrorImage(node1.right, node2.left);
        return isLeftAMirrorImage && isRightAMirrorImage;
    }

    // Incorrect recursive solution that you were thinking about. Run through the debugger to see how the solution that you were thinking about is wrong
    // You are only traversing the left most and the right most branch of the tree in the case when you use this
    // Hence instead of this you should really be using: isMirrorImage(node1.left, node2.right) && isMirrorImage(node1.right, node2.left);
    private static boolean isMirrorImage_incorrect(TreeNode node1, TreeNode node2) {

        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null) return false;
        if (node1.val != node2.val) return false;

        return isMirrorImage_incorrect(node1.left, node2.right);
    }

    // Iterative Solution
    public static boolean isSymmetric_v2(TreeNode root) {

        Deque<TreeNode> queue = new LinkedList<>();
        // Why is the root being added twice to the queue?
        queue.add(root);
        queue.add(root);
        queue.add(null);

        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            if (node1 == null && node2 == null) continue;
            if (node1 == null || node2 == null) return false;
            if (node1.val != node2.val) return false;

            queue.add(node1.left);
            queue.add(node2.right);
            queue.add(node1.right);
            queue.add(node2.left);
        }

        return true;
    }

    public static boolean isSymmetric(TreeNode root) {

        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        if (root.left == null && root.right != null) return false;
        if (root.left != null && root.right == null) return false;
        if (root.left == root.right) return true;

        TreeNode leftRoot = root.left;
        TreeNode rightNode = root.right;


        return false;
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
