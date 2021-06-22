package UdemyCourse.CoreJava.Section20;

enum Person {

    // We have added a constructor. Hence we need to create the enums with data now.
    // Each enum constant is declared with parameters to be passed to the constructor when it is created.
    ALICE("Alice", 21), BOB("Bob", 22), CHARLIE("Charlie", 23), DAVE("Dave", 24);

    String name;
    int age;

    private Person(String name, int age){
        this.name = name;
        this.age = age;
        System.out.println("Constructor Called: " + this.name);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // We can add methods to the enum as well.
    public void printPersonDetails(){
        System.out.println("Name of person is: " + this.name + " and age is: " + this.age);
    }

    // This idea of adding behavior to enum constants can be taken one step further.
    // You can add different behavior to the enum dependent upon which enum it actually is
    public void printPersonHobbies(){
        switch (this){
            case ALICE: System.out.println("Alice hobby is swimming"); break;
            case BOB: System.out.println("Bob hobby is drinking wine"); break;
            case CHARLIE: System.out.println("Charlie hobby is reading books"); break;
            case DAVE: System.out.println("Dave hobby is hiking"); break;
        }
    }
}

public class MyEnum {

    public static void main(String[] args) {
        // Person p = new Person(); // Enum types cannot be instantiated
        Person p = Person.ALICE;

        // enum can only be assigned values that are already defined in the enum class.
        // Person q = Person.EVE; // Cannot resolve symbol 'EVE'

        // ordinal method is used to print the index of the enum
        int a = Person.ALICE.ordinal();
        int d = Person.DAVE.ordinal();
        System.out.println("Alice: " + a); // Prints: 0
        System.out.println("Dave: " + d); // Prints: 3

        System.out.println("Printing all the enums from the People Enum");
        Person[] people = Person.values();
        for (Person person : people) {
            person.printPersonDetails();
            person.printPersonHobbies();
        }
    }
}

class MyEnum2 {

    public static void main(String[] args) {
        // Constructor for all of the Enum values are called the first time that the enum is created
        Person p = Person.ALICE;
    }
}
/*
Prints:
Constructor Called: Alice
Constructor Called: Bob
Constructor Called: Charlie
Constructor Called: Dave
 */

