package bramki.logiczne;

import silnik.Cell;
import silnik.Map;

public abstract class Gate {

    public Map mapa;
    public int x,y;

    public void metodaRobocza(Cell c){
        this.x = c.row;
        this.y = c.column;
    }

      public Gate(Map mapa){
        this.mapa = mapa;
    }

    public abstract void setGate(int row, int column);
}
