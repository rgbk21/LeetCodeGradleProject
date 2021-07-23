package Generics;

import java.util.ArrayList;
import java.util.List;

public class TestClass {

    public static void main(String[] args) {
        List<A> list1 = new ArrayList<>();
        list1.add(new A("Alice"));
        list1.add(new B("Bob"));
        list1.add(new C("Charlie"));

        List<C> list2 = new ArrayList<>();
        list2.add(new C("Charlie"));
        // list2.add(new B("Bob")); // Required type: C Provided: B
    }

}

class A {

    String name;
    A(){}
    A(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public A setName(String name) {
        this.name = name;
        return this;
    }
}

class B extends A {
    String name2;
    B() {}
    B(String str){
        super(str);
    }
}

class C extends B {
    String name2;
    C() {}
    C(String str) {
        super(str);
    }
}