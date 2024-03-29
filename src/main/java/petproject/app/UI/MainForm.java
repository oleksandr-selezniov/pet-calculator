package petproject.app.UI;

import petproject.app.Calculator;
import petproject.app.InputManager;
import petproject.app.Memory;

import javax.swing.*;
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
    private JPanel results;
    private JLabel memoryLabel;

    public MainForm() {
        key0.addActionListener(actionEvent -> refreshInputField("0"));
        key1.addActionListener(actionEvent -> refreshInputField("1"));
        key2.addActionListener(actionEvent -> refreshInputField("2"));
        key3.addActionListener(actionEvent -> refreshInputField("3"));
        key4.addActionListener(actionEvent -> refreshInputField("4"));
        key5.addActionListener(actionEvent -> refreshInputField("5"));
        key6.addActionListener(actionEvent -> refreshInputField("6"));
        key7.addActionListener(actionEvent -> refreshInputField("7"));
        key8.addActionListener(actionEvent -> refreshInputField("8"));
        key9.addActionListener(actionEvent -> refreshInputField("9"));
        keyDot.addActionListener(actionEvent -> refreshInputField("."));
        keyEquals.addActionListener(actionEvent -> {
//                Calculator.parseInput(InputManager.getInputString());
//                refreshCalcLog();
            try {
                updateInputFromField(inputField.getText());
                refreshCalcLog(String.valueOf(InputManager.getLastOperationResult()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        keyPlus.addActionListener(actionEvent -> refreshInputField(" + "));
        keyMinus.addActionListener(actionEvent -> refreshInputField(" - "));
        keyMultiply.addActionListener(actionEvent -> refreshInputField(" * "));
        keyDivide.addActionListener(actionEvent -> refreshInputField(" / "));
        keyClean.addActionListener(actionEvent -> {
            InputManager.cleanInput();
            inputField.setText("");
        });
//        inputField.addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyTyped(KeyEvent e) {
//                super.keyTyped(e);
//                updateInputFromField(String.valueOf(e.getKeyChar()));
//            }
//        });
//        inputField.addCaretListener(new CaretListener() {
//            @Override
//            public void caretUpdate(CaretEvent caretEvent) {
//
//            }
//        });
        keyM.addActionListener(actionEvent -> {
            Memory.storeToMemory(InputManager.getLastOperationResult());
            updateMemoryLabel();
        });
        keyMPlus.addActionListener(actionEvent -> {
            Memory.increaseMemory(InputManager.getLastOperationResult());
            updateMemoryLabel();
        });
        keyMRecall.addActionListener(actionEvent -> {
            refreshInputField(String.valueOf(Memory.recallFromMemory()));
            updateInputFromField(inputField.getText());
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    private void refreshInputField(String text) {
        InputManager.addToInput(text, inputField);
    }

    private void updateInputFromField(String text) {
        InputManager.updateInput(text);
    }

    private void updateMemoryLabel() {
        memoryLabel.setText(String.valueOf(Memory.recallFromMemory()));
    }

    private void refreshCalcLog() {
        calcLog.setText(Calculator.getLogItem());
    }

    private void refreshCalcLog(String s) {
        calcLog.setText(Calculator.updateLogItem(s));
    }
}
