package easy;

public class PathSum {

    public static void main(String[] args) {

    }

    // Correct version
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        int currSum = root.val;
        if (root.left == null && root.right == null) return root.val == targetSum;
        boolean left = pathSum(root.left, currSum, targetSum);
        boolean right = pathSum(root.right, currSum, targetSum);
        return left || right;
    }

    private boolean pathSum(TreeNode node, int currSum, int targetSum) {
        if (node == null) return false;
        currSum = node.val + currSum;
        if (node.left == null && node.right == null) return currSum == targetSum;
        boolean leftAnswer = pathSum(node.left, currSum, targetSum);
        boolean rightAnswer = pathSum(node.right, currSum, targetSum);
        return leftAnswer || rightAnswer;
    }

    public boolean hasPathSum_incorrectVersion(TreeNode root, int targetSum) {
        if (root == null) return false;
        int currSum = root.val;
        boolean left = pathSum_incorrectVersion(root.left, currSum, targetSum);
        boolean right = pathSum_incorrectVersion(root.right, currSum, targetSum);
        return left || right;
    }

    private boolean pathSum_incorrectVersion(TreeNode node, int currSum, int targetSum) {
        // Your logic is incorrect. Think if the input was this tree: [null, 1, 2] and the targetSum was 1
        // You would return true. Because you would have read 1 as a leaf node. You do not want that to happen.
        // A leaf is defined as a leaf node only if BOTH of its children are null
        if (node == null) return currSum == targetSum;
        if (node.left == null && node.right == null) return currSum == targetSum;
        currSum = node.val + currSum;
        boolean leftAnswer = pathSum_incorrectVersion(node.left, currSum, targetSum);
        boolean rightAnswer = pathSum_incorrectVersion(node.right, currSum, targetSum);
        return leftAnswer || rightAnswer;
    }

}
