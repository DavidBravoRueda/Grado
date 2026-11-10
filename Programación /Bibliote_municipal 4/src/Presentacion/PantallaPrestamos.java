package Presentacion;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PantallaPrestamos extends JFrame {

    // Método constructor
    public PantallaPrestamos(ArrayList<String> prestamos) {
        // Configuración de la ventana
        setTitle("Préstamos Realizados - Biblioteca App");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar en la pantalla

        // Crear componentes
        JLabel lblTitulo = new JLabel("Préstamos Realizados");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        JTextArea txtAreaPrestamos = new JTextArea();
        txtAreaPrestamos.setEditable(false); // Para evitar edición del texto
        JScrollPane scrollPane = new JScrollPane(txtAreaPrestamos);
        JButton btnCerrar = new JButton("Cerrar");

        // Configurar el diseño de la ventana
        setLayout(new BorderLayout()); // Distribución de tipo BorderLayout

        // Añadir componentes a la ventana
        add(lblTitulo, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(btnCerrar, BorderLayout.SOUTH);

        // Llenar el área de texto con los préstamos
        for (String prestamo : prestamos) {
            txtAreaPrestamos.append(prestamo + "\n");
        }

        // Manejar eventos del botón de cerrar
        btnCerrar.addActionListener(e -> {
            // Cerrar la pantalla de préstamos
            dispose();
        });
    }

    // Método principal para probar la pantalla
    public static void main(String[] args) {
        // Crear una lista de préstamos de ejemplo
        ArrayList<String> prestamos = new ArrayList<>();
        prestamos.add("1. El Señor de los Anillos - 01/05/2024 - 10/05/2024");
        prestamos.add("2. Harry Potter - 05/05/2024 - 15/05/2024");
        prestamos.add("3. Don Quijote de la Mancha - 10/05/2024 - 20/05/2024");

        // Crear y mostrar la pantalla de préstamos
        PantallaPrestamos pantallaPrestamos = new PantallaPrestamos(prestamos);
        pantallaPrestamos.setVisible(true);
    }
}
