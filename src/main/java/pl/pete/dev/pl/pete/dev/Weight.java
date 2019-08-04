package pl.pete.dev.pl.pete.dev;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class Weight {

    private static final BigDecimal POUND_TO_KILOGRAM_RATIO = new BigDecimal("0.453592");

    private WeightUnit unit;
    private BigDecimal value;


    public Weight(WeightUnit unit, BigDecimal value) {
        this.unit = unit;
        this.value = value;
    }

    public WeightUnit getUnit() {
        return unit;
    }

    public BigDecimal getValue() {
        return value;
    }

    BigDecimal convert(WeightUnit convertTo){
        if (convertTo == unit){
            throw new IllegalArgumentException("You really want to compare to the same unit? ;)");
        }
        else if (convertTo == WeightUnit.KILOGRAM){
            return value.multiply(POUND_TO_KILOGRAM_RATIO).setScale(6, RoundingMode.HALF_EVEN);
        } else{
            return value.divide(POUND_TO_KILOGRAM_RATIO, 6, RoundingMode.HALF_EVEN);
        }
    }

}
