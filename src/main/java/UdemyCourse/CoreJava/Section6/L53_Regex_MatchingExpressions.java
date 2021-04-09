package UdemyCourse.CoreJava.Section6;

public class L53_Regex_MatchingExpressions {

    public static void main(String[] args) {

        // Understanding Regex and how it works

        // Matching Expressions

        // . will match a single character
        System.out.println("**** '.' as regex ****");
        System.out.println("m".matches(".")); // true
        System.out.println("".matches(".")); // false
        System.out.println(" ".matches(".")); // true
        System.out.println("mm".matches(".")); // false

        // '[abc]' will match exactly the given letters. String should be a single character string.
        System.out.println("\n**** '[abc]' as regex ****");
        System.out.println("a".matches("[abc]")); // true
        System.out.println("b".matches("[abc]")); // true
        System.out.println("c".matches("[abc]")); // true
        System.out.println("bc".matches("[abc]")); // false
        System.out.println("d".matches("[abc]")); // false

        // '[abc][vz]' will match exactly two characters. The first character should either be 'a', 'b', or 'c'.
        // The second character should either be a 'v' or 'z'
        System.out.println("\n**** '[abc][vz]' as regex ****");
        System.out.println("a".matches("[abc][vz]")); // false
        System.out.println("av".matches("[abc][vz]")); // true
        System.out.println("aav".matches("[abc][vz]")); // false
        System.out.println("av".matches("[abc][vz]")); // true

        // '[^abc]' will match a single character. The character can be anything 'a', 'b', or 'c'.
        System.out.println("\n**** '[^abc]' as regex ****");
        System.out.println("a".matches("[^abc]")); // false
        System.out.println("d".matches("[^abc]")); // true
        System.out.println("".matches("[^abc]")); // false
        System.out.println(" ".matches("[^abc]")); // true
        System.out.println("%".matches("[^abc]")); // true

        // '[a-c1-7]' will match a single character. The character can be anything between 'a' and 'c' and anything between 1 and 7
        System.out.println("\n**** '[a-c1-7]' as regex ****");
        System.out.println("a".matches("[a-c1-7]")); // true
        System.out.println("1".matches("[a-c1-7]")); // true
        System.out.println("d".matches("[a-c1-7]")); // false
        System.out.println("a1".matches("[a-c1-7]")); // false

        // '[a-c1-7]' will match a single character. The character can be either 'A' or 'B'
        System.out.println("\n**** '[A|B]' as regex ****");
        System.out.println("a".matches("[A|B]")); // false
        System.out.println("A".matches("[A|B]")); // true

        // '[AB]' will match a character exactly to AB. The string should be exactly "AB"
        System.out.println("\n**** '[AB]' as regex ****");
        System.out.println("AB".matches("[AB]")); // false
        System.out.println("A".matches("[AB]")); // true
        System.out.println("B".matches("[AB]")); // true

        // So what is the difference between [AB] and [A|B]
        System.out.println("\n**** difference between [AB] and [A|B] ****");
        // For example, this will match the entire word 'hello' or 'world'
        System.out.println("hello".matches("(hello|world)")); // true
        System.out.println("h".matches("(hello|world)")); // false
        // Whereas this will match the set of characters [helowrld]
        System.out.println("hello".matches("[helloworld]")); // false
        System.out.println("h".matches("[helloworld]")); // true
        System.out.println("o".matches("[helloworld]")); // true
    }
}
