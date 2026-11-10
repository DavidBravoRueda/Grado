package Presentacion;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

public class ComponenteTabla extends JPanel {

    private JTable tabla;
    private DefaultTableModel modeloTabla;

    // Constructor que recibe los encabezados de la tabla y los datos
    public ComponenteTabla(String[] encabezados, Object[][] datos) {
        setLayout(new BorderLayout()); // Configurar diseño del panel

        // Crear el modelo de tabla con los encabezados y datos
        modeloTabla = new DefaultTableModel(datos, encabezados);
        tabla = new JTable(modeloTabla);

        // Agregar la tabla a un JScrollPane para permitir desplazamiento si hay muchos datos
        JScrollPane scrollPane = new JScrollPane(tabla);
        add(scrollPane, BorderLayout.CENTER);
    }

    // Método para agregar una fila a la tabla
    public void agregarFila(Object[] filaDatos) {
        modeloTabla.addRow(filaDatos);
    }

    // Método para eliminar una fila de la tabla por índice
    public void eliminarFila(int indice) {
        modeloTabla.removeRow(indice);
    }

    // Método para obtener los datos de la fila seleccionada
    public Vector<Object> obtenerFilaSeleccionada() {
        int filaSeleccionada = tabla.getSelectedRow();
        if (filaSeleccionada == -1) {
            return null; // Si no se ha seleccionado ninguna fila, devolver null
        } else {
            return (Vector<Object>) modeloTabla.getDataVector().elementAt(filaSeleccionada);
        }
    }

    // Método principal para probar el componente
    public static void main(String[] args) {
        // Crear encabezados y datos de ejemplo para la tabla
        String[] encabezados = {"ID", "Nombre", "Apellido"};
        Object[][] datos = {
                {1, "Juan", "Pérez"},
                {2, "María", "González"},
                {3, "Pedro", "Sánchez"}
        };

        // Crear y mostrar el componente de tabla
        JFrame frame = new JFrame("Componente Tabla");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Crear un ComponenteTabla con los encabezados y datos de ejemplo
        ComponenteTabla tablaPersonalizada = new ComponenteTabla(encabezados, datos);

        // Agregar el ComponenteTabla al marco y hacerlo visible
        frame.getContentPane().add(tablaPersonalizada);
        frame.setVisible(true);
    }
}
