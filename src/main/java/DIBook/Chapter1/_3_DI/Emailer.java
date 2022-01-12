package DIBook.Chapter1._3_DI;

public class Emailer {
  private final SpellChecker spellChecker;

  public Emailer(SpellChecker spellChecker) {
    this.spellChecker = spellChecker;
  }

  public void send(String emailText) {
    spellChecker.validateText(emailText);
  }
}

class EmailClient {
  private final Emailer emailer;

  EmailClient(Emailer emailer) {
    this.emailer = emailer;
  }

  public void sendEmail() {
    emailer.send("This is the email text!");
  }
}
