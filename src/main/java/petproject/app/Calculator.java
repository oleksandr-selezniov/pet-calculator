package petproject.app;

import java.util.Arrays;

public class Calculator {
    private static String[] positive;
    private static String[] negative;
    private static String logItem="";
//    private static double result;
//    private static Pattern number = Pattern.compile("\\^\\d+\\.?\\d+$");
//
//    ^\d+\.?\d+$
    public static void parseInput(String input) {
        logItem = input + "\n\n" + logItem;//move to end, add new items in top of log
        positive = input.split("[+]");
        negative = new String[input.split("[-]").length-1];
        int i = 0;
        for (int k = 0; k < positive.length; k++) {
            String[] temp = positive[k].split("[-]");
            positive[k] = temp[0];
            for (int j = 1; j < temp.length; j++) {
                negative[i] = temp[j];
                i++;
            }
        }
    }
    private static double[] calculateMultDiv (String[] input) {
        double[] i = new double[input.length];
        for (int counter_i=0; counter_i < input.length; counter_i++) {
            if (!input[counter_i].strip().equals("")) {
                String[] mult = input[counter_i].split("[*]");
                double[] j = new double[mult.length];
                for (int counter_m = 0; counter_m < mult.length; counter_m++) {
                    if (!mult[counter_m].strip().equals("")) {
                        String[] div = mult[counter_m].split("[/]");
                        double k = Double.parseDouble(div[0].strip());
                        if (div.length > 1) {
                            for (int counter_d = 1; counter_d < div.length; counter_d++) {
                                k /= Double.parseDouble(div[counter_d].strip());//add check for proper number
                            }
                        }
                        j[counter_m] = k;
                    }
                }
                i[counter_i] = 1;
                for (double v : j) {
                    i[counter_i] *= v;
                }
            }
        }
        return i;
    }
    public static double calculateResult() {
        double result = 0;
        for (double term : calculateMultDiv(positive)) {
            result += term;
        }
        for (double term : calculateMultDiv(negative)) {
            result -= term;
        }
        return result;
    }
/*    public static String parseMultDiv(String[] input) {
//        double result=0;
//        double var_1;
//        MathOperations operation = null;
        String
        for (int i=0; i<Arrays.stream(inputArray).count(); i++) {
            switch (inputArray[i]) {
//                case ("+"):
//                    result += Double.parseDouble(inputArray[i+1]);
//                    i++;
//                    break;
//                case ("-"):
//                    result -= Double.parseDouble(inputArray[i+1]);
//                    i++;
//                    break;
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
    }*/
    public static String getLogItem () {
        logItem = calculateResult() + "\n" + logItem + "\n";
        return logItem;
    }

    public  static String updateLogItem(String s) {
        logItem = s + "\n" + logItem;
        return logItem;
    }
}
