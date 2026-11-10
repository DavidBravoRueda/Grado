package Interfazgrafica;

import javax.swing.*;

public class carrera extends JFrame {

    private JTextField txtNombre, txtApellidos, txtDNI, txtEdad;
    private JTextArea textArea;
    private JRadioButton rbMenorEdad, rbPagadoCarrera, rbDopado;
    private JButton btnValidar, btnConsultar;

    public carrera() {
        setTitle("Inscripción Resultados de Carrera");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLayout(null);

        JLabel lblNombre = new JLabel("Nombre");
        lblNombre.setBounds(80, 20, 100, 25);
        add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(260, 20, 200, 25);
        add(txtNombre);

        JLabel lblApellidos = new JLabel("Apellidos");
        lblApellidos.setBounds(80, 60, 100, 25);
        add(lblApellidos);

        txtApellidos = new JTextField();
        txtApellidos.setBounds(260, 60, 200, 25);
        add(txtApellidos);

        JLabel lblEdad = new JLabel("Edad");
        lblEdad.setBounds(80, 100, 100, 25);
        add(lblEdad);

        txtEdad = new JTextField();
        txtEdad.setBounds(260, 100, 200, 25);
        add(txtEdad);

        JLabel lblDNI = new JLabel("DNI");
        lblDNI.setBounds(80, 140, 100, 25);
        add(lblDNI);

        txtDNI = new JTextField();
        txtDNI.setBounds(260, 140, 200, 25);
        add(txtDNI);

        rbMenorEdad = new JRadioButton("Menor");
        rbMenorEdad.setBounds(10, 180, 100, 25);
        add(rbMenorEdad);

        rbPagadoCarrera = new JRadioButton("Pagado");
        rbPagadoCarrera.setBounds(80, 180, 100, 25);
        add(rbPagadoCarrera);

        rbDopado = new JRadioButton("Dopado");
        rbDopado.setBounds(160, 180, 100, 25);
        add(rbDopado);

        ButtonGroup grupoOpciones = new ButtonGroup();
        grupoOpciones.add(rbMenorEdad);
        grupoOpciones.add(rbPagadoCarrera);
        grupoOpciones.add(rbDopado);

        JLabel lblInformacion = new JLabel("Información");
        lblInformacion.setBounds(80, 270, 100, 25);
        add(lblInformacion);

        textArea = new JTextArea();
        textArea.setBounds(260, 230, 200, 100);
        textArea.setEditable(false);
        textArea.setEnabled(false);
        add(textArea);

        btnValidar = new JButton("Validar");
        btnValidar.setBounds(150, 370, 100, 30);
        btnValidar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
            }
        });
        add(btnValidar);

        btnConsultar = new JButton("Consultar");
        btnConsultar.setBounds(270, 370, 100, 30);
        btnConsultar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
            }
        });
        add(btnConsultar);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(carrera::new);
    }
}

