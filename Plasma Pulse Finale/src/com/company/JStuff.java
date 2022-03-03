package com.company;

import javax.swing.*;

public class JStuff {
    JStuff() {
        JFrame frejm = new JFrame("planek domu");
        JLabel imageLabel = new JLabel();
        ImageIcon image = new ImageIcon("planek domu.png");
        imageLabel.setIcon(image);
        frejm.add(imageLabel);
        frejm.setVisible(true);
        frejm.setResizable(false);
        frejm.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frejm.pack();
    }
}