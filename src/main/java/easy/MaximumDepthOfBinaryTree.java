package easy;

public class MaximumDepthOfBinaryTree {

    public static void main(String[] args) {

    }

    public int maxDepth(TreeNode root) {

        int answer = 0;
        if (root == null) return answer;
        int maxLeftDepth = calculateMaxDepth(root.left, 1);
        int maxRightDepth = calculateMaxDepth(root.right, 1);
        return Math.max(maxLeftDepth, maxRightDepth);
    }

    private int calculateMaxDepth(TreeNode node, int depth) {
        if (node == null) return depth;
        int l = calculateMaxDepth(node.left, depth + 1);
        int r = calculateMaxDepth(node.right, depth + 1);
        return Math.max(l, r);
    }

}
