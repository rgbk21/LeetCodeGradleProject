package Generics;

public class UpperBoundedWildcards {

    public static double calculateSum_v1(Wrapper<?> num1, Wrapper<?> num2) {
        // Code here
        return 0;
    }

    public static double calculateSum_v2(Wrapper<? extends Number> num1, Wrapper<? extends Number> num2) {
        Number n1 = num1.getRef();
        Number n2 = num2.getRef();
        double result =  n1.doubleValue() + n2.doubleValue();
        return result;
    }

    // Then you could have called the method like this.
    public static void main(String[] args) {
        calculateSum_v1(new Wrapper<>(100), new Wrapper<>("Hello"));

        // The type of numberWrapper is <? extends Number>, which means it can refer to
        // (or it is assignment-compatible with) anything that is a subtype of the Number class.
        // Since Integer is a subclass of Number, the assignment of intWrapper to numberWrapper is allowed.
        Wrapper<Integer> intWrapper = new Wrapper<>(100);
        Wrapper<? extends Number> numWrapper = intWrapper;

        // When you try to use the set() method on numberWrapper, the compiler starts complaining
        // because it cannot make sure at compile time that numberWrapper is a type of Integer or Double, which are subtypes of a Number.
//        numWrapper.setRef(1220); // A compile-time error
//        numWrapper.setRef(12.20); // A compile-time error
    }
}
