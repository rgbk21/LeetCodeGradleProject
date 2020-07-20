package Test1;

public interface InterfaceA {

    //Static methods in interfaces should have a body
    //Modifier 'public' is redundant for interface methods
    public static InterfaceB getInterfaceB(){
        return () -> "interfaceB-Prototype";
    }

    //Modifier 'public' is redundant for inner interfaces
    public interface InterfaceB {

        public String printNumber2();

    }
}


