package Ej;

import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;

public class Main2 {
    public static void main(String[] args) {
    	
        String cadenaJson = "[{\"nombre\":\"Maggie\",\"edad\":3},"
                          + "{\"nombre\":\"Snowball\",\"edad\":1},"
                          + "{\"nombre\":\"Bichi\",\"edad\":1},"
                          + "{\"nombre\":\"Meca\",\"edad\":5}]";

        JSONArray arregloJson = new JSONArray(cadenaJson);

        ArrayList<Mascota> mascotas = new ArrayList<>();

        for (int indice = 0; indice < arregloJson.length(); indice++) {
            JSONObject posibleMascota = arregloJson.getJSONObject(indice);
            int edad = posibleMascota.getInt("edad");
            String nombre = posibleMascota.getString("nombre");

            Mascota mascota = new Mascota(nombre, edad);
            mascota.ladrar();

            mascotas.add(mascota);
        }

        for (Mascota mascota : mascotas) {
            System.out.println("Nombre de mascota: " + mascota.getNombre());
        }
    }
}
