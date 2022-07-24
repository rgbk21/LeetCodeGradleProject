package Test1.RandomStuff.OracleTutorial;


@FunctionalInterface
interface ManipulateNumber {
  int manipulate(int input);
}

class AnonymousClassTest {
  int count = 42;

  public ManipulateNumber myMethod() {
    final int count = 21;
    int countButWithADifferentName = count;

    ManipulateNumber addCount = new ManipulateNumber() {

      // We can define a new count variable here. And there is no compile error.
      // This won't be possible in the case of lambda expressions.
      int count = 11;

      @Override
      public int manipulate(int input) {
        // Anonymous classes define a context of their own. Hence, 'this' here
        // refers to this instance of anonymous class that has been created.
        // Note that when we will look at the lambda expression example, this won't compile,
        // because lambda expressions do NOT define their own context, instead they just
        // use the context of their enclosing class. But more on that later.
        System.out.println("count: " + this.count); // Prints: count: 11

        // You cannot access a local variable defined in a method of the outer class from an inner class
        // if the inner class defines already a variable with the same name.
        System.out.println("countButWithADifferentName: " + countButWithADifferentName); // Prints: countButWithADifferentName: 21

        // You can access variables in the enclosing class by using the class name like this:
        System.out.println("AnonymousClassTest.this.count: " + AnonymousClassTest.this.count); // Prints: AnonymousClassTest.this.count: 42

        return input + count;
      }
    };

    return addCount;
  }
}

class LambdaTest {
  int count = 42;

  public ManipulateNumber myMethod() {
    final int count = 21;
    int countButWithADifferentName = count;

    ManipulateNumber addCount = (input) -> {
      // Compile error on the below line:
      // Variable 'count' is already defined in the scope
//      int count = 11;
      System.out.println("count: " + this.count); // Prints: 42. Unlike 11 in the case of anonymous functions.
      System.out.println("countButWithADifferentName: " + countButWithADifferentName); // Prints: countButWithADifferentName: 21
      System.out.println("LambdaTest.this.count: " + LambdaTest.this.count); // Prints: LambdaTest.this.count: 42

      // But since Lambda expressions have no context of their own, prefacing the class name is not required
      // Hence, we can simply write this:
      // This is not an option in the case of the Anonymous class. The ONLY way to access the enclosing class is to use the
      // EnclosingClassName.this.variableName syntax
      // https://stackoverflow.com/a/15709337/8742428
      System.out.println("LambdaTest.this.count: " + this.count); // Prints: LambdaTest.this.count: 42

      return input + count;
    };

    return addCount;
  }
}

class TestingScopes {
  public static void main(String[] args) {
    AnonymousClassTest anonymousClassTest = new AnonymousClassTest();
    ManipulateNumber manipulateNumberAnonymous = anonymousClassTest.myMethod();
    System.out.println(manipulateNumberAnonymous.manipulate(10)); // Prints: 21

    System.out.println("------------------------");

    LambdaTest lambdaTest = new LambdaTest();
    ManipulateNumber manipulateNumberLambda = lambdaTest.myMethod();
    System.out.println(manipulateNumberLambda.manipulate(10)); // Prints: 31
  }
}