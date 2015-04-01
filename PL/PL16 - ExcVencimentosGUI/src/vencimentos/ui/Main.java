/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vencimentos.ui;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import vencimentos.model.*;
/**
 *
 * @author Duarte Nuno Amorim <1130674@isep.ipp.pt>
 */
public class Main {

    public static void main(String[] args) {
        try {
            new Janela();
            Empresa.readFile();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível abrir os dados dos trabalhadores.", "Gestão de Vencimentos", JOptionPane.WARNING_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível ler os dados dos trabalhadores.", "Gestão de Vencimentos", JOptionPane.WARNING_MESSAGE);
        }
        
    }
}
