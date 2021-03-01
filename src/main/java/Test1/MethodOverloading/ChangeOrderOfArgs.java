package Test1.MethodOverloading;

import java.util.StringJoiner;

public class ChangeOrderOfArgs {

    public static void main(String[] args) {

        // You can create overloaded constructors by just changing the order of the parameters in the Constructor declaration
        TestArgsChange alice = new TestArgsChange("Alice", 21);
        TestArgsChange bob = new TestArgsChange(21, "Bob");

        // Similarly, you can create overloaded methods by just changing the order of the parameters in the method declaration
        alice.setPersonDetails("Alice Doe", 22);
        bob.setPersonDetails(22, "Bob Doe");

        System.out.println(alice.toString()); // Prints: TestArgsChange[name='Alice Doe', age=22]
        System.out.println(bob.toString()); // Prints: TestArgsChange[name='Bob Doe', age=22]
    }
}

class TestArgsChange {

    private String name;
    private int age;

    public TestArgsChange(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public TestArgsChange(int age, String name) {
        this.name = name;
        this.age = age;
    }

    public void setPersonDetails(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void setPersonDetails(int age, String name){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", TestArgsChange.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("age=" + age)
                .toString();
    }
}