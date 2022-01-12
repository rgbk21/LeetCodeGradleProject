package Interfaces.MultipleInterfaces;

import javax.annotation.Nullable;

public interface HasValue<T> {
  void setValue(@Nullable T item, boolean fireEvent);
}
