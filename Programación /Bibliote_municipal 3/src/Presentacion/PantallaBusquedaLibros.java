package Presentacion;

import Persistencia.ConexionBD;
import Persistencia.LibroDAO;
import negocio.Libro;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PantallaBusquedaLibros extends JFrame {
    private LibroDAO libroDAO;
    private DefaultTableModel tableModel;
    private JTable tableLibros;
    private JTextField txtBuscarTitulo;

    public PantallaBusquedaLibros(Connection conexion) {
        libroDAO = new LibroDAO(conexion);

        // Configuración de la ventana
        setTitle("Buscar Libro por Título - Biblioteca App");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar en la pantalla

        // Crear componentes
        JLabel lblTitulo = new JLabel("Buscar Libro por Título");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);

        tableModel = new DefaultTableModel(new String[]{"Título", "Autor", "Categoría"}, 0);
        tableLibros = new JTable(tableModel);
        tableLibros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(tableLibros);

        txtBuscarTitulo = new JTextField();
        txtBuscarTitulo.setPreferredSize(new Dimension(300, 30)); // Ajustar el tamaño del campo de texto

        JButton btnBuscar = new JButton("Buscar");
        JButton btnCerrar = new JButton("Cerrar");

        // Configurar el diseño de la ventana con GridBagLayout
        setLayout(new BorderLayout(10, 10)); // Espacio entre componentes

        JPanel panelTitulo = new JPanel();
        panelTitulo.add(lblTitulo);
        panelTitulo.setBorder(new EmptyBorder(10, 10, 10, 10)); // Márgenes alrededor del título
        add(panelTitulo, BorderLayout.NORTH);

        JPanel panelCentro = new JPanel(new GridBagLayout());
        panelCentro.setBorder(new EmptyBorder(10, 10, 10, 10)); // Márgenes alrededor del centro
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Espacio entre componentes

        gbc.gridx = 0;
        gbc.gridy = 0;
        panelCentro.add(new JLabel("Título del Libro:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL; // Para que el campo de texto crezca horizontalmente
        gbc.weightx = 1.0; // Para que el campo de texto ocupe el espacio disponible
        panelCentro.add(txtBuscarTitulo, gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        panelCentro.add(btnBuscar, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        panelCentro.add(scrollPane, gbc);

        add(panelCentro, BorderLayout.CENTER);

        JPanel panelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        panelInferior.add(btnCerrar);
        panelInferior.setBorder(new EmptyBorder(10, 10, 10, 10)); // Márgenes alrededor del panel inferior
        add(panelInferior, BorderLayout.SOUTH);

        // Manejar eventos del botón de buscar libro
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String titulo = txtBuscarTitulo.getText().trim();
                if (!titulo.isEmpty()) {
                    cargarLibrosPorTitulo(titulo);
                } else {
                    JOptionPane.showMessageDialog(PantallaBusquedaLibros.this, "Ingrese un título para buscar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        // Manejar eventos del botón de cerrar
        btnCerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();  // Cerrar la ventana actual
                PantallaInicio pantallaInicio = new PantallaInicio();
                pantallaInicio.setVisible(true);
            }
        });
    }

    private void cargarLibrosPorTitulo(String titulo) {
        tableModel.setRowCount(0); // Limpiar la tabla
        try {
            List<Libro> libros = libroDAO.buscarLibrosPorTitulo(titulo);
            for (Libro libro : libros) {
                tableModel.addRow(new Object[]{libro.getTitulo(), libro.getAutor(), libro.getCategoria()});
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar los libros.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método principal para probar la pantalla
    public static void main(String[] args) {
        try {
            Connection conexion = ConexionBD.obtenerConexion();
            PantallaBusquedaLibros pantallaBuscarLibro = new PantallaBusquedaLibros(conexion);
            pantallaBuscarLibro.setVisible(true);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}





