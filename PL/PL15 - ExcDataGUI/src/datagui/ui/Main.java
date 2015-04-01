package datagui.ui;

import java.awt.image.ImageObserver;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        try {
            Janela j = new Janela();
        } catch (Exception exp) {
            JOptionPane.showMessageDialog(null, exp.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

}

