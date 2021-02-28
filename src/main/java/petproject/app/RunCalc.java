package petproject.app;

import petproject.app.UI.MainForm;

import javax.swing.*;

public class RunCalc {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Title");
        frame.setContentPane(new MainForm().getMainPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        //InputManager inputManager = new InputManager();
    }
}
