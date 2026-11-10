package Presentacion;
import Persistencia.ConexionBD;
import Persistencia.LibroDAO;
import Persistencia.PrestamoDAO;
import negocio.Libro;
import negocio.Prestamo;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
public class PantallaPrestamos extends JFrame {
   private LibroDAO libroDAO;
   private PrestamoDAO prestamoDAO;
   private DefaultTableModel tableModel;
   private JTable tablePrestamos;
   private JTextField txtNombreUsuario;
   private JComboBox<String> cmbLibros;
   public PantallaPrestamos(Connection conexion) {
       libroDAO = new LibroDAO(conexion);
       prestamoDAO = new PrestamoDAO(conexion);
       setTitle("Gestión de Préstamos - Biblioteca App");
       setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       setLocationRelativeTo(null);
       JPanel panelPrincipal = new JPanel(new BorderLayout());
       panelPrincipal.setBorder(new EmptyBorder(10, 10, 10, 10));
       JPanel panelSuperior = new JPanel(new BorderLayout());
       JLabel lblTitulo = new JLabel("Gestión de Préstamos");
       lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
       lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
       panelSuperior.add(lblTitulo, BorderLayout.CENTER);
       panelPrincipal.add(panelSuperior, BorderLayout.NORTH);
       JPanel panelCentral = new JPanel(new GridBagLayout());
       panelCentral.setBorder(new EmptyBorder(10, 10, 10, 10));
       GridBagConstraints gbc = new GridBagConstraints();
       gbc.insets = new Insets(5, 5, 5, 5);
       // Table
       tableModel = new DefaultTableModel(new String[]{"Libro", "Usuario", "Fecha"}, 0) {
           @Override
           public boolean isCellEditable(int row, int column) {
               return false;
           }
       };
       tablePrestamos = new JTable(tableModel);
       JScrollPane scrollPane = new JScrollPane(tablePrestamos);
       gbc.gridx = 0;
       gbc.gridy = 0;
       gbc.gridwidth = 2;
       gbc.weightx = 1.0;
       gbc.weighty = 1.0;
       gbc.fill = GridBagConstraints.BOTH;
       panelCentral.add(scrollPane, gbc);
       gbc.gridwidth = 1;
       // Libro
       gbc.gridx = 0;
       gbc.gridy = 1;
       panelCentral.add(new JLabel("Libro:"), gbc);
       cmbLibros = new JComboBox<>();
       gbc.gridx = 1;
       panelCentral.add(cmbLibros, gbc);
       // Usuario
       gbc.gridx = 0;
       gbc.gridy = 2;
       panelCentral.add(new JLabel("Usuario:"), gbc);
       txtNombreUsuario = new JTextField(20);
       gbc.gridx = 1;
       panelCentral.add(txtNombreUsuario, gbc);
       panelPrincipal.add(panelCentral, BorderLayout.CENTER);
       JPanel panelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
       JButton btnPrestar = new JButton("Registrar Préstamo");
       JButton btnEliminar = new JButton("Eliminar Préstamo");
       JButton btnCerrar = new JButton("Cerrar");
       panelInferior.add(btnPrestar);
       panelInferior.add(btnEliminar);
       panelInferior.add(btnCerrar);
       panelPrincipal.add(panelInferior, BorderLayout.SOUTH);
       add(panelPrincipal);
       cargarLibrosDisponibles();
       cargarPrestamos();
       btnPrestar.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               String nombreUsuario = txtNombreUsuario.getText().trim();
               String libroSeleccionado = (String) cmbLibros.getSelectedItem();
               if (!nombreUsuario.isEmpty() && libroSeleccionado != null) {
                   try {
                       LocalDateTime fechaHoraPrestamo = LocalDateTime.now();
                       Prestamo prestamo = new Prestamo(libroSeleccionado, nombreUsuario, fechaHoraPrestamo);
                       prestamoDAO.registrarPrestamo(prestamo);
                       cargarPrestamos();
                       txtNombreUsuario.setText("");
                   } catch (SQLException ex) {
                       ex.printStackTrace();
                       JOptionPane.showMessageDialog(PantallaPrestamos.this, "Error al registrar el préstamo.", "Error", JOptionPane.ERROR_MESSAGE);
                   }
               } else {
                   JOptionPane.showMessageDialog(PantallaPrestamos.this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
               }
           }
       });
       btnEliminar.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               int filaSeleccionada = tablePrestamos.getSelectedRow();
               if (filaSeleccionada != -1) {
                   String nombreLibro = (String) tableModel.getValueAt(filaSeleccionada, 0);
                   String nombreUsuario = (String) tableModel.getValueAt(filaSeleccionada, 1);
                   String fechaHoraString = (String) tableModel.getValueAt(filaSeleccionada, 2);
                   DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                   LocalDateTime fechaHoraPrestamo = LocalDateTime.parse(fechaHoraString, formatter);
                   Prestamo prestamo = new Prestamo(nombreLibro, nombreUsuario, fechaHoraPrestamo);
                   try {
                       prestamoDAO.eliminarPrestamo(prestamo);
                       cargarPrestamos();
                   } catch (SQLException ex) {
                       ex.printStackTrace();
                       JOptionPane.showMessageDialog(PantallaPrestamos.this, "Error al eliminar el préstamo.", "Error", JOptionPane.ERROR_MESSAGE);
                   }
               } else {
                   JOptionPane.showMessageDialog(PantallaPrestamos.this, "Seleccione un préstamo para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
               }
           }
       });
       btnCerrar.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               dispose();
               PantallaInicio pantallaInicio = new PantallaInicio();
               pantallaInicio.setVisible(true);
           }
       });
       pack();
   }
   private void cargarPrestamos() {
       tableModel.setRowCount(0);
       try {
           List<Prestamo> prestamos = prestamoDAO.obtenerTodosLosPrestamos();
           DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
           for (Prestamo prestamo : prestamos) {
               String fechaHora = prestamo.getFechaHoraPrestamo().format(formatter);
               tableModel.addRow(new Object[]{prestamo.getNombreLibro(), prestamo.getNombreUsuario(), fechaHora});
           }
       } catch (SQLException ex) {
           ex.printStackTrace();
           JOptionPane.showMessageDialog(this, "Error al cargar los préstamos.", "Error", JOptionPane.ERROR_MESSAGE);
       }
   }
   private void cargarLibrosDisponibles() {
       try {
           List<Libro> libros = libroDAO.obtenerTodosLosLibros();
           for (Libro libro : libros) {
               cmbLibros.addItem(libro.getTitulo());
           }
       } catch (SQLException ex) {
           ex.printStackTrace();
           JOptionPane.showMessageDialog(this, "Error al cargar los libros disponibles.", "Error", JOptionPane.ERROR_MESSAGE);
       }
   }
   public static void main(String[] args) {
       try {
           Connection conexion = ConexionBD.obtenerConexion();
           PantallaPrestamos pantallaPrestamos = new PantallaPrestamos(conexion);
           pantallaPrestamos.setVisible(true);
       } catch (SQLException ex) {
           ex.printStackTrace();
       }
   }
}

