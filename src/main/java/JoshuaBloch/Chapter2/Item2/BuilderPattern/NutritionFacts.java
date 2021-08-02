package JoshuaBloch.Chapter2.Item2.BuilderPattern;

public class NutritionFacts {

    private final int servingSize; // Required
    private final int servings; // Required
    private final int calories; // Optional
    private final int fat; // Optional
    private final int sodium; // Optional
    private final int carbohydrate; // Optional

    // Notice no setters in the class. Done to achieve immutable object.
    // You can add getters. Assume there are getters.

    // A static class within the NutritionFacts class that we are trying to construct
    public static class Builder {

        // Required parameters
        private final int servingSize; // Required
        private final int servings; // Required

        // Optional parameters initialised to the default values
        private int calories = 0; // Optional
        private int fat = 0; // Optional
        private int sodium = 0; // Optional
        private int carbohydrate = 0; // Optional

        // Constructor of the static class
        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        // The build() method is called to return the final immutable NutritionFacts object
        public NutritionFacts build() {
            return new NutritionFacts(this);
        }

        // Setters that return a Builder object in order to create a fluid API
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
    }

    // The constructor of the class that we want to create is private
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
        final StringBuilder sb = new StringBuilder("NutritionFacts{");
        sb.append("servingSize=").append(servingSize);
        sb.append(", servings=").append(servings);
        sb.append(", calories=").append(calories);
        sb.append(", fat=").append(fat);
        sb.append(", sodium=").append(sodium);
        sb.append(", carbohydrate=").append(carbohydrate);
        sb.append('}');
        return sb.toString();
    }
}

class TestClass {

    public static void main(String[] args) {
        NutritionFacts facts = new NutritionFacts.Builder(240, 8)
                .setCalories(100)
                .setSodium(110)
                .setFat(120)
                .setCarbohydrate(80)
                .build();
        System.out.println(facts);
        // NutritionFacts[servingSize=240, servings=8, calories=100, fat=120, sodium=110, carbohydrate=80]

        // Without using any optional parameters
        // Note how we are calling the constructor of the static Builder class from the NutritionFacts object
        NutritionFacts.Builder builder = new NutritionFacts.Builder(100, 2);
        NutritionFacts facts1 = builder.build();
        System.out.println("facts1: " + facts1);
        // facts1: NutritionFacts{servingSize=100, servings=2, calories=0, fat=0, sodium=0, carbohydrate=0}

        // Of course the above is normally done in one single step
        NutritionFacts facts2 = new NutritionFacts.Builder(100, 2).build();
        System.out.println("facts2: " + facts2);
        // facts2: NutritionFacts{servingSize=100, servings=2, calories=0, fat=0, sodium=0, carbohydrate=0}
    }
}
