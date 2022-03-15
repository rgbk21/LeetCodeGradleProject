package Test1.RandomStuff;

public class SomeHumanBeing {
  String getName() {
    return "SomeHumanBeing";
  }
}

class SomeMale extends SomeHumanBeing {
  @Override
  String getName() {
    String name = "SomeMale";
    String superClassName = super.getName();
    return name + superClassName;
  }
}

class TestSomeHumanBeing {
  public static void main(String[] args) {
    SomeMale male = new SomeMale();
    System.out.println(male.getName());
  }
}
