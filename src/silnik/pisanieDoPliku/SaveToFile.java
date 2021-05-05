package silnik.pisanieDoPliku;

import bramki.logiczne.*;
import gui.LifePanel;
import silnik.Cell;
import silnik.Map;
import silnik.Reader;

import java.io.*;

public class SaveToFile {
    Map m;

    public void SaveToFile(int n, String s,String nazwa) {
        File zapis = new File(nazwa);
        //System.out.println(s);

        silnik.Reader r = new Reader();
        r.setFilepath(s);
        r.read();
        Map m = r.setMap();
        m.iterate2(n);

        SaveSizeAndGates save1 = new SaveSizeAndGates();
        SaveTailHead save2 = new SaveTailHead();

        save1.saveSizeAndGates(zapis,s);
        save2.saveTailHead(zapis, m);

    }
}



