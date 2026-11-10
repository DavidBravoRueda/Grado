package helloswing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class MainWindow extends JFrame {

    private JTextField inputName = new JTextField();
    private JButton btnAdd = new JButton("Agregar");
    private JButton btnClear = new JButton("Limpiar");
    private JButton btnCount = new JButton("Contar");
    private JList<String> nameList;
    private DefaultListModel<String> listModel = new DefaultListModel<>();

    public MainWindow() {
        setTitle("Gestor de Nombres");
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
   
        initializeActions();
        
        setupLayout();

        setVisible(true);
    }

    private void setupLayout() {
        JPanel mainPanel = new JPanel(new BorderLayout(0, 10));
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        mainPanel.add(createTopPanel(), BorderLayout.NORTH);
        mainPanel.add(createBottomPanel(), BorderLayout.SOUTH);
        mainPanel.add(createCenterPanel());

        add(mainPanel);
    }

    private JPanel createTopPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        JLabel lblInstruction = new JLabel("Introduce un nombre:");
        panel.add(lblInstruction, BorderLayout.WEST);
        panel.add(btnAdd, BorderLayout.EAST);
        panel.add(inputName, BorderLayout.CENTER);
        return panel;
    }

    private JPanel createCenterPanel() {
        nameList = new JList<>(listModel);
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JScrollPane(nameList));
        return panel;
    }

    private JPanel createBottomPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnCount.setPreferredSize(new Dimension(90, 30));
        btnClear.setPreferredSize(new Dimension(90, 30));
        panel.add(btnCount);
        panel.add(btnClear);
        return panel;
    }

    private void initializeActions() {

        btnAdd.addActionListener(new AddNameAction());
        
        btnCount.addActionListener(new CountNamesAction());

        btnClear.addActionListener(e -> {
            int choice = JOptionPane.showConfirmDialog(
                MainWindow.this,
                "¿Seguro deseas limpiar la lista?",
                "Confirmar",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
            );

            if (choice == JOptionPane.YES_OPTION) {
                listModel.clear();
            }
        });
    }
    
    class AddNameAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = inputName.getText().trim();
            if (!name.isEmpty()) {
                listModel.addElement(name);
                inputName.setText("");
                inputName.requestFocus();
            }
        }
    }
    
    class CountNamesAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(
                MainWindow.this,
                "Actualmente tienes " + listModel.getSize() + " nombres en la lista.",
                "Información",
                JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainWindow::new);
    }
}


