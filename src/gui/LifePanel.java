package gui;

import silnik.Map;
import silnik.Reader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class LifePanel extends JPanel implements ActionListener {

    int liczbaIteracji = 10;
    int iteratorRoboczy = 0;
    int delay = 500;
    Timer timer = new Timer(delay, this);
    File selected;
    String filePath;
    Map mapa;
    Board  board = new Board();
    public JButton start = new JButton("Start");
    public JButton open = new JButton("Open");
    public JButton next = new JButton("Next");
    public JTextField ileIteracji = new JTextField();
    public JLabel ileIteracjiLabel = new JLabel("Podaj liczbę iteracji:");
    public JLabel ktoraIteracja = new JLabel("Iteracja: " + 0);

    int canvasW = 600;
    int canvasH = 600;

    public LifePanel() {
        add(board);
        add(open);
        add(start);
        add(next);
        add(ileIteracji);
        add(ileIteracjiLabel);
        add(ktoraIteracja);
        open.addActionListener(this);
        start.addActionListener(this);
        next.addActionListener(this);
        ileIteracji.addActionListener(this);
        board.setBounds(200, 50, canvasW, canvasH);
        start.setBackground(Color.gray);
        open.setBackground(Color.gray);
        next.setBackground(Color.gray);
        open.setBounds(1, 5, 75, 50);
        start.setBounds(1, 75, 75 , 50);
        next.setBounds(1, 145, 75, 50);
        ileIteracji.setBounds(40,240, 25, 25);
        ileIteracjiLabel.setBounds(1,200,200 ,50 );
        ktoraIteracja.setBounds(200, 625, 100, 100);
        setSize(1000, 750);
        setLayout(null);
        setVisible(true);
        setBackground(Color.pink);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();
        if(source == open) {
            iteratorRoboczy = 0;
            ktoraIteracja.setText("Iteracja: " + iteratorRoboczy);
            JFileChooser chooser = new JFileChooser();
            int decision = chooser.showOpenDialog(null);
            if (decision == JFileChooser.APPROVE_OPTION) {
                selected = chooser.getSelectedFile();
                filePath = selected.getAbsolutePath();
                Reader reader = new Reader();
                reader.setFilepath(filePath);
                reader.read();
                mapa = reader.setMap();
                board.mapa = reader.setMap();
                board.wymiar = mapa.rows;
                board.size = board.boardSize/board.wymiar;
            }
        }else if(source == start){
            timer.start();
        }else if(source == next){
            mapa.update();
            iteratorRoboczy++;
            ktoraIteracja.setText("Iteracja: " + iteratorRoboczy);
        }else if(timer.isRunning()){
            mapa.update();
            iteratorRoboczy++;
            ktoraIteracja.setText("Iteracja: " + iteratorRoboczy);
            if(iteratorRoboczy == liczbaIteracji) {
                timer.stop();
                iteratorRoboczy = 0;
            }
        }else if(source == ileIteracji){
            liczbaIteracji = Integer.parseInt(ileIteracji.getText());
            System.out.println("liczba iteracji:" + liczbaIteracji);
        }

        repaint();
    }
}