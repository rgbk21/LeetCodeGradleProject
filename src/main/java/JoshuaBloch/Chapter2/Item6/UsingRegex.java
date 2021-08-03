package JoshuaBloch.Chapter2.Item6;

import java.util.regex.Pattern;

public class UsingRegex {

    private static final String ROMAN_STR_REGEX = "^(?=.)M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$";
    // Reusing expensive object for improved performance (Page 23)
    private static final Pattern ROMAN = Pattern.compile(ROMAN_STR_REGEX);

    // Performance can be greatly improved! (Page 22)
    static boolean isRomanNumeralSlow(String s) {
        return s.matches(ROMAN_STR_REGEX);
    }
    static boolean isRomanNumeralFast(String s) {
        return ROMAN.matcher(s).matches();
    }

    public static void main(String[] args) {
        isRomanNumeralSlow("MCMLXXVI");
        isRomanNumeralFast("MCMLXXVI");
    }
}
