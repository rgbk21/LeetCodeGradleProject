package UdemyCourse.CoreJava.Section24;

public class BoundsOnGenerics {

    public static void main(String[] args) {

        // The class MyArray has been declared as a Generic Type
        // So we would instantiate the class as follows
        // In this case storing anything but Strings in the class will throw an error
        MyArray<String> strArray = new MyArray<>();
        strArray.append("Alice");
//        strArray.append(123); // Compile Error


        // But we can also instantiate the array without the type parameter
        // In this case the items stored in the array will be of Object type
        // Hence we will be able to store both Strings as well as Integers since both qualify as objects
        MyArray objArray = new MyArray();
        objArray.append("Alice");
        objArray.append(123); // No compile error now

        // ****************************************************************************************
        // Extending a Generic Class
        // ****************************************************************************************

        // Since MyArray2 is extending MyArray (without the type parameter),
        // you are basically extending MyArray<Object>
        // Hence in this case, MyArray will be able to store all Object references
        MyArray2 objClass = new MyArray2();
        objClass.append("Alice");
        objClass.append(123);

        // Since MyArray3 is extending MyArray<String>,
        // you can only store String types in MyArray3
        MyArray3 strClass = new MyArray3();
        strClass.append("Alice");
//        strClass.append(123); // Compile Error

        // Since MyArray4 is extending MyArray<T>,
        // it is compulsory for the MyArray4 class to be declared as Generic as well.
        MyArray4<String> genericClass = new MyArray4<>();
        genericClass.append("Alice");
//        genericClass.append(123);

        // ****************************************************************************************
        // Using Upper Bound for a Generic Class
        // ****************************************************************************************

        NumericArray<Integer> intArray = new NumericArray<>();
        intArray.append(123);
//        intArray.append(12.5); // Compile error. Trying to add Double to an array of Integer

        // Compile Error
        // Type parameter 'java.lang.String' is not within its bound; should extend 'java.lang.Number'
//        NumericArray<String> strArray1 = new NumericArray<>();

    }
}

class MyArray<T> {

    private T[] array;
    private int length;

    public MyArray() {
        this.array = (T[]) new Object[10];
        this.length = 0;
    }

    public void append(T el) {
        this.array[length++] = el;
    }

    public void display() {
        for (int i = 0; i < length; i++) {
            System.out.println(this.array[i]);
        }
    }
}

class MyArray2 extends MyArray {

}

class MyArray3 extends MyArray<String> {

}

class MyArray4<T> extends MyArray<T> {

}

class NumericArray<T extends Number> {

    private T[] array;
    private int length;

    public NumericArray() {
        this.array = (T[]) new Object[10];
        this.length = 0;
    }

    public void append(T el) {
        this.array[length++] = el;
    }

    public void display() {
        for (int i = 0; i < length; i++) {
            System.out.println(this.array[i]);
        }
    }
}

