package bramki.logiczne.odwrócone;

import bramki.logiczne.FlipFlopGate;
import silnik.Cell;
import silnik.Map;

public class FlipFlopR extends FlipFlopGate {

    public FlipFlopR(Map mapa) {
        super(mapa);
    }

    @Override
    public void metodaRobocza(Cell c){
        this.x = c.column;
        this.y = c.row;
    }
}
