package LambdaExpressions;

public class I_VariableCapture {

    private int counter = 0;

    public static void main(String[] args) {

        //Ok Scenario
        final String msg1 = "Hello"; // msg1 is final
        AnotherPrinter printer1 = msg -> System.out.println(msg1 + " " + msg);

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
    }

}

@FunctionalInterface
interface AnotherPrinter{
    void print(String msg);
}
