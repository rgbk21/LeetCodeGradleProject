package easy;

public class AddStrings {

    //https://leetcode.com/problems/add-strings/

    public static void main(String[] args) {

        String s1 = "12345";
        String s2 = "145";
        String s3 = "Alice";
        StringBuilder sb = new StringBuilder(s3.charAt(0));
        sb.append("S");
        System.out.println(sb);
    }

    public String addStrings_v2(String num1, String num2){

        StringBuilder result = new StringBuilder();
        String s1 = new StringBuilder(num1).reverse().toString();
        String s2 = new StringBuilder(num2).reverse().toString();
        int carry = 0;
        int idx = 0;

        while (idx < s1.length() || idx < s2.length()) {
            int s1Digit = idx < s1.length() ? Character.getNumericValue(s1.charAt(idx)) : 0;
            int s2Digit = idx < s2.length() ? Character.getNumericValue(s2.charAt(idx)) : 0;
            int sum = s1Digit + s2Digit + carry;
            result.append(sum % 10);
            carry = sum / 10;
            idx++;
        }

        return carry == 0 ? result.reverse().toString() : result.append(1).reverse().toString();
    }

    public String addStrings(String num1, String num2) {

        String s1 = new StringBuilder(num1).reverse().toString();
        String s2 = new StringBuilder(num2).reverse().toString();

        StringBuilder result = new StringBuilder();

        int idx1 = 0;
        int idx2 = 0;
        int carry = 0;

        while (idx1 < s1.length() || idx2 < s2.length()) {

            int digit1 = idx1 < s1.length() ? Character.getNumericValue(s1.charAt(idx1)) : 0;
            int digit2 = idx2 < s2.length() ? Character.getNumericValue(s2.charAt(idx2)) : 0;

            int sum = digit1 + digit2 + carry;

            if (sum >= 10) {
                result.append(sum % 10);
                carry = 1;
            } else {
                carry = 0;
                result.append(sum);
            }

            idx1++;
            idx2++;

        }

        if (carry == 1) {
            result.append(1);
        }

        return result.reverse().toString();

    }

}
