package exercise3colorjframe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class WindowColor extends JFrame {
    
    public WindowColor() {
        //Configuración de la ventana
        setTitle("Ventana de Color");
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        createWindow();
        setVisible(true);
    }
    
    private void createWindow() {
        //Configuración del diseño de la ventana
        add(createLabel("North", Color.white, Color.black, new Font("Liberation Serif", Font.BOLD, 16), 0, 30), BorderLayout.NORTH);
        add(createLabel("South", Color.orange, Color.decode("#2D572C"), new Font("Liberation Serif", Font.BOLD, 16), 0, 50), BorderLayout.SOUTH);
        add(createLabel("West", Color.yellow, Color.black, new Font("Liberation Serif", Font.BOLD, 48), 100, 0), BorderLayout.WEST);
        add(createLabel("East", Color.red, Color.YELLOW, new Font("Liberation Serif", Font.BOLD, 16), 100, 0), BorderLayout.EAST);
        add(createLabel("Center", Color.lightGray, Color.gray, new Font("Liberation Serif", Font.BOLD, 16), 0, 0), BorderLayout.CENTER);
    }
    
    private JLabel createLabel(String text, Color bg, Color fg, Font font, int width, int height) {
        //Configuración de la etiqueta
        JLabel label = new JLabel(text);
        label.setOpaque(true);
        label.setBackground(bg);
        label.setForeground(fg);
        label.setFont(font);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setPreferredSize(new Dimension(width, height));
        
        return label;
    }

    //Método principal
    public static void main(String[] args) {
        new WindowColor();
    }
}
