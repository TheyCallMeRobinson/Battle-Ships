package oop.kurs2.gui;

import javax.swing.*;

public class MainFrame extends JFrame {
    private JPanel rootPanel;
    private DrawPanel drawPanel;
    private JButton nextStepButton;
    private JPanel graphicsPanel;

    public MainFrame() {
        setContentPane(rootPanel);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void createUIComponents() {
        drawPanel = new DrawPanel(800, 800);
    }
}
