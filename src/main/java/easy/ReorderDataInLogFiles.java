package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReorderDataInLogFiles {

    public static void main(String[] args) {

        String[] myArray = new String[] {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        reorderLogFiles(myArray);


    }

    public static String[] reorderLogFiles(String[] logs) {

        List<String> letterLogsList = new ArrayList<>();
        List<String> digitLogsList = new ArrayList<>();

        for (String s : logs) {

            String[] myArray = s.split(" ", 2 );

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
