package bramki.logiczne.normal;

import bramki.logiczne.Gate;
import silnik.Cell;
import silnik.Map;

public class Diode extends Gate {


    public Diode(Map mapa) {
        super(mapa);
    }


    @Override
    public void setGate( int row, int column) {

        for(Cell c : mapa){
            metodaRobocza(c);

            if(( x == row && y == column) ||
                    ( x == row && y == column+1) ||
                    ( x == row && y == column+2) ||
                    ( x == row && y == column+3) ||
                    ( x == row-1 && y == column+3) ||
                    ( x == row-1 && y == column+4) ||
                    ( x == row+1 && y == column+3) ||
                    ( x == row+1 && y == column+4) ||
                    ( x == row && y == column+5) ||
                    ( x == row && y == column+6) ||
                    ( x == row && y == column+7) )
            {
                c.setConductor();
                c.setGate();
            }

        }
    }
}
