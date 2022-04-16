package Work.AddingPresenters.PreStructure;

import static com.google.common.base.Preconditions.checkNotNull;

public class LifeEvent {

  private final PersonView personView;

  LifeEvent(PersonView personView) {
    this.personView = checkNotNull(personView);
  }

  void changeAddressBecauseRelocation(String newAddress) {
    if (!personView.getAddress().equals(newAddress)) {
      personView.setAddress(newAddress);
    }
  }

  void changeAgeBecauseHappyBday(int newAge) {
    if (personView.getAge() != newAge) {
      personView.setAge(newAge);
    }
  }
}
