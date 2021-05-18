package gui;

import silnik.Cell;
import silnik.Map;

import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {

    Map mapa;
    int wymiar;
    int boardSize = 650;
    int size;


    public Board(){
        setBackground(Color.BLACK);
    }

    public void grid(Graphics g){

        if(wymiar != 0) {
            g.setColor(Color.gray);
            for (int i = 0; i <= boardSize / size; i++) {
                g.drawLine(0, size * i, boardSize, i * size);
                g.drawLine(i * size, 0, i * size, boardSize);
            }
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        grid(g);
        rect(g);
    }

    public void rect(Graphics g) {

        if (wymiar != 0) {
            for (Cell c : mapa) {
                if (c.getState() == 1) {
                    g.setColor(Color.ORANGE);
                    g.fillRect(c.getColumn() * size, c.getRow() * size, size, size);
                } else if (c.getState() == 2) {
                    g.setColor(Color.BLUE);
                    g.fillRect(c.getColumn() * size, c.getRow() * size, size, size);
                } else if (c.getState() == 3) {
                    g.setColor(Color.RED);
                    g.fillRect(c.getColumn() * size, c.getRow() * size, size, size);
                }
            }
        }
    }

}
