package gui;

import javax.swing.*;
import java.awt.*;

public class LifeFrame extends JFrame {

    LifePanel lf;

    public LifeFrame() {
        setSize(1000, 750);
        setVisible(true);
        setResizable(false);
        lf = new LifePanel();
        add(lf);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("WireWorld");
        setLocation(350,60);
        Image im = Toolkit.getDefaultToolkit().getImage(getClass().getResource("img.png"));
        setIconImage(im);
    }
}