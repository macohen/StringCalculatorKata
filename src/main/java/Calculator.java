import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by cohenma on 1/30/15.
 */
public class Calculator {
    public int add(String s) {
        int sum = 0;
        if (s != null && !s.trim().equals("")) {
            String customDelimRegex = "//(.)\n(.*)";
            String delims = ",\n";
            Matcher m = Pattern.compile(customDelimRegex).matcher(s);
            if(m.matches()) {
                delims += m.group(1);
                s = m.group(2);
            }
            String[] addends = s.split("[" + delims + "]");
            String negativeNumberMessage = "Negative numbers not supported: ";
            boolean negativeNumber = false;
            for (String addend : addends) {
                int addendInt = Integer.parseInt(addend);
                if (addendInt < 0) {
                    negativeNumberMessage += addendInt + ",";
                    negativeNumber = true;
                } else if (addendInt > 1000) {
                    continue;
                } else {
                    sum += addendInt;
                }
            }
            if(negativeNumber) {
                throw new IllegalArgumentException(negativeNumberMessage);
            }
        }
        return sum;
    }
}
