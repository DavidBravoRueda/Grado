package Ej;

public class Vehiculo {
    private String marca;
    private String modelo;
    private String matricula;
    private String energia;

    public Vehiculo(String marca, String modelo, String matricula, String energia) {
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.energia = energia;
    }

    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public String getMatricula() { return matricula; }
    public String getEnergia() { return energia; }

    public void setMarca(String marca) { this.marca = marca; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public void setMatricula(String matricula) { this.matricula = matricula; }
    public void setEnergia(String energia) { this.energia = energia; }

    @Override
    public String toString() {
        return String.format("Vehiculo { Marca: %s, Modelo: %s, Matricula: %s, Energía: %s }", marca, modelo, matricula, energia);
    }
}

