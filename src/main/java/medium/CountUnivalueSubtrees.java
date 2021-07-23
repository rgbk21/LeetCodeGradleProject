package medium;

public class CountUnivalueSubtrees {

    public static void main(String[] args) {

    }

    // Correct Solution
    public int countUnivalSubtrees_v3(TreeNode root) {
        if (root == null) return 0;
        int[] count = new int[1];
        countSubtrees_v3(root, count);
        return count[0];
    }

    private boolean countSubtrees_v3(TreeNode node, int[] count){
        if (node == null) return true;
        boolean left = countSubtrees_v3(node.left, count);
        boolean right = countSubtrees_v3(node.right, count);
        if (left && right) {
            if (node.left != null && node.left.val != node.val) {
                return false;
            }
            if (node.right != null && node.right.val != node.val) {
                return false;
            }
            count[0]++;
            return true;
        }
        return false;
    }



    // Does not work either
    public int countUnivalSubtrees_v2(TreeNode root) {
        if (root == null) return 0;
        int[] count = new int[1];
        boolean isLeftUniValue = countSubtrees_v2(root, count);
        return count[0];
    }

    private boolean countSubtrees_v2(TreeNode node, int[] count) {
        if (node == null) return true;
        boolean isLeftUniValue = countSubtrees_v2(node.left, count);
        boolean isRightUniValue = countSubtrees_v2(node.right, count);
        // Current node is a leaf node and hence we can increase the count
        if (node.left == null && node.right == null) {
            count[0]++;
            return true;
        }
        // Remember that you do not want to do this.
        // You want to return false, and not true.
        // Write your code in such a manner.
        if (isLeftUniValue && isRightUniValue && node.val == node.left.val && node.val == node.right.val){
            count[0]++;
            return true;
        } else {
            return false;
        }
    }

    // Does not work
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) return 0;
        int leftCount = countSubtrees(root.left);
        int rightCount = countSubtrees(root.right);
        return Math.max(leftCount, rightCount);
    }

    private int countSubtrees(TreeNode node) {
        if (node == null) return 0;
        int leftCount = countSubtrees(node.left);
        int rightCount = countSubtrees(node.right);
        if (node.left == null && node.right == null) return 1;
        if (node.left != null && node.left.val == node.val) return leftCount + rightCount + 1;
        if (node.right != null && node.right.val == node.val) return leftCount + rightCount + 1;
        return leftCount + rightCount;
    }

}
