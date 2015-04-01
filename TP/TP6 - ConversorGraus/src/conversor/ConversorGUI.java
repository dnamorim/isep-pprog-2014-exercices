package conversor;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Representa a interface gráfica (GUI) da aplicação Conversor. Esta interface 
 * usa um ContentPane com um gestor de posicionamento BorderLayout e um objeto 
 * de evento de uma classe interna.
 * 
 * @author ISEP-DEI-PPROG
 */
    public class ConversorGUI extends JFrame {

    /**
     * O campo de texto para o utilizador introduzir um valor em graus 
     * centígrados.  
     */
    private JTextField txtCentigrados;
    
    /**
     * O campo de texto para mostrar o resultado da conversão de graus  
     * centígrados em fahrenheit.
     */
    private JTextField txtFahrenheit;
    
    /**
     * O botão de comando para ordenar a conversão de graus centígrados  
     * em fahrenheit.
     */
    private JButton btnConverter;
    
    /**
     * O botão de comando para ordenar a eliminação do conteúdo dos dois  
     * campos de texto, txtCentigrados e txtFahrenheit.
     */
    private JButton btnLimpar;
    
    /**
     * O botão de comando para ordenar o fim da aplicação.
     */    
    private JButton btnSair;
    
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
    private static final int JANELA_ALTURA = 175;
    
    /**
     * A coordenada x do canto superior esquerdo da janela.
     */
    private static final int POSICAO_X = 200;
    
    /**
     * A coordenada y do canto superior esquerdo da janela.
     */
    private static final int POSICAO_Y = 200;

    /**
     * Constrói uma instância de ConversorGUI.
     */
    public ConversorGUI() {

        super("Conversor Centígrados - Fahrenheit");

        JPanel pCentigrados = criarPainelCentigrados();
        JPanel pFahrenheit = criarPainelFahrenheit();
        JPanel pBotoes = criarPainelBotoes();

        add(pCentigrados, BorderLayout.NORTH);
        add(pFahrenheit, BorderLayout.CENTER);
        add(pBotoes, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setSize(JANELA_LARGURA, JANELA_ALTURA);
        // Alternativa ao setSize()
        // pack();
        
        setMinimumSize(new Dimension(getWidth(), getHeight()));
        
        setLocation(POSICAO_X, POSICAO_Y);
        // Alternativa ao setLocation
        // setLocationRelativeTo(null);
        
        setVisible(true);
    }

    /**
     * Cria e devolve um painel contendo o campo de texto txtCentigrados e a 
     * respetiva legenda numa label.
     *
     * @return painel com o campo de texto txtCentigrados e a respetiva legenda 
     *         numa label
     */
    private JPanel criarPainelCentigrados() {
        JLabel lbl = new JLabel("Centígrados:");
        
        final int LARGURA = 10;
        txtCentigrados = new JTextField(LARGURA);

        JPanel p = new JPanel();
        final int MARGEM_SUPERIOR = 10,MARGEM_INFERIOR = 10;
        final int MARGEM_ESQUERDA = 40, MARGEM_DIREITA = 40;
        p.setBorder(BorderFactory.createEmptyBorder(MARGEM_SUPERIOR,
                MARGEM_ESQUERDA, MARGEM_INFERIOR, MARGEM_DIREITA));
        p.add(lbl);
        p.add(txtCentigrados);

        return p;
    }

    /**
     * Cria e devolve um painel contendo o campo de texto txtFahrenheit e a 
     * respetiva legenda numa label.
     *
     * @return painel com o campo de texto txtFahrenheit e a respetiva legenda 
     *         numa label
     */ 
    private JPanel criarPainelFahrenheit() {
        JLabel lbl = new JLabel("   Fahrenheit:");
        
        final int LARGURA = 10;
        txtFahrenheit = new JTextField(LARGURA);
        txtFahrenheit.setEnabled(false);

        JPanel p = new JPanel();
        p.add(lbl);
        p.add(txtFahrenheit);

        return p;
    }

    /**
     * Cria e devolve um painel contendo os botões de comando, btnConverter, 
     * btnLimpar e btnSair.
     *
     * @return painel dos botões de comando
     */
    private JPanel criarPainelBotoes() {

        trataEvento = new TrataEvento();

        btnConverter = criarBotaoConverter();
        btnLimpar = criarBotaoLimpar();
        btnSair = criarBotaoSair();

        getRootPane().setDefaultButton(btnConverter);

        JPanel p = new JPanel();
        final int MARGEM_SUPERIOR = 0,MARGEM_INFERIOR = 10;
        final int MARGEM_ESQUERDA = 0, MARGEM_DIREITA = 0;        
        p.setBorder(BorderFactory.createEmptyBorder(MARGEM_SUPERIOR,
                MARGEM_ESQUERDA, MARGEM_INFERIOR, MARGEM_DIREITA));
        p.add(btnConverter);
        p.add(btnLimpar);
        p.add(btnSair);

        return p;
    }

    /**
     * Cria e devolve o botão de comando btnConverter.
     *
     * @return botão de comando btnConverter
     */
    private JButton criarBotaoConverter() {
        JButton btn = new JButton("Converter");
        btn.setMnemonic(KeyEvent.VK_C);
        btn.setToolTipText("Efectua a conversão centígrados->fahrnheit");
        btn.addActionListener(trataEvento);
        return btn;
    }

    /**
     * Cria e devolve o botão de comando btnLimpar.
     *
     * @return botão de comando btnLimpar
     */  
    private JButton criarBotaoLimpar() {
        JButton btn = new JButton("Limpar");
        btn.setToolTipText("Limpa o contéudo dos campos de texto");
        btn.setMnemonic(KeyEvent.VK_L);
        btn.addActionListener(trataEvento);
        return btn;
    }

    /**
     * Cria e devolve o botão de comando btnSair.
     *
     * @return botão de comando btnSair
     */   
    private JButton criarBotaoSair() {
        JButton btn = new JButton("Sair");
        btn.setToolTipText("Fecha o programa");
        btn.setMnemonic(KeyEvent.VK_S);
        btn.addActionListener(trataEvento);
        return btn;
    }

    /**
     * Classe interna que representa um objeto para tratar os eventos do tipo 
     * Action gerados pelos botões de comando.
     */
    private class TrataEvento implements ActionListener {

        /**
         * Método de evento do tipo Action gerado por um botão de comando  
         * quando é acionado. Este método tem comportamentos diferentes, 
         * consoante o botão de comando acionado: com o botão btnLimpar
         * elimina o conteúdo dos dois campos de texto, txtCentigrados e
         * txtFahrenheit; com o botão btnConverter calcula e mostra o resultado 
         * da conversão de graus centígrados em fahrenheit. Se o valor em graus 
         * centígrados for inválido, o utilizador é informado dessa situação 
         * através de uma caixa de diálogo; com o botão btnSair a aplicação 
         * é fechada. 
         *
         * @param e o objeto de evento Action gerado por um botão de comando 
         *          quando é acionado
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            Object obj = e.getSource();
            if (obj == btnLimpar) {
                txtCentigrados.setText(null);
                txtFahrenheit.setText(null);
                txtCentigrados.requestFocus();
            } else if (obj == btnConverter) {
                try {
                    double cent = Double.parseDouble(txtCentigrados.getText());
                    double fahr = 1.8 * cent + 32;
                    txtFahrenheit.setText(String.valueOf(fahr));
                } catch (NumberFormatException excecao) {
                    JOptionPane.showMessageDialog(ConversorGUI.this, 
                            "Não foi introduzido um valor numérico!", 
                            "Centígrados", 
                            JOptionPane.ERROR_MESSAGE);
                    txtCentigrados.requestFocus();
                }
            } else {
                dispose();
            }
        }
    }

}
