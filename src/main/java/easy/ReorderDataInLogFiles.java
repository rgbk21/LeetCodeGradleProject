package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ReorderDataInLogFiles {

    public static void main(String[] args) {

        String[] myArray = new String[]{"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"};
        // Regex for - string should contain atleast one or more digits
        System.out.println(myArray[0].split(" ", 2)[1].matches(".*\\d+.*"));
        System.out.println(myArray[1].split(" ", 2)[1].matches(".*\\d+.*"));

//        reorderLogFiles(myArray);

        // List and Array Interconversions

        // Convert String[] into List<String>
        String[] stringArray = new String[]{"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"};
        List<String> stringList = Arrays.asList(stringArray);

        // Merge two String[] into a single List<String>
        // https://stackoverflow.com/a/23188881/8742428
        String[] array1 = new String[]{"A", "B", "C", "D"};
        String[] array2 = new String[]{"E", "F", "G"};
        String[] mergedArray = Stream.concat(Arrays.stream(array1), Arrays.stream(array2)).toArray(String[]::new);
        System.out.println(Arrays.toString(mergedArray)); // Note that you have to use the Arrays.toString method to print the String{}

        // If you have arrays containing primitives, then use the corresponding primitive streams instead
        int[] array3 = new int[]{1,2,3,4};
        int[] array4 = new int[]{5,6,7,8};
        int[] mergedIntArr = IntStream.concat(Arrays.stream(array3), Arrays.stream(array4)).toArray();
        System.out.println(Arrays.toString(mergedIntArr));

        // Merge two List<String> into one single List<String>

        // Create a List<String>
        // https://stackoverflow.com/a/48673336/8742428
        // There are two ways in which you can create a list in Java 8:

        // 1) To create a non-empty list of fixed size (operations like add, remove, etc., are not supported):
        List<String> list1 = Arrays.asList("A", "B", "C", "D"); // but, list.set(...) is supported

        // 2) To create a non-empty mutable list:
        List<String> list2 = new ArrayList<>(Arrays.asList("E", "F", "G"));

        // Merge two lists to create a single list
        List<String> mergedList = Stream.concat(list1.stream(), list2.stream()).collect(Collectors.toList());
        System.out.println(mergedList); // Note that unlike the String[], you do not need any additional method to print the list

        // Convert a List<String> to a String[]
        String[] arr = mergedList.toArray(String[]::new);
        System.out.println(Arrays.toString(arr));
    }

    public static String[] reorderLogFiles_v2(String[] logs) {

        List<String> digitLogs = new ArrayList<>();
        List<String> letterLogs = new ArrayList<>();

        // Filtering out the digit logs
        for (String log : logs) {
            if (log.split(" ", 2)[1].matches(".*\\d+.*")) {
                digitLogs.add(log);
            } else {
                letterLogs.add(log);
            }
        }

        letterLogs.sort((s1, s2) -> {
            String log1 = s1.split(" ", 2)[1];
            String log2 = s2.split(" ", 2)[1];
            String identifier1 = s1.split(" ", 2)[0];
            String identifier2 = s2.split(" ", 2)[0];
            if (log1.compareTo(log2) > 0) {
                return 1;
            } else if (log1.compareTo(log2) < 0) {
                return -1;
            } else {
                return (identifier1.compareTo(identifier2));
            }
        });

        // Stream may be extended replacing 'toArray'
        // String[] resultList_old = (String[]) Stream.concat(letterLogs.stream(), digitLogs.stream()).collect(Collectors.toList()).toArray();

        // The following two lines of code merge two lists into one list and then
        // and convert the List<String> into an String[] and return it
        // List<String> resultList_new = Stream.concat(letterLogs.stream(), digitLogs.stream()).collect(Collectors.toList());
        // return resultList_new.toArray(new String[0]);

        // However it can be done in a single statement as follows:
        return Stream.concat(letterLogs.stream(), digitLogs.stream()).toArray(String[]::new);
    }

    public static String[] reorderLogFiles(String[] logs) {

        List<String> letterLogsList = new ArrayList<>();
        List<String> digitLogsList = new ArrayList<>();

        for (String s : logs) {

            String[] myArray = s.split("\\s", 2);

            int checkIdx = s.indexOf(' ') + 1;
            char checkChar = s.charAt(checkIdx);

            if (Character.isAlphabetic(checkChar)) {
                letterLogsList.add(s);
            } else if (Character.isDigit(checkChar)) {
                digitLogsList.add(s);
            }

        }

        letterLogsList.sort((str1, str2) -> {

            int str1FirstSpaceIdx = str1.indexOf(' ') + 1;
            int str2FirstSpaceIdx = str2.indexOf(' ') + 1;

            if (str1.substring(str1FirstSpaceIdx).compareTo(str2.substring(str2FirstSpaceIdx)) > 0) {
                return 1;
            } else if (str1.substring(str1FirstSpaceIdx).compareTo(str2.substring(str2FirstSpaceIdx)) < 0) {
                return -1;
            } else {
                if (str1.substring(0, str1FirstSpaceIdx - 1).compareTo(str2.substring(0, str2FirstSpaceIdx - 1)) > 0) {
                    return 1;
                } else if (str1.substring(0, str1FirstSpaceIdx - 1).compareTo(str2.substring(0, str2FirstSpaceIdx - 1)) < 0) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        String[] resultArray = new String[logs.length];

        int writeIdx = 0;
        for (; writeIdx < letterLogsList.size(); writeIdx++) {
            resultArray[writeIdx] = letterLogsList.get(writeIdx);
        }

        for (int i = 0; i < digitLogsList.size(); i++) {
            resultArray[writeIdx++] = digitLogsList.get(i);
        }

        return resultArray;


    }
}
