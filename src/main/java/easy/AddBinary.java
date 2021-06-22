package easy;

public class AddBinary {

    //https://leetcode.com/problems/add-binary/

    public static void main(String[] args) {

        String str1 = "1111";
        String str2 = "1111";
        System.out.println(str1.charAt(0));
        System.out.println("Result is:" + addBinary_3(str1, str2));

    }

    //BAAAAAAAD
    public static String addBinary(String a, String b) {

        int carry = 0;
        StringBuilder sb = new StringBuilder();
        String largerStr = a.length() > b.length() ? a : b;
        String shorterStr = a.length() > b.length() ? b : a;
        int shortStrIdx = shorterStr.length() - 1;
        int largeStrIdx = largerStr.length() - 1;

        while (shortStrIdx >= 0 || largeStrIdx >= 0) {

            int digitSum = Character.getNumericValue(shorterStr.charAt(shortStrIdx)) +
                    Character.getNumericValue(largerStr.charAt(largeStrIdx)) +
                    carry;

            carry = digitSum >= 2 ? digitSum % 2 : 0;


        }


        return sb.reverse().toString();
    }

    //OKKKKKKKKK...
    public static String addBinary_2(String a, String b) {

        StringBuilder result = new StringBuilder();

        String a_reverse = new StringBuilder(a).reverse().toString();
        String b_reverse = new StringBuilder(b).reverse().toString();

        int idx = 0;
        int carry = 0;
        int sum = 0;

        while (idx < a_reverse.length() || idx < b_reverse.length()) {

            Integer x = idx < a_reverse.length() ? Character.getNumericValue(a_reverse.charAt(idx)) : 0;
            Integer y = idx < b_reverse.length() ? Character.getNumericValue(b_reverse.charAt(idx)) : 0;

            sum = x + y + carry;

            if (sum >= 2) {
                carry = 1;
                result.append(sum % 2);
            } else {
                carry = 0;
                result.append(sum);
            }

            idx++;
        }

        if (carry == 1) {
            result.append(1);
        }

        return result.reverse().toString();
    }

    public static String addBinary_3(String a, String b) {

        String a_reverse = new StringBuilder(a).reverse().toString();
        String b_reverse = new StringBuilder(b).reverse().toString();
        StringBuilder answer = new StringBuilder();
        int idx = 0;
        int carry = 0;

        while (idx < a_reverse.length() && idx < b_reverse.length()) {
            int d = a_reverse.charAt(idx) + b_reverse.charAt(idx) + carry;
            int partialSum = Character.getNumericValue(a_reverse.charAt(idx)) + Character.getNumericValue(b_reverse.charAt(idx)) + carry;
            if (partialSum >= 2) {
                answer.append(partialSum % 2);
                carry = 1;
            } else if (partialSum == 1) {
                answer.append(1);
                carry = 0;
            } else if (partialSum == 0) {
                answer.append(0);
                carry = 0;
            }
            idx++;
        }

        if (a_reverse.length() > b_reverse.length()) {
            while (idx < a_reverse.length()){
                int partialSum = Character.getNumericValue(a_reverse.charAt(idx)) + carry;
                if (partialSum >= 2) {
                    answer.append(partialSum % 2);
                    carry = 1;
                } else if (partialSum == 1) {
                    answer.append(1);
                    carry = 0;
                } else if (partialSum == 0) {
                    answer.append(0);
                    carry = 0;
                }
                idx++;
            }
        } else if (a_reverse.length() < b_reverse.length()) {
            while (idx < b_reverse.length()){
                int partialSum = Character.getNumericValue(b_reverse.charAt(idx)) + carry;
                if (partialSum >= 2) {
                    answer.append(partialSum % 2);
                    carry = 1;
                } else if (partialSum == 1) {
                    answer.append(1);
                    carry = 0;
                } else if (partialSum == 0) {
                    answer.append(0);
                    carry = 0;
                }
                idx++;
            }
        }

        if (carry == 1) answer.append(1);

        return answer.reverse().toString();
    }


}
