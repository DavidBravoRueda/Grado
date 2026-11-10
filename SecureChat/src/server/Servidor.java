package server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;


// Servidor de chat seguro con autenticación y registro de actividad
public class Servidor {
    private static final int PUERTO = 12345;
    private static Set<PrintWriter> escritores = new HashSet<>();
    private static final Logger logger = Logger.getLogger("ChatLog");
    private static Map<String, String> usuariosDB = new HashMap<>();

    public static void main(String[] args) {
        configurarLogging();
        
        // Usuarios predefinidos (Pass: 12345)
        usuariosDB.put("admin", Seguridad.generarHash("12345"));
        usuariosDB.put("usuario1", Seguridad.generarHash("12345"));

        // Carga del certificado TLS (RA4)
        System.setProperty("javax.net.ssl.keyStore", "server_keystore.jks");
        System.setProperty("javax.net.ssl.keyStorePassword", "password");

        // Iniciar el servidor SSL
        try {
            SSLServerSocketFactory ssf = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            SSLServerSocket serverSocket = (SSLServerSocket) ssf.createServerSocket(PUERTO);
            System.out.println(">>> Servidor SEGURO iniciado en el puerto " + PUERTO);

            while (true) {
                SSLSocket clienteSocket = (SSLSocket) serverSocket.accept();
                new ManejadorCliente(clienteSocket, escritores).start();
            }
        } catch (IOException e) {
            logger.severe("Error en el servidor: " + e.getMessage());
        }
    }

    // Validación de usuario con hash
    public static boolean validarUsuario(String u, String p) {
        String hashRecibido = Seguridad.generarHash(p);
        return usuariosDB.containsKey(u) && usuariosDB.get(u).equals(hashRecibido);
    }

    // Registro de actividad en el log
    public static void registrarLog(String msg) {
        logger.info(msg);
    }
    
    // Configuración del logger para escribir en un archivo
    private static void configurarLogging() {
        try {
            FileHandler fh = new FileHandler("registro_actividad.log", true);
            fh.setFormatter(new SimpleFormatter());
            logger.addHandler(fh);
        } catch (Exception e) { e.printStackTrace(); }
    }
}
