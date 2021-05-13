package bramki.logiczne.odwróconeDoDołu;

import bramki.logiczne.FlipFlopGate;
import silnik.Cell;
import silnik.Map;

public class FlipFlopD extends FlipFlopGate {

    public FlipFlopD(Map mapa) {
        super(mapa);
    }

    @Override
    public void metodaRobocza(Cell c){
        this.x = c.column;
        this.y = c.row;
    }
}
