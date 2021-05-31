package bramki.logiczne;

import silnik.Cell;
import silnik.Map;

public class Empty {

    public static void setEmpty(Map m, int row, int column) {
        for (Cell c : m) {
            if (c.getRow() == row && c.getColumn() == column) {
                c.setEmpty();
            }
        }
    }

}
