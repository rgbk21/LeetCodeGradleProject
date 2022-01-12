package Interfaces.MultipleInterfaces;

import javax.annotation.Nullable;

public interface SingleDataListBoxDisplay<T> {
  void setValue(@Nullable T item, boolean fireEvent);
}
