package Interfaces.TestingInterfaces;

public class SingleDataListBox <T> extends DecoratedListBox implements SingleDataListBoxDisplay<T> {
  // Note that the getItemText does not need to be implemented over here
  // Also the getItemText in the DecorateListBox class does not need an @Override annotation
}

class DecoratedListBox {
  // Adding on override annotation here results in a compile error
  public String getItemText(int index) {
    return "some string";
  }
}

interface SingleDataListBoxDisplay<T> {
  String getItemText(int index);
}