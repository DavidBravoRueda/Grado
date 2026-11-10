/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package its.CounterGui.view;

import its.CounterGui.controller.CounterListener;
import its.CounterGui.model.CounterModel;
import javax.swing.JFrame;

/**
 *
 * @author davidbravorueda
 */
public class CounterFrame extends JFrame {

    public CounterFrame() {
        setTitle("Counter App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        CounterPanel panel = new CounterPanel();

        add(panel);
    }
}
