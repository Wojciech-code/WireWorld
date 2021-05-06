package bramki.logiczne.odwrócone;

import bramki.logiczne.OrGate;
import silnik.Cell;
import silnik.Map;

public class OrGateR extends OrGate {
    public OrGateR(Map mapa) {
        super(mapa);
    }
    @Override
    public void metodaRobocza(Cell c){
        this.x = c.column;
        this.y = c.row;
    }
}
