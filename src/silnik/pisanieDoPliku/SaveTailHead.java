package silnik.pisanieDoPliku;

import silnik.Cell;
import silnik.Map;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class SaveTailHead {

    public void saveTailHead(File z, Map m) {
        try {
            // PrintWriter writer = new PrintWriter(zapis);
            FileWriter writer = new FileWriter(z, true);
            for (Cell c : m) {
                switch (c.getState()) {
                    case (2):
                        // writer.println("Tail " + c.row + " " + c.column);
                        writer.write("Tail " + c.getRow() + " " + c.getColumn() + "\n");
                        // System.out.println("Tail " + c.row + " " + c.column);
                        break;
                    case (3):
                        // writer.println("Head " + c.row + " " + c.column);
                        writer.write("Head " + c.getRow() + " " + c.getColumn() + "\n");
                       // System.out.println("Head " + c.row + " " + c.column);
                        break;
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
