package kuz.lab1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
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

    @Test
    public void teststep2() {
        int result = stringCalculator.add("1,2,3,4,5");
        assertEquals(15, result);
    }

    @Test
    public void teststep3_1() {
        int result = stringCalculator.add("1\n2,3");
        assertEquals(6, result);
    }
    @Test
    public void teststep3_2() {
        assertThrows(IllegalArgumentException.class, () -> stringCalculator.add("1,\n"));
    }

    @Test
    public void teststep4() {
        int result = stringCalculator.add("//[;]\n1;2");
        assertEquals(3, result);
    }

    @Test
    public void teststep5() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> stringCalculator.add("1\n-1,-2"));
        assertEquals("Negative numbers not allowed: [-1, -2]", exception.getMessage());
    }

    @Test
    public void teststep6() {
        int result = stringCalculator.add("1000,999,1001");
        assertEquals(1999, result);
    }

    @Test
    public void teststep7() {
        int result = stringCalculator.add("//[***]\n1***2***3");
        assertEquals(6, result);
    }

    @Test
    public void teststep8() {
        int result = stringCalculator.add("//[*][%]\n1*2%3");
        assertEquals(6, result);
    }

    @Test
    public void teststep9() {
        int result = stringCalculator.add("//[**][%%]\n2**2%%10");
        assertEquals(14, result);
    }


}