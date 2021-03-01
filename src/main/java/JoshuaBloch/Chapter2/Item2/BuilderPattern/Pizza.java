package JoshuaBloch.Chapter2.Item2.BuilderPattern;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public abstract class Pizza {

    public enum Topping {HAM, MUSHROOM, ONION, PEPPER, SAUSAGE};
    final Set<Topping> toppings;

    abstract static class Builder<T extends Builder<T>> {

        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        abstract Pizza build();
        // Subclasses must override this in order to return 'this'
        protected abstract T self();

        public T addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }
    }

    Pizza(Builder<?> builder) {
        toppings = builder.toppings.clone();
    }
}

class NYPizza extends Pizza {

    public enum Size {SMALL, MEDIUM, LARGE};
    private final Size size;

    public static class Builder extends Pizza.Builder<Builder> {

        public final Size size;

        public Builder(Size size) {
            this.size = Objects.requireNonNull(size);
        }

        @Override
        NYPizza build() {
            return new NYPizza(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    private NYPizza(Builder builder) {
        super(builder);
        size = builder.size;
    }
}

class Calzone extends Pizza {

    private final boolean sauceInside;

    public static class Builder extends Pizza.Builder<Builder> {

        private boolean sauceInside = false; // default

        public Builder sauceInside() {
            sauceInside = true;
            return this;
        }

        @Override
        Calzone build() {
            return new Calzone(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    private Calzone(Builder builder) {
        super(builder);
        this.sauceInside = builder.sauceInside;
    }
}




