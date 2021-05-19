package silnik.pisanieDoPliku;

import bramki.logiczne.Gate;
import bramki.logiczne.normal.Diode;
import bramki.logiczne.reversed180.DiodeR;
import bramki.logiczne.reversed90.DiodeD;

import java.io.*;

public class SaveSizeAndGates {

    public void saveSizeAndGates(File z, String st) {
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
                    if (s[3].equals("Down")) {
                        writer.write("Diode " + row + " " + column + " Down" + "\n");
                    } else if (s[3].equals("Reversed")) {
                        writer.write("Diode " + row + " " + column + " Reversed" + "\n");
                    } else if (s[3].equals("Normal")) {
                        writer.write("Diode " + row + " " + column + " Normal" + "\n");
                    }
                }
                if (s[0].equals("OrGate")) {
                    if (s[3].equals("Down")) {
                        writer.write("OrGate " + row + " " + column + " Down" + "\n");
                    } else if (s[3].equals("Reversed")) {
                        writer.write("OrGate " + row + " " + column + " Reversed" + "\n");
                    }else if (s[3].equals("Normal")) {
                        writer.write("OrGate " + row + " " + column + " Normal" + "\n");
                    }
                }
                if (s[0].equals("XorGate")) {
                    if (s[3].equals("Down")) {
                        writer.write("XorGate " + row + " " + column + " Down" + "\n");
                    } else if (s[3].equals("Reversed")) {
                        writer.write("XorGate " + row + " " + column + " Reversed" + "\n");
                    }else if (s[3].equals("Normal")) {
                        writer.write("XorGate " + row + " " + column + " Normal" + "\n");
                    }
                }
                if (s[0].equals("AndNotGate")) {
                    if (s[3].equals("Down")) {
                        writer.write("AndNotGate " + row + " " + column + " Down" + "\n");
                    } else if (s[3].equals("Reversed")) {
                        writer.write("AndNotGate " + row + " " + column + " Reversed" + "\n");
                    }else if (s[3].equals("Normal")) {
                        writer.write("AndNotGate " + row + " " + column + " Normal" + "\n");
                    }
                }
                if (s[0].equals("FlipFlopGate")) {
                    if (s[3].equals("Down")) {
                        writer.write("FlipFlopGate " + row + " " + column + " Down" + "\n");
                    } else if (s[3].equals("Reversed")) {
                        writer.write("FlipFlopGate " + row + " " + column + " Reversed" + "\n");
                    }else if (s[3].equals("Normal")) {
                        writer.write("FlipFlopGate " + row + " " + column + " Normal" + "\n");
                    }
                }
                if (s[0].equals("Conductor")) {
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
