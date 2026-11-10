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
       setLocationRelativeTo(null); 
       // Crear componentes
       JLabel lblTitulo = new JLabel("¡Bienvenido a Biblioteca App!");
       lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
       JButton btnBuscarLibros = new JButton("Buscar Libros");
       JButton btnGestionUsuarios = new JButton("Gestionar Usuarios");
       JButton btnGestionLibros = new JButton("Gestionar Libros");
       JButton btnPrestamos = new JButton("Gestionar Préstamos");
       // Configurar el diseño de la ventana
       setLayout(new GridLayout(6, 1, 10, 10)); 
       // Añadir componentes a la ventana
       add(lblTitulo);
       add(btnBuscarLibros);
       add(btnGestionUsuarios);
       add(btnGestionLibros);
       add(btnPrestamos);
       // Manejar eventos de los botones
       btnBuscarLibros.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               abrirPantallaBusquedaLibros();
           }
       });
       btnGestionUsuarios.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               abrirPantallaGestionUsuarios();
           }
       });
       btnGestionLibros.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               abrirPantallaGestionLibros();
           }
       });
       btnPrestamos.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               abrirPantallaPrestamos();
           }
       });
   }
   // Método para abrir la pantalla de búsqueda de libros
   private void abrirPantallaBusquedaLibros() {
       try {
           // Establecer conexión a la base de datos
           Connection conexion = ConexionBD.obtenerConexion();
           // Abrir la pantalla de búsqueda de libros con la conexión
           PantallaBusquedaLibros pantallaBusqueda = new PantallaBusquedaLibros(conexion);
           pantallaBusqueda.setVisible(true);
           dispose(); 
       } catch (SQLException ex) {
           ex.printStackTrace();
           JOptionPane.showMessageDialog(this, "Error al conectar con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
       }
   }
   // Método para abrir la pantalla de gestión de usuarios
   private void abrirPantallaGestionUsuarios() {
       try {
           // Establecer conexión a la base de datos
           Connection conexion = ConexionBD.obtenerConexion();
           // Abrir la pantalla de gestión de usuarios con la conexión
           PantallaGestionUsuarios pantallaUsuarios = new PantallaGestionUsuarios(conexion);
           pantallaUsuarios.setVisible(true);
           dispose(); 
       } catch (SQLException ex) {
           ex.printStackTrace();
           JOptionPane.showMessageDialog(this, "Error al conectar con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
       }
   }
   // Método para abrir la pantalla de gestión de libros
   private void abrirPantallaGestionLibros() {
       try {
           Connection conexion = ConexionBD.obtenerConexion();
           PantallaGestionLibros pantallaLibros = new PantallaGestionLibros(conexion);
           pantallaLibros.setVisible(true);
           dispose(); 
       } catch (SQLException ex) {
           ex.printStackTrace();
           JOptionPane.showMessageDialog(this, "Error al conectar con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
       }
   }
   // Método para abrir la pantalla de gestión de préstamos
   private void abrirPantallaPrestamos() {
       try {
           Connection conexion = ConexionBD.obtenerConexion();
           PantallaPrestamos pantallaPrestamos = new PantallaPrestamos(conexion);
           pantallaPrestamos.setVisible(true);
           dispose(); 
       } catch (SQLException ex) {
           ex.printStackTrace();
           JOptionPane.showMessageDialog(this, "Error al conectar con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
       }
   }
   public static void main(String[] args) {
       // Crear y mostrar la pantalla de inicio
       PantallaInicio pantallaInicio = new PantallaInicio();
       pantallaInicio.setVisible(true);
   }
}
