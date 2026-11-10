/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buttonsapp;

import buttonsapp.model.ButtonPressed;
import buttonsapp.view.ButtonsFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author davidbravorueda
 */
public class Buttons {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ButtonPressed model = new ButtonPressed();
            
            ButtonsFrame frame = new ButtonsFrame(model);
            frame.setVisible(true);
        });
    }
}


