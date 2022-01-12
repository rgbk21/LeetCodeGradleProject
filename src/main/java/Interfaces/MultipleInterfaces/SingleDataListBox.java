package Interfaces.MultipleInterfaces;

import javax.annotation.Nullable;

public class SingleDataListBox<T> implements HasValue<T>, SingleDataListBoxDisplay<T> {
  @Override
  public void setValue(@Nullable T item, boolean fireEvent) {

  }
}
