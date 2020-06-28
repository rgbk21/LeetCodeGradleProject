package easy;

public class PalindromeNumber {

    public static void main(String[] args) {
        PalindromeNumber.isPalindrome(1221);
    }

    public static boolean isPalindrome(int x) {

        if(x < 0){
            return false;
        }

        int myNum = x;
        int numOfDigits = (int) (Math.log10(myNum) + 1);
        int rightDigit = 0;
        int leftDigit = 0;
        int base = 10;
        int loopCount = numOfDigits - 1;

        while (myNum >= 1){
            rightDigit = myNum % base;
            leftDigit = myNum / (int) (Math.pow(base, loopCount--));
            if (leftDigit != rightDigit){
                return false;
            }
            myNum = myNum / base;
            myNum = myNum - (leftDigit * (int) Math.pow(base, loopCount--));
        }

        return true;
    }
}
