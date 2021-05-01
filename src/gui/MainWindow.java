package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MainWindow {
    private JPanel rootPanel;
    private JButton openButton;

    public File selected;

    public MainWindow() {
        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                int decision = chooser.showOpenDialog(MainWindow.this.rootPanel);
                if(decision == JFileChooser.APPROVE_OPTION){
                     selected = chooser.getSelectedFile();
                }
            }
        });
    }

    public JPanel getRootPanel(){
        return this.rootPanel;
    }
}
