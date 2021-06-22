package UdemyCourse.CoreJava.Section6;

public class L56_RegularExpressions_Practice {

    public static void main(String[] args) {

        String s1 = "a!b@c#d$e%f^";
        // This wil replace everything that is not a alphabet or a number with a empty string
        String s2 = s1.replaceAll("[^a-z0-9]", "");
        System.out.println("Edited String is: " + s2); // abcdef

        // Alternatively, we can do this. Remove everything that is not a word with an empty string
        String s3 = s1.replaceAll("[^\\w]", "");
        System.out.println("Edited String is: " + s3); // abcdef

        // Replace all unnecessary spaces in a string with a single space
        String s4 = "  aa    bbb   c  d  e ff ";
        String s5 = s4.replaceAll("\\s+", " ");
        System.out.println("Edited String is:" + s5); // prints:  aa bbb c d e ff

        boolean isValid = true;
        convertToFalse(isValid);
        System.out.println(isValid);
    }

    private static void convertToFalse(boolean isValid) {
        isValid = false;
    }


}
