package petproject.app;

import javax.swing.*;

public class InputManager {
    private static String inputString="";

    public static void addToInput (String symbol, JTextField text) {
        inputString += symbol;
        text.setText(inputString);
    }
    public static void addToInput (String line) {
        inputString = line;
    }
    public static void cleanInput() {
        inputString="";
    }
    public static String getInputString() {
        return inputString;
    }
}
