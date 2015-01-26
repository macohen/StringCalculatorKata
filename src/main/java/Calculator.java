/**
 * Created by cohenma on 1/26/15.
 */
public class Calculator {
    public int add(String numberStr) {
        int sum = 0;
        if(numberStr != null && !numberStr.trim().equals("")) {
            String[] addendStrings = numberStr.split(",");
            for(String addendStr : addendStrings) {
                sum += Integer.parseInt(addendStr);
            }
        }
        return sum;
    }
}
