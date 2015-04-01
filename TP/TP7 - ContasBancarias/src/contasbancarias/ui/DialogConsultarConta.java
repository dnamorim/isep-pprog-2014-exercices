package contasbancarias.ui;

import contasbancarias.model.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class DialogConsultarConta extends JDialog {

    private JTextField txtNrConta, txtTitular, txtSaldo;

    private static final int DIALOGO_DESVIO_X = 100, DIALOGO_DESVIO_Y = 100;
    private static final Dimension LABEL_TAMANHO = new JLabel("Nr. Conta:").getPreferredSize();

    public DialogConsultarConta(JFrame pai) {

        super(pai, "Consultar Conta", true);

        JPanel p1 = criarPainelSelecionaConta();
        JPanel p2 = criarPainelInfoConta();
        JPanel p3 = criarPainelBotao();

        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);
        add(p3, BorderLayout.SOUTH);

        setLocation(pai.getX() + DIALOGO_DESVIO_X, pai.getY() + DIALOGO_DESVIO_Y);
        pack();
        setResizable(false);
        setVisible(true);
    }

    private JPanel criarPainelSelecionaConta() {
        JLabel lbl = new JLabel("Conta: ");

        final JComboBox<String> cmbContas = new JComboBox<>(Banco.listaDeNumerosETitulares());
        cmbContas.setSelectedIndex(-1);
        cmbContas.setMaximumRowCount(3);
        cmbContas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nrEtitular = (String) (cmbContas.getSelectedItem());
                String[] aux = nrEtitular.split("-");
                int nrConta = Integer.parseInt(aux[0].trim());

                Conta conta = Banco.obterConta(nrConta);
                txtNrConta.setText(String.valueOf(nrConta));
                txtTitular.setText(conta.getTitular());
                txtSaldo.setText(String.format("%.2f", conta.getSaldo()));
            }
        });

        JPanel p = new JPanel();
        final int MARGEM_SUPERIOR = 10, MARGEM_INFERIOR = 10;
        final int MARGEM_ESQUERDA = 10, MARGEM_DIREITA = 10;
        p.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                MARGEM_INFERIOR, MARGEM_DIREITA));
        p.add(lbl);
        p.add(cmbContas);

        return p;
    }

    private JPanel criarPainelInfoConta() {
        JPanel p1 = criarPainelNumeroDeConta();
        JPanel p2 = criarPainelTitular();
        JPanel p3 = criarPainelSaldo();

        JPanel p = new JPanel(new GridLayout(3, 1));
        p.add(p1);
        p.add(p2);
        p.add(p3);

        return p;
    }

    private JPanel criarPainelNumeroDeConta() {
        JLabel lbl = new JLabel("Nr. Conta:", JLabel.RIGHT);
        lbl.setPreferredSize(LABEL_TAMANHO);

        final int CAMPO_LARGURA = 10;
        txtNrConta = new JTextField(CAMPO_LARGURA);
        txtNrConta.setEditable(false);

        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
        final int MARGEM_SUPERIOR = 0, MARGEM_INFERIOR = 0;
        final int MARGEM_ESQUERDA = 10, MARGEM_DIREITA = 10;
        p.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                MARGEM_INFERIOR, MARGEM_DIREITA));
        p.add(lbl);
        p.add(txtNrConta);

        return p;
    }

    private JPanel criarPainelTitular() {
        JLabel lbl = new JLabel("Titular:", JLabel.RIGHT);
        lbl.setPreferredSize(LABEL_TAMANHO);

        final int CAMPO_LARGURA = 20;
        txtTitular = new JTextField(CAMPO_LARGURA);
        txtTitular.setEditable(false);

        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
        final int MARGEM_SUPERIOR = 0, MARGEM_INFERIOR = 0;
        final int MARGEM_ESQUERDA = 10, MARGEM_DIREITA = 10;
        p.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                MARGEM_INFERIOR, MARGEM_DIREITA));
        p.add(lbl);
        p.add(txtTitular);

        return p;
    }

    private JPanel criarPainelSaldo() {
        JLabel lbl = new JLabel("Saldo:", JLabel.RIGHT);
        lbl.setPreferredSize(LABEL_TAMANHO);

        final int CAMPO_LARGURA = 10;
        txtSaldo = new JTextField(CAMPO_LARGURA);
        txtSaldo.setEditable(false);

        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
        final int MARGEM_SUPERIOR = 0, MARGEM_INFERIOR = 0;
        final int MARGEM_ESQUERDA = 10, MARGEM_DIREITA = 10;
        p.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                MARGEM_INFERIOR, MARGEM_DIREITA));
        p.add(lbl);
        p.add(txtSaldo);

        return p;
    }

    private JPanel criarPainelBotao() {
        JButton btnOk = new JButton("OK");
        getRootPane().setDefaultButton(btnOk);
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        JPanel p = new JPanel();
        final int MARGEM_SUPERIOR = 10, MARGEM_INFERIOR = 10;
        final int MARGEM_ESQUERDA = 10, MARGEM_DIREITA = 10;
        p.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                MARGEM_INFERIOR, MARGEM_DIREITA));
        p.add(btnOk);

        return p;
    }

}
