package easy;

import java.util.HashMap;
import java.util.Map;

public class VerifyingAnAlienDictionary {

    //https://leetcode.com/problems/verifying-an-alien-dictionary/

    public static void main(String[] args) {

        //"hello","leetcode"
        // words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"

    }

    public boolean isAlienSorted_v2(String[] words, String order){

        HashMap<Character, Integer> orderIndex = new HashMap<>();

        for (int i = 0; i < order.length(); i++){
            orderIndex.put(order.charAt(i), i);
        }

        for (int i = 0; i < words.length - 1; i++){
            String leftWord = words[i];
            String rightWord = words[i+1];
            boolean wordsAreInOrder = areTheTwoWordsLexicographic(leftWord, rightWord, orderIndex);
            if (!wordsAreInOrder) return false;
        }

        return true;
    }

    private boolean areTheTwoWordsLexicographic(String leftWord, String rightWord, HashMap<Character, Integer> orderIndex) {

        for (int i = 0; i < leftWord.length(); i++ ) {

            if (i >= rightWord.length()) break;

            if (orderIndex.get(leftWord.charAt(i)) < orderIndex.get(rightWord.charAt(i))){
                return true;
            } else if (orderIndex.get(leftWord.charAt(i)) > orderIndex.get(rightWord.charAt(i))){
                return false;
            }
        }

        if (leftWord.length() > rightWord.length()) {
            return false;
        }
        return true;
    }

    public boolean isAlienSorted(String[] words, String order) {

        Map<Character, Integer> index = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            Character currentChar = order.charAt(i);
            index.put(currentChar, i);
        }

        boolean outOfOrder = false;
        boolean sortedWords = false;

        for (int i = 0; i < words.length - 1; i++) {

            String smallerWord = words[i];
            String largerWord = words[i+1];

            int smIdx = 0;
            int lgIdx = 0;

            while (smIdx < smallerWord.length() && lgIdx < largerWord.length()) {

                if (index.get(smallerWord.charAt(smIdx)).equals(index.get(largerWord.charAt(lgIdx)))) {

                    //Nothing

                }else if (index.get(smallerWord.charAt(smIdx)).compareTo(index.get(largerWord.charAt(lgIdx))) < 0) {
                    sortedWords = true;
                    break;
                }else if (index.get(smallerWord.charAt(smIdx)).compareTo(index.get(largerWord.charAt(lgIdx))) > 0) {
                    outOfOrder = true;
                    break;
                }

                smIdx++;
                lgIdx++;

            }

            if (outOfOrder) return false;

            if (!sortedWords && (smallerWord.length() > largerWord.length())) {
                return false;
            }
        }

        return true;

    }

}
