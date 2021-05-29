package gui;

import silnik.Cell;
import silnik.Map;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Board extends JPanel implements MouseListener {

    private Map mapa;
    protected int wymiar;
    private int boardSize = 650;
    private int sizeRect;


    public Board() {
        setBackground(Color.BLACK);
        this.addMouseListener(this);
    }

    public void grid(Graphics g) {

        if (wymiar != 0) {
            g.setColor(Color.gray);
            for (int i = 0; i <= boardSize / sizeRect; i++) {
                g.drawLine(0, sizeRect * i, boardSize, i * sizeRect);
                g.drawLine(i * sizeRect, 0, i * sizeRect, boardSize);
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        grid(g);
        rect(g);
    }

    public void rect(Graphics g) {

        if (wymiar != 0) {
            for (Cell c : mapa) {
                if (c.getState() == 1) {
                    g.setColor(Color.ORANGE);
                    g.fillRect(c.getColumn() * sizeRect, c.getRow() * sizeRect, sizeRect, sizeRect);
                } else if (c.getState() == 2) {
                    g.setColor(Color.BLUE);
                    g.fillRect(c.getColumn() * sizeRect, c.getRow() * sizeRect, sizeRect, sizeRect);
                } else if (c.getState() == 3) {
                    g.setColor(Color.RED);
                    g.fillRect(c.getColumn() * sizeRect, c.getRow() * sizeRect, sizeRect, sizeRect);
                }
            }
        }
    }

    public void setMap(Map map) {
        mapa = map;
    }

    public int getBoardSize() {
        return boardSize;
    }

    public void setSizeRect(int sizeRect) {
        this.sizeRect = sizeRect;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(sizeRect != 0) {
            int x = e.getX() / sizeRect;
            int y = e.getY() / sizeRect;
            for(Cell c : mapa){
                if(c.getRow() == y && c.getColumn() == x){
                    if(c.getState() == 0){
                        c.setConductor();
                    }else if(c.getState() == 1){
                        c.setHead();
                    }else if(c.getState() == 3){
                        c.setTail();
                    }else if(c.getState() == 2)
                        c.setEmpty();
                }

            }
            repaint();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
