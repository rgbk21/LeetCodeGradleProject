package Work.AddingPresenters.PostStructure;

import static com.google.common.base.Preconditions.checkNotNull;

public class PersonPresenter implements Presenter<PersonPresenter.Display> {

  /**
   * Associates the provided {@link PersonPresenter.Display} with this presenter
   */
  public interface Display extends View<PersonPresenter> {
    void setAddress(String address);
    String getAddress();
    int getAge();
    void setAge(int age);
  }

  private Display view;

  @Override
  public void bindView(PersonPresenter.Display view) {
    this.view = checkNotNull(view);
  }

  void setAddress(String address) {
    boolean validAddress = validateAddress(address);
    if (validAddress) {
      view.setAddress(address);
    }
  }

  private boolean validateAddress(String address) {
    // Do stuff in order to verify that the provided address points to a USPS verified address
    return true;
  }

  String getAddress() {
    return view.getAddress();
  }

  int getAge() {
    return view.getAge();
  }

  void setAge(int age) {
    view.setAge(age);
  }
}
