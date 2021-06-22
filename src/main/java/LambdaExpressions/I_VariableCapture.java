package LambdaExpressions;

public class I_VariableCapture {

    private int counter = 0;

    public static void main(String[] args) {

        //Ok Scenario
        final String msg1 = "Hello"; // msg1 is final
        Printer printer1 = msg -> System.out.println(msg1 + " " + msg);

        //Ok Scenario
        String msg2 = "Hello"; // msg2 is effectively final
        Printer printer2 = msg -> System.out.println(msg2 + " " + msg);

        //Ok Scenario
        String msg3;
        msg3 = "Hello"; // msg is effectively final
        Printer printer3 = msg -> System.out.println(msg3 + " " + msg);

        //NOK Scenario
        // msg is not effectively final as it is changed later
        String msg4 = "Hello";
        // A compile-time error as a lambda expression can access only effectively final local variables
        // and the msg variable is not effectively final as it is changed afterwards.
        Printer printer4 = msg -> System.out.println(msg4 + " " + msg);//Variable used in lambda expression should be final or effectively final
        //Uncomment the below line to see the error
        //msg4 = "Hi"; // msg is changed


        //The lambda expression accesses the local variable msg5. Any local variable accessed inside a lambda expression
        //must be effectively final. The lambda expression attempts to modify the msg5 variable inside its body that causes the
        //compile-time error.
        String msg5 = "Hello";
        Printer printer5 = msg -> {
            //Uncomment the below line to see the error
            //msg5 = "Hi " + msg; // A compile-time error. Attempting to modify msg.
            System.out.println(msg5);
        };

        I_VariableCapture capture = new I_VariableCapture();

        Printer lambdaFn1 = capture.createLambdaFn(100);
        lambdaFn1.print("Hello World #1"); // Hello World #1 :: 100
        lambdaFn1.print("Hello World #2"); // Hello World #2 :: 200
        lambdaFn1.print("Hello World #3"); // Hello World #3 :: 300

        Printer lambdaFn2 = capture.createLambdaFn(1);
        lambdaFn2.print("Hello World #1"); // Hello World #1 :: 301
        lambdaFn2.print("Hello World #2"); // Hello World #2 :: 302
        lambdaFn2.print("Hello World #3"); // Hello World #3 :: 303

        I_VariableCapture capture2 = new I_VariableCapture();
        Printer lambdaFn3 = capture2.createLambdaFn(1);
        lambdaFn3.print("Hello World #1"); // Hello World #1 :: 1
        lambdaFn3.print("Hello World #2"); // Hello World #2 :: 2
        lambdaFn3.print("Hello World #3"); // Hello World #3 :: 3

    }

    private Printer createLambdaFn(int value){
        Printer printer = msg -> {
            // Note we are able to access the instance variable as well as change the value of the instance variable
            counter += value;
            System.out.println(msg + " :: " + counter);
        };
        return printer;
    }
}

@FunctionalInterface
interface AnotherPrinter {
    void print(String msg);
}
