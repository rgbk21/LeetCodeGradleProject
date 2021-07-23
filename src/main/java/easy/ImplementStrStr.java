package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/implement-strstr/
public class ImplementStrStr {

    public static void main(String[] args) {

        // ************ COMPARING STRINGS ************************************************************************************
        String s1 = "Hello World";
        String s2 = "Hello World";
        String s3 = "hello world";

        System.out.println("Is s1 equal to s2: " + s1.equals(s2)); // true
        System.out.println("Is s1 equal to s3: " + s1.equals(s3)); // false

        // Strings can also be compared using the compareTo function
        System.out.println("Comparison of s1 and s2: " + s1.compareTo(s2)); // 0
        System.out.println("Comparison of s1 and s3: " + s1.compareTo(s3)); // -32
        System.out.println("Comparison of s3 and s1: " + s3.compareTo(s1)); // 32

        // Compare strings but ignore the case
        System.out.println("Comparison of s1 and s3: " + s1.compareToIgnoreCase(s3)); // 0

        // ********* CONCATENATE TWO STRINGS ************************************************************************************
        // You can concatenate two strings by using the + operator
        // BUT NEVER DO THIS WITHIN A LOOP! Use StringBuilder class instead.
        // If you want to see an example, refer this submission.
        // https://leetcode.com/problems/path-crossing/submissions/
        String s4 = s1 + s2;
        System.out.println("Concatenated String: " + s4); // Hello WorldHello World

        // ********* FIND USING indexOf ************************************************************************************
        // s1 = "Hello World";
        // You can find the index of a particular character in the string
        // This will find the first index of the character
        int idx1 = s1.indexOf("l"); //
        System.out.println("First index of character l: " + idx1); // 2
        // If the character is not present, it will return -1.
        // Hence indexOf can be used to check if a particular character exists in the string or not
        System.out.println("First index of character y: " + s1.indexOf('y')); // -1

        // You can also search for the index of a character starting from a particular index
        // Note that the index returned is counting from the START of the string, and not the index you passed in as args
        System.out.println("Index of character l starting from index 5: " + s1.indexOf('l', 5)); // 9
        // The index being passed is also searched. Here we are searching for a space.
        System.out.println("Index of character ' ' starting from index 5: " + s1.indexOf(' ', 5)); // 5

        // Similarly you can find the last index of the character in the string
        System.out.println("Index of character 'l' starting from the end of the string: " + s1.lastIndexOf('l')); // 9

        // You can also search for strings, the passed args need not necessarily be characters only
        System.out.println("Index of string 'll' from the start of the string: " + s1.indexOf("ll")); // 2

        String longStr = "This is a long string.";
        // But note that .contains() internally just calls indexOf. Hence you are better off just using indexOf
        System.out.println("longStr contains 'This' :" + longStr.contains("This")); // true

        // Note that even if you are using the .contains() method to search for a single character,
        // you would still need to enclose the character in double quotes
        // System.out.println("longStr contains 'T' :" + longStr.contains('T')); // Compile Error: Required type: CharSequence Provided: char
        // Instead you will have to use: note the use of double quotes
        System.out.println("longStr contains 'T' :" + longStr.contains("T")); // true

        // But note that the behavior is not the same for the indexOf() method i.e. both of these work
        String longStr2 = "This is a long string.";
        System.out.println("Index of 's': " + longStr2.indexOf('s')); // 3
        System.out.println("Index of 's': " + longStr2.indexOf("s")); // 3

        // ********* CHECK IF A STRING IS EMPTY OR BLANK ************************************************************************************
        String emptyString = "";
        System.out.println("Is this empty: " + emptyString.isEmpty()); // true
        System.out.println("Is this blank: " + emptyString.isBlank()); // true
        String whiteSpaceString = "  ";
        System.out.println("Is this empty: " + whiteSpaceString.isEmpty()); // false
        System.out.println("Is this blank: " + whiteSpaceString.isBlank()); // true

        // ********* EXTRACT SUBSTRING ************************************************************************************
        // char at left idx is inclusive. char at right index is exclusive.
        // If the length of the string is N, the time complexity of both finding operation and substring operation is O(N).
        // s1 = "Hello World";
        System.out.println("Substring:" + s1.substring(6, s1.length()) + "|||"); // World|||

        // ********* IMMUTABLE STRINGS ************************************************************************************
        // Strings are immutable. If you want to mutate a String, you can convert the string to a charArray and then change it
        String s5 = "This string will be mutated";
        char[] s5CharArray = s5.toCharArray();
        s5CharArray[5] = 'S';
        System.out.println(s5CharArray); // Prints: This String will be mutated
        System.out.println("Note that the original string has not changed: " + s5); // This string will be mutated

        // Converting a char array back to string
        String charToStr1 = new String(s5CharArray);
        String charToStr2 = String.valueOf(s5CharArray);

        // ********* STRINGBUILDER ************************************************************************************
        // If you have to concatenate strings often, it will be better to use some other data structures like StringBuilder.
        // The below code runs in O(n) complexity.
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            stringBuilder.append("hello");
        }
        System.out.println(stringBuilder); // hellohellohellohellohellohellohellohellohellohello

