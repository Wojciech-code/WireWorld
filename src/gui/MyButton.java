package gui;

import javax.swing.*;
import java.awt.*;

public class MyButton extends JButton {

    private int width = 85;
    private int height = 50;

    public MyButton(String title){
        setText(title);
        setBackground(Color.white);
        setBackground(new Color(0xD7F0F8));
        setForeground(new Color(0x441923));
        setBorder(BorderFactory.createLineBorder(Color.black));
        setFont(new Font("Serif", Font.BOLD,16));

    }

    public void setBounds(int x, int y){
        super.setBounds(x,y,width, height);
    }
}
