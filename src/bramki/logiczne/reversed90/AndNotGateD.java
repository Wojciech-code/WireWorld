package bramki.logiczne.reversed90;

import bramki.logiczne.normal.AndNotGate;
import silnik.Cell;
import silnik.Map;

public class AndNotGateD extends AndNotGate {
    public AndNotGateD(Map mapa) {
        super(mapa);
    }
    @Override
    public void metodaRobocza(Cell c){
        this.x = c.getColumn();
        this.y = c.getRow();
    }
}
