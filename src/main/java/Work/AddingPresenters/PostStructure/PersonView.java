package Work.AddingPresenters.PostStructure;

import static com.google.common.base.Preconditions.checkNotNull;

public class PersonView implements PersonPresenter.Display {
  private final String name;
  private final String placeOfBirth;
  private final PersonPresenter presenter;

  private int age;
  private String address;

  PersonView(String name, String placeOfBirth, PersonPresenter presenter) {
    this.name = checkNotNull(name);
    this.placeOfBirth = checkNotNull(placeOfBirth);
    this.presenter = checkNotNull(presenter);
    age = 0;

    presenter.bindView(this);
  }

  @Override
  public PersonPresenter getPresenter() {
    return presenter;
  }

  @Override
  public String getAddress() {
    return address;
  }

  @Override
  public void setAddress(String address) {
    this.address = address;
  }

  @Override
  public int getAge() {
    return this.age;
  }

  @Override
  public void setAge(int age) {
    boolean validAge = validateAge(age);
    if (validAge) {
      this.age = age;
    }
  }

  String getName() {
    return name;
  }

  String getPlaceOfBirth() {
    return placeOfBirth;
  }

  private boolean validateAge(int age) {
    // Verify that the provided age is within the human bounds of an age.
    return true;
  }
}