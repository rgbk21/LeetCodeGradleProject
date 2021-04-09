package UdemyCourse.CoreJava.Section6;

public class L53_Regex_MetaCharacters {

    public static void main(String[] args) {

        // Meta Characters

        // '\d' will match a single digit
        System.out.println("**** '\\d' as regex ****");
        System.out.println("1".matches("\\d")); // true
        System.out.println("13".matches("\\d")); // false
        System.out.println("a".matches("\\d")); // false
        System.out.println("%".matches("\\d")); // false

        // '\D' will match any single character that is not a digit
        System.out.println("\n**** '\\D' as regex ****");
        System.out.println("1".matches("\\D")); // false
        System.out.println("13".matches("\\D")); // false
        System.out.println("a".matches("\\D")); // true
        System.out.println("%".matches("\\D")); // true

        // '\s' will match a single space
        System.out.println("\n**** '\\s' as regex ****");
        System.out.println(" ".matches("\\s")); // true
        System.out.println("  ".matches("\\s")); // false
        System.out.println("".matches("\\s")); // false
        System.out.println("a".matches("\\s")); // false
        System.out.println("!".matches("\\s")); // false

        // '\S' will match anything but a single space. So long as it is a single character.
        System.out.println("\n**** '\\S' as regex ****");
        System.out.println(" ".matches("\\S")); // false
        System.out.println("  ".matches("\\S")); // false (these are two spaces and hence they are false)
        System.out.println("".matches("\\S")); // false
        System.out.println("a".matches("\\S")); // true
        System.out.println("!".matches("\\S")); // true
        System.out.println("1".matches("\\S")); // true

        // '\w' will match either a single digit or a single alphabet.
        System.out.println("\n**** '\\w' as regex ****");
        System.out.println(" ".matches("\\w")); // false
        System.out.println("  ".matches("\\w")); // false
        System.out.println("".matches("\\w")); // false
        System.out.println("a".matches("\\w")); // true
        System.out.println("!".matches("\\w")); // false
        System.out.println("1".matches("\\w")); // true

        // '\W' will match everything but a single digit or a single alphabet. So long as it is a single character.
        System.out.println("\n**** '\\W' as regex ****");
        System.out.println(" ".matches("\\W")); // true
        System.out.println("  ".matches("\\W")); // false
        System.out.println("".matches("\\W")); // false
        System.out.println("a".matches("\\W")); // false
        System.out.println("!".matches("\\W")); // true
        System.out.println("1".matches("\\W")); // false
    }
}
