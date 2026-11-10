/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package its.CounterGui.controller;

import its.CounterGui.model.CounterModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

/**
 *
 * @author davidbravorueda
 */
public class CounterListener implements ActionListener {

    private final CounterModel model;
    private final JLabel label;

    public CounterListener(CounterModel model, JLabel label) {
        this.model = model;
        this.label = label;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        
        if (command.equals("Up")) {
            model.increment();
        } else if (command.equals("Down")) {
            model.decrement();
        }
        
        label.setText(String.valueOf(model.getCount()));
    }
}