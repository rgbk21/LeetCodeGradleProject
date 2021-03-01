package Test1.MethodOverloading;

public class MyUtil {

    public static void main(String[] args) {

        // The method "eat" in Dog does not override the method "eat" in Animal.
        // This is because the arguments are different (one requires Flesh, the other requires Food).
        // Instead, the eat() method overloads.
        Animal animal = new Dog();
        Food flesh = new Flesh();
        Food food = new Food();
        animal.eat(flesh); // Prints: Animal eats Flesh Food
        animal.eat(food); // Prints: Animal eats Normal Food (So overriding working as expected in Food and Flesh classes)

        // Choosing between overloads takes place at compile time, not runtime.
        // It is not based on the actual class of the object on which the method is invoked,
        // but the compile-time type (how the variable is declared).

        // Hence the above code snippet prints: 'Animal eats Flesh Food'
        // because at compile time, the type of the animal variable is Animal
        // And hence the eat() method on the Animal class is called

        // Compare this with the below example in which case the code snippet prints: 'Dog eats Flesh Food'
        // The compile-time type of dog is Dog. And hence the eat() method on Dog is called
        Dog dog = new Dog();
        Food flesh1 = new Flesh();
        dog.eat(flesh1); // Prints: Dog eats Flesh Food

        // In the first code-snippet animal has compile-time type Animal.
        // We know this because the declaration of the variable animal was Animal animal = ....
        // The fact that it is actually a Dog is irrelevant - it is the version of eat in Animal that must be invoked.

        // On the other hand, the toString method in Flesh does override the toString method in Food.

        // When one method overrides another it is the actual class of the object that the method is invoked on that determines which version runs.

        // In the eat method of Animal, even though the argument has compile-time type Food, if you pass an instance of Flesh to it,
        // it is the toString method in Flesh that will execute.
        // Therefore you get the message "Animal eats Flesh Food"


        // The proper way, to get the expected overridden result, would be to define a class (in this case Cat)
        // that uses the eat() method, but with the parameter as type 'Food'
        // since that is the parameter type of the eat() method in the super class 'Animal'
        // that the 'Cat' class is trying to extend
        Animal cat = new Cat();
        Food flesh2 = new Flesh();
        cat.eat(flesh2); // Prints: Cat eats Flesh Food
        // and now dynamic method dispatch works as expected
        cat.eat(new Food()); // Prints: Cat eats Normal Food

    }
}

class Food {
    public String toString(){
        return "Normal Food";
    }
}

class Flesh extends Food {
    public String toString(){
        return "Flesh Food";
    }
}

class Animal {
    public void eat(Food food){
        System.out.println("Animal eats "+ food);
    }
}

class Dog extends Animal{
    public void eat(Flesh flesh){
        System.out.println("Dog eats "+ flesh);
    }
}

class Cat extends Animal {
    public void eat(Food food){
        System.out.println("Cat eats "+ food);
    }
}
