package easy;

public class RangeSumOfBST {

    public static void main(String[] args) {

    }

    public int rangeSumBST(TreeNode root, int low, int high) {

        int[] runningSum = new int[1];
        calculateSum(root,runningSum, low, high);
        return runningSum[0];
    }

    private void calculateSum(TreeNode node,int[] runningSum ,int low, int high) {

        if (node == null) return;
        if (node.val >= low && node.val <= high) runningSum[0] += node.val;
        calculateSum(node.left, runningSum, low, high);
        calculateSum(node.right, runningSum, low, high);

    }

}
