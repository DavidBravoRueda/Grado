package Ej;

import org.json.JSONObject;

public class Main1 {
    public static void main(String[] args) {
    	
        String cadenaJson = "{\"nombre\":\"Maggie\",\"edad\":3}";

        JSONObject objetoJson = new JSONObject(cadenaJson);

        int edad = objetoJson.getInt("edad");
        String nombre = objetoJson.getString("nombre");

        Mascota mascota = new Mascota(nombre, edad);
       
        mascota.ladrar();
    }
}
