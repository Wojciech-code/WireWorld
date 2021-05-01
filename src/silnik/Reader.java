package silnik;

import bramki.logiczne.*;

import java.io.*;

public class Reader {

    public Map m;
    String filepath;

   public void setFilepath(String filepath){
       this.filepath = filepath;
   }

    public void read(){
        try {
            File f = new File(filepath);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line;
            line = br.readLine();
            String[] s;
            s = line.split("\\s+");
             m = new Map(Integer.parseInt(s[0]), Integer.parseInt(s[1]));

            while((line=br.readLine()) != null ){
                s = line.split("\\s+");
                int row = Integer.parseInt(s[1]);
                int column = Integer.parseInt(s[2]);

                if(s[0].equals("Diode")){
                    Gate d = new Diode();
                    d.setGate(m, row, column);
                }else if(s[0].equals("Head")){
                    Head.setHead(m, row, column);
                }else if(s[0].equals("Tail")){
                    Tail.setTail(m, row, column);
                }else if(s[0].equals("Conductor")){
                    Conductor.setConductor(m, row, column);
                }
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Map setMap(){
       return this.m;
    }


}
