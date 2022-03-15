package JoshuaBloch.Chapter3.Item10.Symmetry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Casting {

    public static void main(String[] args) {

        // 1) UPCASTING
        // As per the rules of polymorphism, we already know that a supertype can refer to any subtype.
        // This is an implicit example of Upcasting.
        // There is no need to do explicit cast up the inheritance tree. The compiler knows that cat is an Animal and doesn't display any errors.
        Animal cat = new Cat();
        // But if you want you can make it explicit as well
        Animal anotherCat = (Animal) new Cat(); // Casting 'new Cat()' to 'Animal' is redundant

        // Using upcasting, we've restricted the number of methods available to Cat instance but haven't changed the instance itself.
        // Now we can't do anything that is specific to Cat — we can't invoke meow() on the animal variable.
        // Although Cat object remains Cat object, calling meow() would cause the compiler error:
//        cat.meow(); // Cannot resolve method 'meow' in 'Animal'

        // Upcasting is how we make use of polymorphism
        Cat cat1 = new Cat();
        Dog dog1 = new Dog();
        List<Animal> animals = new ArrayList<>(Arrays.asList(cat1, dog1));

        //AnimalFeeder.feed(animals);
        // The method now polymorphically calls the correct method of the class overriding the 'eat' method
        // Output:
        // Inside Cat class. Called method eat()
        // Inside Dog class. Called method eat()


        // 2) DOWNCASTING
        Animal animal2 = new Cat();
        // Downcasting the Animal to a Cat
        Cat cat2 = (Cat) animal2;
        cat2.meow(); // Now we can access the meow() method

        // We changed the AnimalFeeder method to now account for the downcasting as well
        // Note how we are doing that in that class below
        // Now we call the method feed again
        AnimalFeeder.feed(animals);
        // Output:
        // Inside Cat class. Called method eat()
        // Inside Cat class. Called method meow()
        // Inside Dog class. Called method eat()

        // 3) ClassCastExceptions
        Animal cat3 = new Cat();
        Animal dog3 = new Dog();
        List<Animal> animals3 = new ArrayList<>(Arrays.asList(cat3, dog3));
        BadAnimalFeeder.feed(animals3);

        // Somethings the compiler can preemptively warn you about
        // For example, this is a compile error
        // For the code to compile, BOTH TYPES SHOULD BE IN THE SAME INHERITANCE TREE.
//        String str = (String) cat3; // Inconvertible types; cannot cast 'JoshuaBloch.Chapter3.Item10.Symmetry.Animal' to 'java.lang.String'

        // But this does not produce a compile error. But it does give you this warning:
        // Casting 'cat3' to 'Dog' will produce 'ClassCastException' for any non-null value
        // And sure enough, when we run this, this generates an exception
        Dog someDog = (Dog) cat3;
    }
}

class Animal {
    public void eat() {
        System.out.println("Inside Animal Class. Called method eat()");
    }
}

class Cat extends Animal {

    @Override
    public void eat() {
        System.out.println("Inside Cat class. Called method eat()");
    }

    public void meow() {
        System.out.println("Inside Cat class. Called method meow()");
    }
}

class Dog extends Animal {

    @Override
    public void eat() {
        System.out.println("Inside Dog class. Called method eat()");
    }

    public void bark() {
        System.out.println("InsideDog class. Called method bark()");
    }
}

class AnimalFeeder {
    // AnimalFeeder doesn't care about what kind of animals are in the list
    // So long as they are Animal.
    // It will polymorphically call the corresponding method from the class at runtime.
    public static void feed(List<Animal> animals) {
        for (Animal animal : animals) {
            animal.eat();

            if (animal instanceof Cat) {
                // Downcasting the Animal to a Cat
                // Note: We're trying to downcast only those objects that are really instances of Cat.
                // To do this, we use the operator instanceof.
                ((Cat) animal).meow();
            }
        }
    }
}


class BadAnimalFeeder {
    public static void feed(List<Animal> animals) {
        for (Animal animal : animals) {
            animal.eat();
            // Now we have removed the 'instance of' check that we were doing above
            ((Cat) animal).meow();
        }
    }
}