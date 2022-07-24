package Test1.RandomStuff;

public class ParentClass1 {
  ParentClass1() {
    System.out.println("ParentClass");
  }
}

class ChildClass extends ParentClass1 {
  ChildClass() {
    System.out.println("ChildClass");
  }
}

class TestParent {
  public static void main(String[] args) {
    ChildClass c = new ChildClass();
  }
}
