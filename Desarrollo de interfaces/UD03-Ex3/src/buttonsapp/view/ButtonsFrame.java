/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buttonsapp.view;

import buttonsapp.controller.ButtonsListener;
import buttonsapp.model.ButtonPressed;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author davidbravorueda
 */
public class ButtonsFrame extends JFrame {

    public ButtonsFrame(ButtonPressed model) {
        setTitle("ButtonsApp");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        ButtonsPanel buttonsPanel = new ButtonsPanel();
        add(buttonsPanel);

        ButtonsListener listener = new ButtonsListener(model, buttonsPanel);
        for (JButton button : buttonsPanel.getButtons()) {
            button.addActionListener(listener);
        }
    }
}