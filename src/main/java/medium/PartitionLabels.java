package medium;

import java.util.*;

public class PartitionLabels {

    public static void main(String[] args) {

    }

    public List<Integer> partitionLabels(String S) {

        Map<Character, int[]> charMap = new HashMap<>();

        for (int i = 0; i < S.length(); i++) {

            Character currChar = S.charAt(i);
            int[] prevIndices = charMap.get(currChar);

            if (prevIndices == null) {
                charMap.put(currChar, new int[] {i, i});
            } else {
                prevIndices[1] = i;
                charMap.put(currChar, prevIndices);
            }
        }

        List<int[]> ranges = new ArrayList<>();

        for (Map.Entry<Character, int[]> entry : charMap.entrySet()) {
            ranges.add(entry.getValue());
        }

        ranges.sort((arr1, arr2) -> {
            if (arr1[0] > arr2[0]) {
                return 1;
            } else if (arr1[0] < arr2[0]) {
                return -1;
            } else {
                return 0;
            }
        });

        List<int[]> merged = new ArrayList<>();
        merged.add(ranges.get(0));
        int writeIdx = 0;

        for (int i = 1; i < ranges.size(); i++) {

            if (merged.get(writeIdx)[1] >= ranges.get(i)[0]) {
                int[] prevRange = merged.get(writeIdx);
                prevRange[1] = Math.max(prevRange[1], ranges.get(i)[1]);
                merged.set(writeIdx, prevRange);
            } else {
                writeIdx++;
                merged.add(ranges.get(i));
            }
        }

        Integer[] result = new Integer[merged.size()];
        for (int i = 0; i < merged.size(); i++) {
            result[i] = merged.get(i)[1] - merged.get(i)[0];
        }

        return Arrays.asList(result);

    }

}
