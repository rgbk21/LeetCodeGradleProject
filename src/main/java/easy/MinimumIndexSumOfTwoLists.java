package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumIndexSumOfTwoLists {

    public static void main(String[] args) {

    }

    public String[] findRestaurant(String[] list1, String[] list2) {

        Map<String, Integer> list2Map = new HashMap<>();
        for (int i = 0; i < list2.length; i++) {
            list2Map.put(list2[i], i);
        }

        Map<String, Integer> commonRestScores = new HashMap<>();
        int minScore = Integer.MAX_VALUE;
        for (int i = 0; i < list1.length; i++) {
            String currRestaurant = list1[i];
            if (list2Map.containsKey(currRestaurant)) {
                Integer list2ChoiceNum = list2Map.get(currRestaurant);
                int totalScore = list2ChoiceNum + i;
                commonRestScores.put(currRestaurant, totalScore);
                minScore = Math.min(minScore, totalScore);
            }
        }

        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : commonRestScores.entrySet()) {
            if (entry.getValue() == minScore) {
                result.add(entry.getKey());
            }
        }

        return result.toArray(String[]::new);

    }

}
