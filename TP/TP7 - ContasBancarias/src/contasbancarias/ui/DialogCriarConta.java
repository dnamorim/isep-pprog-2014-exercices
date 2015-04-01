package contasbancarias.ui;

import contasbancarias.model.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class DialogCriarConta extends JDialog {

    private JTextField txtTitular, txtDeposito;

    private static final int DIALOGO_DESVIO_X = 100, DIALOGO_DESVIO_Y = 100;
    private static final Dimension LABEL_TAMANHO = new JLabel("Depósito:").getPreferredSize();

    public DialogCriarConta(Frame pai) {

        super(pai, "Criar Conta", true);

        JPanel p1 = criarPainelTitular();
        JPanel p2 = criarPainelDeposito();
        JPanel p3 = criarPainelBotoes();

        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);
        add(p3, BorderLayout.SOUTH);

        setLocation(pai.getX() + DIALOGO_DESVIO_X, pai.getY() + DIALOGO_DESVIO_Y);
        pack();
        setResizable(false);
        setVisible(true);
    }

    private JPanel criarPainelTitular() {
        JLabel lbl = new JLabel("Titular:",JLabel.RIGHT);
        lbl.setPreferredSize(LABEL_TAMANHO);

        final int CAMPO_LARGURA = 20;
        txtTitular = new JTextField(CAMPO_LARGURA);
        txtTitular.requestFocus();

        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
        final int MARGEM_SUPERIOR = 10, MARGEM_INFERIOR = 0;
        final int MARGEM_ESQUERDA = 10, MARGEM_DIREITA = 0;
        p.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                MARGEM_INFERIOR, MARGEM_DIREITA));

        p.add(lbl);
        p.add(txtTitular);
        
        return p;
    }

    private JPanel criarPainelDeposito() {
        JLabel lbl = new JLabel("Depósito:",JLabel.RIGHT);
        lbl.setPreferredSize(LABEL_TAMANHO);

        final int CAMPO_LARGURA = 10;
        txtDeposito = new JTextField(CAMPO_LARGURA);

        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
        final int MARGEM_SUPERIOR = 0, MARGEM_INFERIOR = 0;
        final int MARGEM_ESQUERDA = 10, MARGEM_DIREITA = 0;
        p.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                MARGEM_INFERIOR, MARGEM_DIREITA));
        p.add(lbl);
        p.add(txtDeposito);

        return p;
    }

    private JPanel criarPainelBotoes() {
        JButton btnOK = criarBotaoOK();
        getRootPane().setDefaultButton(btnOK);
        
        JButton btnCancelar = criarBotaoCancelar();

        JPanel p = new JPanel();
        final int MARGEM_SUPERIOR = 0, MARGEM_INFERIOR = 10;
        final int MARGEM_ESQUERDA = 10, MARGEM_DIREITA = 10;
        p.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                MARGEM_INFERIOR, MARGEM_DIREITA));
        p.add(btnOK);
        p.add(btnCancelar);

        return p;
    }
    
    private JButton criarBotaoOK(){
        JButton btn = new JButton("OK");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nome = txtTitular.getText();
                    if(nome.isEmpty())
                        throw new TitularInvalidoException();
                    double deposito = Double.parseDouble(txtDeposito.getText());
                    Banco.adicionarConta(nome, deposito);
                    dispose();
                } catch (NumberFormatException excecao) {
                    JOptionPane.showMessageDialog(DialogCriarConta.this,
                            "Tem que introduzir um valor numérico no depósito.",
                            "Criação de Conta Bancária",
                            JOptionPane.WARNING_MESSAGE);
                    txtDeposito.requestFocus();
                } catch (TitularInvalidoException excecao) {
                    JOptionPane.showMessageDialog(DialogCriarConta.this,
                            "Tem que introduzir o nome do titular.",
                            "Criação de Conta Bancária",
                            JOptionPane.WARNING_MESSAGE);
                    txtTitular.requestFocus();
                } catch (DepositoInvalidoException excecao) {
                    JOptionPane.showMessageDialog(DialogCriarConta.this,
                            "Tem que introduzir um valor não negativo no depósito.",
                            "Criação de Conta Bancária",
                            JOptionPane.WARNING_MESSAGE);
                    txtDeposito.requestFocus();
                }
            }
        });
        return btn;
    }
    
    private JButton criarBotaoCancelar(){
        JButton btn = new JButton("Cancelar");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        return btn;
    }

}
