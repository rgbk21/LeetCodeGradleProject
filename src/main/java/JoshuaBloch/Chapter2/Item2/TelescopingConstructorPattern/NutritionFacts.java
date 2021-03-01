package JoshuaBloch.Chapter2.Item2.TelescopingConstructorPattern;

import java.util.StringJoiner;

public class NutritionFacts {

    private final int servingSize; // Required
    private final int servings; // Required
    private final int calories; // Optional
    private final int fat; // Optional
    private final int sodium; // Optional
    private final int carbohydrate; // Optional

    // These two are the required parameters. Rest are optional.
    public NutritionFacts(int servingSize, int servings) {
        this(servingSize, servings, 0);
    }

    public NutritionFacts(int servingSize, int servings, int calories) {
        this(servingSize, servings, calories, 0);
    }

    public NutritionFacts(int servingSize, int servings, int calories, int fat) {
        this(servingSize, servings, calories, fat, 0);
    }

    public NutritionFacts(int servingSize, int servings, int calories, int fat, int sodium) {
        this(servingSize, servings, calories, fat, sodium, 0);
    }

    public NutritionFacts(int servingSize, int servings, int calories, int fat, int sodium, int carbohydrate) {
        this.servingSize = servingSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
        this.sodium = sodium;
        this.carbohydrate = carbohydrate;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", NutritionFacts.class.getSimpleName() + "[", "]")
                .add("servingSize=" + servingSize)
                .add("servings=" + servings)
                .add("calories=" + calories)
                .add("fat=" + fat)
                .add("sodium=" + sodium)
                .add("carbohydrate=" + carbohydrate)
                .toString();
    }
}

class TestClass {

    public static void main(String[] args) {
        // Now you can call the constructor with only the parameters that you want
        NutritionFacts facts = new NutritionFacts(10, 4, 5, 5);
        System.out.println(facts);
    }
}