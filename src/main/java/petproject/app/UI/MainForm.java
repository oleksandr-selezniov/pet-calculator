package petproject.app.UI;

import petproject.app.Calculator;
import petproject.app.InputManager;
import petproject.app.RPNCalculator;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm {
    private JTextField inputField;
    private JButton key7;
    private JButton keyM;
    private JButton key4;
    private JButton key1;
    private JButton key0;
    private JPanel keyPad;
    private JButton key8;
    private JButton key5;
    private JButton key2;
    private JButton keyMPlus;
    private JButton key6;
    private JButton key3;
    private JButton keyMRecall;
    private JButton key9;
    private JButton keyDivide;
    private JButton keyMultiply;
    private JButton keyMinus;
    private JButton keyPlus;
    private JButton keyEquals;
    private JTextPane calcLog;
    private JButton keyDot;
    private JButton keyClean;
    private JPanel mainPanel;

    public MainForm() {
        key0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                refreshInputField("0");
            }
        });
        key1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                refreshInputField("1");
            }
        });
        key2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                refreshInputField("2");
            }
        });
        key3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                refreshInputField("3");
            }
        });
        key4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                refreshInputField("4");
            }
        });
        key5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                refreshInputField("5");
            }
        });
        key6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                refreshInputField("6");
            }
        });
        key7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                refreshInputField("7");
            }
        });
        key8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                refreshInputField("8");
            }
        });
        key9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                refreshInputField("9");
            }
        });
        keyDot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                refreshInputField(".");
            }
        });
        keyEquals.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
//                Calculator.parseInput(InputManager.getInputString());
//                refreshCalcLog();
                try {
                    updateInputFromField(inputField.getText());
                    refreshCalcLog(RPNCalculator.calc(InputManager.getInputString()).toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        keyPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                refreshInputField(" + ");
            }
        });
        keyMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                refreshInputField(" - ");
            }
        });
        keyMultiply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                refreshInputField(" * ");
            }
        });
        keyDivide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                refreshInputField(" / ");
            }
        });
        keyClean.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                InputManager.cleanInput();
                inputField.setText("");
            }
        });
    }
    public JPanel getMainPanel() {
        return mainPanel;
    }
    private void refreshInputField(String text) {
        InputManager.addToInput(text, inputField);
    }
    private void refreshCalcLog () {
        calcLog.setText(Calculator.getLogItem());
    }
}
