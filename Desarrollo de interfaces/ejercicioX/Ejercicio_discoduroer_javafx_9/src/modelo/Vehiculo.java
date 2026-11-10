/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import conexiondb.ConexionMySQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author davidbravorueda
 */
public class Vehiculo {
    private String matricula;
    private String descripcion;
    private String marca;
    private int km;
    private int precio;

    public Vehiculo() {
    }

    public Vehiculo(String matricula, String descripcion, String marca, int km, int precio) {
        this.matricula = matricula;
        this.descripcion = descripcion;
        this.marca = marca;
        this.km = km;
        this.precio = precio;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return matricula;
    }

    public ObservableList<Vehiculo> getVehiculos() {
        ObservableList<Vehiculo> obs = FXCollections.observableArrayList();
        try {

            ConexionMySQL conexion = new ConexionMySQL("127.0.0.1", "alquiler_vehiculos", "root", "david1287");

            conexion.ejecutarConsulta("select * from vehiculos");

            ResultSet rs = conexion.getResultSet();
            
            while(rs.next()){
                
                String matricula = rs.getString("matricula");
                String descripcion = rs.getString("descripcion");
                String marca = rs.getString("marca");
                int km = rs.getInt("kilometros");
                int precio = rs.getInt("precio");
                
                Vehiculo v = new Vehiculo(matricula, descripcion, marca, km, precio);
                
                obs.add(v);
                
            }
            
            
            conexion.cerrarConexion();
            

        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obs;
    }
}
