package Presentacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaReserva extends JFrame {

    // Método constructor
    public PantallaReserva(String tituloLibro) {
        // Configuración de la ventana
        setTitle("Reserva de Libro - Biblioteca App");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar en la pantalla

        // Crear componentes
        JLabel lblTitulo = new JLabel("Reserva de Libro");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        JLabel lblTituloLibro = new JLabel("Título del Libro: " + tituloLibro);
        JLabel lblFechaReserva = new JLabel("Fecha de Reserva:");
        JTextField txtFechaReserva = new JTextField(10);
        JButton btnReservar = new JButton("Reservar");
        JButton btnCancelar = new JButton("Cancelar");

        // Configurar el diseño de la ventana
        setLayout(new GridLayout(5, 1, 10, 10)); // Cinco filas, una columna

        // Añadir componentes a la ventana
        add(lblTitulo);
        add(lblTituloLibro);
        add(lblFechaReserva);
        add(txtFechaReserva);
        add(btnReservar);
        add(btnCancelar);

        // Manejar eventos del botón de reservar
        btnReservar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fechaReserva = txtFechaReserva.getText();
                // Aquí podrías implementar la lógica para realizar la reserva del libro
                JOptionPane.showMessageDialog(null, "Libro reservado para el " + fechaReserva);
            }
        });

        // Manejar eventos del botón de cancelar
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cerrar la pantalla de reserva
                dispose();
            }
        });
    }

    // Método principal para probar la pantalla
    public static void main(String[] args) {
        // Crear y mostrar la pantalla de reserva con un título de ejemplo
        PantallaReserva pantallaReserva = new PantallaReserva("El Señor de los Anillos");
        pantallaReserva.setVisible(true);
    }
}
