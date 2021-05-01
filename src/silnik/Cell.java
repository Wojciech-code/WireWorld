package silnik;

/* EMPTY 0
   CONDUCTOR 1
   TAIL 2
   HEAD 3
 */

public class Cell {

    public int row;
    public int column;
    int state;
    int numberOfHeads;

    public Cell(int row, int column){
        this.row = row;
        this.column = column;
        this.state = 0;
    }

    public void setHead(){
        this.state = 3;
    }

    public void setTail(){
        this.state = 2;
    }

    public void setConductor(){
        this.state = 1;
    }

    public void setEmpty(){
        this.state = 0;
    }

    public int getState(){
        return this.state;
    }

    public String toString(){
        return String.valueOf(state);
    }
}
