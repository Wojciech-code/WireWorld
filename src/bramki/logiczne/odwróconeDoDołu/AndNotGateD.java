package bramki.logiczne.odwróconeDoDołu;

import bramki.logiczne.AndNotGate;
import silnik.Cell;
import silnik.Map;

public class AndNotGateD extends AndNotGate {
    public AndNotGateD(Map mapa) {
        super(mapa);
    }
    @Override
    public void metodaRobocza(Cell c){
        this.x = c.column;
        this.y = c.row;
    }
}
