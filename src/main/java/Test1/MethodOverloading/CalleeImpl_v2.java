package Test1.MethodOverloading;

public class CalleeImpl_v2 implements Callee {

    @Override
    public void foo(Object o) {
        System.out.println("CalleeImpl_v2::foo(Object o)");
    }

    @Override
    public void foo(String s) {
        System.out.println("CalleeImpl_v2::foo(\"" + s + "\")");
    }

    @Override
    public void foo(Integer i) {
        System.out.println("CalleeImpl_v2::foo(" + i + ")");
    }

    public static void main(String[] args) {

        Callee callee;

        Object i = 12;
        Object s = "foobar";
        Object o = new Object();

        // The compile time type of the method parameters is used to determine the signature of the method to be called
        // Since the compile-time type of i, s, o are Object, it is the foo(Object o) method that is called
        callee = new CalleeImpl_v2();
        callee.foo(i); // Prints: CalleeImpl_v2::foo(Object o)
        callee.foo(s); // Prints: CalleeImpl_v2::foo(Object o)
        callee.foo(o); // Prints: CalleeImpl_v2::foo(Object o)

        // At runtime, the class of the object the method is called on determines which implementation of that method is called,
        // taking into account that it may be an instance of a subclass of the declared type that overrides the method
        // Since we changed the callee to refer to the CalleeImpl_v3 subtype, hence now the CalleeImpl_v3 foo(Object o) method is called
        callee = new CalleeImpl_v3();
        callee.foo(i); // Prints: CalleeImpl_v3::foo(Object o)
        callee.foo(s); // Prints: CalleeImpl_v3::foo(Object o)
        callee.foo(o); // Prints: CalleeImpl_v3::foo(Object o)

        // So, if we changed the compile-time type of the parameters that are being used, the results should also change
        Integer num = 12;
        String str = "foobar";
        Object obj = new Object();

        callee.foo(num); // Prints: CalleeImpl_v3::foo(12)
        callee.foo(str); // Prints: CalleeImpl_v3::foo("foobar")
        callee.foo(obj); // Prints: CalleeImpl_v3::foo(Object o)

        // Now the question is, is there a way to modify this code so that it'll print
        // foo(12), foo("foobar") and foo(Object o) for when the compile-time type of the parameters is just Object
        callee = new CalleeImpl_v4();
        callee.foo(i); // Prints: CalleeImpl_v4::foo(12)
        callee.foo(s); // Prints: CalleeImpl_v4::foo("foobar")
        callee.foo(o); // Prints: CalleeImpl_v4::foo(Object o)
    }
}

class CalleeImpl_v3 implements Callee {
    @Override
    public void foo(Object o) {
        System.out.println("CalleeImpl_v3::foo(Object o)");
    }

    @Override
    public void foo(String s) {
        System.out.println("CalleeImpl_v3::foo(\"" + s + "\")");
    }

    @Override
    public void foo(Integer i) {
        System.out.println("CalleeImpl_v3::foo(" + i + ")");
    }
}

class CalleeImpl_v4 implements Callee {

    @Override
    public void foo(Object o) {

        if (o instanceof String) {
            String s = (String) o;
            foo(s);
        } else if (o instanceof Integer) {
            Integer num = (Integer) o;
            foo(num);
        } else {
            System.out.println("CalleeImpl_v4::foo(Object o)");
        }
    }

    @Override
    public void foo(String s) {
        System.out.println("CalleeImpl_v4::foo(\"" + s + "\")");
    }

    @Override
    public void foo(Integer i) {
        System.out.println("CalleeImpl_v4::foo(" + i + ")");
    }
}