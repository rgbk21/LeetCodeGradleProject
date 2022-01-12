package Generics.JavaTmTutorials;

public class GenericMethod {
  // Why does the following code not work?
  /*
  - The greater than operator (>) applies only to primitive types such as short, int, double, long, float, byte, and char.
  - You cannot use the > operator to compare objects.
   */
  public static <T> int countGreaterThan(T[] array, T element) {
    int count = 0;
    for (T currItem : array) {
//      if (currItem > element) { // Operator '>' cannot be applied to 'T', 'T'
        count++;
//      }
    }
    return count;
  }

  /*
  public interface Comparable<T> {
    public int compareTo(T o);
  }
  */

  // To fix the problem, use a type parameter bounded by the Comparable<T> interface:
  public static <T extends Comparable<T>> int genericCountGreaterThan(T[] array, T element) {
    int count = 0;
    for (T currItem : array) {
      if (currItem.compareTo(element) > 0) {
        count++;
      }
    }
    return count;
  }
}
