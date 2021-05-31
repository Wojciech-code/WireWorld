package silnik.pisanieDoPliku;

import gui.Board;
import silnik.Cell;
import silnik.Map;
import silnik.Reader;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class SaveTailHead {

    public void saveTailHead(File z, String s, Map mapa) {
        try {
            FileWriter writer = new FileWriter(z, true);
            for (Cell c : mapa) {
                if (c.getState() == 0 && c.getIsGate() == true) {
                    writer.write("Empty " + c.getRow() + " " + c.getColumn() + "\n");
                }
                if (c.getState() == 1 && c.getIsGate() == false) {
                    writer.write("Conductor " + c.getRow() + " " + c.getColumn() + "\n");
                }
                if (c.getState() == 2) {
                    writer.write("Tail " + c.getRow() + " " + c.getColumn() + "\n");
                }
                if (c.getState() == 3) {
                    writer.write("Head " + c.getRow() + " " + c.getColumn() + "\n");
                }
            }
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
