package medium;

import java.util.*;

public class WordLadder {

    //https://leetcode.com/problems/word-ladder/
    public static void main(String[] args) {

        String beginWord = "hit";
        String endWord = "cog";
        String[] wordArray = {"hot","dot","dog","lot","log","cog"};
        List<String> wordList = new ArrayList<>(Arrays.asList(wordArray));

        WordLadder ladder = new WordLadder();
        ladder.ladderLength_3(beginWord, endWord, wordList);

    }

    /*
    Input:
    beginWord = "hit",
    endWord = "cog",
    wordList = ["hot","dot","dog","lot","log","cog"]
    "hit" -> "hot" -> "dot" -> "dog" -> "cog"
    */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        List<List<String>> wordTransGraph = new ArrayList<>();
        wordTransGraph.add(new ArrayList<>());
        wordTransGraph.get(0).add(beginWord);

        boolean[] visited = new boolean[wordList.size()];
        Queue<String> queue = new ArrayDeque<>();
        queue.add(beginWord);

        List<Queue<String>> levels = new ArrayList<>();
        levels.add(queue);

        int distFromBegin = 0;
        boolean newWordAdded = true;
        //wordList = ["hot","dot","dog","lot","log","cog"]

        int depth = 0;
        for (; depth < levels.size(); depth++) {

            queue = levels.get(depth);

            if (newWordAdded) {
                wordTransGraph.add(new ArrayList<>());
                distFromBegin++;
            }

            while (!queue.isEmpty()) {

                newWordAdded = false;
                String sourceWord = queue.poll();

                for (int i = 0; i < wordList.size(); i++) {
                    String targetWord = wordList.get(i);
                    if (!visited[i]) {
                        if (distBetnWordsIsOne(sourceWord, targetWord)) {
                            if (targetWord.equals(endWord)) return distFromBegin;
                            visited[i] = true;
                            wordTransGraph.get(distFromBegin).add(targetWord);
                            queue.offer(targetWord);
                            newWordAdded = true;
                        }
                    }
                }
            }

        }


        return 0;
    }

    public int ladderLength_2(String beginWord, String endWord, List<String> wordList) {

        if (!wordList.contains(endWord)) return 0;

        List<Queue<String>> wordLevels = new ArrayList<>();
        wordLevels.add(new ArrayDeque<>());
        wordLevels.get(0).add(beginWord);

        boolean[] visited = new boolean[wordList.size()];

        boolean newWordAdded = true;
        //wordList = ["hot","dot","dog","lot","log","cog"]

        int levelNum = 0;
        while (levelNum < wordLevels.size()) {

            Queue<String> queue = wordLevels.get(levelNum);

            if (newWordAdded) {
                wordLevels.add(new ArrayDeque<>());
                newWordAdded = false;
            }

            while (!queue.isEmpty()) {

                String sourceWord = queue.poll();

                for (int i = 0; i < wordList.size(); i++) {
                    String targetWord = wordList.get(i);
                    if (!visited[i]) {
                        if (distBetnWordsIsOne(sourceWord, targetWord)) {
                            if (targetWord.equals(endWord)) return (levelNum + 1);
                            visited[i] = true;
                            wordLevels.get(levelNum).add(targetWord);
                            newWordAdded = true;
                        }
                    }
                }
            }
            levelNum++;

        }

        return 0;
    }

    public int ladderLength_3(String beginWord, String endWord, List<String> wordList) {

        if (!wordList.contains(endWord)) return 0;

        List<List<String>> wordLevels = new ArrayList<>();
        wordLevels.add(new ArrayList<>());
        wordLevels.get(0).add(beginWord);

        boolean[] visited = new boolean[wordList.size()];

        //wordList = ["hot","dot","dog","lot","log","cog"]

        int levelNum = 0;
        while (!wordLevels.get(levelNum).isEmpty()) {

            List<String> words = wordLevels.get(levelNum);
            wordLevels.add(new ArrayList<>());

            for (int i = 0; i < words.size(); i++) {
                String sourceWord = words.get(i);
                for (int j = 0; j < wordList.size(); j++) {
                    String targetWord = wordList.get(j);
                    if (!visited[j]) {
                        if (distBetnWordsIsOne(sourceWord, targetWord)) {
                            if (targetWord.equals(endWord)) return (levelNum + 2);
                            visited[j] = true;
                            wordLevels.get(levelNum + 1).add(targetWord);
                        }
                    }
                }
            }
            levelNum++;

        }

        return 0;
    }

    private boolean distBetnWordsIsOne(String s1, String s2) {

        int distance = 0;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                distance++;
            }
            if (distance >= 2) return false;
        }

        return distance == 1;

    }

}
