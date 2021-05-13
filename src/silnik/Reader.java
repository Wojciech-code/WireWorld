package silnik;

import bramki.logiczne.*;
import bramki.logiczne.odwrócone180.AndNotGateR;
import bramki.logiczne.odwrócone180.DiodeR;
import bramki.logiczne.odwróconeDoDołu.*;

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
             m = new Map(Integer.parseInt(s[0]), Integer.parseInt(s[0]));
            while((line=br.readLine()) != null ) {
                s = line.split("\\s+");
                int row = Integer.parseInt(s[1]);
                int column = Integer.parseInt(s[2]);

                if (s[0].equals("Diode")) {
                    Gate d;
                    if(s[3].equals("Normal")) {
                         d = new Diode(m);
                        d.setGate( row, column);
                    }else if(s[3].equals("Down")){
                        row = Integer.parseInt(s[2]);
                        column = Integer.parseInt(s[1]);
                         d = new DiodeD(m);
                        d.setGate( row, column);
                    }else if(s[3].equals("Reversed")){
                        d = new DiodeR(m);
                        d.setGate(row, column);
                    }
                } else if (s[0].equals("Head")) {
                    Head.setHead( m,row, column);
                } else if (s[0].equals("Tail")) {
                    Tail.setTail( m,row, column);
                } else if (s[0].equals("Conductor")) {
                    Conductor.setConductor( m,row, column);
                } else if (s[0].equals("OrGate") ) {
                    Gate d;
                    if(s[3].equals("Normal")) {
                        d = new OrGate(m);
                        d.setGate( row, column);
                    }else if(s[3].equals("Down")){
                        row = Integer.parseInt(s[2]);
                        column = Integer.parseInt(s[1]);
                        d = new OrGateD(m);
                        d.setGate( row, column);
                    }
                } else if (s[0].equals("XorGate")) {
                    Gate d;
                    if(s[3].equals("Normal")) {
                        d = new XorGate(m);
                        d.setGate( row, column);
                    }else if(s[3].equals("Down")){
                        row = Integer.parseInt(s[2]);
                        column = Integer.parseInt(s[1]);
                        d = new XorGateD(m);
                        d.setGate( row, column);
                    }
                } else if (s[0].equals("AndNotGate") ){
                    Gate d;
                    if(s[3].equals("Normal")) {
                        d = new AndNotGate(m);
                        d.setGate( row, column);
                    }else if(s[3].equals("Down")){
                        row = Integer.parseInt(s[2]);
                        column = Integer.parseInt(s[1]);
                        d = new AndNotGateD(m);
                        d.setGate( row, column);
                    }else if(s[3].equals("Reversed")){
                        d = new AndNotGateR(m);
                        d.setGate( row, column);
                    }
                } else if (s[0].equals("FlipFlopGate") ) {
                    Gate d;
                    if(s[3].equals("Normal")) {
                        d = new FlipFlopGate(m);
                        d.setGate( row, column);
                    }else if(s[3].equals("Down")){
                        row = Integer.parseInt(s[2]);
                        column = Integer.parseInt(s[1]);
                        d = new FlipFlopD(m);
                        d.setGate( row, column);
                    }
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
