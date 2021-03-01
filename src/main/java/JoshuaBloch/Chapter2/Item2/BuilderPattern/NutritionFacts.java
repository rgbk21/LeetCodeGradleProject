package JoshuaBloch.Chapter2.Item2.BuilderPattern;

import java.util.StringJoiner;

public class NutritionFacts {

    private final int servingSize; // Required
    private final int servings; // Required
    private final int calories; // Optional
    private final int fat; // Optional
    private final int sodium; // Optional
    private final int carbohydrate; // Optional

    public static class Builder {

        // Required parameters
        private final int servingSize; // Required
        private final int servings; // Required

        // Optional parameters initialised to the default values
        private int calories = 0; // Optional
        private int fat = 0; // Optional
        private int sodium = 0; // Optional
        private int carbohydrate = 0; // Optional

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder setCalories(int calories) {
            this.calories = calories;
            return this;
        }

        public Builder setFat(int fat) {
            this.fat = fat;
            return this;
        }

        public Builder setSodium(int sodium) {
            this.sodium = sodium;
            return this;
        }

        public Builder setCarbohydrate(int carbohydrate) {
            this.carbohydrate = carbohydrate;
            return this;
        }

        public NutritionFacts build() {
            return new NutritionFacts(this);
        }
    }

    private NutritionFacts(Builder builder) {
        this.servingSize = builder.servingSize;
        this.servings = builder.servings;
        this.calories = builder.calories;
        this.fat = builder.fat;
        this.sodium = builder.sodium;
        this.carbohydrate = builder.carbohydrate;
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
        NutritionFacts facts = new NutritionFacts
                .Builder(240, 8)
                .setCalories(100)
                .setSodium(110)
                .setFat(120)
                .setCarbohydrate(80)
                .build();

        System.out.println(facts);
        // NutritionFacts[servingSize=240, servings=8, calories=100, fat=120, sodium=110, carbohydrate=80]
    }
}
