package UdemyCourse.CoreJava.Section5;

public class L29 {

    public static void main(String[] args) {

        // Mod operation can be applied on decimal numbers as well
        System.out.println(12.5 % 3.2);
        System.out.println(12.5 % 3);

        // Bitshift operations
        // 10 = 00001010
        // 10 << 1 = 10100 = 20
        System.out.println( "10 << 1 is: " + (10 << 1));
        // 10 >> 1 = 00000101 = 5
        System.out.println( "10 >> 1 is: " + (10 >> 1));

        /* ************************************************************************************************************* */
        // Why does this not compile?
//        byte b = 0b1000_0000; // Compile Error

        // What you were trying to do is declare a byte variable to be -128, but setting the bits yourself.
        // The expectation was that, since bits are represented in two's complement, setting 0b1000_0000 would
        // set it to -128.
        // But that expectation is incorrect.
        // Because the bits are set in the normal decimal form. Not in the two's complement
        // Hence when you do
        // byte b = 0b1000_0000
        // java thinks that what you are trying to do is this:
        // byte b = 128;
        // which is a lossy conversion, since the largest number that can be stored in a byte is 127

        // And that is also why, when you cast the number into a byte, the number that is stored is -128 and not 128
        byte b0 = (byte) 0b1000_0000;

        // But adding a -ve sign before the decimal works. No casting is necessary in this case
        byte b1 = - 0b1000_0000;

        // And this works generally as well
        byte b2 = -128;

        System.out.println("b0 in two's complement: " + Integer.toBinaryString(b0) + ", b0 in decimal: " + b0);
        // b0 in two's complement: 11111111111111111111111110000000, b0 in decimal: -128

        System.out.println("b1 in two's complement: " + Integer.toBinaryString(b1) + ", b1 in decimal: " + b1);
        // b1 in two's complement: 11111111111111111111111110000000, b1 in decimal: -128

        System.out.println("b2 in two's complement: " + Integer.toBinaryString(b2) + ", b2 in decimal: " + b2);
        // b2 in two's complement: 11111111111111111111111110000000, b2 in decimal: -128

        /* ************************************************************************************************************* */

        // What happens when you left shift a -ve number? The negative number can be converted to a +ve number!
        // Left Shifting:  -1610612736 = 0b1010_0000_0000_0000_0000_0000_0000_0000
        // Gives:           1073741824 = 0b0100_0000_0000_0000_0000_0000_0000_0000
        System.out.println("Trying to left shift a -ve number: " + (0b1010_0000_0000_0000_0000_0000_0000_0000 << 1)); // Warning: Numeric overflow in expression
        // Trying to left shift a -ve number: 1073741824

        System.out.println("Trying to left shift a -ve number: " + Integer.toBinaryString(0b1010_0000_0000_0000_0000_0000_0000_0000 << 1));
        // Trying to left shift a -ve number: 1000000000000000000000000000000

        // Left Shifting:   -536870912 = 0b1110_0000_0000_0000_0000_0000_0000_0000
        // Gives:          -1073741824 = 0b1100_0000_0000_0000_0000_0000_0000_0000
        System.out.println("Trying to left shift a -ve number: " + (0b1110_0000_0000_0000_0000_0000_0000_0000 << 1)); // Note: No warning is generated in this case
        // Trying to left shift a -ve number: -1073741824

        System.out.println("Trying to left shift a -ve number: " + Integer.toBinaryString(0b1110_0000_0000_0000_0000_0000_0000_0000 << 1));
        // Trying to left shift a -ve number: 1100_0000_0000_0000_0000_0000_0000_0000

        /* ************************************************************************************************************* */
        // <<< vs <<

        int numShift1 = 1610612736;
        int numShift2 = -1610612736; // 1010_0000_0000_0000_0000_0000_0000_0000

        System.out.println("numShift2 In binary: " + Integer.toBinaryString(numShift2));
        // numShift2 In binary: 1010_0000_0000_0000_0000_0000_0000_0000

        System.out.println("numShift2 sign right shifted by 1: " + Integer.toBinaryString(numShift2 >> 1));
        // numShift2 sign right shifted by 1: 1101_0000_0000_0000_0000_0000_0000_0000

        System.out.println("numShift2 logical right shift by 1: " + Integer.toBinaryString(numShift2 >>> 1));
        // numShift2 logical right shift by 1: 0101_0000_0000_0000_0000_0000_0000_0000


        System.out.println("numShift1 In binary: " + Integer.toBinaryString(numShift1));
        // numShift1 In binary: 0110_0000_0000_0000_0000_0000_0000_0000

        System.out.println("numShift1 sign right shifted by 1: " + Integer.toBinaryString(numShift1 >> 1));
        // numShift1 sign right shifted by 1: 0011_0000_0000_0000_0000_0000_0000_0000

        System.out.println("numShift1 logical right shift by 1: " + Integer.toBinaryString(numShift1 >>> 1));
        // numShift1 logical right shift by 1: 0011_0000_0000_0000_0000_0000_0000_0000

        /* ************************************************************************************************************* */
        // ~ Operator
        int notNumber =  1610612736;
        System.out.println("notNumber in Binary: " + Integer.toBinaryString(notNumber));
        // notNumber in Binary: 0110_0000_0000_0000_0000_0000_0000_0000
        System.out.println("notNumber complement in Binary: " + Integer.toBinaryString(~notNumber));
        // notNumber complement in Binary: 1001_1111_1111_1111_1111_1111_1111_1111

        /* ************************************************************************************************************* */
        // You cannot assign a byte type to character even though the size of byte is 8bits, and a character is 16bits.
        char c1 = 65;
        byte bassign = 66;
        int iassign = 66;
        c1 = (char) bassign;
    }
}
