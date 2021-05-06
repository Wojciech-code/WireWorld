package bramki.logiczne.odwrócone;

import bramki.logiczne.Diode;
import silnik.Cell;
import silnik.Map;

public class DiodeR extends Diode {

    public DiodeR(Map mapa) {
        super(mapa);
    }

    @Override
    public void metodaRobocza(Cell c){
        this.x = c.column;
        this.y = c.row;
    }

}
