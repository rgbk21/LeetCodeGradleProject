package Test1;

public class TestAbstractClass {


}


abstract class Product {

    int multiplyBy;

    public Product(int multiplyBy) {
        this.multiplyBy = multiplyBy;
    }

    public int multiply(int val) {
        return multiplyBy * val;
    }
}

class TimesTwo extends Product {
    public TimesTwo() {
        super(2);
    }
}

class TimesWhat extends Product {
    public TimesWhat(int what) {
        super(what);
    }
}