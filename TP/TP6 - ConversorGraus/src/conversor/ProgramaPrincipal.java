/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package conversor;

import conversor.*;
import javax.swing.*;

/**
 *
 * @author Duarte Nuno Amorim <1130674@isep.ipp.pt>
 */
public class ProgramaPrincipal {
    
    public static void main(String[] args) {
        try {
            //ConversorGUI jan = new ConversorGUI();
            //ConversorGUI_2 jan = new ConversorGUI_2(); 
            ConversorGUI_3 jan = new ConversorGUI_3(); 
            //UIManager.setLookAndFeel("com.sun.javax.swing.plaf.windows.WindowsLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

}
