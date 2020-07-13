package LambdaExpressions;

public class H_LexicalScoping {

    public static void main(String[] args) {

        //The following code for a lambda expression inside a method generates a compile-time error as its parameter
        //name msg is already defined in the method's scope:
        String msg = "Hello";
        String msg2 = "Hello";

        // A compile-time error. The msg variable is already defined and the lambda parameter is attempting to redefine it.
        // Uncomment the below line to see the error
        // Printer printer1 = msg -> System.out.println(msg);//Variable 'msg' is already defined in the scope

        //The following code generates a compile-time error for the same reason that the local variable name msg2 is in
        //scope inside the body of the lambda expression and the lambda expression is attempting to declare a local variable
        //with the same name msg
        Printer printer2 = msg1 -> {
            // Uncomment the below line to see the error
            //String msg2 = "Hi"; //Variable 'msg2' is already defined in the scope
            System.out.println(msg2);
        };
    }

}

@FunctionalInterface
interface Printer {
    void print(String msg);
}