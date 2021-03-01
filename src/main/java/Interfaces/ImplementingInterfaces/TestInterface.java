package Interfaces.ImplementingInterfaces;

public class TestInterface {

    public static void main(String[] args) {

        IPerson person;

        Student student = new Student();
        student.init("Alice");

        Teacher teacher = new Teacher();
        teacher.init("Bob");

        person = student;
        person.printName(); // Prints: The student's name is: Alice

        // An interface reference variable has knowledge only of the methods declared by its interface declaration.
        // So this will not compile
        // person.getName(); // Cannot resolve method 'getName' in 'IPerson'

        person = teacher;
        person.printName(); // Prints: The teacher's name is: Bob

    }
}
