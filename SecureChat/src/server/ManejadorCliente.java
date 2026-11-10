package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Set;

import javax.net.ssl.SSLSocket;

// Se encarga de manejar la comunicación con un cliente específico, incluyendo autenticación, recepción de mensajes y notificación de desconexión.
public class ManejadorCliente extends Thread {
    private SSLSocket socket;
    private PrintWriter out;
    private BufferedReader in;
    private String nombre;
    private Set<PrintWriter> escritores;

    public ManejadorCliente(SSLSocket socket, Set<PrintWriter> escritores) {
        this.socket = socket;
        this.escritores = escritores;
    }

    @Override
    // El método principal del hilo que maneja la comunicación con el cliente, incluyendo autenticación y manejo de mensajes.
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            out.println("LOGIN_USER");
            String user = in.readLine();
            out.println("LOGIN_PASS");
            String pass = in.readLine();

            if (Servidor.validarUsuario(user, pass)) {
                out.println("AUTH_SUCCESS");
                this.nombre = user;
                Servidor.registrarLog("Entrada: " + user);
                
                synchronized (escritores) { escritores.add(out); }
                enviarMensaje("SISTEMA: " + user + " se ha conectado.");
            } else {
                out.println("AUTH_FAIL");
                Servidor.registrarLog("Fallo de login para: " + user);
                socket.close();
                return;
            }

            String msg;
            while ((msg = in.readLine()) != null) {
                enviarMensaje(nombre + ": " + msg);
            }
        } catch (IOException e) {
            Servidor.registrarLog("Error/Desconexión de: " + nombre);
        } finally {
            desconectar();
        }
    }

    // Envía un mensaje a todos los clientes conectados utilizando el conjunto de escritores.
    private void enviarMensaje(String m) {
        synchronized (escritores) {
            for (PrintWriter esc : escritores) esc.println(m);
        }
    }

    // Maneja la desconexión del cliente, notificando a los demás y cerrando el socket.
    private void desconectar() {
        if (nombre != null) {
            enviarMensaje("SISTEMA: " + nombre + " ha salido.");
            Servidor.registrarLog("Salida: " + nombre);
        }
        synchronized (escritores) { escritores.remove(out); }
        try { socket.close(); } catch (IOException e) {}
    }
}