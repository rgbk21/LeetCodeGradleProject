package DIBook.Chapter1._1_ConstructionByHand;

public class Emailer {
  private SpellChecker spellChecker;

  // Using constructor injection
  public Emailer(SpellChecker spellChecker) {
    this.spellChecker = spellChecker;
  }

  // Using setter injection
  public void setSpellChecker(SpellChecker spellChecker) {
    this.spellChecker = spellChecker;
  }

  public void sendEmail() {
    // check spelling
    String emailText = "";
    spellChecker.checkSpelling(emailText);
    // send email
  }
}

// Constructing a new Emailer class with a SpellChecker
// is as simple as calling the constructor
class Test {
  public static void main(String[] args) {
    SpellChecker spellChecker = new SpellChecker();
    Emailer emailer = new Emailer(spellChecker);
    emailer.sendEmail();
  }
}

