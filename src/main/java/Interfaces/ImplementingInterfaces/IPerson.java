package Interfaces.ImplementingInterfaces;

public interface IPerson {

    // Modifier public, static, final, are redundant
    public static final int MAX_AGE = 120;

    // Modifier 'public' is redundant for interface methods
    public String init(String name);

    String destroy();

    void printName();

}
