package bramki.logiczne.reversed90;

import bramki.logiczne.normal.XorGate;
import silnik.Cell;
import silnik.Map;

public class XorGateD extends XorGate {
    public XorGateD(Map mapa) {
        super(mapa);
    }
    @Override
    public void metodaRobocza(Cell c){
        this.x = c.column;
        this.y = c.row;
    }
}
