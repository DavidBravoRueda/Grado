/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package its.CounterGUI.controller;

import its.CounterGUI.view.CounterPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author davidbravorueda
 */
public class CounterListener implements ActionListener{
    private CounterPanel countPanel;
    
    public CounterListener(CounterPanel countPanel){
        this.countPanel = countPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        System.out.println("actionCommand: " + actionCommand);
        
        if (actionCommand.equals("up")){
            countPanel.increment();
        }else if (actionCommand.equals("down")){
            countPanel.decrement();
        }else if (actionCommand.equals("reset")){
            countPanel.reset();
        }
    }
}
