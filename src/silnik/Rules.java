package silnik;

public class Rules {

    protected static void countNeigh(Cell c, Map m){ //count heads
        c.numberOfHeads = 0;
        for(Cell e : m){
            if(e.getRow() == c.getRow()-1 && ( e.getColumn() == c.getColumn()-1 || e.getColumn() == c.getColumn() || e.getColumn() == c.getColumn()+1 )){
                if(e.getState() == 3)
                    c.numberOfHeads++;
            }else if(e.getRow() == c.getRow() && ( e.getColumn() == c.getColumn()-1 || e.getColumn() == c.getColumn()+1 )){
                if(e.getState() == 3)
                    c.numberOfHeads++;
            }else if(e.getRow() == c.getRow()+1 && ( e.getColumn() == c.getColumn()-1 || e.getColumn() == c.getColumn() || e.getColumn() == c.getColumn()+1 )){
                if(e.getState() == 3)
                    c.numberOfHeads++;
            }
        }

    }

    protected static void changeState(Cell c) {

        switch (c.getState()){

            case(0):
                break;

            case(1):
                if(c.numberOfHeads == 1 || c.numberOfHeads == 2)
                   c.setHead();
                break;

            case(2):
                c.setConductor();
                break;

            case(3):
                c.setTail();
                break;

        }
    }
}
