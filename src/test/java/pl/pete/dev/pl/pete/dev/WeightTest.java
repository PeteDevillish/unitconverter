package pl.pete.dev.pl.pete.dev;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class WeightTest {

    Weight testee;

    @Test
    void shouldConvertPoundToKilogram() {
        testee = new Weight(WeightUnit.POUND, BigDecimal.ONE);
        assertEquals(testee.convert(WeightUnit.KILOGRAM), new BigDecimal("0.453592"));
    }

    @Test
    void shouldConvertKilogramToPound() {
        testee = new Weight(WeightUnit.KILOGRAM, BigDecimal.ONE);
        System.out.println(testee.convert(WeightUnit.POUND));
        assertEquals(testee.convert(WeightUnit.POUND), new BigDecimal("2.204624"));
    }

    @Test
    void shouldConvertKilogramToPoundAndPoundToKilogram() {
        testee = new Weight(WeightUnit.KILOGRAM, BigDecimal.ONE);
        System.out.println(testee.convert(WeightUnit.POUND));
        Weight testee2 = new Weight(WeightUnit.POUND, testee.convert(WeightUnit.POUND));
        assertEquals(BigDecimal.ONE.compareTo(testee2.convert(WeightUnit.KILOGRAM)), 0);
    }

    @Test
    void shouldntConvertToSameUnit() {
        testee = new Weight(WeightUnit.KILOGRAM, BigDecimal.ONE);
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> testee.convert(WeightUnit.KILOGRAM)
        );
        assertEquals(exception.getMessage(), "You really want to compare to the same unit? ;)");
    }
}