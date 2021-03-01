package Interfaces.DefaultMethods;

public interface IA {

    void printNumber();

    default void printString() {
        System.out.println("Default method in Interface A called");
    }
}

class A implements IA {

    @Override
    public void printNumber() {
        System.out.println("Printing number in class A");
    }
}

class Test {
    public static void main(String[] args) {
        A a = new A();
        a.printNumber();
        a.printString();
    }
}