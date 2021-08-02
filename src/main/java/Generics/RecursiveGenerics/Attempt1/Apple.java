package Generics.RecursiveGenerics.Attempt1;

// Note that we are doing Comparable<Apple> and not Comparable<Fruit>
public class Apple implements Fruit, Comparable<Apple>{

    private final Integer size;

    public Apple(int size) {
        this.size = size;
    }

    @Override
    public Integer getSize() {
        return this.size;
    }

    @Override
    public int compareTo(Apple otherApple) {
        // compareTo Compares two Integer objects numerically.
        return this.size.compareTo(otherApple.size);
    }
}
