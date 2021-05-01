package bramki.logiczne;

import silnik.Cell;
import silnik.Map;

public class Conductor {
    public static void setConductor(Map m, int row, int column) {
        for (Cell c : m) {
            if (c.row == row && c.column == column) {
                c.setConductor();
            }
        }
    }
}
