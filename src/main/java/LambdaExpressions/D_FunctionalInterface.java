package LambdaExpressions;

import java.util.function.*;

public class D_FunctionalInterface {

    public static void main(String[] args) {

        int myNum = 10;
        Function<Integer, Integer> mySquare = x -> x * x;
        Function<Integer, Integer> myDouble = x -> 2 * x;
        UnaryOperator<Integer> mySquare4 = x -> x * x;

        //IntFunction<R>, LongFunction<R>, and DoubleFunction<R> take an int, a long, and a double as an argument, respectively, and return a value of type R
        IntFunction<Integer> mySquare2 = x -> x * x;

        //ToIntFunction<T>, ToLongFunction<T>, and ToDoubleFunction<T> take an argument of type T and return an int, a long, and a double, respectively
        ToIntFunction<Integer> mySquare3 = x -> x * x;

        //BiFunction example
        BiFunction<Integer, Integer, Integer> mySum = (x, y) -> x + y;

        testMain_Function(mySquare, myNum);
        testMain_Function(myDouble, myNum);
        testMain_Function(mySquare4, myNum);

        testMain_IntFunction(mySquare2, myNum);

        testMain_ToIntFunction(mySquare3, myNum);

        testMain_BiFunction(mySum, myNum, myNum);

    }

    public static void testMain_Function(Function<Integer, Integer> myFunc, Integer myNum){
        System.out.println("Input: " + myNum + " " + "Output: " + myFunc.apply(myNum));
    }

    public static void testMain_IntFunction(IntFunction<Integer> myFunc, Integer myNum){
        System.out.println("Input: " + myNum + " " + "Output: " + myFunc.apply(myNum));
    }

    public static void testMain_ToIntFunction(ToIntFunction<Integer> myFunc, Integer myNum){
        System.out.println("Input: " + myNum + " " + "Output: " + myFunc.applyAsInt(myNum));
    }

    public static void testMain_BiFunction(BiFunction<Integer, Integer, Integer> myFunc, Integer myNum1, Integer myNum2){
        System.out.println("Input1 : " + myNum1 + ", " + myNum2 + " " + "Output: " + myFunc.apply(myNum1, myNum2));
    }
}

// Input: 10 Output: 100
// Input: 10 Output: 20
// Input: 10 Output: 100
// Input: 10 Output: 100
// Input: 10 Output: 100