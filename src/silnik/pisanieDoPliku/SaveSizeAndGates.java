package silnik.pisanieDoPliku;

import java.io.*;

public class SaveSizeAndGates {

    public void saveSizeAndGates(File z,String st) {
        try {
            //PrintWriter writer = new PrintWriter(zapis);
            FileWriter writer = new FileWriter(z);
            File f = new File(st);//"C:\\Users\\ksmol\\Documents\\Dane1.txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line;
            line = br.readLine();
            String[] s;
            s = line.split("\\s+");

            //writer.println(s[0] + " " + s[1]);
            writer.write(s[0] + "\n");
            while ((line = br.readLine()) != null) {
                s = line.split("\\s+");
                int row = Integer.parseInt(s[1]);
                int column = Integer.parseInt(s[2]);

                if (s[0].equals("Diode")) {
                    // writer.println("Diode " + row + " " + column);
                    writer.write("Diode " + row + " " + column + "\n");
                } else if (s[0].equals("OrGate")) {
                    //  writer.println("OrGate " + row + " " + column);
                    writer.write("OrGate " + row + " " + column + "\n");
                } else if (s[0].equals("XorGate")) {
                    //  writer.println("XorGate " + row + " " + column);
                    writer.write("XorGate " + row + " " + column + "\n");
                } else if (s[0].equals("AndNotGate")) {
                    // writer.println("AndNotGate " +row + " " + column);
                    writer.write("AndNotGate " + row + " " + column + "\n");
                } else if (s[0].equals("FlipFlopGate")) {
                    // writer.println("FlipFlopGate " + row + " " + column);
                    writer.write("FlipFlopGate " + row + " " + column + "\n");
                } else if (s[0].equals("Conductor")) {
                    // writer.println("FlipFlopGate " + row + " " + column);
                    writer.write("Conductor " + row + " " + column + "\n");
                }

            }
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
