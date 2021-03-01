package Interfaces.ExtendingIF;

public interface A {
    void printA();
}

interface B extends A {
    void printB();
}

interface C extends A, B {
    void printC();
}

class D implements C {

    @Override
    public void printA() {

    }

    @Override
    public void printB() {

    }

    @Override
    public void printC() {

    }
}