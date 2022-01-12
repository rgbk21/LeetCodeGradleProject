package Test1.abstractclasses;

public abstract class Person {

  private int age;
  private String name;

  Person(int age, String name) {
    this.age = age;
    this.name = name;
  }

}

class Student extends Person {

  private String school;

  public Student(int age, String name, String school) {
    super(age, name);
    this.school = school;
  }
}