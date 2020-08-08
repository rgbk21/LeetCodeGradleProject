package medium;

import java.util.*;

public class TopKFrequentWords {

    public static void main(String[] args) {

    }

    public List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> wordCount = new HashMap<>();
        List<String> result = new ArrayList<>();

        for (String word : words) {
            wordCount.merge(word, 1, (oldValue, value) -> oldValue + 1);
        }

        List<Map.Entry<String, Integer>> sortedWords = new ArrayList<>(wordCount.entrySet());

        sortedWords.sort((entry1, entry2) -> {
            if (entry1.getValue().compareTo(entry2.getValue()) > 0) {
                return -1;
            } else if (entry1.getValue().compareTo(entry2.getValue())< 0) {
                return 1;
            } else {
                if (entry1.getKey().compareTo(entry2.getKey()) > 0) {
                    return 1;
                } else if (entry1.getKey().compareTo(entry2.getKey()) < 0) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        for (int i = 0; i < k; i++) {
            result.add(sortedWords.get(i).getKey());
        }

        return result;

    }

}
