package LambdaExpressions;

import java.util.function.Function;

public class DD_Function {

    public static void main(String[] args) {

        //https://stackoverflow.com/questions/43849066/java-8-functions-compose-and-andthen

        Integer myNum = 5;
        Integer myNum2 = 15;

        //Case 1: When both the functions that you want to join are already present
        //In this case both andThen and compose are the same, just their orders are reversed
        Function<Integer, Integer> square = x -> x * x;
        Function<Integer, Integer> addOne = x -> x + 1;

        Function<Integer, Integer> squareAndAddOne = square.andThen(addOne);
        Function<Integer, Integer> squareAndAddOne_usingCompose = addOne.compose(square);

        System.out.println("Square and add one to: " + myNum);
        System.out.println("Result using andThen: " + squareAndAddOne.apply(myNum));
        System.out.println("Result using compose: " + squareAndAddOne_usingCompose.apply(myNum));

        //Case 2: When the first function is defined but the second is not
        //In this case, using andThen seems to be the easier approach
        Function<Integer, String> iToHex = i -> Integer.toHexString(i);
        Function<Integer, String> itoUpperHex = iToHex.andThen(s -> s.toUpperCase());
        Function<Integer, String> itoUpperHex_usingCompose = ((Function<String, String>) s -> s.toUpperCase()).compose(iToHex);

        System.out.println("\nInput Integer being converted to Hex UpperCase in Case 2: " + myNum2);
        System.out.println("Result using andThen: " + itoUpperHex.apply(myNum2));
        System.out.println("Result using compose: " + itoUpperHex_usingCompose.apply(myNum2));

        //Case 3: When the second function is defined but the first is not
        //In this case, using compose seems to be the easier approach
        Function<String, String> upperCase = s -> s.toUpperCase();
        Function<Integer, String> iToUpperHex2 = ((Function<Integer, String>) i -> Integer.toHexString(i)).andThen(upperCase);
        Function<Integer, String> iToUpperHex2_usingCompose = upperCase.compose(i -> Integer.toHexString(i));

        System.out.println("\nInput Integer being converted to Hex UpperCase in Case 3: " + myNum2);
        System.out.println("Result using andThen: " + iToUpperHex2.apply(myNum2));
        System.out.println("Result using compose: " + iToUpperHex2_usingCompose.apply(myNum2));

        //Case 4: When you do not have either of the functions, you can just combine them
        Function<Integer, String> lastTry = i -> Integer.toHexString(i).toUpperCase();
        System.out.println("\nCase4: " + lastTry.apply(15));
    }
}

//Square and add one to: 5
//Result using andThen: 26
//Result using compose: 26

//Input Integer being converted to Hex UpperCase in Case 2: 15
//Result using andThen: F
//Result using compose: F

//Input Integer being converted to Hex UpperCase in Case 3: 15
//Result using andThen: F
//Result using compose: F

//Case4: F