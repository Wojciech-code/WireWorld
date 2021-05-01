package silnik;

import java.util.ArrayList;
import java.util.Iterator;

public class CellIterator implements Iterator<Cell> {

    private Cell [] t;
    private int current = 0;
    private int size;
    private Map m;
    private ArrayList<Cell> mapa;

    public CellIterator(ArrayList<Cell> mapa){
        this.mapa = mapa;

    }

    @Override
    public boolean hasNext() {
       return current < mapa.size();
    }

    @Override
    public Cell next() {
        return mapa.get(current++);
    }
}
