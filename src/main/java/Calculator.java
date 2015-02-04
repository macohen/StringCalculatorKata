/**
 * Created by cohenma on 2/4/15.
 */
public class Calculator {
    public int add(String s) {
        int sum = 0;
        String delimiters = ",\n";

        if(!s.isEmpty()) {
            if(s.startsWith("//")) {
                String[] delimiterNumberStringPair = s.split("\n");
                String delimiterString = delimiterNumberStringPair[0];
                String numberString = delimiterNumberStringPair[1];

                delimiters += delimiterString.toCharArray()[delimiterString.length() - 1];
                s = numberString;

            }
            String[] addends = s.split("[" + delimiters + "]");
            boolean negativeNumberException = false;
            String negativeNumberExceptionMessage = "Negative numbers not allowed: ";

            for(String addend : addends) {
                int addendInt = Integer.parseInt(addend);
                if(addendInt < 0) {
                    negativeNumberException = true;
                    negativeNumberExceptionMessage += addend + ",";
                } else if (negativeNumberException == false) {
                    sum += addendInt;
                }
            }
            if (negativeNumberException) {
                throw new IllegalArgumentException(negativeNumberExceptionMessage);
            }
        }
        return sum;
    }
}
