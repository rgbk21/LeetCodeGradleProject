package LambdaExpressions;

import java.util.Random;

public class B_LambdaSyntax {

    public static void main(String[] args) {

        //Simple Lambda Expression that takes two parameters as input
        NumbersSum mySumWithParams = (int x, int y) -> {return x+y;};
        //You can omit the declared types of the parameters
        NumbersSum mySumWithoutParams = (x, y) -> {return x+y;};
        //You can use the modifiers such as final in the parameters
        NumbersSum mySumWithFinalParams = (final int x, int y) -> {return x+y;};

        //Another example that takes one parameter as input
        NumbersSquare mySquareWithParams = (int x) -> {return x*x;};
        //omit the type
        NumbersSquare mySquareWithoutParams = (x) -> {return x*x;};
        //The parentheses can be omitted only if the single parameter also omits its type
        NumbersSquare mySquareWithoutParamsAndBrackets = x -> {return x*x;};

        //Another example that takes no parameters as input
        //It is not allowed to omit the parentheses when the lambda expression takes no parameter
        RandomInt myRanNumGenerator = () -> {return new Random().nextInt(50);};

    }

}

@FunctionalInterface
interface NumbersSum {
    int sum(int x, int y);
}

@FunctionalInterface
interface NumbersSquare {
    int square(int x);
}

@FunctionalInterface
interface RandomInt {
    int generateRandomNumber();
}

