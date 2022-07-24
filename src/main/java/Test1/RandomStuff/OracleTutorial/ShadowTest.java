package Test1.RandomStuff.OracleTutorial;

public class ShadowTest {
  public int x = 0;

  class FirstLevel {
    public int x = 1;

    void methodInFirstLevel(int x) {
      System.out.println("x = " + x); // Prints: x = 21
      System.out.println("this.x = " + this.x); // Prints: this.x = 1
      System.out.println("ShadowTest.this.x = " + ShadowTest.this.x); // Prints: ShadowTest.this.x = 0
    }
  }
}

class ShadowTestTest {
  public static void main(String[] args) {
    ShadowTest shadowTest = new ShadowTest();
    ShadowTest.FirstLevel firstLevel = shadowTest. new FirstLevel();
    firstLevel.methodInFirstLevel(21);
  }
}