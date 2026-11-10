package calculator;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MainWindow extends JFrame {

    //Componentes de la interfaz gráfica
    private final TextField txtNum1 = new TextField();
    private final TextField txtNum2 = new TextField();
    private final JButton cmdAdd = new JButton("+");
    private final JButton cmdSub = new JButton("-");
    private final JButton cmdMul = new JButton("*");
    private final JButton cmdDiv = new JButton("/");
    private final JButton cmdClr = new JButton("Clear");
    private final DefaultListModel<String> model = new DefaultListModel<>();
    private final JList<String> lstRes = new JList<>(model);

    public MainWindow() {
        //Configurar la ventana principal
        setTitle("Calculator");
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        //Añadir panel principal a la ventana
        add(createMainPanel(), BorderLayout.CENTER);

        //Añadir listeners a los botones
        addListeners();

        setVisible(true);
    }

    private JPanel createMainPanel() {
        JPanel panel = new JPanel(new BorderLayout(0, 10));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        panel.add(createTopPanel(), BorderLayout.NORTH);
        panel.add(createCenterPanel(), BorderLayout.CENTER);
        panel.add(createBottomPanel(), BorderLayout.SOUTH);
        return panel;
    }

    private JPanel createTopPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.add(createInputPanel(), BorderLayout.CENTER);
        panel.add(createOperatorPanel(), BorderLayout.EAST);
        return panel;
    }

    private JPanel createInputPanel() {
        JPanel panel = new JPanel(new GridLayout(1, 2, 10, 0));
        panel.add(txtNum1);
        panel.add(txtNum2);
        return panel;
    }

    private JPanel createOperatorPanel() {
        JPanel panel = new JPanel(new GridLayout(1, 4, 10, 0));
        for (JButton btn : new JButton[]{cmdAdd, cmdSub, cmdMul, cmdDiv}) {
            configureButton(btn, 40, 40);
            panel.add(btn);
        }
        return panel;
    }

    private JPanel createCenterPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JScrollPane(lstRes), BorderLayout.CENTER);
        return panel;
    }

    private JPanel createBottomPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        configureButton(cmdClr, 120, 40); // Botón Clear más grande
        panel.add(cmdClr);
        return panel;
    }

    private void configureButton(JButton btn, int width, int height) {
        btn.setPreferredSize(new Dimension(width, height));
        btn.setFont(new Font("SansSerif", Font.BOLD, 16));
    }

    private void addListeners() {
        cmdAdd.addActionListener(e -> calculate('+'));
        cmdSub.addActionListener(e -> calculate('-'));
        cmdMul.addActionListener(e -> calculate('*'));
        cmdDiv.addActionListener(e -> calculate('/'));
        cmdClr.addActionListener(e -> clearResults());
    }

    private void calculate(char operator) {
        try {
            double num1 = Double.parseDouble(txtNum1.getText());
            double num2 = Double.parseDouble(txtNum2.getText());
            double result = switch (operator) {
                case '+' -> num1 + num2;
                case '-' -> num1 - num2;
                case '*' -> num1 * num2;
                case '/' -> num2 != 0 ? num1 / num2 : Double.NaN;
                default -> 0;
            };
            model.addElement(String.format("%.2f %c %.2f = %.2f", num1, operator, num2, result));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, introduce números válidos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearResults() {
        if (JOptionPane.showConfirmDialog(this, "¿Seguro que quieres eliminar la lista?", "Atención",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            model.clear();
        }
    }

    public static void main(String[] args) {
        new MainWindow();
    }
}


