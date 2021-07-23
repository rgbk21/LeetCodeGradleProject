package medium;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {

        // Does adding an element to a list change its size? Yes.
        List<Integer> list0 = new ArrayList<>();
        System.out.println("Initial size of the list: " + list0.size());
        for (int i = 0; i < 10; i++) {
            list0.add(i);
            System.out.println("Current Element at index i: " + list0.get(i) + ", current size of the list:" + list0.size());
        }

        // Does removing an element from a list change its size? Yes
        System.out.println("\nRemoving single element from list");
        list0.remove(list0.size() - 1);
        System.out.println("List: " + list0 + ", current size of the list:" + list0.size());

        // Removing elements from a list while iterating over it:
        // Does not throw any kind of exception
        System.out.println("\nRemoving elements from the list while iterating over it");
        for (int i = 0; i < list0.size(); i++) {
            System.out.println("List: " + list0 + ", value of i: " + i + ", current size of the list:" + list0.size());
            list0.remove(list0.size() - 1);
        }

        // Adding elements to a list while iterating over it. Is ok as well.
        // There is no ConcurrentModificationException on adding to a list and iterating over it at the same time
        System.out.println("\nNo ConcurrentModificationException on adding to a list");
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        for (int i = 0; i < list1.size(); i++) {
            list1.add(i + 1);
            System.out.println("Current Element at index i: " + list1.get(i) + ", current size of the list:" + list1.size());
            if (list1.size() == 10) break;
        }

        // But doing the same operations using a for-each style loop is going to throw exceptions
        // Throws ConcurrentModificationException
        List<Integer> list2 = new ArrayList<>();
        System.out.println("Initial size of the list: " + list2.size());
        list2.add(0);
        for (Integer i : list2) {
            // list2.add(i + 1);
            System.out.println("Current size of the list:" + list2.size());
        }

        // And the same for removing elements from a List as well
        List<Integer> list3 = new ArrayList<>();
        System.out.println("Initial size of the list: " + list3.size());
        // Add generic 10 elements to a new list
        for (int i = 0; i < 10; i++) {
            list3.add(i);
        }
        // Try removing elements from the list as you iterate over it
        // Throws ConcurrentModificationException
        for (Integer i : list3) {
            // list3.remove(i);
        }

        // ******************************************************************************************
        // You should not be removing elements from the list while you are iterating over it
        // https://stackoverflow.com/a/2397367/8742428
        List<Integer> anotherList = new ArrayList<>();
        // Add generic elements to the list
        for (int i = 0; i < 10; i++) {
            anotherList.add(i+1);
        }
        // Add another element 5 to the list
        anotherList.add(5,5);
        System.out.println(anotherList); // [1, 2, 3, 4, 5, 5, 6, 7, 8, 9, 10]
        // Now remove the elements while iterating over it
        for (int i = 0; i < anotherList.size(); i++) {
            if (anotherList.get(i) == 5) {
                anotherList.remove(i);
                // Oops! list.get(i) now points to some other object so if I
                // increase i again before checking that object I will have
                // skipped one item in the list
            }
        }
        // After removing elements from the list it looks like
        System.out.println("After removing elements: " + anotherList); // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        // So you can see that one element 5 is STILL there.

        // ******************************************************************************************
        // How do you remove elements from a list while iterating over the same list?
        List<Integer> anotherList2 = new ArrayList<>();
        // Add generic elements to the list
        for (int i = 0; i < 10; i++) {
            anotherList2.add(i+1);
        }
        // Add another element 5 to the list
        anotherList2.add(5,5);
        System.out.println(anotherList2); // [1, 2, 3, 4, 5, 5, 6, 7, 8, 9, 10]
        anotherList2.removeIf(num -> num == 5);
        System.out.println("After Removal: "  + anotherList2); //  [1, 2, 3, 4, 6, 7, 8, 9, 10]
    }

    // BFS. Think KT algo where you have to iterate over the graph in terms of layers.
    // Please do not get this wrong again.
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<TreeNode>> queue = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        queue.add(new ArrayList<>());
        queue.get(0).add(root);

        for (int idx = 0; idx < queue.size(); idx++) {

            List<TreeNode> currLevel = queue.get(idx);
            List<TreeNode> nextLevel = new ArrayList<>();

            for (int i = 0; i < currLevel.size(); i++) {
                TreeNode currNode = currLevel.get(i);
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
            for (int j = 0; j < queue.get(i).size(); j++) {
                result.get(i).add(queue.get(i).get(j).val);
            }
        }

        return result;
    }
}
