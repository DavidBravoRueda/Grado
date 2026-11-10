package Ej1;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class json {

    public static void main(String[] args) {
        JSONArray studentArray = new JSONArray();

        JSONObject student1 = new JSONObject();
        student1.put("Name", "Kotte");
        student1.put("College", "BVRIT");
        student1.put("Branch", "Computer Science Engineering");
        student1.put("Section", "CSE_C");

        studentArray.add(student1);

        JSONObject student2 = new JSONObject();
        student2.put("Name", "Saikiran");
        student2.put("College", "BVRIT");
        student2.put("Branch", "Computer Science Engineering");
        student2.put("Section", "CSE_C");

        studentArray.add(student2);

        System.out.println(studentArray.toJSONString());

        try (FileWriter file = new FileWriter("/Users/davidbravorueda/eclipse-workspace/Json1/students.json")) {
            file.write(studentArray.toJSONString());
            file.flush();
            System.out.println("Archivo JSON creado: students.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
