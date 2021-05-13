package gui;

import silnik.Map;
import silnik.Reader;
import silnik.pisanieDoPliku.SaveToFile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class LifePanel extends JPanel implements ActionListener {

    int liczbaIteracji = 10;
    int iteratorRoboczy = 0;

    int liczbaPoIluzapiac =0;
    String nazwaPliku;

    int delay = 500;
    Timer timer = new Timer(delay, this);
    File selected;
    private  String filePath;
    Map mapa;
    Board  board = new Board();
    public JButton start = new JButton("Start");
    public JButton open = new JButton("Open");
    public JButton next = new JButton("Next");
    public JButton restart = new JButton("Restart");
    public JTextField ileIteracji = new JTextField();
    public JLabel ileIteracjiLabel = new JLabel("Podaj liczbę iteracji:");

    public JTextField poIluZapisac = new JTextField();
    public JLabel poIluZapisacLabel = new JLabel("Podaj po ilu iteracjach zapisać:");

    public JLabel nazwaDoZapisuLabel = new JLabel("Podaj sciezke do zapisania pliku:");
    public JTextField nazwaDozapisu = new JTextField();

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

        add(poIluZapisac);
        add(poIluZapisacLabel);
        add(nazwaDozapisu);
        add(nazwaDoZapisuLabel);
        add(restart);

        open.addActionListener(this);
        start.addActionListener(this);
        next.addActionListener(this);
        ileIteracji.addActionListener(this);
        restart.addActionListener(this);

        poIluZapisac.addActionListener(this);
        nazwaDozapisu.addActionListener(this);

        board.setBounds(200, 50, canvasW, canvasH);
        start.setBackground(Color.white);
        open.setBackground(Color.white);
        next.setBackground(Color.white);
        restart.setBackground(Color.white);
        open.setBounds(25, 5, 75, 50);
        start.setBounds(25, 75, 75 , 50);
        next.setBounds(25, 145, 75, 50);
        ileIteracji.setBounds(40,240, 25, 25);
        ileIteracjiLabel.setBounds(10,200,200 ,50 );
        restart.setBounds(25, 475, 85, 50);

        poIluZapisac.setBounds(40,300, 25, 25);
        poIluZapisacLabel.setBounds(10,260,200 ,50 );

        nazwaDozapisu.setBounds(25,360, 150, 25);
        nazwaDoZapisuLabel.setBounds(10,320,200 ,50 );

        ktoraIteracja.setBounds(200, 625, 100, 100);
        setSize(1000, 750);
        setLayout(null);
        setVisible(true);
        setBackground(new Color(186, 206, 205));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();
            if (source == open) {
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
                    board.size = board.boardSize / board.wymiar;
                }
            } else if (source == start) {
                iteratorRoboczy = 0;
                timer.start();
            } else if (source == next) {
                mapa.update();
                iteratorRoboczy++;
                ktoraIteracja.setText("Iteracja: " + iteratorRoboczy);
            } else if (timer.isRunning()) {
                mapa.update();
                iteratorRoboczy++;
                ktoraIteracja.setText("Iteracja: " + iteratorRoboczy);
                if (iteratorRoboczy % liczbaIteracji == 0) {
                    timer.stop();
                    iteratorRoboczy = 0;
                }
            } else if (source == ileIteracji) {
                liczbaIteracji = Integer.parseInt(ileIteracji.getText());
                System.out.println("liczba iteracji:" + liczbaIteracji);
            } else if (source == nazwaDozapisu) {
                nazwaPliku = nazwaDozapisu.getText();
                System.out.println("nazwa pliku " + nazwaPliku);
                SaveToFile save = new SaveToFile();
                save.SaveToFile(liczbaPoIluzapiac, filePath, nazwaPliku);
            } else if (source == poIluZapisac) {
                liczbaPoIluzapiac = Integer.parseInt(poIluZapisac.getText());
                System.out.println("po ilu zapisac: " + liczbaPoIluzapiac);
            } else if( source == restart){
                Reader reader = new Reader();
                reader.setFilepath(filePath);
                reader.read();
                mapa = reader.setMap();
                board.mapa = reader.setMap();
                board.wymiar = mapa.rows;
                board.size = board.boardSize / board.wymiar;
                iteratorRoboczy = 0;
                ktoraIteracja.setText("Iteracja: " + iteratorRoboczy);
            }

            repaint();
        }

}