package JoshuaBloch.Chapter2.Item2.JavaBeansPattern;

import java.util.StringJoiner;

public class NutritionFacts {

    // variables can no longer be declared final
    private int servingSize; // Required
    private int servings; // Required
    private int calories; // Optional
    private int fat; // Optional
    private int sodium; // Optional
    private int carbohydrate; // Optional

    public NutritionFacts() {
        // Empty
    }

    // Setters
    public void setServingSize(int servingSize) {
        this.servingSize = servingSize;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public void setCarbohydrate(int carbohydrate) {
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

        NutritionFacts facts = new NutritionFacts();
        facts.setServingSize(10);
        facts.setServings(4);
        facts.setCalories(1000);
        facts.setFat(100);
        facts.setSodium(100);
        facts.setCarbohydrate(500);
    }
}
