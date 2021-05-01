package bramki.logiczne;

import silnik.Cell;
import silnik.Map;

public class Diode implements Gate{


    @Override
    public void setGate(Map m, int row, int column) {

        for(Cell c : m){

            if(( c.row == row && c.column == column) ||
                    ( c.row == row && c.column == column+1) ||
                    ( c.row == row && c.column == column+2) ||
                    ( c.row == row && c.column == column+3) ||
                    ( c.row == row-1 && c.column == column+3) ||
                    ( c.row == row-1 && c.column == column+4) ||
                    ( c.row == row+1 && c.column == column+3) ||
                    ( c.row == row+1 && c.column == column+4) ||
                    ( c.row == row && c.column == column+5) ||
                    ( c.row == row && c.column == column+6) ||
                    ( c.row == row && c.column == column+7) )
            {
                c.setConductor();
            }

        }
    }
}
