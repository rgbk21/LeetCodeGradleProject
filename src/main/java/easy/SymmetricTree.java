package easy;

public class SymmetricTree {

    public static void main(String[] args) {
//        SymmetricTree.isSymmetric();
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
