package Interfaces.MultipleInheritance;

public interface Alpha {
    default void printDetails() {
        System.out.println("In Alpha interface");
    }
}

interface Beta {
    default void printDetails() {
        System.out.println("In Beta interface");
    }
}

interface Charlie extends Beta {
    default void printDetails() {
        System.out.println("In Charlie interface");
    }
}

class MyClass implements Alpha, Beta {

    @Override
    public void printDetails() {
        System.out.println("In MyClass");
    }
}

// This compiles fine..
class MyClass2 implements Alpha {

}

// ..but this will create a compile error because we are implementing two methods with the same signature
//class MyClass3 implements Alpha, Beta {
//
//}

// An object of MyClass4 will call the Charlie IF implementation of printDetails()
// because that is the IF that extends
class MyClass4 implements Charlie {

}

// You can refer to method in super interface like follows:
class MyClass5 implements Alpha, Beta, Charlie {
    @Override
    public void printDetails() {
        Alpha.super.printDetails();
    }
}

class Test {
    public static void main(String[] args) {

        MyClass mc = new MyClass();
        mc.printDetails(); // Prints: In MyClass

        MyClass4 mc4 = new MyClass4();
        mc4.printDetails(); // Prints: In Charlie interface

        MyClass5 mc5 = new MyClass5();
        mc5.printDetails(); // Prints: In Alpha interface

    }
}