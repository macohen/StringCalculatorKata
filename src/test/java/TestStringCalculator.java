/**
 * Created by cohenma on 1/26/15.
 */

import org.junit.*;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

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
        assertEquals(2, c.add("1,1"));
    }

    @Test
    public void testAddUnknownNumbers() {
        assertEquals(10, c.add("1,1,1,1,1,1,1,1,1,1"));
    }

    @Test
    public void testAddNewlineAndCommaDelim() {
        assertEquals(6,c.add("1\n2,3"));
    }

}
