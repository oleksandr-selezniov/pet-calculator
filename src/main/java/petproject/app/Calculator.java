package petproject.app;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static petproject.app.MathOperations.*;

public class Calculator {
    private static String[] inputArray;
    private static String logItem="";
    //private static Pattern number = Pattern.compile("\\^\\d+\\.?\\d+$");
    //
    //^\d+\.?\d+$
    public static void parseInput(String input) {
        logItem = logItem + input + "\n";
        inputArray = input.split( " ");
    }
    public static String calculateResult () {
        double result=0;
        double var_1;
        //MathOperations operation = null;
        for (int i=0; i<Arrays.stream(inputArray).count(); i++) {
            switch (inputArray[i]) {
                case ("+"):
                    result += Double.parseDouble(inputArray[i+1]);
                    i++;
                    break;
                case ("-"):
                    result -= Double.parseDouble(inputArray[i+1]);
                    i++;
                    break;
                case ("*"):
                    result *= Double.parseDouble(inputArray[i+1]);
                    i++;
                    break;
                case ("/"):
                    result /= Double.parseDouble(inputArray[i+1]);
                    i++;
                    break;
                default:
                    //Matcher matcher = number.matcher(inputArray[i]);
                    result += Double.parseDouble(inputArray[i]);
            }
        }
        return Double.toString(result);
    }
    public static String getLogItem () {
        logItem = logItem + calculateResult() + "\n\n";
        return logItem;
    }
}
