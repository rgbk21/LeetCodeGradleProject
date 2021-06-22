package Test1.MethodOverloading;

public class CalleeImpl implements Callee {

    @Override
    public void foo(Object o) {
        System.out.println("foo(Object o)");
    }

    @Override
    public void foo(String s) {
        System.out.println("foo(\"" + s + "\")");
    }

    @Override
    public void foo(Integer i) {
        System.out.println("foo(" + i + ")");
    }

    public static void main(String[] args) {

        Callee callee = new CalleeImpl();

        Object i = 12;
        Object s = "foobar";
        Object o = new Object();

        callee.foo(i);
        callee.foo(s);
        callee.foo(o);
    }
}

interface Callee {
    void foo(Object o);
    void foo(String s);
    void foo(Integer i);
}
