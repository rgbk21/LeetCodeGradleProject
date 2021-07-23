package Generics;

// Note that we have to specify the 'type parameter' with the 'type' (class name or interface name)
public class Wrapper<T> {

    private T ref;

    Wrapper(T ref) {
        this.ref = ref;
    }

    public T getRef() {
        return this.ref;
    }

    public void setRef(T ref) {
        this.ref = ref;
    }

    public static void main(String[] args) {

        Wrapper<String> wrapper = new Wrapper<>("Hello");
        // Now Java already knows that we are using a Wrapper with a String type
        // So no need to cast it to String, unlike the case of the ObjectWrapper above
        String str = wrapper.getRef();
        System.out.println("String Value: " + str);
        // And we can set it to another String value
        wrapper.setRef("World");
        System.out.println("String Value: " + wrapper.getRef());

        // And when we try to set an Integer into the object, we will get compile time error
        // wrapper.setRef(100); // Compile Error: Required type: String Provided: int

        // Now if you want to store an <code>Integer</code> in the <i>Wrapper</i> class, you will have to do it like this:
        Wrapper<Integer> intWrapper = new Wrapper<>(100);
        Integer intWrapperRef = intWrapper.getRef(); // Again. No need for a cast
        System.out.println("Integer Value: " + intWrapperRef);

        // *****************************************************************************
        // SuperType SubType Relationship
        // *****************************************************************************

        Wrapper<String> strWrapper = new Wrapper<>("Hello");
        Wrapper<Object> objWrapper = new Wrapper<>(new Object());

        // In Java you can do this:
        String s1 = "Hello";
        Object obj = s1; // You can point an Object reference to a String reference

        // But this is an illegal operation:
        // objWrapper = strWrapper; // Required type: Wrapper<Object> Provided: Wrapper <String>

        // The reason that you cannot do this is that, if suppose you were able to do that, then:
        // You could store an object in the strWrapper using the objWrapper
        objWrapper.setRef(new Object());

        // And then this would have thrown a ClassCastException
        String str2 = strWrapper.getRef();

        // *****************************************************************************
        // Raw Type
        // *****************************************************************************
        Wrapper rawType = new Wrapper("Hello"); // Compiler Warning: Raw use of parameterized class 'Wrapper' ' as a member of raw type 'Generics.Wrapper'
        Wrapper<String> stringWrapper2 = new Wrapper<>("World");
        stringWrapper2 = rawType; // Compiler Warning: Unchecked assignment: 'Generics.Wrapper' to 'Generics.Wrapper<java.lang.String>'
        rawType = stringWrapper2;
    }
}
