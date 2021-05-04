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
        setTitle("WireWorld najlepsza praca");
    }

public static void main(String [] args){

    javax.swing.SwingUtilities.invokeLater(new Runnable() {
        public void run() {
           LifeFrame window = new LifeFrame();
        }
    });
}

}