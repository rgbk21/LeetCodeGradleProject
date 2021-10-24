package Test1;

import java.util.Map;

public class Trial11 {

    private String name;
    private String age;
    private Person1 person = new Person1(this.name, this.age);

    Trial11(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public Person1 getPerson() {
        return person;
    }
}

class Person1 {
    String name;
    String age;
    Person1(String name, String age) {
        this.name = name;
        this.age = age;
    }
}

class Test {

    public static void main(String[] args) {
        Trial11 trial = new Trial11("Alice", "21");
        System.out.println("trial.getPerson().name: " + trial.getPerson().name);
    }

}