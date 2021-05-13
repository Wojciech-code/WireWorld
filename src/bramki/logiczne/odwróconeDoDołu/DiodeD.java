package bramki.logiczne.odwróconeDoDołu;

import bramki.logiczne.Diode;
import silnik.Cell;
import silnik.Map;

public class DiodeD extends Diode {

    public DiodeD(Map mapa) {
        super(mapa);
    }

    @Override
    public void metodaRobocza(Cell c){
        this.x = c.column;
        this.y = c.row;
    }

}
