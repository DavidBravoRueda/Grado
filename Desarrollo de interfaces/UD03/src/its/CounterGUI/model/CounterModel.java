/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package its.CounterGUI.model;

/**
 *
 * @author davidbravorueda
 */
public class CounterModel {
    private int value;
    
    public CounterModel(){
        value = 0;
    }
    
    public void Increment(){
        value++;
    }
    
    public void Decrement(){
        value--;
    }
    
    public void Reset(){
        value = 0;
    }
    
    public int getValue(){
        return value;
    }
}
