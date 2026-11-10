package exercise5;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class MainWindow extends JFrame {
    
    private JComboBox lstFont;
    private JTextField txtSize = new JTextField("20");
    private JCheckBox chkBold = new JCheckBox("Bold");
    private JCheckBox chkItalic = new JCheckBox("Italic");
    private JRadioButton cmdLeft = new JRadioButton("Left");
    private JRadioButton cmdCenter = new JRadioButton("Center");
    private JRadioButton cmdRight = new JRadioButton("Right");
    private JCheckBox chkTrans = new JCheckBox("Transparent Background");
    private JButton btnReset = new JButton("Reset to default");
    private JLabel lblText = new JLabel("This is the text");
    
    private JTextField txtText = new JTextField("This is the text");

    private JSlider sldRfg = new JSlider(JSlider.HORIZONTAL);
    private JSlider sldGfg = new JSlider(JSlider.HORIZONTAL);
    private JSlider sldBfg = new JSlider(JSlider.HORIZONTAL);
    private JSlider sldRbg = new JSlider(JSlider.HORIZONTAL);
    private JSlider sldGbg = new JSlider(JSlider.HORIZONTAL);
    private JSlider sldBbg = new JSlider(JSlider.HORIZONTAL);

    public MainWindow() {
        setTitle("Sign");
        setSize(700, 550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        createWindow();
        setVisible(true);
    }
    
    private void createWindow() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        panel.add(createTop(), BorderLayout.NORTH);
        panel.add(createCenter());
        add(panel);
    }

    private JPanel createCenter() {
        lblText.setOpaque(true);
        lblText.setBackground(Color.white);
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(20, 0, 20, 0));
        JPanel sign = new JPanel(new BorderLayout());
        sign.setBorder(new LineBorder(Color.black));
        JPanel inner = new JPanel(new BorderLayout());
        inner.setBorder(new LineBorder(Color.white, 5));
        inner.add(createDots(), BorderLayout.NORTH);
        inner.add(createDots(), BorderLayout.SOUTH);
        inner.add(createMargin(), BorderLayout.WEST);
        inner.add(createMargin(), BorderLayout.EAST);
        inner.add(lblText);
        sign.add(inner);
        panel.add(sign);
        return panel;
    }

    private JLabel createMargin() {
        JLabel label = new JLabel();
        label.setPreferredSize(new Dimension(5, 5));
        label.setOpaque(true);
        label.setBackground(Color.white);
        return label;
    }

    private JPanel createDots() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(createDot(), BorderLayout.WEST);
        panel.add(createDot(), BorderLayout.EAST);
        panel.add(createMargin());
        return panel;
    }

    private JLabel createDot() {
        JLabel label = new JLabel();
        label.setPreferredSize(new Dimension(5, 5));
        label.setOpaque(true);
        label.setBackground(Color.black);
        return label;
    }

    private JPanel createTop() {
        JPanel panel = new JPanel(new GridLayout(6, 1));
        panel.add(createFont());
        panel.add(createFg());
        panel.add(createBg());
        panel.add(createText());
        panel.add(createBorder());
        panel.add(createResetButton());
        return panel;
    }

    private JPanel createResetButton() {
        JPanel panel = new JPanel();
        btnReset.addActionListener(e -> resetToDefault());
        panel.add(btnReset);
        return panel;
    }

    private void resetToDefault() {
        // Reset all to default values
        lstFont.setSelectedIndex(0);
        txtSize.setText("20");
        chkBold.setSelected(false);
        chkItalic.setSelected(false);
        cmdLeft.setSelected(true);
        chkTrans.setSelected(false);
        sldRfg.setValue(0);
        sldGfg.setValue(0);
        sldBfg.setValue(0);
        sldRbg.setValue(255);
        sldGbg.setValue(255);
        sldBbg.setValue(255);
        updateTextAppearance();
    }

    private JPanel createBorder() {
        JPanel panel = new JPanel(new GridLayout(1, 2));
        JLabel colorLabel = new JLabel("Background Color");
        JButton colorButton = new JButton("Change Color");
        colorButton.addActionListener(e -> updateTextAppearance());

        panel.add(colorLabel);
        panel.add(colorButton);
        return panel;
    }

    private JPanel createText() {
        txtText.setText(lblText.getText());
        JPanel panel = new JPanel(new BorderLayout(10, 0));
        panel.setBorder(new EmptyBorder(5, 0, 5, 0));
        JLabel label = new JLabel("Text");
        panel.add(new JLabel("Text"), BorderLayout.WEST);
        panel.add(txtText);
        return panel;
    }

    private JPanel createColor(String text, int width, JSlider slider, int min, int max, int value) {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel label = new JLabel(" " + text);
        label.setPreferredSize(new Dimension(width, 30));
        panel.add(label, BorderLayout.WEST);
        slider.setMinimum(min);
        slider.setMaximum(max);
        slider.setValue(value);
        slider.setMajorTickSpacing(50);
        slider.setMinorTickSpacing(10);
        slider.setPaintTicks(true);
        panel.add(slider);
        return panel;
    }

    private JPanel createColors(JSlider sldRed, JSlider sldGreen, JSlider sldBlue, int red, int green, int blue) {
        JPanel panel = new JPanel(new GridLayout(1, 3));
        panel.add(createColor("Red", 40, sldRed, 0, 255, red));
        panel.add(createColor("Green", 50, sldGreen, 0, 255, green));
        panel.add(createColor("Blue", 40, sldBlue, 0, 255, blue));
        return panel;
    }

    private JPanel createBg() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(5, 0, 5, 0));
        JLabel label = new JLabel("Background");
        label.setPreferredSize(new Dimension(120, 30));
        panel.add(label, BorderLayout.WEST);
        panel.add(createColors(sldRbg, sldGbg, sldBbg, 255, 255, 255));
        return panel;
    }

    private JPanel createFg() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(5, 0, 5, 0));
        JLabel label = new JLabel("Text color");
        label.setPreferredSize(new Dimension(120, 30));
        panel.add(label, BorderLayout.WEST);
        panel.add(createColors(sldRfg, sldGfg, sldBfg, 0, 0, 0));
        return panel;
    }

    private JPanel createFonts() {
        JPanel panel = new JPanel(new BorderLayout(10, 0));
        JLabel label = new JLabel("Font");
        panel.add(new JLabel("Font"), BorderLayout.WEST);
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for (String font : fonts) {
            model.addElement(font);
        }
        lstFont = new JComboBox(model);
        panel.add(lstFont);
        return panel;
    }

    private JPanel createFont() {
        JPanel panel = new JPanel(new BorderLayout(10, 0));
        panel.setBorder(new EmptyBorder(5, 0, 5, 0));
        panel.add(createFonts());
        JPanel east = new JPanel();
        east.add(chkBold);
        east.add(chkItalic);
        east.add(new JLabel(" | Alignment"));
        ButtonGroup group = new ButtonGroup();
        group.add(cmdLeft);
        group.add(cmdCenter);
        group.add(cmdRight);
        east.add(cmdLeft);
        east.add(cmdCenter);
        east.add(cmdRight);
        panel.add(east, BorderLayout.EAST);
        return panel;
    }

    private void updateTextAppearance() {
        String selectedFont = (String) lstFont.getSelectedItem();
        Font currentFont = lblText.getFont();
        
        int fontStyle = Font.PLAIN;
        if (chkBold.isSelected()) fontStyle |= Font.BOLD;
        if (chkItalic.isSelected()) fontStyle |= Font.ITALIC;
        
        int fontSize = Integer.parseInt(txtSize.getText());
        
        lblText.setFont(new Font(selectedFont, fontStyle, fontSize));
        
        Color textColor = new Color(sldRfg.getValue(), sldGfg.getValue(), sldBfg.getValue());
        lblText.setForeground(textColor);
        
        Color bgColor = new Color(sldRbg.getValue(), sldGbg.getValue(), sldBbg.getValue());
        lblText.setBackground(chkTrans.isSelected() ? new Color(0, 0, 0, 0) : bgColor);
        
        if (cmdLeft.isSelected()) {
            lblText.setHorizontalAlignment(JLabel.LEFT);
        } else if (cmdCenter.isSelected()) {
            lblText.setHorizontalAlignment(JLabel.CENTER);
        } else if (cmdRight.isSelected()) {
            lblText.setHorizontalAlignment(JLabel.RIGHT);
        }
    }
    
    public static void main(String[] args) {
        new MainWindow();
    }
}

