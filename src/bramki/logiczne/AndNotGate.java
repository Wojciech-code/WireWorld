package bramki.logiczne;

import silnik.Cell;
import silnik.Map;

public class AndNotGate implements Gate{


    @Override
    public void setGate(Map m, int row, int column) {

        for(Cell c : m){

            if(( c.row == row && c.column == column) ||
                    ( c.row == row && c.column == column+1) ||
                    ( c.row == row && c.column == column+2) ||
                    ( c.row == row && c.column == column+3) ||

                    ( c.row == row+1 && c.column == column+4) ||

                    ( c.row == row+2 && c.column == column+3) ||
                    ( c.row == row+2 && c.column == column+4) ||
                    ( c.row == row+2 && c.column == column+5) ||

                    ( c.row == row+3 && c.column == column+4) ||

                    ( c.row == row+4 && c.column == column+3) ||
                    ( c.row == row+4 && c.column == column+5) ||
                    ( c.row == row+4 && c.column == column+6) ||
                    ( c.row == row+4 && c.column == column+7) ||

                    ( c.row == row+5 && c.column == column+3) ||

                    ( c.row == row+6 && c.column == column+3) ||



                    ( c.row == row+7 && c.column == column) ||
                    ( c.row == row+7 && c.column == column+1) ||
                    ( c.row == row+7 && c.column == column+2))
            {
                c.setConductor();
            }

        }
    }
}
