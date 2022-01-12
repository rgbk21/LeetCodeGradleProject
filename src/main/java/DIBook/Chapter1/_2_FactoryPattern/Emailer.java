package DIBook.Chapter1._2_FactoryPattern;

public class Emailer {
  private final SpellChecker spellChecker;
  private Dict dictionary;
  private AddressBook addressBook;

  // We still follow the constructor injection for the Emailer class
  public Emailer(SpellChecker spellChecker) {
    this.spellChecker = spellChecker;
  }

  public void setDictionary(Dict dictionary) {
    this.dictionary = dictionary;
  }

  public void setAddressBook(AddressBook addressBook) {
    this.addressBook = addressBook;
  }

  public boolean send() {
    spellChecker.validateText("Email Text");
    return true;
  }
}

class EmailerFactory {
  public static Emailer createFrenchEmailer() {
    Emailer emailer = new Emailer(new FrenchSpellChecker());
    emailer.setAddressBook(new AddressBook());
    emailer.setDictionary(new Dict());
    return emailer;
  }
  public static Emailer createEnglishEmailer() {
    Emailer emailer = new Emailer(new EnglishSpellChecker());
    emailer.setAddressBook(new AddressBook());
    emailer.setDictionary(new Dict());
    return emailer;
  }
}

// There are no changes to the client code.
// The client code is still simple.
class Client {
  public static void main(String[] args) {
    Emailer emailer = EmailerFactory.createFrenchEmailer();
    emailer.send();
  }
}


