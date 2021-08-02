package Generics.RecursiveGenerics.Attempt3;

public class Fruit <T> implements Comparable<T> {

    private final Integer size;

    public Fruit(Integer size) {
        this.size = size;
    }

    public Integer getSize() {
        return this.size;
    }

    @Override
    public int compareTo(T other) {
        return 0;
//        return this.size.compareTo(other.getSize()); // Cannot resolve method 'getSize' in 'T'
    }
}
