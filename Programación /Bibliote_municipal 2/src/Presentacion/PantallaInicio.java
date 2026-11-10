package Presentacion;

import Persistencia.ConexionBD;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaInicio extends JFrame {

    public PantallaInicio() {
        // Configuración de la ventana
        setTitle("Inicio - Biblioteca App");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar en la pantalla

        // Crear componentes
        JLabel lblTitulo = new JLabel("¡Bienvenido a Biblioteca App!");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        JButton btnBuscarLibros = new JButton("Buscar Libros");
        JButton btnGestionUsuarios = new JButton("Gestionar Usuarios");
        JButton btnGestionLibros = new JButton("Gestionar Libros");
        JButton btnConfiguracion = new JButton("Configuración");

        // Configurar el diseño de la ventana
        setLayout(new GridLayout(5, 1, 10, 10)); // Cinco filas, una columna

        // Añadir componentes a la ventana
        add(lblTitulo);
        add(btnBuscarLibros);
        add(btnGestionUsuarios);
        add(btnGestionLibros);
        add(btnConfiguracion);

        // Manejar eventos de los botones
        btnBuscarLibros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Establecer conexión a la base de datos
                    Connection conexion = ConexionBD.obtenerConexion();
                    // Abrir la pantalla de búsqueda de libros con la conexión
                    PantallaBusquedaLibros pantallaBusqueda = new PantallaBusquedaLibros(conexion);
                    pantallaBusqueda.setVisible(true);
                    dispose(); // Cerrar la pantalla de inicio
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(PantallaInicio.this, "Error al conectar con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnGestionUsuarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Establecer conexión a la base de datos
                    Connection conexion = ConexionBD.obtenerConexion();
                    // Abrir la pantalla de gestión de usuarios con la conexión
                    PantallaGestionUsuarios pantallaUsuarios = new PantallaGestionUsuarios(conexion);
                    pantallaUsuarios.setVisible(true);
                    dispose(); // Cerrar la pantalla de inicio
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(PantallaInicio.this, "Error al conectar con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnGestionLibros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Establecer conexión a la base de datos
                    Connection conexion = ConexionBD.obtenerConexion();
                    // Abrir la pantalla de gestión de libros con la conexión
                    PantallaGestionLibros pantallaLibros = new PantallaGestionLibros(conexion);
                    pantallaLibros.setVisible(true);
                    dispose(); // Cerrar la pantalla de inicio
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(PantallaInicio.this, "Error al conectar con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnConfiguracion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abrir la pantalla de configuración
                PantallaConfiguracion pantallaConfiguracion = new PantallaConfiguracion();
                pantallaConfiguracion.setVisible(true);
                dispose(); // Cerrar la pantalla de inicio
            }
        });
    }

    public static void main(String[] args) {
        // Crear y mostrar la pantalla de inicio
        PantallaInicio pantallaInicio = new PantallaInicio();
        pantallaInicio.setVisible(true);
    }
}


