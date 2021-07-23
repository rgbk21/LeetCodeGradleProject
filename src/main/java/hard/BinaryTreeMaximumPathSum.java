package hard;

public class BinaryTreeMaximumPathSum {

    public static void main(String[] args) {

    }

    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        int[] maxSum = new int[1];
        maxSum[0] = Integer.MIN_VALUE;
        calculatePathSum(root, maxSum);
        return maxSum[0];
    }

    private int calculatePathSum(TreeNode node, int[] maxSum) {
        if (node == null) return 0;
        int left = Math.max(calculatePathSum(node.left, maxSum), 0);
        int right = Math.max(calculatePathSum(node.right, maxSum), 0);
        int currSum = node.val + left + right;
        if (currSum > maxSum[0]) maxSum[0] = currSum;
        return Math.max(left + node.val, right + node.val);
    }


    public int maxPathSum_incorrect(TreeNode root) {
        if (root == null) return 0;
        int[] maxSum = new int[1];
        maxSum[0] = Integer.MIN_VALUE;
        return calculatePathSum_incorrect(root, maxSum);
    }

    private int calculatePathSum_incorrect(TreeNode node, int[] maxSum) {

        if (node == null) return 0;
        int leftSum = calculatePathSum_incorrect(node.left, maxSum);
        int rightSum = calculatePathSum_incorrect(node.right, maxSum);
        int sumOfSubtree = Math.max(leftSum, rightSum) + node.val;
        if (sumOfSubtree > maxSum[0]){
            maxSum[0] = sumOfSubtree;
        }
        return sumOfSubtree;
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
