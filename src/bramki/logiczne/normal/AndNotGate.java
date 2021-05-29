package bramki.logiczne.normal;

import bramki.logiczne.Gate;
import silnik.Cell;
import silnik.Map;

public class AndNotGate extends Gate {


    public AndNotGate(Map mapa) {
        super(mapa);
    }

    @Override
    public void setGate(int row, int column) {

        for(Cell c : mapa){

            metodaRobocza(c);
            if(( x == row && y == column) ||
                    ( x == row && y == column+1) ||
                    ( x == row && y == column+2) ||
                    ( x == row && y == column+3) ||

                    ( x == row+1 && y == column+4) ||

                    ( x == row+2 && y == column+3) ||
                    ( x == row+2 && y == column+4) ||
                    ( x == row+2 && y == column+5) ||

                    ( x == row+3 && y == column+4) ||

                    ( x == row+4 && y == column+3) ||
                    ( x == row+4 && y == column+5) ||
                    ( x == row+4 && y == column+6) ||
                    ( x == row+4 && y == column+7) ||

                    ( x == row+5 && y == column+3) ||

                    ( x == row+6 && y == column+3) ||



                    ( x == row+7 && y == column) ||
                    ( x == row+7 && y == column+1) ||
                    ( x == row+7 && y == column+2))
            {
                c.setConductor();
                c.setGate();
            }

        }
    }
}
