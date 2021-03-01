package Test1;

public class Bicycle {

    private int cadence;
    private int gear;
    private int speed;
    private int id;

    private static int numberOfBicycles = 0;

    public Bicycle(int startCadence, int startSpeed, int startGear){
        gear = startGear;
        cadence = startCadence;
        speed = startSpeed;
        id = ++numberOfBicycles;
    }

    // new method to return the ID instance variable
    public int getID() {
        return id;
    }

    public void printBicycleDetails(){

        // 1) Instance methods can access instance variables and instance methods directly.
        System.out.println("Added bicycle with id: " + getID());

        // 2) Instance methods can access class variables and class methods directly.
        System.out.println("Current number of Bicycles: " + Bicycle.numberOfBicycles);
        System.out.println("Current number of Bicycles: " + Bicycle.getNumberOfBicycles());
    }

    public static int getNumberOfBicycles() {
        // 3) Class methods can access class variables and class methods directly
        int num = Bicycle.numberOfBicycles;

        // 4) Class methods cannot access instance variables or instance methods directly—they must use an object reference.
        // Also, class methods cannot use the this keyword as there is no instance for this to refer to.
        // System.out.println("Added bicycle with id: " + getID()); // Compile Error: Non-static method 'getID()' cannot be referenced from a static context
        // System.out.println("Added bicycle with id: " + id); // Compile Error: Non-static field 'id' cannot be referenced from a static context
        // System.out.println("Added bicycle with id: " + this.id); // Compile Error: 'Test1.Bicycle.this' cannot be referenced from a static context

        return num;
    }
}

class TestClassBicycle {

    public static void main(String[] args) {

    }

}