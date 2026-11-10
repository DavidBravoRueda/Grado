package helloSwing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class MainWindows extends javax.swing.JFrame {
	
    public MainWindows() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    private void initComponents() {

        //Declaración de los paneles y botones
        jPanel1 = new javax.swing.JPanel();
        btnClear = new javax.swing.JButton();
        btnCount = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblPrompt = new javax.swing.JLabel();
        txtInput = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        scrollPane = new javax.swing.JScrollPane();
        listNames = new java.awt.List();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestión de Nombres");

        //Botones Clear y Count
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 35));
        btnClear.setBackground(new java.awt.Color(213, 232, 251));
        btnClear.setText("Limpiar");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleClear(evt);
            }
        });
        btnCount.setBackground(new java.awt.Color(212, 229, 249));
        btnCount.setText("Contar");
        btnCount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleCount(evt);
            }
        });
        jPanel1.add(btnCount);
        jPanel1.add(btnClear);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        //Etiqueta, campo de texto y botón Add
        lblPrompt.setText("Introduce un nombre:");
        txtInput.setPreferredSize(new java.awt.Dimension(220, 25));
        btnAdd.setBackground(new java.awt.Color(212, 229, 249));
        btnAdd.setText("Añadir");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleAdd(evt);
            }
        });
        jPanel2.add(lblPrompt);
        jPanel2.add(txtInput);
        jPanel2.add(btnAdd);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        //Lista gráfica
        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        scrollPane.setViewportView(listNames);
        jPanel3.add(scrollPane);

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);
        pack();
    }

    //Eventos asociados a los botones
    private void handleAdd(ActionEvent evt) {
        String name = txtInput.getText().trim();
        if (!name.isEmpty()) {
            listNames.add(name);
            txtInput.setText("");
            txtInput.requestFocus();
        }
    }

    private void handleClear(ActionEvent evt) {
        listNames.removeAll();
    }

    private void handleCount(ActionEvent evt) {
        int count = listNames.getItemCount();
        JOptionPane.showMessageDialog(this, "Se han añadido " + count + " nombres.", 
                "Información", JOptionPane.INFORMATION_MESSAGE);
    }

    //Método principal de la aplicación
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new MainWindows().setVisible(true);
        });
    }

    //Variables de la clase
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnCount;
    private java.awt.List listNames;
    private javax.swing.JLabel lblPrompt;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTextField txtInput;
}
