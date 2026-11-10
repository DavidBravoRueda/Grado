package JavaIOUtils;

import java.io.FileWriter;
import java.io.IOException;

public class Extención4 {

    public static void main(String[] args) {
        String filePath = "/Users/davidbravorueda/Documents/Fichero4.txt";
        String s = "Reyes de Castilla y Aragón,\n y, creadores del primer Estado moderno de Europa.";

        try {
            FileWriter fw = new FileWriter(filePath, true);
            fw.write(s);
            fw.close();
            System.out.println("Texto añadido a: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

