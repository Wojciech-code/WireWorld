package bramki.logiczne;

import silnik.Cell;
import silnik.Map;

public class Head {

    public static void setHead(Map m, int row, int column) {
        for (Cell c : m) {
            if (c.row == row && c.column == column) {
                c.setHead();
            }
        }
    }

}
