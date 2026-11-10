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

public class PantallaGestionLibros extends JFrame {
    private LibroDAO libroDAO;
    private DefaultTableModel tableModel;
    private JTable tableLibros;
    private JTextField txtTitulo;
    private JTextField txtAutor;
    private JTextField txtCategoria;

    public PantallaGestionLibros(Connection conexion) {
        libroDAO = new LibroDAO(conexion);

        // Configuración de la ventana
        setTitle("Gestión de Libros - Biblioteca App");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar en la pantalla

        // Crear componentes
        JLabel lblTitulo = new JLabel("Gestión de Libros");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);

        // Actualizar la tabla para incluir el ID (oculto)
        tableModel = new DefaultTableModel(new String[]{"ID", "Título", "Autor", "Categoría"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Hacer todas las celdas no editables
            }
        };
        tableLibros = new JTable(tableModel);
        tableLibros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableLibros.removeColumn(tableLibros.getColumnModel().getColumn(0)); // Ocultar la columna de ID
        JScrollPane scrollPane = new JScrollPane(tableLibros);

        txtTitulo = new JTextField(15);
        txtAutor = new JTextField(15);
        txtCategoria = new JTextField(15);

        JButton btnAgregarLibro = new JButton("Agregar Libro");
        JButton btnEditarLibro = new JButton("Editar Libro");
        JButton btnEliminarLibro = new JButton("Eliminar Libro");
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
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        panelCentro.add(scrollPane, gbc);

        gbc.gridwidth = 1;
        gbc.weightx = 0;
        gbc.weighty = 0;

        gbc.gridx = 0;
        gbc.gridy = 1;
        panelCentro.add(new JLabel("Título:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panelCentro.add(txtTitulo, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panelCentro.add(new JLabel("Autor:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        panelCentro.add(txtAutor, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panelCentro.add(new JLabel("Categoría:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        panelCentro.add(txtCategoria, gbc);

        add(panelCentro, BorderLayout.CENTER);

        JPanel panelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        panelInferior.add(btnAgregarLibro);
        panelInferior.add(btnEditarLibro);
        panelInferior.add(btnEliminarLibro);
        panelInferior.add(btnCerrar);
        panelInferior.setBorder(new EmptyBorder(10, 10, 10, 10)); // Márgenes alrededor del panel inferior
        add(panelInferior, BorderLayout.SOUTH);

        // Cargar libros desde la base de datos
        cargarLibros();

        // Agregar libro
        btnAgregarLibro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String titulo = txtTitulo.getText().trim();
                String autor = txtAutor.getText().trim();
                String categoria = txtCategoria.getText().trim();
                if (!titulo.isEmpty() && !autor.isEmpty() && !categoria.isEmpty()) {
                    Libro nuevoLibro = new Libro(titulo, autor, categoria, true); // Asumiendo que el nuevo libro está disponible
                    try {
                        libroDAO.agregarLibro(nuevoLibro);
                        cargarLibros();
                        limpiarCampos();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(PantallaGestionLibros.this, "Error al agregar el libro.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(PantallaGestionLibros.this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Editar libro
        btnEditarLibro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = tableLibros.getSelectedRow();
                if (selectedIndex != -1) {
                    String nuevoTitulo = txtTitulo.getText().trim();
                    String nuevoAutor = txtAutor.getText().trim();
                    String nuevaCategoria = txtCategoria.getText().trim();
                    if (!nuevoTitulo.isEmpty() && !nuevoAutor.isEmpty() && !nuevaCategoria.isEmpty()) {
                        int idSeleccionado = Integer.parseInt(tableModel.getValueAt(selectedIndex, 0).toString());
                        Libro libroSeleccionado = new Libro(idSeleccionado, nuevoTitulo, nuevoAutor, nuevaCategoria, true); // Aquí deberías manejar el estado de disponibilidad según tu lógica
                        try {
                            libroDAO.modificarLibro(libroSeleccionado);
                            cargarLibros();
                            limpiarCampos();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                            JOptionPane.showMessageDialog(PantallaGestionLibros.this, "Error al actualizar el libro.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(PantallaGestionLibros.this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(PantallaGestionLibros.this, "No se ha seleccionado ningún libro.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Eliminar libro
        btnEliminarLibro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = tableLibros.getSelectedRow();
                if (selectedIndex != -1) {
                    int idSeleccionado = Integer.parseInt(tableModel.getValueAt(selectedIndex, 0).toString());
                    if (idSeleccionado != 0) {
                        try {
                            libroDAO.eliminarLibro(idSeleccionado);
                            cargarLibros();
                            limpiarCampos();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                            JOptionPane.showMessageDialog(PantallaGestionLibros.this, "Error al eliminar el libro.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(PantallaGestionLibros.this, "No se ha seleccionado ningún libro.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
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

        // Manejar selección de filas en la tabla
        tableLibros.getSelectionModel().addListSelectionListener(event -> {
            int selectedRow = tableLibros.getSelectedRow();
            if (selectedRow != -1) {
                txtTitulo.setText(tableModel.getValueAt(selectedRow, 1).toString());
                txtAutor.setText(tableModel.getValueAt(selectedRow, 2).toString());
                txtCategoria.setText(tableModel.getValueAt(selectedRow, 3).toString());
            }
        });
    }

    private void cargarLibros() {
        tableModel.setRowCount(0); // Limpiar la tabla
        try {
            List<Libro> libros = libroDAO.obtenerTodosLosLibros();
            for (Libro libro : libros) {
                tableModel.addRow(new Object[]{libro.getId(), libro.getTitulo(), libro.getAutor(), libro.getCategoria()});
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar los libros.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiarCampos() {
        txtTitulo.setText("");
        txtAutor.setText("");
        txtCategoria.setText("");
    }

    // Método principal para probar la pantalla
    public static void main(String[] args) {
        try {
            Connection conexion = ConexionBD.obtenerConexion();
            PantallaGestionLibros pantallaGestionLibros = new PantallaGestionLibros(conexion);
            pantallaGestionLibros.setVisible(true);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}










