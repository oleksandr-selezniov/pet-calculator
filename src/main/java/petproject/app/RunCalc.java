package petproject.app;

import petproject.app.UI.MainForm;

import javax.swing.JFrame;

public class RunCalc {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setContentPane(new MainForm().getMainPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        //InputManager inputManager = new InputManager();
    }
}
