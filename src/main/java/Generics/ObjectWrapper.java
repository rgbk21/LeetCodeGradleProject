package Generics;

public class ObjectWrapper {

    private Object object;

    ObjectWrapper(Object o) {
        this.object = o;
    }

    public Object getObject() {
        return this.object;
    }

    public void setObject(Object o) {
        this.object = o;
    }

    public static void main(String[] args) {

        ObjectWrapper stringWrapper = new ObjectWrapper("Hello");
        // Note that we need to cast it to String
        String str = (String) stringWrapper.getObject();
        System.out.println("String value: " + str); // String value: Hello
        // We can also change the value
        stringWrapper.setObject("World");
        System.out.println("String value: " + stringWrapper.getObject()); // String value: World

        // We initialize the ObjectWrapper with a String object
        ObjectWrapper stringWrapper1 = new ObjectWrapper("Hello");
        // Since the setObject method takes in an args of type Object, we can pass in ANY object into the method
        stringWrapper1.setObject(100);
        // Note that the following code compiles fine. But you get a ClassCastException when you try to run this code.
        // Runtime Error: class java.lang.Integer cannot be cast to class java.lang.String
        String number = (String) stringWrapper1.getObject();
    }
}


