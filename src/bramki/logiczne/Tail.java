package bramki.logiczne;

import silnik.Cell;
import silnik.Map;

public class Tail {

    public static void setTail(Map m, int row, int column) {
        for (Cell c : m) {
            if (c.getRow() == row && c.getColumn() == column) {
                c.setTail();
            }
        }
    }
}
