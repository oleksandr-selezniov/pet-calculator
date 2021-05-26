package petproject.app;

import javax.swing.*;

public class InputManager {
    private static String inputString="";
    private static double lastOperationResult;

    public static double getLastOperationResult() {
        return lastOperationResult;
    }

    public static void addToInput (String symbol, JTextField text) {
        inputString += symbol;
        text.setText(inputString);
    }
    //TODO cleanup in input updating methods
    public static void updateInput(String line) {
        inputString = line;
        lastOperationResult = (RPNCalculator.calc(inputString));
    }
    public static void cleanInput() {
        inputString="";
    }
    public static String getInputString() {
        return inputString;
    }
}
