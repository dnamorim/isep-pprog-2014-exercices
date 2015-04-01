package exemploseventos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Representa uma janela contendo três labels: 
 * - uma label com texto e que faz surgir, após um clique nela, uma caixa de 
 *   diálogo mostrando o seu texto; 
 * - uma label inicializada com um ícone e um texto que muda de cor à passagem 
 *   do rato; 
 * - uma label com texto e ícone adicionados depois da criação da label.
 *
 * @author ISEP-DEI-PPROG
 */
public class JanelaEventosLabel extends JFrame {

    /**
     * A largura da janela em píxeis.
     */
    private static final int JANELA_LARGURA = 400;

    /**
     * A altura da janela em píxeis.
     */
    private static final int JANELA_ALTURA = 200;

    /**
     * Constrói uma instância de JanelaEventosLabel.
     */
    public JanelaEventosLabel() {

        super("Teste de Labels");

        setLayout(new FlowLayout());

        JLabel lbl1 = criarLabelComTexto();
        
        Icon icone = new ImageIcon("tips.GIF");
        JLabel lbl2 = criarLabelComTextoEImagem1(icone);
        JLabel lbl3 = criarLabelComTextoEImagem2(icone);

        add(lbl1);
        add(lbl2);
        add(lbl3);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(JANELA_LARGURA, JANELA_ALTURA);
        setVisible(true);

    }

    /**
     * Cria e devolve uma label com texto. Um clique nesta label faz surgir uma 
     * caixa de diálogo mostrando o seu texto.
     */
    private JLabel criarLabelComTexto() {
        JLabel lbl1 = new JLabel("TEXTO");
        lbl1.setToolTipText("Label 1");

        /* 
         * Regista uma nova instância de TrataEvento1 destinada a executar o  
         * método de evento após a ocorrência de um clique do rato na label 
         * lbl1.  
        */
        lbl1.addMouseListener(new TrataEvento1());
        
        return lbl1;
    }

    /**
     * Cria e devolve uma label com ícone e texto, sendo este alinhado à 
     * direita. Um clique nesta label faz surgir uma caixa de diálogo que 
     * mostra o seu texto.
     */
    private JLabel criarLabelComTextoEImagem1(Icon icone) {        
        JLabel lbl2 = new JLabel("TEXTO e ÍCONE", icone, SwingConstants.RIGHT);
        lbl2.setForeground(Color.RED);
        lbl2.setFont(new Font("TimesRoman", Font.BOLD, 20));
        lbl2.setToolTipText("Label 2");
        lbl2.setPreferredSize(new Dimension(200, 100));

        /* 
         * Regista uma nova instância de TrataEvento2 destinada a executar o  
         * método de evento após a entrada/saída do rato na label lbl2.
        */
        lbl2.addMouseListener(new TrataEvento2());
        
        return lbl2;         
    }

    /**
     * Cria e devolve uma label vazia e, posteriormente, é adicionado um texto 
     * e um ícone.
     */
    private JLabel criarLabelComTextoEImagem2(Icon icone) {
        JLabel lbl3 = new JLabel();
        lbl3.setText("TEXTO e ÍCONE no FIM");
        lbl3.setIcon(icone);
        lbl3.setHorizontalTextPosition(SwingConstants.CENTER);
        lbl3.setVerticalTextPosition(SwingConstants.BOTTOM);
        lbl3.setToolTipText("Label 3");
        
        return lbl3;         
    }

    /**
     * Classe interna que representa um objeto para tratar os eventos do tipo 
     * Mouse gerados por cliques do rato numa label.
     */ 
    private class TrataEvento1 extends MouseAdapter {

        /**
         * Método de evento do tipo Mouse gerado por uma label, após um clique
         * do rato sobre ela. Este método mostra uma mensagem ao utilizador
         * informando a label indicada.
         *
         * @param e o objeto de evento do tipo Mouse gerado por uma label após
         *          um clique do rato sobre ela
         */
        @Override
        public void mouseClicked(MouseEvent e) {

            String texto = "Clicou na label com texto: ";
            texto += ((JLabel) e.getSource()).getText();
            JOptionPane.showMessageDialog(JanelaEventosLabel.this, texto);

        }
    }
    
    /**
     * Classe interna que representa um objeto para tratar os eventos do tipo 
     * Mouse gerados na passagem do rato sobre uma label.
     */    
    private class TrataEvento2 extends MouseAdapter {

        /**
         * Método de evento do tipo Mouse gerado por uma label quando o rato 
         * entra nessa label. Este método muda a cor da label para preto. 
         *
         * @param e o objeto de evento do tipo Mouse gerado por uma label quando
         *          o rato entra nessa label
         */
        @Override
        public void mouseEntered(MouseEvent e) {
            ((JLabel) e.getSource()).setForeground(Color.BLACK);
        }

        /**
         * Método de evento do tipo Mouse gerado por uma label quando o rato sai 
         * dessa label. Este método muda a cor da label para encarnado.
         *
         * @param e o objeto de evento do tipo Mouse gerado por uma label quando
         *          o rato sai dessa label
         */
        @Override
        public void mouseExited(MouseEvent e) {
            ((JLabel) e.getSource()).setForeground(Color.RED);
        }

    }
}
