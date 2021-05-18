package silnik;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Map implements Iterable<Cell> {

    public int rows;
    public int columns;

    public List<Cell> mapa;

    {
        mapa = new ArrayList<Cell>();
    }

    public Map(int rows, int columns){
        this.rows = rows;
        this.columns = columns;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                Cell c = new Cell(i, j);
                addCell(c);
            }
        }

    }

    private void addCell(Cell c){
        mapa.add(c);
    }

    public void update(){
        for(Cell c : mapa){
            Rules.countNeigh(c, this);
        }
        for(Cell c : mapa){
            Rules.changeState(c);
        }
    }


    public void iterate(int n){
        for(int i = 0; i < n; i++){
            update();
        }
    }

    public void draw(){
        int n = 0;
        for (Cell c : mapa) {
            System.out.print(c + " ");
            if (n++ == columns - 1) {
                System.out.println();
                n = 0;
            }
        }
        System.out.println(" ");
    }

    @Override
    public Iterator<Cell> iterator() {
        return new CellIterator((ArrayList<Cell>) mapa);
    }
}
