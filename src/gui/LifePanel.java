package gui;

import silnik.Cell;
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


    int delay = 550;
    Timer timer = new Timer(delay, this);
    File selected;
    File file;
    private String filePath;
    private String filePath2;
    Map mapa;
    Board board = new Board();
    public MyButton start = new MyButton("Start");
    public MyButton open = new MyButton("Open");
    public MyButton next = new MyButton("Next");
    public MyButton restart = new MyButton("Restart");
    public MyButton save = new MyButton("Save");
    public JTextField ileIteracji = new JTextField();
    public JLabel ileIteracjiLabel = new JLabel("Liczba iteracji:");

    public JLabel ktoraIteracja = new JLabel("Iteracja: " + 0);
    public MyButton instrukcja = new MyButton("Instrukcja");
    String message = "Aby program zaczął pracę, wymagamy aby na samym początku został podany plik wejściowy z danymi o określonym formacie.\n" +
            "Pierwsze co podajemy to wymiar mapy którą program będzie rysować (jedna wartość, ponieważ mapa jest kwadratem).\n" +
            "Każda linijka danych wejściowych powinna zawiarać odrębny element który będzie rysowany na mapie.\n" +
            "Po wymiarze mapy neleży określić bramki logiczne wraz z położeniem oraz konfiguracją.\n" +
            "Na końcu należy podać pojedyncze komórki wraz z położeniem.\n" +
            "Format:\n" +
            "<Wymiar>\n" +
            "<Bramka logiczna> <Wiersz> <Kolumna> <Konfiguracja>\n" +
            "<Pojedyncza komórka> <Wiersz> <Kolumna>\n" +
            "Dostępne bramki logiczne:\n" +
            "AndNotGate, Diode, FlipFlopGate, XorGate, OrGate\n" +
            "Dostępne konfiguracje: (czyli w którym kierunku ma być rysowana bramka)\n" +
            "Normal, Reversed, Down\n" +
            "Pojedyncze komórki:\n" +
            "Head, Tail, Empty\n" +
            "Możesz dodawać komórki na mapie również ręcznie.\n" +
            "Kliknięcie na pustą komórkę spowoduje ustawienie przewodnika.\n" +
            "Kliknięcie na przewodnik spowoduje ustawienie głowy.\n" +
            "Kliknięcie na głowę spowoduje ustawienie ogona.\n" +
            "Kliknięcie na ogon spowoduje ustawienie pustej komórki";


    public LifePanel() {
        add(board);
        add(open);
        add(start);
        add(next);
        add(restart);
        add(save);
        add(instrukcja);
        add(ileIteracji);
        add(ileIteracjiLabel);
        add(ktoraIteracja);

        open.addActionListener(this);
        start.addActionListener(this);
        next.addActionListener(this);
        ileIteracji.addActionListener(this);
        restart.addActionListener(this);
        save.addActionListener(this);
        instrukcja.addActionListener(this);

        board.setBounds(245, 15, board.getBoardSize(), board.getBoardSize());
        open.setBounds(55, 35);
        start.setBounds(55, 100);
        next.setBounds(55, 165);
        restart.setBounds(55, 230);
        save.setBounds(55, 295);
        ileIteracji.setBounds(78, 400, 35, 25);
        ileIteracjiLabel.setBounds(52, 360, 200, 50);

        ktoraIteracja.setBounds(500, 632, 200, 100);
        ktoraIteracja.setFont(new Font("Plain", Font.BOLD, 20));
        instrukcja.setBounds(55, 645);

        ileIteracjiLabel.setFont(new Font("Serif", Font.BOLD, 16));

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
                board.setSizeRect(board.getBoardSize() / board.wymiar);
                data = true;
            }
        } else if (source == start) {
            if (data) {
                iteratorRoboczy = 0;
                timer.start();
            } else {
                JOptionPane.showMessageDialog(null, "Błąd: dane wejściowe");
            }
        } else if (source == next) {
            if (data) {
                mapa.update();
                iteratorRoboczy++;
                ktoraIteracja.setText("Iteracja: " + iteratorRoboczy);
            } else {
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
        } else if (source == save) {
            JFileChooser chooser2 = new JFileChooser();
            int decision2 = chooser2.showSaveDialog(null);
            if (decision2 == JFileChooser.APPROVE_OPTION) {
                file = chooser2.getSelectedFile();
                filePath2 = file.getAbsolutePath();

                SaveToFile save = new SaveToFile();
                save.SaveToFile(liczbaIteracji, filePath, filePath2, mapa);
                // tutaj trzeba dopisać zapisywanie do pliku + poprawić klasy odpowiadające za to
            }

        } else if (source == restart) {
            if (data) {
                Reader reader = new Reader();
                reader.setFilepath(filePath);
                reader.read();
                mapa = reader.setMap();
                board.setMap(reader.setMap());
                board.wymiar = mapa.getRows();
                board.setSizeRect(board.getBoardSize() / board.wymiar);
                iteratorRoboczy = 0;
                ktoraIteracja.setText("Iteracja: " + iteratorRoboczy);
            } else {
                JOptionPane.showMessageDialog(null, "Błąd: dane wejściowe");
            }
        } else if (source == instrukcja) {
            JOptionPane.showMessageDialog(null, message);
        }

        repaint();
    }

}