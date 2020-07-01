package easy;

import java.math.BigInteger;

public class Overflow {

    public static void main(String[] args) {

        long hoursInDay = 24;
        //type promotion
        long MICROS_PER_DAY = hoursInDay * 60L * 60 * 1000 * 1000;//86,400,000,000 > 2,147,483,647
        System.out.println("MICROS_PER_DAY: " + MICROS_PER_DAY);

        //-128 to 127 - signed data type //unsigned datatype
        //8 bits
        //silent overflow
        byte myByte = (byte) (12 * 10 + 7 + 1);
        System.out.println("myByte: "+ myByte);


    }

}