        // append can also be chained. So you can do this:
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Hello").append(" ").append("World.");
        // Convert the StringBuilder to string using:
        String result = stringBuilder2.toString();
        System.out.println("Result is: " + result); // Result is: Hello World.
        // This is an easy way to reverse string
        String reversedStr = stringBuilder2.reverse().toString();

        // ********* ITERATING OVER A STRING ************************************************************************************
        String s6 = "Iterate over this string";
        for (int i = 0; i < s6.length(); i++) {
            char currChar = s6.charAt(i);
            // Do stuff with currChar
        }

        // ********* SPLITTING STRING ************************************************************************************
        String splitString1 = "boo:and:foo";
        String[] splitter1 = splitString1.split(":");
        // When no additional args are supplied, we will search for all the occurrences of the input string
        // and split based on that
        System.out.println(Arrays.toString(splitter1)); // [boo, and, foo]
        // Here 2 is the size of the resulting array that we want after the split has been performed.
        String[] splitter2 = splitString1.split(":", 2);
        System.out.println(Arrays.toString(splitter2)); // [boo, and:foo]
        // What happens if the string on which you are splitting does not occur in the string?
        String[] splitter3 = splitString1.split(";", 2);
        System.out.println(Arrays.toString(splitter3)); // [boo:and:foo]

        // ********* BASIC REGEX ************************************************************************************
        String[] myArray = new String[]{"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"};
        System.out.println(myArray[0].split(" ", 2)[1]); // 8 1 5 1
        System.out.println(myArray[1].split(" ", 2)[1]); // art can

        // Regex for - string should contain at least one or more digits
        System.out.println(myArray[0].split(" ", 2)[1].matches(".*\\d+.*")); // true
        System.out.println(myArray[1].split(" ", 2)[1].matches(".*\\d+.*")); // false

        // ********* REPLACING CHARACTERS ************************************************************************************

        // Note that the replaceAll() method takes a regex as the args for what you want to replace
        // Replace multiple spaces in the string with a single space
        String str7 = "   the   sky  is  blue  ";
        String singleSpacedStr = str7.replaceAll("\\s+", " ");
        System.out.println("singleSpacedStr:" + singleSpacedStr + "***"); // singleSpacedStr: the sky is blue ***

        // Whereas the replace() method takes a character sequence as the args for what you want to remove from the String
        String singleSpacedStr2 = str7.replace("is", " ");
        System.out.println("singleSpacedStr2:" + singleSpacedStr2 + "***"); // singleSpacedStr2:   the   sky     blue  ***

    }

    // haystack = "hello", needle = "ll"
    public int strStr(String haystack, String needle) {

        if (haystack.equals(needle)) return 0;
        if (haystack.isEmpty()) return -1;
        if (needle.isEmpty()) return 0;

        int leftIdx = 0;

        // If the leftIdx reaches a point in haystack where the needle is too long to appear in haystack.
        // Then we do not have to traverse the rest of the haystack string.
        // Without this, we run into TLE for one input.
        while (leftIdx < (haystack.length() - needle.length()) + 1) {
            int currChar = haystack.charAt(leftIdx);

            if (currChar == needle.charAt(0)) {
                boolean stringsMatch = true;
                for (int i = 0; i < needle.length(); i++) {
                    if (leftIdx + i >= haystack.length()) {
                        stringsMatch = false;
                        break;
                    }
                    char hayStackChar = haystack.charAt(leftIdx + i);
                    char needleChar = needle.charAt(i);
                    if (hayStackChar != needleChar) {
                        stringsMatch = false;
                        break;
                    }
                }
                if (stringsMatch) return leftIdx;
            }
            leftIdx++;
        }
        return -1;
    }
}
