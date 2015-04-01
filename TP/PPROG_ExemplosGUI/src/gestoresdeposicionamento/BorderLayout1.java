package gestoresdeposicionamento;

import java.awt.*;
import javax.swing.*;

/**
 * Representa uma janela cujo ContentPane tem um gestor de posicionamento 
 * BorderLayout.
 * 
 * @author ISEP-DEI-PPROG
 */
public class BorderLayout1 extends JFrame {
    
    /**
     * A largura da janela em píxeis.
     */
    private static final int JANELA_LARGURA = 400;
    
    /**
     * A altura da janela em píxeis.
     */
    private static final int JANELA_ALTURA = 200;    
    
    
    /**
     * Constrói uma instância de BorderLayout1.
     * 
     * @param titulo o título da janela
     */    
    public BorderLayout1(String titulo) {

        super(titulo);

        getContentPane().setBackground(Color.cyan);

        BorderLayout bl = new BorderLayout();
        setLayout(bl);
        
        criarComponentes();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(JANELA_LARGURA, JANELA_ALTURA);
        setVisible(true);
    }
    
    /**
     * Cria e adiciona componentes à janela.
     */
    private void criarComponentes(){
        JButton bt1 = new JButton("Um");
        JButton bt2 = new JButton("Dois");
        JButton bt3 = new JButton("Tres");
        JButton bt4 = new JButton("Quatro");
        JButton bt5 = new JButton("Cinco");
        JButton bt6 = new JButton("Seis");
        JButton bt7 = new JButton("Sete");
        
        add(bt1, BorderLayout.NORTH);
        add(bt2, BorderLayout.WEST);
        add(bt3, BorderLayout.CENTER);
        add(bt4, BorderLayout.EAST);
        add(bt5, BorderLayout.SOUTH);
    }
    
    /**
     * Para testar a janela BorderLayout1.
     * 
     * @param args as opções de execução
     */
    public static void main(String [] args) {

        BorderLayout1 jan = new BorderLayout1("Gestor de Posicionamento: BorderLayout");
        
    }
}
