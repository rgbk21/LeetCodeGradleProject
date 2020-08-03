package easy;

import java.util.HashMap;
import java.util.Map;

public class VerifyingAnAlienDictionary {

    //https://leetcode.com/problems/verifying-an-alien-dictionary/

    public static void main(String[] args) {

        //"hello","leetcode"

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
