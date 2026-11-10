package Ej;

import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String cadenaJson = "["
                          + "{\"Marca\" : \"Renault\", \"Modelo\" : \"Laguna\", \"Matricula\" : \"3423 HJK\", \"Energía\" : \"Diesel\"},"
                          + "{\"Marca\" : \"Tesla\", \"Modelo\" : \"Model3\", \"Matricula\" : \"1245 MML\", \"Energía\" : \"Eléctrico\"},"
                          + "{\"Marca\" : \"Lexus\", \"Modelo\" : \"Niagara\", \"Matricula\" : \"4567 Mjk\", \"Energía\" : \"Eléctrico\"}"
                          + "]";

        JSONArray arregloJson = new JSONArray(cadenaJson);

        ArrayList<Vehiculo> vehiculos = new ArrayList<>();

        for (int indice = 0; indice < arregloJson.length(); indice++) {
            JSONObject posibleVehiculo = arregloJson.getJSONObject(indice);

            String marca = posibleVehiculo.getString("Marca");
            String modelo = posibleVehiculo.getString("Modelo");
            String matricula = posibleVehiculo.getString("Matricula");
            String energia = posibleVehiculo.getString("Energía");

            Vehiculo vehiculo = new Vehiculo(marca, modelo, matricula, energia);
            
            vehiculos.add(vehiculo);
        }

        for (Vehiculo vehiculo : vehiculos) {
            System.out.println(vehiculo);
        }
    }
}
