package easy;

public class InvertBinaryTree {

    public static void main(String[] args) {

    }

    // I DO NOT FUCKING BELIEVE IT! THIS ACTUALLY WORKED!
    public TreeNode invertTree(TreeNode root) {
        swapNodes(root);
        return root;
    }

    private void swapNodes(TreeNode node) {
        if (node == null) return;
        if (node.left == null) {
            TreeNode temp = node.right;
            node.right = null;
            node.left = temp;
        } else if (node.right == null) {
            TreeNode temp = node.left;
            node.left = null;
            node.right = temp;
        } else {
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }

        swapNodes(node.left);
        swapNodes(node.right);
    }
}
