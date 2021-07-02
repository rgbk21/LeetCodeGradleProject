package easy;

// https://leetcode.com/problems/same-tree/
public class SameTree {

    public static void main(String[] args) {

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.right.left = new TreeNode(6);
        root1.right.right = new TreeNode(7);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(6);
        root2.right.left = new TreeNode(6);
        root2.right.right = new TreeNode(7);

        SameTree.isSameTree(root1, root2);

    }

    // Review: You wanted to understand recursion, right? Well here you go...
    public static boolean isSameTree(TreeNode p, TreeNode q) {

        // p and q are both null
        if (p == null && q == null) return true;

        // one of p and q is null
        if (q == null || p == null) return false;

        if (p.val != q.val) return false;

        // This statement is the crux of the entire program basically
        // We will reach this point only if during the execution chain/stack none of the other false conditions have been satisfied
        // Note the && operator. You were confused about WHY we are actually using the && operator
        // First understand that this is the shorthand operator. So if the LHS of the expression evaluates to false, the RHS will never be executed
        // Sec
        return isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
    }

}
