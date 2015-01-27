import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by cohenma on 1/27/15.
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
    public void testAddUnknownNumbers() {
        String numberStr = "1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1";
        assertEquals(21, c.add(numberStr));
    }

    @Test
    public void testNewlineComma() {
        assertEquals(6, c.add("1\n2,3"));
    }

    @Test
    public void testUserProvidedDefault() {
        assertEquals(3, c.add("//;\n1;1;1"));
    }

}
