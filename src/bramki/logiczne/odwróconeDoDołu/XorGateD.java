package bramki.logiczne.odwróconeDoDołu;

import bramki.logiczne.XorGate;
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
