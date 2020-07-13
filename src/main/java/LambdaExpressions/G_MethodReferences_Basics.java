package LambdaExpressions;

import java.util.function.ToIntFunction;

public class G_MethodReferences_Basics {

    public static void main(String[] args) {

        ToIntFunction<String> strLength = str -> str.length();
        System.out.println("Length of string \"Whodunnit\": " + strLength.applyAsInt("Whodunnit"));

        //This method can be re-written as:
        ToIntFunction<String> strLength2 = String::length;
        System.out.println("Length of string \"Whodunnit\": " + strLength2.applyAsInt("Whodunnit"));

    }

}
