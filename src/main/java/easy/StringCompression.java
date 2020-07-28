package easy;

public class StringCompression {

    public static void main(String[] args) {

//        char[] input = new char[] {'a','a','b','b','c','c','c'};
        char[] input = new char[] {'a','a','a','a','b','a'};
//        char[] input = new char[] {'a','b','b','b','b','b','b','b','b','b','b','b','b','b'};
        //Output should be: {'a', 'b', '1','3'}
        compress(input);

    }

    public static int compress(char[] chars) {

        int count = 1;
        int writeIdx = 0;
        char prevChar = '\u0000';
        char currentChar = '\u0000';

        if (chars.length == 1) return 1;
        //'a','a','a','a','b','a'
        for (int i = 0; i < chars.length; i++) {

            currentChar = chars[i];

            if (i >= 1) {
                prevChar = chars[i - 1];

                if (currentChar == prevChar) {
                    count++;
                } else {
                    if (count > 1) {
                        chars[writeIdx++] = prevChar;
                        for (int j = 0; j < Integer.toString(count).length(); j++) {
                            chars[writeIdx++] = Integer.toString(count).charAt(j);
                        }
                        count = 1;
                    } else if (count == 1 && prevChar != '\u0000') {
                        chars[writeIdx++] = prevChar;
                    }
                }
            }
        }

        if (count > 1) {
            chars[writeIdx++] = prevChar;
            for (int j = 0; j < Integer.toString(count).length(); j++) {
                chars[writeIdx++] = Integer.toString(count).charAt(j);
            }
        } else if (count == 1) {
            chars[writeIdx++] = currentChar;
        }

        return writeIdx;
    }


}
