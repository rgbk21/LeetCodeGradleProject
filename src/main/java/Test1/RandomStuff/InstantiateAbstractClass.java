package Test1.RandomStuff;

public class InstantiateAbstractClass {
}

interface ValueEditorPopupView<T> {
  void setValue(T value);

  void setApplyEnabled();
}

// If the ValueEditorPopupView is declared generic, then the ValueEditorPopup will also
// have to be declared as a generic. Ie. removing <T> from the ValueEditorPopup<T> is a compile error
abstract class ValueEditorPopup<T> implements ValueEditorPopupView<T> {


  // Because ValueEditorPopup is declared abstract, we can get by with implementing
  // just the setApplyEnabled and leave the 'setValue' method unimplemented.
  // Now any concrete class that tries to create an instance of ValueEditorPopup will have to
  // provide the implementation of 'setValue' method.
  @Override
  public void setApplyEnabled() {
    System.out.println("In ValueEditorPopup.setApplyEnabled()");
  }

//  abstract void getValues();
}

class ListEditorTextField {
  private final ValueEditorPopup<String> popup;

  ListEditorTextField() {
    // Here we are trying to create an instance of ValueEditorPopup,
    // and hence we have to override the setValue method (atleast. We can override other methods too.)
    popup = new ValueEditorPopup<String>() {
      @Override
      public void setValue(String value) {
        System.out.println("In Anonymous Class impl setValue()");
      }

      // But now when we add a method that is NOT defined in the abstract class,
      // we get an error for using the diamond operator in the class declaration above
      // when we did 'new ValueEditorPopup<>()'
      public void getValues() {

      }
    };
  }

  public void someMethod() {
    // Even though the `getValues` method has been declared on the anonymous class above,
    // you still get a compile error on the below line:
    // Cannot resolve method 'getValues' in 'ValueEditorPopup'
    // This is because the `getValues` method is not defined on the `ValueEditorPopup` class,
    // nor on the `ValueEditorPopupView` interface.
    // Doing either of those things, ie.
    // a) adding the `getValues` method to the interface
    // b) adding the `getValues` method to the abstract class
    // will fix the issue and you will be able to call the `getValues` method on the popup
    // But NOTE: doing this means that ALL the classes that are going to instantiate
    // `ValueEditorPopup` will now also have to implement this method
//    popup.getValues();
  }
}

class IntegerValueEditor extends ValueEditorPopup<Integer> {

  @Override
  public void setValue(Integer value) {

  }
}