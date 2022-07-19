package co.com.sofka.app.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BasicCalculatorTest {
    private final BasicCalculator basicCalculator = new BasicCalculator();

    @Test
    @DisplayName("Testing sum: 1+1=2")
    void sum() {
        // Arrange
        Long number1 = 1L;
        Long number2 = 1L;
        Long expectedValue = 2L;

        // Act
        Long result = basicCalculator.sum(number1, number2);

        // Assert
        assertEquals(expectedValue, result);
    }

    @DisplayName("Testing several sums")
    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "0,    1,   1",
            "1,    2,   3",
            "49,  51, 100",
            "1,  100, 101"
    })
    void severalSums(Long first, Long second, Long expectedResult) {
        assertEquals(expectedResult, basicCalculator.sum(first, second),
                () -> first + " + " + second + " should equal " + expectedResult);
    }

    @Test
    @DisplayName("Testing rest: 32-15=17")
    void rest() {
        // Arrange
        Long number1 = 32L;
        Long number2 = 15L;
        Long expectedValue = 17L;

        // Act
        Long result = basicCalculator.rest(number1, number2);

        // Assert
        assertEquals(expectedValue, result);
    }

    @DisplayName("Testing several substracts")
    @ParameterizedTest(name = "{0} - {1} = {2}")
    @CsvSource({
            "1,    1,   0",
            "1,    2,   -1",
            "50,  27, 23",
            "1,  100, -99"
    })
    void severalSubstracts(Long first, Long second, Long expectedResult) {
        assertEquals(expectedResult, basicCalculator.rest(first, second),
                () -> first + " - " + second + " should equal " + expectedResult);
    }

    @Test
    @DisplayName("Testing multiply: 5*2=10")
    void multiply() {
        // Arrange
        Long number1 = 5L;
        Long number2 = 2L;
        Long expectedValue = 10L;

        // Act
        Long result = basicCalculator.multiply(number1, number2);

        // Assert
        assertEquals(expectedValue, result);
    }

    @DisplayName("Testing several multiplications")
    @ParameterizedTest(name = "{0} * {1} = {2}")
    @CsvSource({
            "2, 5, 10",
            "12, 10, 120",
            "49,  51, 2499",
            "1,  100, 100"
    })
    public void severalMultiply(Long first, Long second, Long expectedResult) {
        assertEquals(expectedResult, basicCalculator.multiply(first, second),
                () -> first + " * " + second + " should equal " + expectedResult);
    }

    @Test
    @DisplayName("Testing division: 5/2=2")
    public void division() {
        // Arrange
        Long number1 = 5L;
        Long number2 = 2L;
        Long expectedValue = 2L;

        // Act
        Long result = basicCalculator.division(number1, number2);

        // Assert
        assertEquals(expectedValue, result);
    }

    @DisplayName("Testing several divisions")
    @ParameterizedTest(name = "{0} / {1} = {2}")
    @CsvSource({
            "15, 5, 3",
            "12, 10, 1",
            "49,  7, 7",
            "100,  2, 50"
    })
    public void severalDivision(Long first, Long second, Long expectedResult) {
        assertEquals(expectedResult, basicCalculator.division(first, second),
                () -> first + " / " + second + " should equal " + expectedResult);
    }

    @Test
    @DisplayName("Testing division: 5/0")
    public void divisionThrow() {
        // Arrange
        Long number1 = 5L;
        Long number2 = 0L;

        // Act
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> basicCalculator.division(number1, number2));

        // Assert
        assertEquals("You can't divide by 0", exception.getMessage());
    }
}
