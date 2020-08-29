package AmazonPractice;

import java.util.*;

public class AmazonFreshPromotion {

    //https://leetcode.com/discuss/interview-question/762546/
    public static void main(String[] args) {

        List<String> codeList1;
        List<String> codeList2;

        //[[apple, apple], [banana, anything, banana]] shoppingCart = [orange, apple, apple, banana, orange, banana]
        codeList1 = new ArrayList<>(Arrays.asList("apple", "apple"));
        codeList2 = new ArrayList<>(Arrays.asList("banana", "anything", "banana"));

        List<List<String>> codelist = new ArrayList<>();
        codelist.add(codeList1);
        codelist.add(codeList2);

        List<String> shoppingCart = new ArrayList<>(Arrays.asList("orange", "apple", "apple", "banana", "orange", "banana"));

        customerWinsPromotion(codelist, shoppingCart);

    }

    public static int customerWinsPromotion(List<List<String>> codelist, List<String> shoppingCart){

        Map<String, Integer> fruitIndex = new HashMap<>();
        int idx = 0;
        fruitIndex.put("anything", idx++);

        for (String item : shoppingCart) {

            if (!fruitIndex.containsKey(item)) {
                fruitIndex.put(item, idx++);
            }

        }

        for (List<String> itemList : codelist) {
            for (String item : itemList) {

                if (!fruitIndex.containsKey(item)) {
                    fruitIndex.put(item, idx++);
                }

            }
        }

        //codeList = [[apple, apple], [banana, anything, banana]] shoppingCart = [orange, apple, apple, banana, orange, banana]
        boolean[] visited = new boolean[shoppingCart.size()];

        for (int i = 0; i < codelist.size(); i++) {

            List<String> itemList = codelist.get(i);

            if (!isValidSubsequence(itemList, shoppingCart, visited)) return 0;


        }

        return 1;
    }

    //codeList = [[apple, apple]] shoppingCart = [orange, apple, apple, banana, orange, banana]
    private static boolean isValidSubsequence(List<String> itemList, List<String> shoppingCart, boolean[] visited){

        int index = shoppingCart.size() - itemList.size();

        for (int i = 0, j = 0; i < shoppingCart.size() && j < itemList.size(); i++) {

            String currItem = shoppingCart.get(i);
            String currCode = itemList.get(j);

            if (!currItem.equals(currCode) && !currCode.equals("anything")) {
                j = 0;
                continue;
            }

            j++;
            if (j == itemList.size()) return true;

        }

        return false;

    }



}
