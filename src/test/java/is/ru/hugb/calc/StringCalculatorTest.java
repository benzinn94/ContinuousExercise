package is.ru.hugb.calc;

import org.junit.Test;
import static org.junit.Assert.*;

public class StringCalculatorTest {
    @Test
    public void testEmptyStringReturnsZero() {
        StringCalculator Calculator = new StringCalculator();
        assertEquals(0, Calculator.add(""));
    }

    @Test
    public void testOneNumber() {
        StringCalculator Calculator = new StringCalculator();
        assertEquals(1, Calculator.add("1"));
    }

    @Test
    public void testTwoNumbers() {
        StringCalculator Calculator = new StringCalculator();
        assertEquals(3, Calculator.add("1,2"));
    }

    @Test
    public void testMultipleNumbers() {
        StringCalculator Calculator = new StringCalculator();
        assertEquals(15, Calculator.add("1,2,3,4,5"));
    }

    @Test
    public void testWithNewLineDelimiter() {
        StringCalculator Calculator = new StringCalculator();
        assertEquals(6, Calculator.add("1\n2,3"));
    }
}
