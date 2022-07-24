package Test1.RandomStuff;

public class BooleanTest {
  void acceptBoolean(boolean value) {
    System.out.println("Value is: " + value);
  }
}

class BooleanTestTest {
  public static void main(String[] args) {
    BooleanTest test = new BooleanTest();
    Boolean b = null;
    // Warning: Unboxing of 'b' may produce 'NullPointerException'
    test.acceptBoolean(b); // NPE on this line.
  }
}


