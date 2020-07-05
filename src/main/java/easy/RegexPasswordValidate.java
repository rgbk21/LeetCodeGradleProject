package easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.regex.*;

public class RegexPasswordValidate {

    /**
     * Iterate through each line of input.
     */

    //https://rubular.com/
    //https://stackoverflow.com/questions/5142103/regex-to-validate-password-strength

    public static final String INVALID = "invalid";
    public static final String WEAK = "weak";
    public static final String MEDIUM = "medium";
    public static final String STRONG = "strong";

    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        while ((line = in.readLine()) != null) {

            if (line.length() < 6 || line.length() > 25) {
                System.out.println(INVALID);
                return;
            }

            for (Character c : line.toCharArray()) {
                if (c < '\u0021' || c > '\u007A') {
                    System.out.println(INVALID);
                    return;
                }
            }

            String checkIfStrong = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[\\[\\]\\\\!\"#$%&'()*+,-./:;<>=?@^_`]).{10,}$";
            String checkIfMedium = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9]).{8,}$";
            String checkIfMediumWithSpecChar = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[\\[\\]\\\\!\"#$%&'()*+,-./:;<>=?@^_`]).{8,}$";

            if (Pattern.matches(checkIfStrong, line)) {
                System.out.println(STRONG);
            } else if (Pattern.matches(checkIfMedium, line)) {
                System.out.println(MEDIUM);
            } else if (Pattern.matches(checkIfMediumWithSpecChar, line)) {
                System.out.println(MEDIUM);
            } else {
                System.out.println(WEAK);
            }
        }
    }
}
