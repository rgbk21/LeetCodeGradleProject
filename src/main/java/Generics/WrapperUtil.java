package Generics;

public class WrapperUtil {

    public static void printDetails(Wrapper<Object> wrapper) {
        System.out.println("The value is: " + wrapper.getRef());
    }

    public static void printDetails_v2(Wrapper<?> wrapper) {
        System.out.println("The value is: " + wrapper.getRef());
    }

    public static void main(String[] args) {

        Wrapper<Object> objWrapper = new Wrapper<>(new Object());
        printDetails(objWrapper); // This works correctly

        Wrapper<String> strWrapper = new Wrapper<>("Hello");
//        printDetails(strWrapper); // Compile Error. Required type: Wrapper<Object> Provided: Wrapper<String>

        Wrapper<Object> objWrapper_v2 = new Wrapper<>(new Object());
        printDetails_v2(objWrapper_v2); // This works correctly

        Wrapper<String> strWrapper_v2 = new Wrapper<>("Hello");
        printDetails_v2(strWrapper_v2); // This works fine now.

        // Generic WildCard Type can be assigned to a generic of any type
        Wrapper<?> wildCardWrapper1 = objWrapper;
        Wrapper<?> wildCardWrapper2 = strWrapper;

        // You cannot use <?> with a 'new' operator. It's a compile-time error
//        Wrapper<?> wildCardWrapper3 = new Wrapper<?>("Hello"); // Compile Error: Wildcard type '?' cannot be instantiated directly

        // You can use the <?> to refer to a known generic type object
        Wrapper<?> unknownWrapper = new Wrapper<>(1234);

        // There is a restriction on the kind of actions you can perform on a reference of a wildcard type.
//        String str = unknownWrapper.getRef(); // Compile Time Error: Required type: String Provided: capture of ?
        // Doing this will get rid of the compile error you get above, but you will still run into ClassCastException
        // if you instantiate unknownWrapper class with an Integer type object.
//        String str2 = (String) unknownWrapper.getRef();

        /*
        Why does the above line not compile?
        - The compiler knows that the getRef() method of the Wrapper<T> class returns an object of type T.
        However, for the unknownWrapper variable, type T is unknown. Therefore, the compiler cannot make sure that the method call,
        unknownWrapper.getRef(), will return a String and its assignment to str variable is fine at runtime.
        All you have to do is convince the compiler that the assignment will not throw a ClassCastException at runtime.
        */

        // So in order to make the compiler happy, we can write this instead. This compiles properly.
        Object obj = unknownWrapper.getRef();
        /*
        The above code will compile because the compiler is convinced that this statement will not throw a ClassCastException at runtime.
        It knows that the get() method returns an object of a type, which is not known to the unknownWrapper variable.
        No matter what type of object the get() method returns, it will always be assignment compatible with the Object type.
        After all, all reference types in Java are subtypes of the Object type.
         */

//        unknownWrapper.setRef("Hello"); // Compile Error
//        unknownWrapper.setRef(100); // Compile Error
//        unknownWrapper.setRef(new Object()); // Compile Error
        unknownWrapper.setRef(null); // But this is fine.
        /*
        Why do the above setRef() statements don't compile?
        The setRef(T a) method accepts the generic type argument.
        This type, T, is not known to unknownWrapper, and therefore the compiler cannot make sure
        that the unknown type is a String type, an Integer type, or an Object type.
        This is the reason that the first three calls to setRef() are rejected by the compiler.
        Why is the fourth call to the setRef() method correct?
        A null is assignment-compatible to any reference type in Java.
        The compiler thought that no matter what type T would be in the setRef(T a) method for the object to which unknownWrapper reference variable is pointing to,
        a null can always be safe to use.
         */
    }
}
