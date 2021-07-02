package easy;

public class SubtreeOfAnotherTree {

    public static void main(String[] args) {

    }

    // Look Mommy! I wrote my first recursive algorithm!
    public boolean isSubtree_v2(TreeNode root, TreeNode subRoot) {

        boolean[] flag = new boolean[0];
        traverseTree(root, subRoot, flag);
        return flag[1];

    }

    private void traverseTree(TreeNode node, TreeNode subRoot, boolean[] flag) {

        if (node == null) return;
        if (isNodeValidSubtree(node, subRoot)){
            flag[0] = true;
        }
        traverseTree(node.left, subRoot, flag);
        traverseTree(node.right, subRoot, flag);
    }

    private boolean isNodeValidSubtree(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null) return false;
        if (node1.val != node2.val) return false;
        return isNodeValidSubtree(node1.left, node2.left) && isNodeValidSubtree(node1.right, node2.right);
    }

    // ******************************
    // Solution from LeetCode
    // ******************************
    public boolean isSubtree(TreeNode root, TreeNode subroot) {
        if (root == null) return false;
        if (isSame(root, subroot)) return true;
        return isSubtree(root.left, subroot) || isSubtree(root.right, subroot);
    }

    private boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;

        if (s.val != t.val) return false;

        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }

}
