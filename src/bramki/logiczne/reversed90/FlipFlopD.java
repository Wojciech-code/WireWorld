package bramki.logiczne.reversed90;

import bramki.logiczne.normal.FlipFlopGate;
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
