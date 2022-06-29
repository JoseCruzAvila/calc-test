package co.com.sofka.app.calculator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasicCalculator {
    private static final Logger logger = LoggerFactory.getLogger(BasicCalculator.class);

    public Long sum(Long number1, Long number2) {
        logger.info( "Summing {} + {}", number1, number2 );
        
        return number1 + number2;
    }

    public Long rest(Long number1, Long number2) {
        logger.info("Substracting {} - {}", number1, number2);

        return number1 - number2;
    }

    public Long multiply(Long number1, Long number2) {
        logger.info("Multiplying {} * {}", number1, number2);

        return number1 * number2;
    }

    public Long division(Long number1, Long number2) {
        logger.info("Dividing {} / {}", number1, number2);

        try {
            return number1 / number2;
        } catch (ArithmeticException e) {
            logger.error("Error in the division {} / {} because you're trying to divide by 0", number1, number2);
            throw new IllegalArgumentException("You can't divide by 0");
        }
    }
}
