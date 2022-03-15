package Test1.RandomStuff;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TwoDStringToListConversion {

  public static void main(String[] args) {
    String[][] strArray = new String[][] {{"name", "age"}, {"Alice", "21"}, {"Bob", "22"}, {"Charlie", "23"}};
    System.out.println(Arrays.deepToString(strArray));

    List<List<String>> list = Arrays.stream(strArray).map(Arrays::asList).collect(Collectors.toList());
    System.out.println(list);
  }

}
