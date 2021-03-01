package Test1;

public class Floats {

    public static void main(String[] args) {
        // Why do we have to add the suffix 'f'?
        float[] myArray = {10.0f, 12f, 13.2f};

        // Because if we do this:
        // we are going to get an error because java will think
        // that you are trying to assign a double value in an array supposed to store floats
        float[] myArray2 = {10.0f, 12f, 13.2f}; // Required type: float. Provided: double
        float[] myArray3 = {10.0f, 12, 13.2f}; // This doesn't give an error though

        // Same error here
        // float myNum = 12.0; // Required type: float. Provided: double

        float myNu2 = 12; // But no error here

        // IN fact, check this out:
        double d1 = 0.1;
        double d2 = 0.1f;
        if (d1 == d2) {
            System.out.println("True!");
        } else {
            System.out.println("False");
        }
        // The program prints out False!
    }
}
