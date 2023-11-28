package kuz.lab1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class StringCalculatorTest {

    private StringCalculator stringCalculator = new StringCalculator();

    @Test
    public void teststep1_1() {
        int result = stringCalculator.add("");
        assertEquals(0, result);
    }

    @Test
    public void teststep1_2() {
        int result = stringCalculator.add("1");
        assertEquals(1, result);
    }

    @Test
    public void teststep1_3() {
        int result = stringCalculator.add("1,2");
        assertEquals(3, result);
    }


}