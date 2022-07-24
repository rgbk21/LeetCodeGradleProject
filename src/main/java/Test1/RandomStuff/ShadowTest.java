package Test1.RandomStuff;

class ShadowTest {

    public int x = 0;

    public static void main(String... args) {
        ShadowTest st = new ShadowTest();
        FirstLevel fl = new FirstLevel();
        fl.methodInFirstLevel(23);
        SecondLevel sl = new SecondLevel();
        sl.methodINSecondLevel(23);

    }
}

class FirstLevel {

    public int x = 1;

    void methodInFirstLevel(int x) {
        System.out.println("x = " + x);
        System.out.println("this.x = " + this.x);
    }
}

class SecondLevel {
    public int x = 2;

    void methodINSecondLevel(int x) {
        System.out.println("x = " + x);
        System.out.println("this.x = " + this.x);
    }
}