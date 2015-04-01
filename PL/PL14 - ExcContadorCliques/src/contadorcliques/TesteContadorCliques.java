/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package contadorcliques;

import contadorcliques.*;
import javax.swing.*;

/**
 *
 * @author Duarte Nuno Amorim <1130674@isep.ipp.pt>
 */
public class TesteContadorCliques {
    public static void main(String[] args) {
        try {
            ContadorCliquesGUI gui = new ContadorCliquesGUI();
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
