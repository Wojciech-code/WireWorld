package silnik.pisanieDoPliku;

import silnik.Cell;
import silnik.Map;
import silnik.Reader;

import java.io.*;

public class SaveToFile {


    public void SaveToFile(int n, String s, String nazwa, Map mapa) {
        File zapis = new File(nazwa + ".txt");

        SaveSizeAndGates save1 = new SaveSizeAndGates();
        SaveTailHead save2 = new SaveTailHead();

        save1.saveSizeAndGates(zapis, s);
        save2.saveTailHead(zapis, s, mapa);

    }
}



