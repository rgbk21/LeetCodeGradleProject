package UdemyCourse.CoreJava.Section17;

public class MyException {

    public static void main(String[] args) {
        // No compile error in this try-catch block
        try {
            int a = 10;
            int b = 20;
            int c = a / b;
        } catch (ArithmeticException e){
            System.out.println(e.getMessage());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        // This try-catch block produces a compile error though
        try {
            int a = 10;
            int b = 20;
            int c = a / b;
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
//        catch (ArithmeticException e){ // Exception 'java.lang.ArithmeticException' has already been caught
//            System.out.println(e.getMessage());
//        }
    }
}
