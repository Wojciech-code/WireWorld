package silnik;

public class Rules {

    public static void countNeigh(Cell c, Map m){ //count heads
        c.numberOfHeads = 0;
        for(Cell e : m){
            if(e.row == c.row-1 && ( e.column == c.column-1 || e.column == c.column || e.column == c.column+1 )){
                if(e.state == 3)
                    c.numberOfHeads++;
            }else if(e.row == c.row && ( e.column == c.column-1 || e.column == c.column+1 )){
                if(e.state == 3)
                    c.numberOfHeads++;
            }else if(e.row == c.row+1 && ( e.column == c.column-1 || e.column == c.column || e.column == c.column+1 )){
                if(e.state == 3)
                    c.numberOfHeads++;
            }
        }

    }

    public static void changeState(Cell c) {

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
