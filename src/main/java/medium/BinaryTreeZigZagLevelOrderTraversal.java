package medium;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreeZigZagLevelOrderTraversal {

    public static void main(String[] args) {

    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<TreeNode>> queue = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) return result;

        // Initialize the queue
        queue.add(new ArrayList<>());
        queue.get(0).add(root);

        // Start iteration
        for (int i = 0; i < queue.size(); i++) {
            List<TreeNode> currLevel = queue.get(i);
            List<TreeNode> nextLevel = new ArrayList<>();

            for (int j = 0; j < currLevel.size(); j++) {
                TreeNode currNode = currLevel.get(j);
                if (currNode.left != null) {
                    nextLevel.add(currNode.left);
                }
                if (currNode.right != null) {
                    nextLevel.add(currNode.right);
                }
            }

            if (!nextLevel.isEmpty()) queue.add(nextLevel);
        }

        for (int i = 0; i < queue.size(); i++) {
            result.add(new ArrayList<>());
            List<TreeNode> layer = queue.get(i);
            if (i % 2 == 1) Collections.reverse(layer);
            for (int j = 0; j < layer.size(); j++) {
                result.get(i).add(layer.get(j).val);
            }
        }

        return result;
    }

}
