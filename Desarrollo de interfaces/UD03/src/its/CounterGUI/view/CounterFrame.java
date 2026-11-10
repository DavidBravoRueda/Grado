/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package its.CounterGUI.view;

import java.awt.BorderLayout;

/**
 *
 * @author davidbravorueda
 */
public class CounterFrame extends SimpleFrame{

    public void CounterFrame(String tittle) {
        CounterPanel counterPanel1 = new CounterPanel();
        this.getContentPane().add(counterPanel1, BorderLayout.CENTER);
    }
        
}
