package JoshuaBloch.Chapter3.Item10.Symmetry;

public class CastingStrings {

    public static void main(String[] args) {

        // Compile Error
        // Invertible types because there is no relationship between.
        String str1 = "Hello";
//        StringBuilder sb1 = (StringBuilder) str1; // Inconvertible types; cannot cast 'java.lang.String' to 'java.lang.StringBuilder'

        // Compile Error
        // Incompatible types because String is not child class of StringBuilder.
        Object str2 = "Hello";
//        StringBuilder sb2 = (String) str2; // Required type: StringBuilder Provided: String

        // Warning. RunTime Error. ClassCastException.
        Object str3 = "Hello";
        StringBuilder sb3 = (StringBuilder) str3; // Warning: Casting 'str3' to 'StringBuilder' will produce 'ClassCastException' for any non-null value
    }
}
