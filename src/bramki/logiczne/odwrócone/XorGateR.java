package bramki.logiczne.odwrócone;

import bramki.logiczne.XorGate;
import silnik.Cell;
import silnik.Map;

public class XorGateR extends XorGate {
    public XorGateR(Map mapa) {
        super(mapa);
    }
    @Override
    public void metodaRobocza(Cell c){
        this.x = c.column;
        this.y = c.row;
    }
}
