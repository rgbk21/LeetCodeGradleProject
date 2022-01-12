package Test1.RandomStuff;

public class Manipulation {

    public static void main(String[] args) {



    }

    int digitsManipulations(int n) {


        long prodOfDigits = 1L;
        long sumOfDigits = 0L;
        int num = n;

        while (num > 0) {

            int digit = num % 10;
            prodOfDigits = prodOfDigits * digit;
            sumOfDigits = sumOfDigits + digit;
            num = num / 10;

        }

        return (int)(prodOfDigits - sumOfDigits);



    }

}
