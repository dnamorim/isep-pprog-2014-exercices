package exemploseventos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Representa uma janela contendo três campos de texto: 
 * - um campo vazio e editável. O uso da tecla ENTER faz surgir o conteúdo  
 *   deste campo, no campo de texto à sua direita; 
 * - um campo com texto por omissão e editável. O uso da tecla ENTER origina a 
 *   apresentação de uma caixa de diálogo com o texto deste campo; 
 * - um campo com texto não editável. 
 * 
 * @author ISEP-DEI-PPROG
 */
public class JanelaEventosTexto extends JFrame {

    /**
     * O campo de texto 1.
     */
    private JTextField txt1;

    /**
     * O campo de texto 2.
     */
    private JTextField txt2;
    
    /**
     * A instância da classe interna TrataEvento para executar um método de 
     * evento quando é usada a tecla ENTER num campo de texto.
     */
    private TrataEvento trataEvento;    

    /**
     * A largura da janela em píxeis.
     */
    private static final int JANELA_LARGURA = 350;

    /**
     * A altura da janela em píxeis.
     */
    private static final int JANELA_ALTURA = 200;

    /**
     * Constrói uma instância de JanelaEventosBotao.
     */
    public JanelaEventosTexto() {

        super("Teste de Campos de Texto");

        setLayout(new FlowLayout());

        trataEvento = new TrataEvento();

        txt1 = criarCampoDeTexto1();
        txt2 = criarCampoDeTexto2();
        JTextField txt3 = criarCampoDeTexto3();

        add(txt1);
        add(txt2);
        add(txt3);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(JANELA_LARGURA, JANELA_ALTURA);
        setVisible(true);
    }

    /**
     * Cria e devolve um campo de texto vazio com tamanho fixo.
     */
    private JTextField criarCampoDeTexto1() {
        JTextField txt1 = new JTextField(10);
        
        /* 
         * Regista a instância de TrataEvento destinada a executar o método de 
         * evento quando é usada a tecla ENTER no campo de texto txt1.  
        */        
        txt1.addActionListener(trataEvento);
        
        return txt1;
    }

    /**
     * Cria e devolve um campo de texto com texto por omissão.
     */
    private JTextField criarCampoDeTexto2() {
        JTextField txt2 = new JTextField("Escrever texto aqui");

        /* 
         * Regista a instância de TrataEvento destinada a executar o método de 
         * evento quando é usada a tecla ENTER no campo de texto txt2.  
        */        
        txt2.addActionListener(trataEvento);

        return txt2;
    }

    /**
     * Cria e devolve um campo de texto com texto não editável.
     */
    private JTextField criarCampoDeTexto3() {
        final int LARGURA = 20;
        JTextField txt3 = new JTextField("Campo não editável", LARGURA);
        txt3.setEditable(false);
        
        return txt3;
    }

    /**
     * Classe interna que representa um objeto para tratar os eventos do tipo 
     * Action gerados pelos campos de texto aquando do uso da tecla ENTER.
     */    
    private class TrataEvento implements ActionListener {

        /**
         * Método de evento do tipo Action gerado pelos campos de texto após o 
         * uso da tecla ENTER. No caso do campo txt1, este método substitui o 
         * conteúdo do campo txt2 pelo texto do campo txt1. No caso do campo 
         * txt2, este método mostra uma caixa de diálogo informando o texto do 
         * campo txt2.
         *
         * @param e o objeto de evento do tipo Action gerado pelo campo de texto
         *          quando é usada a tecla ENTER
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            Object obj = e.getSource();
            String s = "";
            if (obj == txt1) {
                s = "Texto 1: " + e.getActionCommand();
                txt2.setText(s);
            } else if (obj == txt2) {
                s = "Texto 2: " + e.getActionCommand();
                JOptionPane.showMessageDialog(JanelaEventosTexto.this, s);
            }
        }
    }
}
