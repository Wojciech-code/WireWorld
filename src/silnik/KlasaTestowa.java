package silnik;

import bramki.logiczne.Diode;

public class KlasaTestowa {


    public static void main(String [] args) {

        int rows = 6;
        int columns = 10;
        Map m = new Map(rows, columns);

        Diode diode = new Diode();
        diode.setGate(m, 2, 1);

        for(Cell c : m) {
            if (c.row == 2 && c.column == 2)
                c.setHead();
        }


        int iteracje = 5;
        m.iterate(5);

    }
}
