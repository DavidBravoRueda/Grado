package cinema.view;

import cinema.models.Sala;
import cinema.models.SesionOcupacion;

import javax.swing.*;
import java.awt.*;

public class SalaApp extends JFrame {
    private Sala sala;
    private JPanel panelButacas, panelInfo;
    private JLabel lblLibres, lblOcupados;

    public SalaApp() {
        setTitle("Cinema Paradiso");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLayout(new BorderLayout());

        sala = new Sala("Sala La Mundial");
        sala.generarSesiones();

        crearZonaSuperior();
        crearZonaCentral();
        crearZonaInferior();
        actualizarSesion(0);
    }

    private void crearZonaSuperior() {
        JPanel panelSesiones = new JPanel(new GridLayout(1, 4));
        JButton[] botonesSesion = new JButton[4];

        for (int i = 0; i < 4; i++) {
            final int index = i;
            botonesSesion[i] = new JButton("Sesión " + (i + 1));
            botonesSesion[i].addActionListener(e -> actualizarSesion(index));
            panelSesiones.add(botonesSesion[i]);
        }

        add(panelSesiones, BorderLayout.NORTH);
    }

    private void crearZonaCentral() {
        panelButacas = new JPanel(new GridBagLayout());
        add(panelButacas, BorderLayout.CENTER);
    }

    private void crearZonaInferior() {
        panelInfo = new JPanel(new FlowLayout(FlowLayout.CENTER));
        lblLibres = new JLabel("Libres: 0");
        lblOcupados = new JLabel("Ocupados: 0");

        lblLibres.setFont(new Font("Arial", Font.BOLD, 16));
        lblOcupados.setFont(new Font("Arial", Font.BOLD, 16));

        panelInfo.add(lblLibres);
        panelInfo.add(lblOcupados);
        add(panelInfo, BorderLayout.SOUTH);
    }

    private void actualizarSesion(int index) {
        panelButacas.removeAll();
        SesionOcupacion sesion = sala.getSesiones().get(index);
        GridBagConstraints gbc = new GridBagConstraints();

        // Agregar las letras de columnas en la parte superior (A-I)
        for (int col = 1; col <= 9; col++) {
            gbc.gridx = col;
            gbc.gridy = 0;
            gbc.insets = new Insets(5, 5, 5, 5);

            JLabel lblColumna = new JLabel(String.valueOf((char) ('A' + col - 1)), SwingConstants.CENTER);
            lblColumna.setFont(new Font("Arial", Font.BOLD, 16));
            panelButacas.add(lblColumna, gbc);
        }

        // Agregar las filas de butacas invertidas (8-1)
        for (int fila = 8; fila >= 1; fila--) {
            // Etiqueta del número de la fila en el lateral
            gbc.gridx = 0;
            gbc.gridy = 9 - fila; // Invertir la fila para que el 1 esté abajo
            gbc.insets = new Insets(5, 5, 5, 5);

            JLabel lblFila = new JLabel(String.valueOf(fila), SwingConstants.CENTER);
            lblFila.setFont(new Font("Arial", Font.BOLD, 16));
            panelButacas.add(lblFila, gbc);

            for (int col = 1; col <= 9; col++) {
                gbc.gridx = col;
                gbc.gridy = 9 - fila;

                String asiento = (char) ('A' + col - 1) + String.valueOf(fila);
                JButton btnAsiento = new JButton();
                btnAsiento.setPreferredSize(new Dimension(40, 40)); // Tamaño más grande
                btnAsiento.setFont(new Font("Arial", Font.PLAIN, 14));

                btnAsiento.setBackground(sesion.obtenerColorAsiento(asiento));
                btnAsiento.setOpaque(true);
                btnAsiento.setBorderPainted(false);

                btnAsiento.addActionListener(e -> {
                    sesion.ocuparAsiento(asiento);
                    actualizarSesion(index);
                });

                panelButacas.add(btnAsiento, gbc);
            }
        }

        lblLibres.setText("Libres: " + sesion.getNumeroButacasLibres());
        lblOcupados.setText("Ocupados: " + sesion.getNumeroButacasOcupadas());

        panelButacas.revalidate();
        panelButacas.repaint();
    }
}


