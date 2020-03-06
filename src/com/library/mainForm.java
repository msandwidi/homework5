package com.library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainForm {
    private JButton titlesButton;
    private JButton authorsButton;
    private JButton ISBNButton;
    private JPanel mainPanel;
    static Frame frame;

    public mainForm() {
        frame = new JFrame("SE 475 Book Store, LLC");
        titlesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                titlesForm titlesFrame = new titlesForm() ;
                titlesForm.show();
            }
        });
    }

    public static void main(String[] args) {


        mainForm form = new mainForm();

        frame.add(form.mainPanel);

        frame.setSize(600, 400);// set screen size
        frame.setVisible(true);//making frame visible
    }
}
