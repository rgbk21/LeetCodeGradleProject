package Generics.RecursiveGenerics.Attempt1;

public class Orange implements Fruit, Comparable<Orange>{

    private final Integer size;

    public Orange(Integer size) {
        this.size = size;
    }

    @Override
    public Integer getSize() {
        return this.size;
    }

    @Override
    public int compareTo(Orange otherOrange) {
        return this.size.compareTo(otherOrange.size);
    }
}
