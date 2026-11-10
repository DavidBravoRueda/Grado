package Presentacion;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PantallaListaReservas extends JFrame {

    // Método constructor
    public PantallaListaReservas(ArrayList<String> reservas) {
        // Configuración de la ventana
        setTitle("Lista de Reservas - Biblioteca App");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar en la pantalla

        // Crear componentes
        JLabel lblTitulo = new JLabel("Lista de Reservas");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        JTextArea txtAreaReservas = new JTextArea();
        txtAreaReservas.setEditable(false); // Para evitar edición del texto
        JScrollPane scrollPane = new JScrollPane(txtAreaReservas);
        JButton btnCerrar = new JButton("Cerrar");

        // Configurar el diseño de la ventana
        setLayout(new BorderLayout()); // Distribución de tipo BorderLayout

        // Añadir componentes a la ventana
        add(lblTitulo, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(btnCerrar, BorderLayout.SOUTH);

        // Llenar el área de texto con las reservas
        for (String reserva : reservas) {
            txtAreaReservas.append(reserva + "\n");
        }

        // Manejar eventos del botón de cerrar
        btnCerrar.addActionListener(e -> {
            // Cerrar la pantalla de lista de reservas
            dispose();
        });
    }

    // Método principal para probar la pantalla
    public static void main(String[] args) {
        // Crear una lista de reservas de ejemplo
        ArrayList<String> reservas = new ArrayList<>();
        reservas.add("1. El Señor de los Anillos - 01/05/2024");
        reservas.add("2. Harry Potter - 05/05/2024");
        reservas.add("3. Don Quijote de la Mancha - 10/05/2024");

        // Crear y mostrar la pantalla de lista de reservas
        PantallaListaReservas pantallaListaReservas = new PantallaListaReservas(reservas);
        pantallaListaReservas.setVisible(true);
    }
}
