package LambdaExpressions;

public class C_TargetTyping {

    public static void main(String[] args) {
        /*
        - This is an example of target typing.
        - The same lambda expression: (x, y) -> x+y is interpreted by the compiler in the first line as of type Adder
        - Whereas on the second line, it is interpreted being of type Joiner
         */
        Adder adder = (x, y) -> x+y;
        Joiner joiner = (x, y) -> x+y;
    }
}

@FunctionalInterface
interface Adder{
    double add(double a, double b);
}

@FunctionalInterface
interface Joiner{
    String join(String s1, String s2);
}