package Work.AddingPresenters.PreStructure;

import static com.google.common.base.Preconditions.checkNotNull;

public class PersonView {
  private final String name;
  private final String placeOfBirth;

  private int age;
  private String address;

  PersonView(String name, String placeOfBirth) {
    this.name = checkNotNull(name);
    this.placeOfBirth = checkNotNull(placeOfBirth);
    age = 0;
  }

  String getAddress() {
    return address;
  }

  void setAddress(String address) {
    boolean validAddress = validateAddress(address);
    if (validAddress) {
      this.address = address;
    }
  }

  int getAge() {
    return this.age;
  }

  void setAge(int age) {
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

  private boolean validateAddress(String address) {
    // Do stuff in order to verify that the provided address points to a USPS verified address
    return true;
  }
}
