package com.library;

import javax.swing.*;

public class titlesForm {
    private JLabel pageTitleLabel;
    private JScrollPane titlesScrollPane;
    private JList titlesList;
    private JPanel mainPanel;

    public static void show(){
        JFrame frame = new JFrame();
        frame.getContentPane().add(new titlesForm().mainPanel);
        frame.setVisible(true);
    }
}
