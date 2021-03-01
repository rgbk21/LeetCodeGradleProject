package Interfaces.NestedInterfaces;

public class A {

    public interface NestedIF {
        boolean isPositive(int x);
    }
}

class B implements A.NestedIF {

    @Override
    public boolean isPositive(int x) {
        return x > 0;
    }
}

class NestedIFDemo {

    public static void main(String[] args) {
        A.NestedIF nif = new B();

        if (nif.isPositive(42)) {
            System.out.println("..is positive");
        }
    }
}