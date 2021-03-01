package Test1;

public class ShadowTest2 {

    public int x = 0;

    class FirstLevel2 {

        public int x = 1;

        void methodInFirstLevel(int x) {
            System.out.println("x = " + x);
            System.out.println("this.x = " + this.x);
            System.out.println("ShadowTest.this.x = " + ShadowTest2.this.x);
        }
    }

    public static void main(String... args) {
        ShadowTest2 st = new ShadowTest2();
        ShadowTest2.FirstLevel2 fl = st.new FirstLevel2();
        fl.methodInFirstLevel(23);
    }
}
