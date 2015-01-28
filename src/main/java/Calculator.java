import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by cohenma on 1/28/15.
 */
public class Calculator {
    private Pattern customDelimiter = Pattern.compile("//(.)\\n(.*)");

    public int add(String numberStr) {
        String delimiters = "\\n,";
        int sum = 0;
        if(numberStr != null && !numberStr.trim().equals("")) {
            Matcher matcher = customDelimiter.matcher(numberStr);
            if(matcher.matches()) {
                String delimiter = matcher.group(1);
                delimiters += delimiter;
                numberStr = matcher.group(2);

            }
            sum = addNumbers(numberStr, delimiters, sum);
        }
        return sum;
    }

    private int addNumbers(String numberStr, String delimiters, int sum) {
        Pattern delimiterPattern = Pattern.compile("[" + delimiters + "]");
        String[] addends = delimiterPattern.split(numberStr);
        for(String addend : addends) {
            int addendInt = Integer.parseInt(addend);
            if (addendInt < 0) {
                throw new IllegalArgumentException("Negative numbers not allowed: " + addendInt);
            }
            sum += addendInt;
        }
        return sum;
    }
}
