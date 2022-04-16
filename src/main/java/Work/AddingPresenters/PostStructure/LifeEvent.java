package Work.AddingPresenters.PostStructure;

import static com.google.common.base.Preconditions.checkNotNull;

public class LifeEvent {

  private final PersonPresenter personPresenter;

  LifeEvent(PersonPresenter personPresenter) {
    this.personPresenter = checkNotNull(personPresenter);
  }

  void changeAddressBecauseRelocation(String newAddress) {
    if (!personPresenter.getAddress().equals(newAddress)) {
      personPresenter.setAddress(newAddress);
    }
  }

  void changeAgeBecauseHappyBday(int newAge) {
    if (personPresenter.getAge() != newAge) {
      personPresenter.setAge(newAge);
    }
  }
}
