package Presentacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaDetallesLibro extends JFrame {

    // Método constructor
    public PantallaDetallesLibro(String tituloLibro) {
        // Configuración de la ventana
        setTitle("Detalles del Libro - Biblioteca App");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar en la pantalla

        // Simulación de datos del libro (puedes reemplazarlo con datos reales obtenidos de la base de datos)
        String autor = "Autor del libro";
        String categoria = "Categoría del libro";
        int numPaginas = 200;
        boolean disponible = true; // Indica si el libro está disponible para préstamo o no

        // Crear componentes
        JLabel lblTitulo = new JLabel("Detalles del Libro");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        JLabel lblTituloLibro = new JLabel("Título: " + tituloLibro);
        JLabel lblAutor = new JLabel("Autor: " + autor);
        JLabel lblCategoria = new JLabel("Categoría: " + categoria);
        JLabel lblNumPaginas = new JLabel("Número de Páginas: " + numPaginas);
        JLabel lblDisponible = new JLabel("Disponible: " + (disponible ? "Sí" : "No"));
        JButton btnCerrar = new JButton("Cerrar");

        // Configurar el diseño de la ventana
        setLayout(new GridLayout(6, 1, 10, 10)); // Seis filas, una columna

        // Añadir componentes a la ventana
        add(lblTitulo);
        add(lblTituloLibro);
        add(lblAutor);
        add(lblCategoria);
        add(lblNumPaginas);
        add(lblDisponible);
        add(btnCerrar);

        // Manejar eventos del botón de cerrar
        btnCerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cerrar la pantalla de detalles del libro
                dispose();
            }
        });
    }

    // Método principal para probar la pantalla
    public static void main(String[] args) {
        // Crear y mostrar la pantalla de detalles del libro con un título de ejemplo
        PantallaDetallesLibro pantallaDetalles = new PantallaDetallesLibro("El Señor de los Anillos");
        pantallaDetalles.setVisible(true);
    }
}
