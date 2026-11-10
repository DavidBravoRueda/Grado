package supermercado;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.SwingUtilities;

// Clase que representa una caja registradora en el supermercado
public class Caja extends Thread {
	private List<Cliente> cola = new ArrayList<>();
    private JLabel label;
    private int id;

    public Caja(int id, JLabel label) {
        this.id = id;
        this.label = label;
        actualizarLabel(); // Mostrar caja vacía al inicio
    }

    // Agrega un cliente a la cola de la caja
    public void agregarCliente(Cliente c) {
        cola.add(c);
        actualizarLabel();
    }

    // Actualiza el label de la caja en la interfaz gráfica
    private void actualizarLabel() {
        SwingUtilities.invokeLater(() -> {
            StringBuilder sb = new StringBuilder();
            sb.append("Caja ").append(id).append(":\n");
            for (Cliente c : cola) {
                sb.append(c.toString()).append("\n");
            }
            if (cola.isEmpty()) sb.append("vacía");
            label.setText("<html>" + sb.toString().replaceAll("\n", "<br>") + "</html>");
        });
    }

    // Método que simula la atención de clientes en la caja
    public void run() {
        while (true) {
            if (!cola.isEmpty()) {
                Cliente c = cola.get(0);
                cola.remove(0);
                actualizarLabel();
                try {
                    // Simula el tiempo de atención según el número de artículos	
                    int tiempoAtencion = c.numArticulos * 1000; // 1 segundo por artículo
                    Thread.sleep(tiempoAtencion);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Devuelve el tamaño actual de la cola
    public int getTamañoCola() {
        return cola.size();
    }
}
	