import gui.MainWindow;
import silnik.Map;
import silnik.Reader;

import javax.swing.*;
import java.awt.*;

public class WireWorldMain {

    public static void main(String [] args){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainWindow window = new MainWindow();

                JFrame frame = new JFrame("WireWorld");
                frame.setContentPane(window.getRootPanel());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setPreferredSize(new Dimension(950, 600));
                frame.pack();
                frame.setVisible(true);

            }
        });

    }

}
