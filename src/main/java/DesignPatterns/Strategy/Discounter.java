package DesignPatterns.Strategy;

import java.math.BigDecimal;

public interface Discounter {
    BigDecimal applyDiscount(BigDecimal amount);
}

class EasterDiscounter implements Discounter{
    @Override
    public BigDecimal applyDiscount(BigDecimal amount) {
        return amount.multiply(BigDecimal.valueOf(0.5));
    }
}

class ChristmasDiscounter implements Discounter{
    @Override
    public BigDecimal applyDiscount(BigDecimal amount) {
        return amount.multiply(BigDecimal.valueOf(0.75));
    }
}

class Test {
    public static void main(String[] args) {
        int marketPrice = 1000;

        Discounter easterD = new EasterDiscounter();
        BigDecimal finalPrice1 = easterD.applyDiscount(BigDecimal.valueOf(marketPrice));

        Discounter christmasD = new EasterDiscounter();
        BigDecimal finalPrice2 = christmasD.applyDiscount(BigDecimal.valueOf(marketPrice));

        // Using Lambda Expressions
        Discounter easterDiscount = originalPrice -> originalPrice.multiply(BigDecimal.valueOf(0.5));
        BigDecimal finalValue3 = easterDiscount.applyDiscount(BigDecimal.valueOf(marketPrice));

    }
}