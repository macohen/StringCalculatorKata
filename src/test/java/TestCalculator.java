import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by cohenma on 2/2/15.
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
    public void oneNumberShouldReturnThatNumber() {
        assertEquals(1, c.add("1"));
    }

    @Test
    public void twoNumbersShouldReturnTheirSum() {
        assertEquals(3, c.add("1,2"));
    }

    @Test
    public void manyNumbersShouldReturnTheirSum() {
        assertEquals(18, c.add("1,2,1,2,1,2,1,2,1,2,1,2"));
    }

    @Test
    public void newLinesOrCommasShouldWorkAsDelimiters() {
        assertEquals(6, c.add("1,2\n3"));
    }
    private final String regex = "//\\[*([^\\]])\\]*\n(.*)";
    //"//(.)\n(.*)";
    @Test
    public void testCustomDelimiterRegex() {
        Matcher m = Pattern.compile(regex).matcher("//;\n1;2");
        if(m.matches()) {
            assertEquals(";", m.group(1));
            assertEquals("1;2", m.group(2));
        } else {
            fail("regex does not match");
        }
    }

    @Ignore
    @Test
    public void testCustomDelimiterWithMultipleCharsRegex() {
        Matcher m = Pattern.compile(regex).matcher("//[--]\n1--2");
        if(m.matches()) {
            assertEquals("--", m.group(1));
            assertEquals("1--2", m.group(2));
        } else {
            fail("regex does not match");
        }
    }

    @Test
    public void customDelimitersShouldReturnASumOfAllDelimitedNumbers() {
        assertEquals(6, c.add("//;\n1;2;3"));
    }

    @Test
    public void negativeNumbersShouldThrowException() {
        try {
            c.add("-1,2");
            fail("Did not throw IllegalArgumentException for negative number");
        } catch(IllegalArgumentException e) {
            assertEquals("negatives not allowed -1", e.getMessage());
        }
    }

    @Test
    public void numbersBiggerThan1000ShouldBeIgnored() {
        assertEquals(2, c.add("1001,2"));
    }

    @Ignore
    @Test
    public void customDelimitersCanBeAnyLength() {
        assertEquals(2, c.add("//[--]\n1--1"));
    }





}
