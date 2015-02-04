import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by cohenma on 2/4/15.
 */
public class TestCalculator {
    private Calculator c;

    @Before
    public void setUp() {
        c = new Calculator();
    }


    @Test
    public void emptyStringShouldReturnZero() {
        assertEquals(0, c.add(""));
    }

    @Test
    public void singleNumberShouldReturnThatNumber() {
        assertEquals(1, c.add("1"));
    }

    @Test
    public void twoNumbersSeparatedByCommaShouldReturnTheirSum() {
        assertEquals(3, c.add("1,2"));
    }

    @Test
    public void numbersSeparatedByCommaOrNewlineShouldReturnTheirSum() {
        assertEquals(6, c.add("1,2\n3"));
    }

    @Test
    public void customDelimitersShouldBeAllowed() {
        assertEquals(6, c.add("//;\n1;2;3"));
    }

    @Test
    public void negativeNumbersShouldThrowException() {
        try {
            negativeNumberTest();
        } catch(IllegalArgumentException e) {

        }
    }

    @Test
    public void negativeNumbersShouldThrowExceptionIncludingMessageWithNegativeNumberList() {
        try {
            negativeNumberTest();
        } catch(IllegalArgumentException e) {
            assertEquals("Negative numbers not allowed: -1,", e.getMessage());
        }
    }

    private void negativeNumberTest() {
        c.add("-1,2");
        fail("Negative numbers should throw an exception");
    }


}
