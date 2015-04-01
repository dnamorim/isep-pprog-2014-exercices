package conversor;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Representa a interface gráfica (GUI) da aplicação Conversor. Esta interface 
 * usa um ContentPane com um gestor de posicionamento GridLayout e objetos de 
 * evento de classes anónimas.
 * 
 * @author ISEP-DEI-PPROG
 */
public class ConversorGUI_3 extends JFrame {

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
     * Constrói uma instância de ConversorGUI_3.
     */
    public ConversorGUI_3() {

        super("Conversor Centígrados - Fahrenheit");

        final int NUMERO_LINHAS = 3, NUMERO_COLUNAS = 1;
        final int INTERVALO_HORIZONTAL = 5, INTERVALO_VERTICAL = 5;
        setLayout(new GridLayout(NUMERO_LINHAS, NUMERO_COLUNAS,
                INTERVALO_HORIZONTAL, INTERVALO_VERTICAL));

        JPanel pCentigrados = criarPainelCentigrados();
        JPanel pFahrenheit = criarPainelFahrenheit();
        JPanel pBotoes = criarPainelBotoes();

        add(pCentigrados);
        add(pFahrenheit);
        add(pBotoes);

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

        JPanel p = new JPanel();
        p.add(lbl);
        txtFahrenheit.setEnabled(false);
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

        JButton btnConverter = criarBotaoConverter();
        JButton btnLimpar = criarBotaoLimpar();
        JButton btnSair = criarBotaoSair();

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
     * Contém uma classe anónima que é instanciada, sendo o objeto criado  
     * registado no botão de comando, de modo a executar o seu método de evento 
     * quando o botão é acionado. Este método de evento calcula e mostra o 
     * resultado da conversão de graus centígrados em fahrenheit. Se o valor 
     * em graus centígrados for inválido, o utilizador é informado dessa 
     * situação através de uma caixa de diálogo.
     *
     * @return botão de comando btnConverter
     */
    private JButton criarBotaoConverter() {
        JButton btn = new JButton("Converter");
        btn.setMnemonic(KeyEvent.VK_C);
        btn.setToolTipText("Efetua a conversão centígrados->fahrnheit");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double cent = Double.parseDouble(txtCentigrados.getText());
                    double fahr = 1.8 * cent + 32;
                    txtFahrenheit.setText(String.valueOf(fahr));
                } catch (NumberFormatException excecao) {
                    JOptionPane.showMessageDialog(ConversorGUI_3.this,
                            "Não foi introduzido um valor numérico!",
                            "Centígrados",
                            JOptionPane.ERROR_MESSAGE);
                    txtCentigrados.requestFocus();
                }
            }
        });
        return btn;
    }

    /**
     * Cria e devolve o botão de comando btnLimpar.
     * 
     * Contém uma classe anónima que é instanciada, sendo o objeto criado  
     * registado no botão de comando, de modo a executar o seu método de evento 
     * quando o botão é acionado. Este método de evento elimina o conteúdo dos 
     * dois campos de texto, txtCentigrados e txtFahrenheit. 
     *
     * @return botão de comando btnLimpar
     */
    private JButton criarBotaoLimpar() {
        JButton btn = new JButton("Limpar");
        btn.setToolTipText("Limpa o contéudo dos campos de texto");
        btn.setMnemonic(KeyEvent.VK_L);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtCentigrados.setText(null);
                txtFahrenheit.setText(null);
                txtCentigrados.requestFocus();
            }
        });
        return btn;
    }

    /**
     * Cria e devolve o botão de comando btnSair.
     * 
     * Contém uma classe anónima que é instanciada, sendo o objeto criado  
     * registado no botão de comando, de modo a executar o seu método de  
     * evento quando o botão é acionado. Este método de evento fecha a 
     * aplicação.
     *
     * @return botão de comando btnSair
     */
    private JButton criarBotaoSair() {
        JButton btn = new JButton("Sair");
        btn.setToolTipText("Fecha o programa");
        btn.setMnemonic(KeyEvent.VK_S);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        return btn;
    }

}
