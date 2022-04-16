package Generics.JavaBook.Chapter1;

import java.util.ArrayList;
import java.util.List;

public class GenericsVsRaw {
  public void addStringsGeneric() {
    List<String> words = new ArrayList<>();
    words.add("Hello");
    words.add("World");
    String answer = words.get(0).toUpperCase() + " " + words.get(1).toUpperCase();
    System.out.println(answer); // HELLO WORLD
  }

  public void addStringRaw() {
    List words = new ArrayList();
    words.add("Hello");
    words.add("World");
    String answer = ((String) words.get(0)).toUpperCase() + " " + ((String) words.get(1)).toUpperCase();
    System.out.println(answer); // HELLO WORLD
  }
}

class GenericsViewTest {
  public static void main(String[] args) {
    GenericsVsRaw test = new GenericsVsRaw();
    test.addStringsGeneric();
    test.addStringRaw();
  }
}
