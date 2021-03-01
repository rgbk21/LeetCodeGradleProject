package Interfaces.ImplementingInterfaces;

import Interfaces.ImplementingInterfaces.IPerson;

public class Teacher implements IPerson {

    private String name;

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
        System.out.println("The teacher's name is: " + this.name);
    }

}
