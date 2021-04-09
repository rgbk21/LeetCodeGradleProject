package UdemyCourse.CoreJava.Section4;

public class L11_CheckSizeAndRangeOfDataTypes {

    public static void main(String[] args) {

        System.out.println("*** Byte ***");
        System.out.println("Min size of Byte: " + Byte.MIN_VALUE); // -128
        System.out.println("Max size of Byte: " + Byte.MAX_VALUE); // 127
        System.out.println("Bytes in an Byte: " + Byte.BYTES); // 1
        System.out.println("Bits in a Byte: " + Byte.SIZE); // 8

        System.out.println("\n*** Short ***");
        System.out.println("Min size of Short: " + Short.MIN_VALUE); // -32768
        System.out.println("Max size of Short: " + Short.MAX_VALUE); // 32767
        System.out.println("Bytes in an Short: " + Short.BYTES); // 2
        System.out.println("Bits in a Short: " + Short.SIZE); // 16

        System.out.println("\n*** Integer ***");
        System.out.println("Min size of Integer: " + Integer.MIN_VALUE); // -2147483648
        System.out.println("Max size of Integer: " + Integer.MAX_VALUE); // 2147483647
        System.out.println("Bytes in an Integer: " + Integer.BYTES); // 4
        System.out.println("Bits in a Integer: " + Integer.SIZE); // 32

        System.out.println("\n*** Long ***");
        System.out.println("Min size of Long: " + Long.MIN_VALUE); // -9223372036854775808
        System.out.println("Max size of Long: " + Long.MAX_VALUE); // 9223372036854775807
        System.out.println("Bytes in an Long: " + Long.BYTES); // 8
        System.out.println("Bits in a Long: " + Long.SIZE); // 64

        System.out.println("\n*** Character ***");
        System.out.println("Min size of Character: " + Character.MIN_VALUE); // '\u0000' but prints nothing
        System.out.println("Max size of Character: " + Character.MAX_VALUE); // '\uFFFF' but prints '?'
        System.out.println("Min size of Character: " + (int) Character.MIN_VALUE); // 0
        System.out.println("Max size of Character: " + (int) Character.MAX_VALUE); // 65535
        System.out.println("Bytes in an Character: " + Character.BYTES); // 2
        System.out.println("Bits in a Character: " + Character.SIZE); // 16

        System.out.println("\n*** Float ***");
        System.out.println("Min size of Float: " + Float.MIN_VALUE); // 1.4E-45
        System.out.println("Max size of Float: " + Float.MAX_VALUE); // 3.4028235E38
        System.out.println("Bytes in an Float: " + Float.BYTES); // 4
        System.out.println("Bits in a Float: " + Float.SIZE); // 32

        System.out.println("\n*** Double ***");
        System.out.println("Min size of Double: " + Double.MIN_VALUE); // 4.9E-324
        System.out.println("Max size of Double: " + Double.MAX_VALUE); // 1.7976931348623157E308
        System.out.println("Bytes in an Double: " + Double.BYTES); // 8
        System.out.println("Bits in a Double: " + Double.SIZE); // 64

        System.out.println("\n*** Boolean ***");
        System.out.println("Size of the boolean is dependent on the JVM");

        // An integer literal can be represented in different formats
        // Suppose we want to represent the integer 10 in different formats
        byte b1 = 10; // Decimal
        byte b2 = 0b1010; // Binary
        byte b3 = 012; // Octal
        byte b4 = 0xA; // Hexadecimal

        // Printing each of them is going to print 10
        // Printing numbers: 10 10 10 10
        System.out.println("Printing numbers: " + b1 + " " + b2 + " " + b3 + " " + b4);

        // Recall that numbers larger than Integer.MAX_VALUE need to be appended with L
//        long l1 = 9999999999; // Compile error: Integer number too large
        long l2 = 9999999999L; // This is the way

        // Recall that decimal numbers are of type double by default
//        float f1 = 2.2; // Compile error. Required Type: float. Provided: double.
        float f2 = 2.2f; // This is the way

        // How do you represent -ve numbers
        // -5?
        // 1) Take magnitude 5 => 00000101 in binary
        // 2) Invert bits => 11111010 (One's Complement)
        // 3) Add 1 => 11111011 (Two's Complement)
        // The Two's Complement format is how the number will be stored in the computer's memory
        // Recall that the left-most bit is a sign bit. Since that is 1, hence the number is -ve
        int num1 = 5;
        int num2 = -5;
        System.out.println("Representing 5 in binary: " + Integer.toBinaryString(num1)); // Prints: 101
        System.out.println("Representing -5 in binary: " + Integer.toBinaryString(num2)); // Prints: 11111111111111111111111111111011

        // Similar to binary, we can also get the representation of a number in other bases
        System.out.println("Representing 10 in binary: " + Integer.toBinaryString(10)); // Prints: 101
        System.out.println("Representing 5 in octal: " + Integer.toOctalString(10)); // Prints: 12
        System.out.println("Representing 5 in hex: " + Integer.toHexString(10)); // Prints: a

        // If we were to convert the two's complement 11111011 back to decimal
        // 1) Since the leftmost bit is 1, it means the number was -ve
        // 2) Invert the bits => 00000100
        // 3) Add 1 => 00000101 (You get 5)
        // Since the original number was -ve, the number becomes -5

    }
}
