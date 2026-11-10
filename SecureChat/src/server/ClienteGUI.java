package server;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

// Representa la interfaz gráfica del cliente que se conecta al servidor seguro TLS para enviar y recibir mensajes.
public class ClienteGUI extends JFrame {
    private JTextArea areaTexto = new JTextArea(15, 40);
    private JTextField campoEntrada = new JTextField(30);
    private PrintWriter salida;

    public ClienteGUI() {
        setTitle("Messenger Seguro TLS");
        areaTexto.setEditable(false);
        add(new JScrollPane(areaTexto), BorderLayout.CENTER);
        
        JPanel panel = new JPanel();
        panel.add(campoEntrada);
        JButton btn = new JButton("Enviar");
        panel.add(btn);
        add(panel, BorderLayout.SOUTH);

        btn.addActionListener(e -> enviar());
        campoEntrada.addActionListener(e -> enviar());

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    // Envía el mensaje ingresado en el campo de texto al servidor a través del socket seguro.
    private void enviar() {
        if (!campoEntrada.getText().isEmpty()) {
            salida.println(campoEntrada.getText());
            campoEntrada.setText("");
        }
    }

    // Establece la conexión segura con el servidor TLS, maneja la autenticación y actualiza la interfaz según las respuestas del servidor.
    public void iniciarConexion() {
        System.setProperty("javax.net.ssl.trustStore", "server_keystore.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", "password");

        try {
            SSLSocketFactory ssf = (SSLSocketFactory) SSLSocketFactory.getDefault();
            SSLSocket socket = (SSLSocket) ssf.createSocket("localhost", 12345);

            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            salida = new PrintWriter(socket.getOutputStream(), true);

            while (true) {
                String r = entrada.readLine();
                if (r == null) break;

                if (r.equals("LOGIN_USER")) {
                    salida.println(JOptionPane.showInputDialog("Usuario:"));
                } else if (r.equals("LOGIN_PASS")) {
                    salida.println(JOptionPane.showInputDialog("Contraseña:"));
                } else if (r.equals("AUTH_SUCCESS")) {
                    setVisible(true);
                } else if (r.equals("AUTH_FAIL")) {
                    JOptionPane.showMessageDialog(null, "Acceso denegado");
                    System.exit(0);
                } else {
                    areaTexto.append(r + "\n");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Servidor no disponible");
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new ClienteGUI().iniciarConexion();
    }
}
