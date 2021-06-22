package UdemyCourse.CoreJava.Section16;

public class ParameterizedInheritance {

    public static void main(String[] args) {

        System.out.println("**Calling constructor without any args**");
        Child c1 = new Child();

        System.out.println("\n**Calling constructor with one args**");
        Child c2 = new Child("Alice");

        System.out.println("\n**Calling constructor with two args**");
        Child c3 = new Child("Alice", "Doe");
    }
}

class Parent {

    Parent(){
        System.out.println("Inside non-parameterized constructor of Parent");
    }

    Parent(String args){
        System.out.println("Inside parameterized constructor of Parent with args: " + args);
    }
}

class Child extends Parent {

    Child() {
        System.out.println("Inside non-parameterized constructor of Child");
    }

    Child(String args) {
        // super();
        System.out.println("Inside parameterized constructor of Child with args: " + args);
    }

    Child (String args1, String args2) {
        super(args1);
        System.out.println("Inside parameterized constructor of Child with args: " + args1);
    }

}

