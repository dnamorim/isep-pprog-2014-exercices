package gestoresdeposicionamento;

import java.awt.*;
import javax.swing.*;

/**
 * Representa uma janela cujo ContentPane tem um gestor de posicionamento 
 * FlowLayout.
 * 
 * @author ISEP-DEI-PPROG
 */
public class FlowLayout1 extends JFrame {

    /**
     * A largura da janela em píxeis.
     */
    private static final int JANELA_LARGURA = 400;

    /**
     * A altura da janela em píxeis.
     */
    private static final int JANELA_ALTURA = 200;

    /**
     * Constrói uma instância de FlowLayout1.
     *
     * @param titulo o título da janela
     */
    public FlowLayout1(String titulo) {

        super(titulo);

        getContentPane().setBackground(Color.cyan);

        FlowLayout fl = new FlowLayout();
        setLayout(fl);

        criarComponentes();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(JANELA_LARGURA, JANELA_ALTURA);
        setVisible(true);
    }

    /**
     * Cria e adiciona componentes à janela.
     */
    private void criarComponentes() {
        JButton bt1 = new JButton("Um");
        JButton bt2 = new JButton("Dois");
        JButton bt3 = new JButton("Tres");
        JButton bt4 = new JButton("Quatro");
        JButton bt5 = new JButton("Cinco");
        JButton bt6 = new JButton("Seis");
        JButton bt7 = new JButton("Sete");

        add(bt1);
        add(bt2);
        add(bt3);
        add(bt4);
        add(bt5);
        add(bt6);
        add(bt7);
    }

    /**
     * Para testar a janela FlowLayout1.
     *
     * @param args as opções de execução
     */
    public static void main(String[] args) {

        FlowLayout1 jan = new FlowLayout1("Gestor de Posicionamento: FlowLayout");

    }
}
