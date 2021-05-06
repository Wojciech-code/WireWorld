package bramki.logiczne.odwrócone;

import bramki.logiczne.AndNotGate;
import silnik.Cell;
import silnik.Map;

public class AndNotGateR extends AndNotGate {
    public AndNotGateR(Map mapa) {
        super(mapa);
    }
    @Override
    public void metodaRobocza(Cell c){
        this.x = c.column;
        this.y = c.row;
    }
}
