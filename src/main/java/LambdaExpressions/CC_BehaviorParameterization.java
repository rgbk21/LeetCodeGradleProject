package LambdaExpressions;

public class CC_BehaviorParameterization {

    public static void main(String[] args) {

        CC_BehaviorParameterization behavParam = new CC_BehaviorParameterization();

        String s1 = "Hello";
        String s2 = "World";

        behavParam.testJoiner((x,y) -> x + y, s1, s2);
        behavParam.testJoiner((x,y) -> x + " " + y, s1, s2);
        behavParam.testJoiner((x,y) -> x.toUpperCase() + " " + y.toUpperCase(), s1, s2);
    }

    public void testJoiner(AnotherJoiner joiner, String s1, String s2){
        System.out.print("Using Joiner: ");
        System.out.println( s1 + " + " + s2 + " = "  + joiner.join(s1, s2));
    }
}

@FunctionalInterface
interface AnotherJoiner{
    String join(String s1, String s2);
}