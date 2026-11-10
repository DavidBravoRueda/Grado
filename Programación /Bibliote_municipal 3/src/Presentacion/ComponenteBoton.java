package Presentacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComponenteBoton extends JPanel {

    // Constructor que recibe el texto del botón y un ActionListener opcional
    public ComponenteBoton(String textoBoton, ActionListener listener) {
        setLayout(new FlowLayout(FlowLayout.CENTER)); // Configurar diseño del panel
        JButton boton = new JButton(textoBoton); // Crear el botón con el texto especificado
        add(boton); // Agregar el botón al panel

        // Si se proporciona un ActionListener, agregarlo al botón
        if (listener != null) {
            boton.addActionListener(listener);
        }
    }

    // Método para cambiar el texto del botón
    public void setTextoBoton(String texto) {
        Component[] components = getComponents();
        if (components.length > 0 && components[0] instanceof JButton) {
            ((JButton) components[0]).setText(texto);
        }
    }

    // Método principal para probar el componente
    public static void main(String[] args) {
        // Crear un ActionListener para el botón de ejemplo
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "¡Botón presionado!");
            }
        };

        // Crear y mostrar el componente de botón
        JFrame frame = new JFrame("Componente Botón");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        // Crear un ComponenteBoton con el texto "Haz clic aquí" y el ActionListener definido arriba
        ComponenteBoton botonPersonalizado = new ComponenteBoton("Haz clic aquí", listener);

        // Agregar el ComponenteBoton al marco y hacerlo visible
        frame.getContentPane().add(botonPersonalizado);
        frame.setVisible(true);
    }
}
