package UdemyCourse.CoreJava.Section20;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;

public class Reflection {

    public static void main(String[] args) {
        SampleReflection sample = new SampleReflection();

        // There are two ways in which you can get the class details
        Class sampleClass = sample.getClass();
        Class sampleClass2 = SampleReflection.class;
        System.out.println(sampleClass.getName()); // Prints: UdemyCourse.CoreJava.Section20.SampleReflection
        System.out.println(sampleClass2.getName()); // Prints: UdemyCourse.CoreJava.Section20.SampleReflection

        // You can get the fields that are defined in the class
        Field[] fields = sampleClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        /*
        Prints:
        private int UdemyCourse.CoreJava.Section20.SampleReflection.a
        protected int UdemyCourse.CoreJava.Section20.SampleReflection.b
        public int UdemyCourse.CoreJava.Section20.SampleReflection.c
        int UdemyCourse.CoreJava.Section20.SampleReflection.d
         */

        // You can get the constructors that are defined in the class
        Constructor[] constructors = sampleClass.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
        /*
        public UdemyCourse.CoreJava.Section20.SampleReflection()
        public UdemyCourse.CoreJava.Section20.SampleReflection(int,int)
        */

        // You can get the methods that are defined in the class
        Method[] methods = sampleClass.getMethods();
        for(Method method : methods){
            System.out.println(method);
        }
        /*
        Note that the methods that have been inherited from the Object class have also been displayed.
        public void UdemyCourse.CoreJava.Section20.SampleReflection.display(java.lang.String,java.lang.String)
        public int UdemyCourse.CoreJava.Section20.SampleReflection.show(int,int)
        public final native void java.lang.Object.wait(long) throws java.lang.InterruptedException
        public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException
        public final void java.lang.Object.wait() throws java.lang.InterruptedException
        public boolean java.lang.Object.equals(java.lang.Object)
        public java.lang.String java.lang.Object.toString()
        public native int java.lang.Object.hashCode()
        public final native java.lang.Class java.lang.Object.getClass()
        public final native void java.lang.Object.notify()
        public final native void java.lang.Object.notifyAll()
         */

        // For each method you can also get the parameters that are accepted by the method
        // Note that the names of the parameters are printed as arg0, arg1
        Parameter[] parametersOfMethod1 = methods[0].getParameters();
        System.out.println(methods[0].getName() + Arrays.toString(parametersOfMethod1)); // display[java.lang.String arg0, java.lang.String arg1]
        Parameter[] parametersOfMethod2 = methods[1].getParameters();
        System.out.println(methods[1].getName() + Arrays.toString(parametersOfMethod2)); // show[int arg0, int arg1]

    }
}

class SampleReflection {

    private int a;
    protected int b;
    public int c;
    int d;

    public SampleReflection(){}
    public SampleReflection(int x, int y){}

    public void display(String s1, String s2){}
    public int show(int a, int b){return 0;}
}