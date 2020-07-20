package easy;

public class AddBinary {

    public static void main(String[] args) {

        String str1 = "111";
        String str2 = "111";
        addBinary(str1, str2);

    }

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


}
