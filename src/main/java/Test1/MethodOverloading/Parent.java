package Test1.MethodOverloading;

public class Parent {
  Number age;
  Object relation;

  public Number getAge() {return 42;}
  public void setAge(Number age) {this.age = age;}
  public void setRelation(Number relation) {this.relation = relation;}
}

class Child extends Parent {

  // 1) getAge returns a subtype of the overridden method and is valid
  @Override
  public Integer getAge() {return 42;}

  // Compile Error: Method does not override method from its superclass
  // Args type CANNOT be subtype of the overridden method
//  @Override
  public void setAge(Integer age) {this.age = age;}

  // Compile Error: Method does not override method from its superclass
  // Args type CANNOT be supertype of the overridden method
//  @Override
  public void setRelation(Object relation) {this.relation = relation;}

  // But as we discussed, both of these will work. Because the args match exactly.
  @Override
  public void setAge(Number age) {this.age = age;}

  @Override
  public void setRelation(Number relation) {this.relation = relation;}
}

class TestParent {
  public static void main(String[] args) {
    // But do note that when it comes to calling the methods, that can be done with args that are of the specific types
    // as well as any of the subtypes.
    // Our setAge() method takes an args of type Number, but we can call the method by passing in an Integer value as well.
    Child child = new Child();
    Number number = 42;
    Integer integer = 42;
    child.setAge(number);
    child.setAge(integer);
  }
}