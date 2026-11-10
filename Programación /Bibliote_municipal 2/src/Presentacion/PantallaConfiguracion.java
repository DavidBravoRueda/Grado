package Presentacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaConfiguracion extends JFrame {

    // Componentes de la interfaz de usuario
    private JLabel lblTitulo;
    private JLabel lblTema;
    private JComboBox<String> cmbTema;
    private JButton btnGuardar;
    private JButton btnCancelar;

    // Método constructor
    public PantallaConfiguracion() {
        // Configuración de la ventana
        setTitle("Configuración - Biblioteca App");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar en la pantalla

        // Crear componentes
        lblTitulo = new JLabel("Configuración");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        lblTema = new JLabel("Tema:");
        String[] temas = {"Claro", "Oscuro"};
        cmbTema = new JComboBox<>(temas);
        btnGuardar = new JButton("Guardar");
        btnCancelar = new JButton("Cancelar");

        // Configurar el diseño de la ventana
        setLayout(new GridLayout(4, 2, 10, 10)); // Cuatro filas, dos columnas

        // Añadir componentes a la ventana
        add(lblTitulo);
        add(new JLabel()); // Espacio en blanco
        add(lblTema);
        add(cmbTema);
        add(new JLabel()); // Espacio en blanco
        add(new JLabel()); // Espacio en blanco
        add(btnGuardar);
        add(btnCancelar);

        // Manejar eventos del botón de guardar
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String temaSeleccionado = (String) cmbTema.getSelectedItem();
                // Aquí podrías implementar la lógica para guardar la configuración
                JOptionPane.showMessageDialog(null, "Tema guardado: " + temaSeleccionado);

                // Cambiar el tema
                if (temaSeleccionado.equals("Oscuro")) {
                    // Cambiar el tema a oscuro
                    try {
                        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                        SwingUtilities.updateComponentTreeUI(PantallaConfiguracion.this);
                    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    // Cambiar el tema a claro
                    try {
                        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                        SwingUtilities.updateComponentTreeUI(PantallaConfiguracion.this);
                    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        // Manejar eventos del botón de cancelar
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cerrar la pantalla de configuración
                dispose();

                // Mostrar la pantalla de inicio
                PantallaInicio pantallaInicio = new PantallaInicio();
                pantallaInicio.setVisible(true);
            }
        });
    }

    // Método principal para probar la pantalla
    public static void main(String[] args) {
        // Crear y mostrar la pantalla de configuración
        PantallaConfiguracion pantallaConfiguracion = new PantallaConfiguracion();
        pantallaConfiguracion.setVisible(true);
    }
}

