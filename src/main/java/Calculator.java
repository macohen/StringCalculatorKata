import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by cohenma on 2/2/15.
 */
public class Calculator {
    public int add(String s) {

        int sum = 0;
        if (!s.isEmpty()) {
            String delimiters = ",\n";
            if(s.startsWith("//")) {
                Matcher m = Pattern.compile("//(.)\n(.*)").matcher(s);
                if(m.matches()) {
                    delimiters += m.group(1);
                    s = m.group(2);
                }
            }
            String[] addendsStr = s.split("[" + delimiters + "]");
            String exceptionMessage = "negatives not allowed ";
            boolean exception = false;
            for (String addendStr : addendsStr) {
                int addend = Integer.parseInt(addendStr);
                if(addend < 0) {
                    exceptionMessage += addend;
                    exception = true;
                } else if (addend <= 1000) {
                    sum += addend;
                }
            }
            if(exception) {
                throw new IllegalArgumentException(exceptionMessage);
            }
        }
        return sum;
    }
}
