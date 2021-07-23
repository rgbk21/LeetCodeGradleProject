package Generics;

public class Test1 {

    public <V> void m1(Wrapper<V> a, Wrapper<V> b) {
        // Do something
    }

    public static void main(String[] args) {
        // Note that while instantiating we do not need any type definitions
        // i.e. we are not using Test1<Integer> or something like that
        Test1 test1 = new Test1();
        test1.m1(new Wrapper<Integer>(123), new Wrapper<Integer>(321));
    }
}

class Test2<T> {

    // Type Parameter T can be used within the non - static method
    public <V> void m1(Wrapper<V> a, Wrapper<V> b, T c) {
        T value = c;
        // Do something
    }

    public static void main(String[] args) {

        // We have defined the type parameter of Test2 to be String
        Test2<String> test2 = new Test2<>();
        // Hence if we use anything other than String as args for c, we get a compile error
//        test2.m1(new Wrapper<Integer>(123), new Wrapper<Integer>(321), 123); // reason: int is not compatible with String
        test2.m1(new Wrapper<Integer>(123), new Wrapper<Integer>(321), "Hello"); // We have to use String
    }
}
