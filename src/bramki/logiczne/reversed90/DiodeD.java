package bramki.logiczne.reversed90;

import bramki.logiczne.normal.Diode;
import silnik.Cell;
import silnik.Map;

public class DiodeD extends Diode {

    public DiodeD(Map mapa) {
        super(mapa);
    }

    @Override
    public void metodaRobocza(Cell c){
        this.x = c.getColumn();
        this.y = c.getRow();
    }

}
