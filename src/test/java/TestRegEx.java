import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by cohenma on 1/27/15.
 */
public class TestRegEx {
    @Test
    public void testUserSuppliedDelimRegex() {

        String str = "//;\n1;1;1";
        Matcher m = Pattern.compile("//(?<delim>.)\n(?<numberStr>.*)").matcher(str);
        if(m.matches()) {
            assertEquals(";", m.group("delim"));
            assertEquals("1;1;1", m.group("numberStr"));
        } else {
            fail(m.pattern().toString() + " does not match " + str);
        }


    }
}
