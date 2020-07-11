package LambdaExpressions;

public class A_BasicExamples {

    public static void main(String[] args) {
        /*
        - Here the lambda expression represents an instance of the StringToIntMapper functional interface
        - The compiler sees that the RHS of the expression is a Lambda Expression
        - To infer it's type, it looks at the LHS of the assignment operator and sees that it expects an instance of
        StringToIntMapper
        - It then verifies that the lambda expression conforms to the declaration of the getLength method in the StringToIntMapper interface
        - If everything is proper, it infers the type of the lambda expression to be StringToIntMapper and the code compiles
         */
        StringToIntMapper myMapper = (String str) -> str.length();

        /*
        - Compare this to something like this, where the lambda expression does NOT conform, and you get a compile-error:
         */
        //StringToIntMapper myIncorrectMapper = (String str) -> str.toUpperCase();//Bad return type in lambda expression: String cannot be converted to int

        /*
        - When you call the getLength method on the myMapper variable, passing a String, the body of the lambda expression is executed.
         */
        System.out.println(myMapper.getLength("Whodunnit?"));

    }
}

@FunctionalInterface
interface StringToIntMapper{
    public int getLength(String s);
}
