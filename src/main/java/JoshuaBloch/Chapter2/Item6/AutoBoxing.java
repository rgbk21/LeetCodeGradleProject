package JoshuaBloch.Chapter2.Item6;

public class AutoBoxing {

    public static void main(String[] args) {
        Long sum = 0L; // Intellij warns you that type maybe primitive
        for (long i = 0; i <= Integer.MAX_VALUE; i++)
            sum += i;
    }
}
