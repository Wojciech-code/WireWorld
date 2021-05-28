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
    Boolean data = false;

    int liczbaPoIluzapiac =0;
    String nazwaPliku;

    int delay = 650;
    Timer timer = new Timer(delay, this);
    File selected;
    private  String filePath;
    Map mapa;
    Board  board = new Board();
    public MyButton start = new MyButton("Start");
    public MyButton open = new MyButton("Open");
    public MyButton next = new MyButton("Next");
    public MyButton restart = new MyButton("Restart");
    public JTextField ileIteracji = new JTextField();
    public JLabel ileIteracjiLabel = new JLabel("Liczba iteracji:");

    public JTextField poIluZapisac = new JTextField();
    public JLabel poIluZapisacLabel = new JLabel("Po ilu iteracjach zapisać:");

    public JLabel nazwaDoZapisuLabel = new JLabel("Nazwa pliku do zapisu:");
    public JTextField nazwaDozapisu = new JTextField();

    public JLabel ktoraIteracja = new JLabel("Iteracja: " + 0);
    public MyButton instrukcja = new MyButton("Instrukcja");
    String message = "Aby program zaczął pracę, wymagamy aby na samym początku został podany plik wejściowy z danymi o określonym formacie.\n" +
            "Pierwsze co podajemy to wymiar mapy którą program będzie rysować (jedna wartość, ponieważ mapa jest kwadratem).\n" +
            "Każda linijka danych wejściowych powinna zawiarać odrębny element który będzie rysowany na mapie.\n" +
            "Po wymiarze mapy neleży określić bramki logiczne wraz z położeniem oraz konfiguracją.\n" +
            "Na końcu należy podać pojedyncze komórki wraz z położeniem.\n" +
            "Format:\n" +
            "<Wymiar>" +
            "<Bramka logiczna> <Wiersz> <Kolumna> <Konfiguracja>\n" +
            "<Pojedyncza komórka> <Wiersz> <Kolumna>\n" +
            "Dostępne bramki logiczne:\n" +
            "AndNotGate, Diode, FlipFlopGate, XorGate, OrGate\n" +
            "Dostępne konfiguracje: (czyli w którym kierunku ma być rysowana bramka)\n" +
            "Normal, Reversed, Down\n" +
            "Pojedyncze komórki:\n" +
            "Head, Tail, Empty\n" +
            "Jeśli liczba iteracji nie zostanie podana program domyślnie przyjmuje 10.\n" +
            "Zatwierdzaj wprowadzone dane Enterem :).";


    public LifePanel() {
        add(board);
        add(open);
        add(start);
        add(next);
        add(restart);
        add(instrukcja);
        add(ileIteracji);
        add(ileIteracjiLabel);
        add(ktoraIteracja);
        add(poIluZapisac);
        add(poIluZapisacLabel);
        add(nazwaDozapisu);
        add(nazwaDoZapisuLabel);

        open.addActionListener(this);
        start.addActionListener(this);
        next.addActionListener(this);
        ileIteracji.addActionListener(this);
        restart.addActionListener(this);
        instrukcja.addActionListener(this);
        poIluZapisac.addActionListener(this);
        nazwaDozapisu.addActionListener(this);

        board.setBounds(245, 15, board.getBoardSize(), board.getBoardSize());
        open.setBounds(55, 35);
        start.setBounds(55, 100);
        next.setBounds(55, 165);
        restart.setBounds(55, 230);
        ileIteracji.setBounds(64,350, 25, 25);
        ileIteracjiLabel.setBounds(35,310,200 ,50 );
        poIluZapisacLabel.setBounds(25,370,200 ,50 );
        nazwaDoZapisuLabel.setBounds(25,430,200 ,50 );
        poIluZapisac.setBounds(75,410, 25, 25);
        nazwaDozapisu.setBounds(25,470, 150, 25);
        ktoraIteracja.setBounds(500, 632, 200, 100);
        ktoraIteracja.setFont(new Font("Plain", Font.BOLD,20));
        instrukcja.setBounds(55,645);

        ileIteracjiLabel.setFont(new Font("Serif", Font.BOLD,16));
        nazwaDoZapisuLabel.setFont(new Font("Serif", Font.BOLD,16));
        poIluZapisacLabel.setFont(new Font("Serif", Font.BOLD,16));

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
                    board.setMap(reader.setMap());
                    board.wymiar = mapa.getRows();
                    board.setSize(board.getBoardSize() / board.wymiar);
                    data = true;
                }
            } else if (source == start) {
                if(data) {
                    iteratorRoboczy = 0;
                    timer.start();
                }else{
                    JOptionPane.showMessageDialog(null, "Błąd: dane wejściowe");
                }
            } else if (source == next) {
                if(data) {
                    mapa.update();
                    iteratorRoboczy++;
                    ktoraIteracja.setText("Iteracja: " + iteratorRoboczy);
                }else{
                    JOptionPane.showMessageDialog(null, "Błąd: dane wejściowe");
                }
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
                if(data) {
                    Reader reader = new Reader();
                    reader.setFilepath(filePath);
                    reader.read();
                    mapa = reader.setMap();
                    board.setMap(reader.setMap());
                    board.wymiar = mapa.getRows();
                    board.setSize(board.getBoardSize() / board.wymiar);
                    iteratorRoboczy = 0;
                    ktoraIteracja.setText("Iteracja: " + iteratorRoboczy);
                }else{
                    JOptionPane.showMessageDialog(null, "Błąd: dane wejściowe");
                }
            } else if(source == instrukcja) {
                JOptionPane.showMessageDialog(null, message);
            }

            repaint();
        }

}