package exemploseventos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Representa uma janela contendo dois botões de comando: um botão com um texto
 * e outro botão com um texto e um ícone que muda à passagem do rato. Um clique 
 * nestes botões gera uma caixa de diálogo com informação sobre o botão acionado.
 *
 * @author ISEP-DEI-PPROG
 */
public class JanelaEventosBotao extends JFrame {

    /**
     * A instância da classe interna TrataEvento para executar o método de 
     * evento quando um botão de comando é acionado.
     */
    private TrataEvento trataEvento;

    /**
     * A largura da janela em píxeis.
     */
    private static final int JANELA_LARGURA = 350;

    /**
     * A altura da janela em píxeis.
     */
    private static final int JANELA_ALTURA = 350;

    /**
     * Constrói uma instância de JanelaEventosBotao.
     */
    public JanelaEventosBotao() {

        super("Teste de Botões");

        setLayout(new FlowLayout());

        trataEvento = new TrataEvento();

        JButton bt1 = criarBotaoComTexto();
        JButton bt2 = criarBotaoComTextoEImagem();
        
        add(bt1);
        add(bt2);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(JANELA_LARGURA, JANELA_ALTURA);
        setVisible(true);
    }

    /**
     * Cria e devolve um botão de comando com um texto. Se este botão for 
     * acionado, surge uma caixa de diálogo que mostra o seu texto. 
     */
    private JButton criarBotaoComTexto() {
        JButton bt1 = new JButton("Botão 1");
        bt1.setMnemonic(KeyEvent.VK_B);
        bt1.setForeground(Color.BLUE);
        final int BOTAO_LARGURA = 80, BOTAO_ALTURA = 50;
        bt1.setPreferredSize(new Dimension(BOTAO_LARGURA, BOTAO_ALTURA));
        
        /* 
         * Regista a instância de TrataEvento destinada a executar o método de 
         * evento depois do botão bt1 ser acionado.  
        */        
        bt1.addActionListener(trataEvento);
        
        return bt1;
    }

    /**
     * Cria e devolve um botão de comando com um texto e um ícone que muda à 
     * passagem do rato. Se este botão for acionado, surge uma caixa de diálogo 
     * que mostra o seu texto. 
     */
    private JButton criarBotaoComTextoEImagem() {
        Icon ic1 = new ImageIcon("tips.gif");
        Icon ic2 = new ImageIcon("bullet.gif");

        JButton bt2 = new JButton("Botão 2", ic1);
        final int BOTAO_LARGURA = 110, BOTAO_ALTURA = 50;
        bt2.setPreferredSize(new Dimension(BOTAO_LARGURA, BOTAO_ALTURA));
        bt2.setToolTipText("Botao 2");
        
        // Muda o ícone do botão bt2 à passagem do rato.
        bt2.setRolloverIcon(ic2);                     
        
        /* 
         * Regista a instância de TrataEvento destinada a executar o método de 
         * evento depois do botão bt2 ser acionado.  
        */        
        bt2.addActionListener(trataEvento);
        
        return bt2;

    }

    /**
     * Classe interna que representa um objeto para tratar os eventos do tipo 
     * Action gerados pelos botões de comando.
     */
    private class TrataEvento implements ActionListener {

        /**
         * Método de evento do tipo Action gerado quando um botão de comando 
         * é acionado. Este método mostra uma mensagem ao utilizador informando 
         * o botão acionado.
         *
         * @param e o objeto de evento Action gerado por um botão de comando 
         *          quando é acionado
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(JanelaEventosBotao.this,
                    "Carregou em " + e.getActionCommand());
        }
    }
}
