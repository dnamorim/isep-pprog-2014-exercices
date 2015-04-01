package conversor;

import javax.swing.*;

/**
 * Classe principal para executar a aplicação Conversor.
 * 
 * @author ISEP-DEI-PPROG
 */
public class Main {
    
    public static void main(String[] args) {
        try {
            ConversorGUI janela = new ConversorGUI();
            // ConversorGUI_2 janela = new ConversorGUI_2();
            // ConversorGUI_3 janela = new ConversorGUI_3();
            
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            // Estilos alternativos
            // UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            // UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
            //  UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
        } catch (Exception excecao) {
            JOptionPane.showMessageDialog(null, excecao.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
