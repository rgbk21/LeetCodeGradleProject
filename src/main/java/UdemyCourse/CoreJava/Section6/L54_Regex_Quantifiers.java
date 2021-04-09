package UdemyCourse.CoreJava.Section6;

public class L54_Regex_Quantifiers {

    public static void main(String[] args) {

        // Quantifiers

        // '*' will match a character that appears zero or more times
        System.out.println("**** '*' as regex ****");
        // This will match any characters any number of times
        System.out.println("asda".matches(".*")); // true
        System.out.println("".matches(".*")); // true
        // This will match the characters a, s, d appearing any number of times, including none
        // Letter must be 'a, s, d', but they can appear any number of times
        System.out.println("a".matches("[asd]*")); // true
        System.out.println("".matches("[asd]*")); // true
        System.out.println("dadsssdda".matches("[asd]*")); // true
        System.out.println("asdf".matches("[asd]*")); // false
        System.out.println("asdwqqq".matches("[asd]*[qwe]*")); // true
        // String can contain any number of lower case alphabets
        System.out.println("asdwqfqq".matches("[a-z]*")); // true
        System.out.println("asdwqfq1".matches("[a-z]*")); // false

        // '+' will match a character that appears one or more times
        System.out.println("\n**** '+' as regex ****");
        System.out.println("a".matches("[asd]+")); // true
        System.out.println("as".matches("[asd]+")); // true
        System.out.println("".matches("[asd]+")); // false
        System.out.println("q".matches("[asd]+")); // false
        System.out.println("aasssdddaa".matches("[asd]+")); // true

        // '?' will match a character that appears 0 or 1 time
        System.out.println("\n**** '?' as regex ****");
        System.out.println("a".matches("[asd]?")); // false
        System.out.println("as".matches("[asd]?")); // false
        System.out.println("".matches("[asd]?")); // true

        // '{X}' will match a string that has exactly a length of X
        System.out.println("\n**** '{X}' as regex ****");
        // String can contain any character between a and z, but the length of the string must be exactly 5
        System.out.println("a".matches("[a-z]{5}")); // false
        System.out.println("abcde".matches("[a-z]{5}")); // true
        System.out.println("abcd5".matches("[a-z]{5}")); // false

        // '{X, Y}' will match a character that appears between X and Y times
        System.out.println("\n**** '{X,Y}' as regex ****");
        // The string can contain any character between a and z, but the length of the string must be between 2 and 5 characters
        System.out.println("a".matches("[a-z]{2,5}")); // false
        System.out.println("as".matches("[a-z]{2,5}")); // true
        System.out.println("asdfg".matches("[a-z]{2,5}")); // true
        System.out.println("asdfgh".matches("[a-z]{2,5}")); // false
        System.out.println("asdf5".matches("[a-z]{2,5}")); // false
    }
}
