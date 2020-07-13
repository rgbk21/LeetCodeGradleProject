package LambdaExpressions;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class GH_ConstructorMethodREferences {

    public static void main(String[] args) {

        //Consider the following two statements that use a String object creation expression as the body for lambda expressions
        Supplier<String> strSupplier = () -> new String();
        Function<String, String> strSupplier2 = str -> new String(str);

        //You can rewrite these statements by replacing the lambda expressions with constructor references as shown:
        Supplier<String> strSupplier3 = String::new;
        Function<String, String> strSupplier4 = String::new;

        //Example that shows constructors being chosen by the compiler based on the target type that is used
        //Using Lambda
        Supplier<Item> myFunc1 = () -> new Item();
        Function<String, Item> myFunc2 = name -> new Item(name);
        BiFunction<String, Double, Item> myFunc3 = (name, price) -> new Item(name, price);

        System.out.println("Printing items using the lambda expressions");
        System.out.println(myFunc1.get());
        System.out.println(myFunc2.apply("Apple"));
        System.out.println(myFunc3.apply("Apple", 0.75));

        //Using Method References

        //When the statement Supplier<Item> func1 = Item::new; is executed, the compiler finds that the target type
        //Supplier<String> does not accept any argument. Therefore, it uses the no-args constructor of the Item class
        Supplier<Item> myFunc4 = Item::new;

        //When the statement Function<String,Item> func2 = Item::new; is executed, the compiler finds that the
        //target type Function<String,Item> takes a String argument. Therefore, it uses the constructor of the Item class that
        //takes a String argument
        Function<String, Item> myFunc5 = Item::new;

        //When the statement BiFunction<String,Double,Item> func3 = Item::new; is executed, the compiler finds
        //that the target type BiFunction<String,Double,Item> takes two arguments: a String and a Double. Therefore, it uses
        //the constructor of the Item class that takes a String and a double argument.
        BiFunction<String, Double, Item> myFunc6 = Item::new;

        //The following statement generates a compile-time error, as the compiler does not find a constructor in the Item
        //class that accepts a Double argument:
        //Function<Double, Item> badFunc = Item::new;//Cannot resolve constructor 'Item'

        System.out.println("\nPrinting items using the Constructor References");
        System.out.println(myFunc4.get());
        System.out.println(myFunc5.apply("Apple"));
        System.out.println(myFunc6.apply("Apple", 0.75));

    }

}

class Item{

    private String name;
    private double price;

    public Item() {
    }

    public Item(String name) {
        this.name = name;
    }

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("name", name)
                .add("price", price)
                .toString();
    }
}
