/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buttonsapp.controller;

import buttonsapp.model.ButtonPressed;
import buttonsapp.view.ButtonsPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author davidbravorueda
 */
public class ButtonsListener implements ActionListener {
    private final ButtonPressed model;
    private final ButtonsPanel view;

    public ButtonsListener(ButtonPressed model, ButtonsPanel view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int buttonNumber = Integer.parseInt(e.getActionCommand());
            model.setButtonPressed(buttonNumber);

            view.updateLabel("El último botón pulsado fue el Num: " + buttonNumber);
        } catch (NumberFormatException ex) {
            view.updateLabel("Error: comando no válido.");
        }
    }
}