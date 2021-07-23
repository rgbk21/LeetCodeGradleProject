package easy;

// https://leetcode.com/problems/closest-binary-search-tree-value/
public class ClosestBinarySearchTreeValue {

    public static void main(String[] args) {

    }

    public int closestValue(TreeNode root, double target) {
        TreeNode curr = root;
        double[] minDiffOverall = new double[]{Math.abs(target - curr.val), root.val};
        calculateClosestValue(curr, target, minDiffOverall);
        return (int) minDiffOverall[1];
    }

    private double[] calculateClosestValue(TreeNode curr, double target, double[] minDiffOverall) {

        if (curr == null) return minDiffOverall;
        double currDiff = Math.abs(curr.val - target);

        if (currDiff < minDiffOverall[0]) {
            minDiffOverall[0] = currDiff;
            minDiffOverall[1] = curr.val;
        }

        if (target < curr.val) {
            curr = curr.left;
        } else if (target > curr.val) {
            curr = curr.right;
        } else if (target == curr.val) {
            minDiffOverall[0] = 0;
            minDiffOverall[1] = curr.val;
            return minDiffOverall;
        }

        return calculateClosestValue(curr, target, minDiffOverall);
    }

}
