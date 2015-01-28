import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by cohenma on 1/28/15.
 */
public class TestStringCalculator {
    private Calculator c;

    @Before
    public void setUp() {
        c = new Calculator();
    }

    @Test
    public void testAddEmptyString() {
        assertEquals(0, c.add(""));
    }

    @Test
    public void testAddOneNumber() {
        assertEquals(1, c.add("1"));
    }

    @Test
    public void testAddTwoNumbers() {
        assertEquals(3, c.add("1,2"));
    }

    @Test
    public void testAddTenNumbers() {
        assertEquals(550, c.add("10,20,30,40,50,60,70,80,90,100"));
    }

    @Test
    public void testAddNewLinesAndCommas() {
        assertEquals(6, c.add("1,2\n3"));
    }

    @Test
    public void testAddCustomDelimiter() {
        assertEquals(6, c.add("//;\n1;2;3"));
    }

    @Test
    public void testAddNegativeNumbers() {
        try {
            c.add("-1,-3");
            fail("no exception thrown for negative numbers");
        } catch (IllegalArgumentException e) {

        }
    }
}
