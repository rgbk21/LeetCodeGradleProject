package Test1;

import com.google.common.base.MoreObjects;

public abstract class Car {

    protected boolean isSedan;
    protected String seats;

    public Car(boolean isSedan, String seats) {
        this.isSedan = isSedan;
        this.seats = seats;
    }

    public boolean isSedan() {
        return isSedan;
    }

    public String getSeats() {
        return seats;
    }

    abstract public String getMileage();

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("isSedan", isSedan)
                .add("seats", seats)
                .toString();
    }
}

class WagonR extends Car{

    private int mileage;

    public WagonR(int mileage) {
        super(false, "4");
        this.mileage = mileage;
    }

    @Override
    public String getMileage() {
        return (this.mileage + " kmpl");
    }
}

class InnovaCrysta extends Car{

    private int mileage;

    public InnovaCrysta(int mileage) {
        super(false, "6");
        this.mileage = mileage;
    }

    public String getMileage() {
        return (this.mileage + " kmpl");
    }

}

//Remember that you cannot implement abstract classes
//class TestClass implements Car{//Compile Error - Interface expected here
//
//    @Override
//    public String getMileage() {
//        return null;
//    }
//}
