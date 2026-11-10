package Presentacion;

import Persistencia.UsuarioDAO;
import Persistencia.ConexionBD;
import negocio.Usuario;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PantallaGestionUsuarios extends JFrame {
    private UsuarioDAO usuarioDAO;
    private DefaultTableModel tableModel;
    private JTable tableUsuarios;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtEmail;

    public PantallaGestionUsuarios(Connection conexion) {
        usuarioDAO = new UsuarioDAO(conexion);

        // Configuración de la ventana
        setTitle("Gestión de Usuarios - Biblioteca App");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear componentes
        JLabel lblTitulo = new JLabel("Gestión de Usuarios");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);

        tableModel = new DefaultTableModel(new String[]{"Nombre", "Apellido", "Email"}, 0);
        tableUsuarios = new JTable(tableModel);
        tableUsuarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(tableUsuarios);

        txtNombre = new JTextField(15);
        txtApellido = new JTextField(15);
        txtEmail = new JTextField(15);

        JButton btnAgregarUsuario = new JButton("Agregar Usuario");
        JButton btnEditarUsuario = new JButton("Editar Usuario");
        JButton btnEliminarUsuario = new JButton("Eliminar Usuario");
        JButton btnCerrar = new JButton("Cerrar");

        // Configurar el diseño de la ventana con GridBagLayout
        setLayout(new BorderLayout(10, 10)); 

        JPanel panelTitulo = new JPanel();
        panelTitulo.add(lblTitulo);
        panelTitulo.setBorder(new EmptyBorder(10, 10, 10, 10)); 
        add(panelTitulo, BorderLayout.NORTH);

        JPanel panelCentro = new JPanel(new GridBagLayout());
        panelCentro.setBorder(new EmptyBorder(10, 10, 10, 10));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); 
        
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
        panelCentro.add(new JLabel("Nombre:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panelCentro.add(txtNombre, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panelCentro.add(new JLabel("Apellido:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        panelCentro.add(txtApellido, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panelCentro.add(new JLabel("Email:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        panelCentro.add(txtEmail, gbc);

        add(panelCentro, BorderLayout.CENTER);

        JPanel panelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        panelInferior.add(btnAgregarUsuario);
        panelInferior.add(btnEditarUsuario);
        panelInferior.add(btnEliminarUsuario);
        panelInferior.add(btnCerrar);
        panelInferior.setBorder(new EmptyBorder(10, 10, 10, 10)); 
        add(panelInferior, BorderLayout.SOUTH);

        // Cargar usuarios desde la base de datos
        cargarUsuarios();

        // botón de agregar usuario
        btnAgregarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText().trim();
                String apellido = txtApellido.getText().trim();
                String email = txtEmail.getText().trim();
                
                if (usuarioExiste(email)) {
                    JOptionPane.showMessageDialog(PantallaGestionUsuarios.this, "El usuario con este email ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!nombre.isEmpty() && !apellido.isEmpty() && !email.isEmpty()) {
                    Usuario nuevoUsuario = new Usuario(0, nombre, apellido, email, "", false);
                    try {
                        usuarioDAO.agregarUsuario(nuevoUsuario);
                        cargarUsuarios();
                        limpiarCampos();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(PantallaGestionUsuarios.this, "Error al agregar el usuario.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

     // botón de agregar usuario
        btnAgregarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText().trim();
                String apellido = txtApellido.getText().trim();
                String email = txtEmail.getText().trim();
                if (!nombre.isEmpty() && !apellido.isEmpty() && !email.isEmpty()) {
                    Usuario nuevoUsuario = new Usuario(0, nombre, apellido, email, "", false);
                    try {
                        usuarioDAO.agregarUsuario(nuevoUsuario);
                        cargarUsuarios();
                        limpiarCampos();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(PantallaGestionUsuarios.this, "Error al agregar el usuario.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        // botón de editar usuario
        btnEditarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = tableUsuarios.getSelectedRow();
                if (selectedIndex != -1) {
                    String emailSeleccionado = tableModel.getValueAt(selectedIndex, 2).toString();
                    Usuario usuarioSeleccionado = usuarioDAO.buscarUsuarioPorEmail(emailSeleccionado);
                    String nuevoNombre = txtNombre.getText().trim();
                    String nuevoApellido = txtApellido.getText().trim();
                    String nuevoEmail = txtEmail.getText().trim();
                    if (!nuevoNombre.isEmpty() && !nuevoApellido.isEmpty() && !nuevoEmail.isEmpty()) {
                        usuarioSeleccionado.setNombre(nuevoNombre);
                        usuarioSeleccionado.setApellido(nuevoApellido);
                        usuarioSeleccionado.setEmail(nuevoEmail);
                        try {
                            usuarioDAO.actualizarUsuario(usuarioSeleccionado);
                            cargarUsuarios();
                            limpiarCampos();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                            JOptionPane.showMessageDialog(PantallaGestionUsuarios.this, "Error al actualizar el usuario.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        });

        // botón de eliminar usuario
        btnEliminarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = tableUsuarios.getSelectedRow();
                if (selectedIndex != -1) {
                    String emailSeleccionado = tableModel.getValueAt(selectedIndex, 2).toString();
                    Usuario usuarioSeleccionado = usuarioDAO.buscarUsuarioPorEmail(emailSeleccionado);
                    try {
                        usuarioDAO.eliminarUsuario(usuarioSeleccionado.getId());
                        cargarUsuarios();
                        limpiarCampos();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(PantallaGestionUsuarios.this, "Error al eliminar el usuario.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        // botón de cerrar
        btnCerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();  // Cerrar la ventana actual
                PantallaInicio pantallaInicio = new PantallaInicio();
                pantallaInicio.setVisible(true);
            }
        });

        // filas en la tabla
        tableUsuarios.getSelectionModel().addListSelectionListener(event -> {
            int selectedRow = tableUsuarios.getSelectedRow();
            if (selectedRow != -1) {
                txtNombre.setText(tableModel.getValueAt(selectedRow, 0).toString());
                txtApellido.setText(tableModel.getValueAt(selectedRow, 1).toString());
                txtEmail.setText(tableModel.getValueAt(selectedRow, 2).toString());
            }
        });
    }

    private void cargarUsuarios() {
        tableModel.setRowCount(0); 
        try {
            List<Usuario> usuarios = usuarioDAO.obtenerTodosLosUsuarios();
            for (Usuario usuario : usuarios) {
                tableModel.addRow(new Object[]{usuario.getNombre(), usuario.getApellido(), usuario.getEmail()});
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar los usuarios.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiarCampos() {
        txtNombre.setText("");
        txtApellido.setText("");
        txtEmail.setText("");
    }

    // Método principal para probar la pantalla
    public static void main(String[] args) {
        try {
            Connection conexion = ConexionBD.obtenerConexion();
            PantallaGestionUsuarios pantallaGestionUsuarios = new PantallaGestionUsuarios(conexion);
            pantallaGestionUsuarios.setVisible(true);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    private boolean usuarioExiste(String email) {
        Usuario usuario = usuarioDAO.buscarUsuarioPorEmail(email);
		return usuario != null;
    }

}




