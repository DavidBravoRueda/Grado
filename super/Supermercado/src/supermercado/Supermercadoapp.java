package supermercado;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Supermercadoapp {
	private JFrame frame;
    private JPanel panelCajas;
    private List<Caja> cajas = new ArrayList<>();
    private static int clienteCounter = 1;

    // Constructor que inicializa la interfaz gráfica
    public Supermercadoapp() {
        frame = new JFrame("Supermercado Concurrente");
        frame.setSize(700, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(10, 10));

        // Crear panel para las cajas
        panelCajas = new JPanel();
        panelCajas.setLayout(new GridLayout(1, 3, 10, 10));
        panelCajas.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        frame.add(panelCajas, BorderLayout.CENTER);

        // Crear 3 cajas
        for (int i = 1; i <= 3; i++) {
            JLabel label = new JLabel();
            label.setVerticalAlignment(JLabel.TOP);
            label.setOpaque(true);
            label.setBackground(new Color(220, 220, 255));
            label.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2, true));
            label.setFont(new Font("Arial", Font.BOLD, 14));
            label.setHorizontalAlignment(SwingConstants.CENTER);

            Caja caja = new Caja(i, label);
            cajas.add(caja);
            panelCajas.add(label);
            caja.start();
        }

        // Botón para generar nuevo cliente
        JButton btnNuevoCliente = new JButton("Llegada de nuevo cliente");
        btnNuevoCliente.setFont(new Font("Verdana", Font.BOLD, 16));
        btnNuevoCliente.setForeground(Color.BLACK); // Letras en negro
        btnNuevoCliente.setBackground(new Color(50, 150, 250));
        btnNuevoCliente.setFocusPainted(false);
        btnNuevoCliente.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.DARK_GRAY, 2, true),
                BorderFactory.createEmptyBorder(10, 20, 10, 20)
        ));
        btnNuevoCliente.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnNuevoCliente.addActionListener(e -> generarCliente());

        JPanel panelBoton = new JPanel();
        panelBoton.add(btnNuevoCliente);
        frame.add(panelBoton, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    // Método para generar un nuevo cliente y asignarlo a la caja con la cola más corta
    private void generarCliente() {
        int id = clienteCounter++;
        String nombre = "Cliente" + id;
        int numArticulos = (int) (Math.random() * 10) + 1;
        Cliente c = new Cliente(id, nombre, numArticulos);

        // Encontrar la caja con la cola más corta
        Caja cajaSeleccionada = cajas.get(0);
        for (Caja caja : cajas) {
            if (caja.getTamañoCola() < cajaSeleccionada.getTamañoCola()) {
                cajaSeleccionada = caja;
            }
        }
        cajaSeleccionada.agregarCliente(c);
    }
}