package UdemyCourse.CoreJava.Section6;

public class L42 {

    public static void main(String[] args) {

        // New strings that are created using String literal are stored in the String Pool.
        // The String Pool is present in the heap, but it is different from storing a string directly in the heap.
        // When we create a String variable and assign a value to it, the JVM searches the pool for a String of equal value.
        // If found, the Java compiler will simply return a reference to its memory address, without allocating additional memory.
        // If not found, it'll be added to the pool (interned) and its reference will be returned.
        String s1 = "Alice";
        String s2 = "Alice";
        System.out.println("s1 == s2 is: " + (s1 == s2)); // Prints: true

        // New strings that are created using String literal are stored in the Heap
        // When we create a String via the new operator, the Java compiler will create a new object and store it in the heap space reserved for the JVM.
        // Every String created like this will point to a different memory region with its own address.
        String s3 = new String("Bob");
        String s4 = new String("Bob");
        System.out.println("s3 == s4 is: " + (s3 == s4)); // Prints: false

        String s5 = "Charlie";
        String s6 = new String("Charlie");
        System.out.println("s5 == s6 is: " + (s5 == s6)); // Prints: false

        // Note this example carefully.
        // Recall that s6.intern() may return s6 or some other String object that is equal to it.
        // In the above code, we already declared s5 to be equal to 'Charlie'. Hence when the string s6 is interned, it is s5 that is returned.
        String s7 = s6.intern();
        System.out.println("s7 == s6 is: " + (s7 == s6)); // Prints: false
        // And we can validate this by checking s7 against s5
        System.out.println("s7 == s5 is: " + (s7 == s5)); // Prints: true
    }
}
