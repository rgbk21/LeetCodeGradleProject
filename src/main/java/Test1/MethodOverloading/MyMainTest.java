package Test1.MethodOverloading;

public class MyMainTest {

    public static void main(String[] args) {
        Integer in = 3;
        A a = new B(); // developer by mistake types new B() instead of new C()
        a.print(in);  // compiler will allow this because class A has print method which can take any subclass of Object type(in this case any class because Object is superclass of all classes in java).
    }


}

class A {
    public void print(Object obj) {
        System.out.println(obj.toString());
    }
}

class B extends A {
//    @Override
    public void print(String str) {
        System.out.println(str.toString());
    }
}

class C extends A {
//    @Override
    public void print(Integer in) {
        System.out.println(in.toString());
    }
}