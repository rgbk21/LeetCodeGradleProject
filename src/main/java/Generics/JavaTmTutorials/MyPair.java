package Generics.JavaTmTutorials;

public class MyPair<K,V> {
  private K key;
  private V value;

  MyPair(K key, V value) {
    this.key = key;
    this.value = value;
  }

  public K getKey() {return this.key;}
  public V getValue() {return this.value;}
  public void setKey(K key) {this.key = key;}
  public void setValue(V value) {this.value = value;}
}

class Utils {
  // Position for type parameters for a static method
  public static <K,V> boolean compare(MyPair<K,V> pair1, MyPair<K,V> pair2) {
    return pair1.getKey().equals(pair2.getKey()) && pair1.getValue().equals(pair2.getValue());
  }

  // Position for type parameters for a non-static method
  public <K,V> boolean compareObj(MyPair<K,V> pair1, MyPair<K,V> pair2) {
    return pair1.getKey().equals(pair2.getKey()) && pair1.getValue().equals(pair2.getValue());
  }
}

class Test {
  public static void main(String[] args) {
    MyPair<Integer, String> p1 = new MyPair<>(1, "apple");
    MyPair<Integer, String> p2 = new MyPair<>(2, "pear");
    // This is how methods using type parameters are used
    // Warning: Explicit type arguments can be inferred
    boolean same = Utils.<Integer, String>compare(p1, p2);
  }
}
