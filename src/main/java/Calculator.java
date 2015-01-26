import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by cohenma on 1/26/15.
 */

public class Calculator {
    public int add(String numberStr) {
        int sum = 0;
        if(numberStr != null && !numberStr.trim().equals("")) {
            //split by \n or ,
            Pattern p = Pattern.compile("[,\\n]");
            String[] addendStrings = p.split(numberStr);
            for(String addendStr : addendStrings) {
                sum += Integer.parseInt(addendStr);
            }
        }
        return sum;
    }
}
