package Test1.PrivateConstructors;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

import java.util.List;

public class SummaryView {

  private final List<FieldsPresenter> fieldsPresenters = Lists.newArrayList();

  private void createFieldsPresenter(List<String> fields) {
    for (String field : fields) {
      // Even though the constructor of the FieldsPresenter class is private, we can still call it here
      fieldsPresenters.add(new FieldsPresenter(field, field));
    }
  }

  private class FieldsPresenter {
    private final String name;
    private final String type;

    private FieldsPresenter(String nameOfField, String typeOfField) {
      this.name = Preconditions.checkNotNull(nameOfField);
      this.type = Preconditions.checkNotNull(typeOfField);
    }

    private void printDetails() {
      System.out.println("Inside FieldsPresenter. name: " + name + ", type: " + type);
    }
  }
}
