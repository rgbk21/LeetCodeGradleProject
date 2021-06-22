package UdemyCourse.CoreJava.Section16;

public class VarArgs {

    public static void main(String[] args) {
        VarArgs test = new VarArgs();
        test.printItems();
        test.printItems("One", "Two", "Three");
        test.printItems(new String[]{"Four", "Five", "Six"}); // Redundant array creation for calling varargs method
    }

    private void printItems(String ...items) {
        for (int i = 0; i < items.length; i++) {
            System.out.println(items[i]);
        }
    }
}
