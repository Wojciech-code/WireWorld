package silnik;

public class Testowa2 {

    public static void main(String [] args){

        Reader r = new Reader();
        r.setFilepath("C:\\Users\\wojte\\IdeaProjects\\wireworld\\testdata\\dane1.txt");
        r.read();
        Map m = r.setMap();
        m.iterate(5);
    }
}
