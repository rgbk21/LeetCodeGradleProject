package LambdaExpressions;

import java.util.function.Function;
import java.util.function.IntFunction;

public class GH_ArrayConstructorReferences {

    public static void main(String[] args) {

        // Uses a lambda expression
        IntFunction<int[]> arrayCreator1 = size -> new int[size];
        int[] empIds1 = arrayCreator1.apply(5); // Creates an int array of five elements
        // Uses an array constructor reference
        IntFunction<int[]> arrayCreator2 = int[]::new;
        int[] empIds2 = arrayCreator2.apply(5); // Creates an int array of five elements

        //You can also use a Function<Integer,R> type to use an array constructor reference, where R is the array type.
        // Uses an array constructor reference
        Function<Integer,int[]> arrayCreator3 = int[]::new;
        int[] empIds3 = arrayCreator3.apply(5); // Creates an int array of five elements
    }
}
