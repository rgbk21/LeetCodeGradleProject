package LambdaExpressions;

public class BB_LambdaSyntax {

    public static void main(String[] args) {

        // Uses a block statement. Takes two int parameters and returns their product.
        NumbersMultiply withBraces =  (int x, int y) -> {return x * y;};
        //// Uses an expression. Takes a two int parameters and returns their product.
        NumbersMultiply withoutBraces =  (int x, int y) -> x * y;

        //It is not always necessary that your Lambda Expression has to return something.
        //It can also return void
        StringToVoid myPrinterWithBraces = (String str) -> {System.out.println(str);};
        StringToVoid myPrinterWithoutBraces = (String str) -> System.out.println(str);

    }
}

@FunctionalInterface
interface NumbersMultiply {
    int multiply(int x, int y);
}

@FunctionalInterface
interface StringToVoid{
    void print(String s);
}