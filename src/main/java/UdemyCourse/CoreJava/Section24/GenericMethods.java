package UdemyCourse.CoreJava.Section24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericMethods {

    public static void main(String[] args) {

        AnotherClass anotherClass = new AnotherClass();
        anotherClass.printItems(new ArrayList<>(Arrays.asList("Alice", "Bob", "Charlie")));
        anotherClass.printNumbers(new ArrayList<>(Arrays.asList(10, 20, 30, 30.2))); // Note that we are passing in Double value as well and thats fine
//        anotherClass.printNumbers(new ArrayList<>(Arrays.asList("Alice", "Bob", "Charlie"))); // Compile Error



        List<Integer> intList = new ArrayList<>();
        List<Object> objList = new ArrayList<>();

        // This line will produce a compile error
        // Required type:List<Object> Provided:List<Integer>
//        anotherClass.printListObj(intList);
        // But this compiles just fine
        anotherClass.printListGeneric(intList);

        // and both of these compile as well
        anotherClass.printListObj(objList);
        anotherClass.printListGeneric(objList);
    }

}

class AnotherClass {

    public <T> void printItems(List<T> list) {
        for (T item : list) {
            System.out.println("Item: " + item);
        }
    }

    // Unlike the above method, this method can only be used to print numbers.
    // You can use T as the return type as well
    public <T extends Number> T printNumbers(List<T> list) {
        for (T number : list) {
            System.out.println("Next Number: " + number);
        }
        return list.get(0);
    }

    // But note that we cannot do this
    // This is a compile error: Unexpected Token
//    public <T super Number> T printNumbersAnother(List<T> list) {
//        for (T number : list) {
//            System.out.println("Next Number: " + number);
//        }
//        return list.get(0);
//    }

    // ****************************************************************************************************
    // Using the unbounded generic operator
    // ****************************************************************************************************

    public void printObjects(MyArray obj) {
        obj.display();
    }

    // The below method is equivalent to the above method
    // Here we are using the unbounded operator ?,
    // which essentially is equivalent to writing MyArray<Object>
    // which is same as writing MyArray
    public void printObjectsGeneric(MyArray<?> obj) {
        obj.display();
    }

    public void printListObj(List<Object> list) {
        for (Object obj : list) {
            System.out.println("Next Item:" + obj);
        }
    }

    public void printListGeneric(List<?> list) {
        for (Object obj : list) {
            System.out.println("Next Item:" + obj);
        }
    }


}

//class MathOperationV1 {
//
//    public <T extends Number> T add(T a, T b) {
//        return a + b; // error: Operator '+' cannot be applied to 'T', 'T'
//    }
//
//    public <T extends Integer> T add(T a, T b) {
//        return a + b; // error: Operator '+' cannot be applied to 'T', 'T'
//    }
//}























