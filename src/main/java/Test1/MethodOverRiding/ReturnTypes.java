package Test1.MethodOverRiding;

public class ReturnTypes {
    public static void main(String[] args) {
        // If a super class is returning an object of type A, then the overridden method can return an object of it's subclass
        Super sup = new Sub();
        sup.print(); // Prints: Inside Sub
    }
}

class Super {
    public A print(){
        System.out.println("Inside Super");
        return new A();
    }
}

class Sub extends Super{
    @Override
    public B print(){
        System.out.println("Inside Sub");
        return new B();
    }
}

class A {}

class B extends A {}

