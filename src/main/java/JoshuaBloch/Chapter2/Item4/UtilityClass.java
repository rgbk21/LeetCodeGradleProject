package JoshuaBloch.Chapter2.Item4;

public class UtilityClass {

    // Suppresses default constructor, ensuring non-instantiability
    private UtilityClass(){}

    public static String extractFirstName(String fullName) {
        return fullName.split(" ")[0];
    }

    public static String extractLastName(String fullName) {
        return fullName.split(" ")[1];
    }
}

// Compile error: There is no default constructor available in 'JoshuaBloch.Chapter2.Item4.UtilityClass'
//class AnotherUtilClass extends UtilityClass {
//
//}
