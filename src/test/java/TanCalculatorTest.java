import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Tan tests")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TanCalculatorTest {

    private static final double DELTA = 0.05;
    private static final double INFINITY = 1. / 0;
    private static final double PI = 3.141592653589793D;

    private TanCalculator calculator;

    @BeforeEach
    void init() {
        calculator = new TanCalculator();
    }

    @ParameterizedTest(name = "Calculate tan({1} PI / {2})")
    @CsvFileSource(resources = "/data.csv")
    void dataTest(Double expectedResult, Integer numerator, Integer denominator) {
        assertEquals(expectedResult, calculator.calculateTan(numerator * PI / denominator), DELTA);
        assertNotEquals(expectedResult, calculator.calculateTan(numerator * PI / denominator + DELTA), DELTA);
        assertNotEquals(expectedResult, calculator.calculateTan(numerator * PI / denominator - DELTA), DELTA);
    }

    @ParameterizedTest(name = "Infinity test tan({0} PI / {1})")
    @CsvSource(value = {"1, 2", "-1, 2", "3, 2", "-3, 2"})
    void infinityTest(Integer numerator, Integer denominator) {
        assertEquals(INFINITY, calculator.calculateTan(numerator * PI / denominator), DELTA);
        assertNotEquals(INFINITY, calculator.calculateTan(numerator * PI / denominator + DELTA), DELTA);
        assertNotEquals(INFINITY, calculator.calculateTan(numerator * PI / denominator - DELTA), DELTA);
    }

    @Test
    void extraValuesTest() {
        assertEquals(Double.NaN, calculator.calculateTan(Double.POSITIVE_INFINITY));
        assertEquals(Double.NaN, calculator.calculateTan(Double.NEGATIVE_INFINITY));
        assertEquals(Double.NaN, calculator.calculateTan(Double.NaN));
    }
}
