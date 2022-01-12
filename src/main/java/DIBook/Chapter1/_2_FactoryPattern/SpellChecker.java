package DIBook.Chapter1._2_FactoryPattern;

public class SpellChecker {
  public boolean validateText(String emailText) {
    return true;
  }
}

class FrenchSpellChecker extends SpellChecker {
  @Override
  public boolean validateText(String emailText) {
    return true;
  }
}

class EnglishSpellChecker extends SpellChecker {
  @Override
  public boolean validateText(String emailText) {
    return true;
  }
}