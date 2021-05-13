package bramki.logiczne.odwróconeDoDołu;

import bramki.logiczne.OrGate;
import silnik.Cell;
import silnik.Map;

public class OrGateD extends OrGate {
    public OrGateD(Map mapa) {
        super(mapa);
    }
    @Override
    public void metodaRobocza(Cell c){
        this.x = c.column;
        this.y = c.row;
    }
}
