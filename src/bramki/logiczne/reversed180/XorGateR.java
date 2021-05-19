package bramki.logiczne.reversed180;

import bramki.logiczne.Gate;
import silnik.Cell;
import silnik.Map;

public class XorGateR extends Gate {

    public XorGateR(Map mapa) {
        super(mapa);
    }


    @Override
    public void setGate(int row, int column) {

        for(Cell c : mapa){
            metodaRobocza(c);
            if(( x == row && y == column) ||
                    ( x == row && y == column-1) ||
                    ( x == row && y == column-2) ||

                    ( x == row+1 && y == column-3) ||

                    ( x == row+2 && y == column-2) ||
                    ( x == row+2 && y == column-3) ||
                    ( x == row+2 && y == column-4) ||
                    ( x == row+2 && y == column-5) ||

                    ( x == row+3 && y == column-2) ||

                    ( x == row+3 && y == column-5) ||
                    ( x == row+3 && y == column-6) ||
                    ( x == row+3 && y == column-7) ||
                    ( x == row+3 && y == column-8) ||

                    ( x == row+4 && y == column-2) ||
                    ( x == row+4 && y == column-3) ||
                    ( x == row+4 && y == column-4) ||
                    ( x == row+4 && y == column-5) ||

                    ( x == row+5 && y == column-3) ||

                    ( x == row+6 && y == column) ||
                    ( x == row+6 && y == column-1) ||
                    ( x == row+6 && y == column-2))

            {
                c.setConductor();
            }

        }
    }
}
