import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by cohenma on 1/27/15.
 */
public class Calculator {

    public int add(String numberStr) {
        int sum = 0;

        if (!numberStr.equals("")) {
            String userDelim = "";
            if(numberStr.startsWith("//")) { //user provided default delimiter
                Matcher m = Pattern.compile("//(?<delim>.)\n(?<numberStr>.*)").matcher(numberStr);
                if(m.matches()) {
                    userDelim = m.group("delim");
                    numberStr = m.group("numberStr");
                } else {
                    throw new IllegalArgumentException("Bad number string for the calculator: " + numberStr);
                }
            }

            Pattern p = Pattern.compile("[\\n," + userDelim + "]");
            String[] addendStrings = p.split(numberStr);
            for (String s : addendStrings) {
                sum += Integer.parseInt(s);
            }
        }
        return sum;
    }


}
