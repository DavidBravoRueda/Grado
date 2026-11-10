package JavaIOUtils;

import java.io.*;

public class JavaIOUtils {

    public boolean createFile(String filePath, String fileName){
        boolean result;
        File newFile = new File(filePath, fileName);
        if ((result = !newFile.exists())){
            try {
                result = newFile.createNewFile();
                System.out.println("Fichero creado: " + newFile.getAbsolutePath());
            } catch (IOException ex) {
                result = false;
                System.out.println("File create exception (Excepción al crear el fichero): \n     " + ex);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        JavaIOUtils ioUtils = new JavaIOUtils();
        String filePath = "/Users/davidbravorueda/Documents";

        ioUtils.createFile(filePath, "Fichero1.txt");
        ioUtils.createFile(filePath, "Fichero2.txt");
        ioUtils.createFile(filePath, "Fichero3.txt");
        ioUtils.createFile(filePath, "Fichero4.txt");

        try {
            BufferedWriter bw1 = new BufferedWriter(new FileWriter(filePath + "/Fichero1.txt"));
            bw1.write("Tanto monta");
            bw1.close();

            BufferedWriter bw2 = new BufferedWriter(new FileWriter(filePath + "/Fichero2.txt"));
            bw2.write("Monta tanto");
            bw2.close();

            BufferedWriter bw3 = new BufferedWriter(new FileWriter(filePath + "/Fichero3.txt"));
            bw3.write("Isabel como Fernando");
            bw3.close();

            BufferedReader br1 = new BufferedReader(new FileReader(filePath + "/Fichero1.txt"));
            String s1 = br1.readLine();
            br1.close();

            BufferedReader br2 = new BufferedReader(new FileReader(filePath + "/Fichero2.txt"));
            String s2 = br2.readLine();
            br2.close();

            BufferedReader br3 = new BufferedReader(new FileReader(filePath + "/Fichero3.txt"));
            String s3 = br3.readLine();
            br3.close();

            BufferedWriter bw4 = new BufferedWriter(new FileWriter(filePath + "/Fichero4.txt"));
            bw4.write(s1 + ", " + s2 + ", " + s3);
            bw4.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}