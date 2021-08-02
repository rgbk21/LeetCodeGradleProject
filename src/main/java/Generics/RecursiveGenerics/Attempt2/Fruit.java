package Generics.RecursiveGenerics.Attempt2;

public class Fruit implements Comparable<Fruit>{

    private final Integer size;

    public Fruit(Integer size) {
        this.size = size;
    }

    public Integer getSize() {
        return this.size;
    }

    // Now the code for the compareTo method is present in the parent class and
    // does not need to be duplicated in all of the child classes that are going to
    // extend this class. This way, atleast duplication is avoided.
    // But now this creates another problem, as shown in the TestClass
    @Override
    public int compareTo(Fruit other) {
        return this.size.compareTo(other.size);
    }
}
