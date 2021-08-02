package Generics.RecursiveGenerics.Attempt3;

// And the way that we extend the Generic Class Fruit is as follows
public class Apple extends Fruit<Apple>{
    public Apple(Integer size) {
        super(size);
    }
}
