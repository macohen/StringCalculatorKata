import org.junit.Before;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by cohenma on 1/30/15.
 */
public class TestCalculator {
    Calculator c;
    @Before
    public void setUp() {
        c = new Calculator();
    }

    @Test
    public void testAdd() {
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
    public void testAddManyNumbers() {
        assertEquals(100, c.add("10,10,10,10,10,10,10,10,10,10"));
    }

    @Test
    public void testNewlineCommaDelims() {
        assertEquals(6, c.add("1,2\n3"));
    }

    @Test
    public void testCustomDelimiter() {
        assertEquals(3, c.add("//;\n1;2"));
    }

    @Test
    public void testCustomDelimRegex() {
        //not really testing the Calculator.  just figuring out the regex here
        String expectedDelim = ";";
        //String expectedNums = "1;2";
        String numStr = "//;\n1;2";

        String regex = "//(.)\n(.*)";
        Matcher m = Pattern.compile(regex).matcher(numStr);
        if(m.matches()) {
            assertEquals(";", m.group(1));
            assertEquals("1;2", m.group(2));
        } else {
            fail("no match");
        }
    }

    private String negativeNumberMessage = "Negative numbers not supported: ";
    @Test
    public void testNegativeNumbers() {
        try {
            c.add("-1,2");
            fail("No exception caught for negative numbers");
        } catch(IllegalArgumentException e) {
            assertEquals(negativeNumberMessage + "-1,", e.getMessage());
        }
    }

    @Test
    public void testMultipleNegativeNumbers() {
        try {
            c.add("-1,-2");
            fail("No exception caught for negative numbers");
        } catch(IllegalArgumentException e) {
            assertEquals(negativeNumberMessage + "-1,-2,", e.getMessage());
        }
    }

    @Test
    public void testIgnoreGreaterThan1000() {
        assertEquals(2, c.add("2,1001"));
    }
}
