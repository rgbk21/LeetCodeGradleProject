package Interfaces.ImplementingInterfaces;

public class Student implements IPerson {

    private String name;

    // The methods that implement an interface must be declared public.
    @Override
    public String init(String name) {
        this.name = name;
        return name;
    }

    @Override
    public String destroy() {
        name = null;
        return name;
    }

    @Override
    public void printName() {
        System.out.println("The student's name is: " + this.name);
    }

    // You can also define methods of your own in order to add functionality
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
