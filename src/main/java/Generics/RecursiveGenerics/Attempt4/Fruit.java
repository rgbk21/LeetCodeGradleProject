package Generics.RecursiveGenerics.Attempt4;

public class Fruit <T extends Fruit<T>> implements Comparable<T>{

    private final Integer size;

    public Fruit(Integer size) {
        this.size = size;
    }

    public Integer getSize() {
        return size;
    }

    @Override
    public int compareTo(T otherFruit) {
        return this.size.compareTo(otherFruit.getSize());
    }
}
