package DIBook.Chapter1._1_ConstructionByHand;

public class SpellChecker {
  public boolean checkSpelling(String text) {
    System.out.println("Inside SpellChecker.checkSpelling");
    return true;
  }
}

class MockSpellChecker extends SpellChecker {

  private boolean spellingWasChecked = false;

  public boolean checkSpelling(String text) {
    boolean result = true;
    spellingWasChecked = true;
    return result;
  }

  // Method that will be called from the test suite to verify that the spelling
  // was in-fact checked
  public boolean wasSpellingChecked() {
    return spellingWasChecked;
  }
}

class EnglishSpellChecker {
  public boolean checkSpelling() {
    return true;
  }
}