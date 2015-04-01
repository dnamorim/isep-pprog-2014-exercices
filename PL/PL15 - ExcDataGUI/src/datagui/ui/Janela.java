package datagui.ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import datagui.model.*;

public class Janela extends JFrame {
    
    private JTextField txtData, txtSemana;
    private JLabel lblExtenso;
    private JButton btnSemana, btnExtenso, btnLimpar;
    private JPanel pData, pSemana, pExtenso;
         
    public Janela() {
        super("PPROG_PL15 - ExcDataGUI");
        
        pData = criarPainelData();
        pSemana = criarPainelSemana();
        pExtenso = criarPainelExtenso();
        JPanel pBotoes = criarPainelBotoes();
        JPanel pJanela = criarPainelJanela();
        
        add(pJanela, BorderLayout.CENTER);
        add(pBotoes, BorderLayout.SOUTH);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        pack();
        setMinimumSize(new Dimension(getWidth(), getHeight()));
        setLocationRelativeTo(null);
        
        setVisible(true);
    }
    
    private JPanel criarPainelData() {
        JLabel lbl = new JLabel("Data:");
        final int LARGURA = 10;
        txtData = new JTextField(LARGURA);
        txtData.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Data d = null;
                try {
                    d=lerData();
                    txtSemana.setText(d.diaDaSemana());
                    lblExtenso.setText(d.toString());
                } catch(MesInvalidoException | DiaInvalidoException exp) {
                    txtData.setText(null);
                    JOptionPane.showMessageDialog(Janela.this, exp.getMessage() ,"Erro",JOptionPane.ERROR_MESSAGE);
                    txtData.requestFocus();
                } catch(NumberFormatException | ArrayIndexOutOfBoundsException exp) {
                    txtData.setText(null);
                    JOptionPane.showMessageDialog(Janela.this, "Data é Inválida!", "Erro", JOptionPane.ERROR_MESSAGE);
                    txtData.requestFocus();
                }
            }
        });
        
        JPanel p = new JPanel();
        p.add(lbl);
        p.add(txtData);
        
        return p;
    }
    
    private JPanel criarPainelSemana() {
        JLabel lbl = new JLabel("Dia da Semana:");
        final int LARGURA = 10;
        txtSemana = new JTextField(LARGURA);
        txtSemana.setEditable(false);
        
        JPanel p = new JPanel();
        p.add(lbl);
        p.add(txtSemana);
        
        return p;
    }
    
    private JPanel criarPainelExtenso() {
        lblExtenso = new JLabel("", JLabel.CENTER);
        
        JPanel p = new JPanel();
        p.add(lblExtenso);
        
        return p;
    }
    
    private JPanel criarPainelJanela() {
        final int LINHAS = 3, COLUNAS = 1;
        JPanel p = new JPanel(new GridLayout(LINHAS, COLUNAS));
        
        p.add(pData);
        p.add(pSemana);
        p.add(pExtenso);
        
        return p;
    }
    
    private JPanel criarPainelBotoes() {
        btnSemana = criarBotaoSemana();
        btnExtenso = criarBotaoExtenso();
        btnLimpar = criarBotaoLimpar();
        
        getRootPane().setDefaultButton(btnSemana);
        
        JPanel p = new JPanel();
        p.add(btnSemana);
        p.add(btnExtenso);
        p.add(btnLimpar);
        
        return p;
    }
    
    private JButton criarBotaoSemana() {
        JButton btn = new JButton("Dia da Semana");
        btn.setMnemonic(KeyEvent.VK_S);
        btn.setToolTipText("Determina o dia da semana");
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Data d = null;
                try {
                    d=lerData();
                    txtSemana.setText(d.diaDaSemana());
                    lblExtenso.setText(null);
                } catch(MesInvalidoException | DiaInvalidoException exp) {
                    txtData.setText(null);
                    JOptionPane.showMessageDialog(Janela.this, exp.getMessage() ,"Erro",JOptionPane.ERROR_MESSAGE);
                    txtData.requestFocus();
                } catch(NumberFormatException | ArrayIndexOutOfBoundsException exp) {
                    txtData.setText(null);
                    JOptionPane.showMessageDialog(Janela.this, "Data é Inválida!", "Erro", JOptionPane.ERROR_MESSAGE);
                    txtData.requestFocus();
                }
            }
        });
        return btn;
    }

    private JButton criarBotaoExtenso() {
        JButton btn = new JButton("Data por Extenso");
        btn.setMnemonic(KeyEvent.VK_E);
        btn.setToolTipText("Imprime a data por extenso");
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Data d = null;
                try {
                    d=lerData();
                    txtSemana.setText(null);
                    lblExtenso.setText(d.toString());
                 } catch(MesInvalidoException | DiaInvalidoException exp) {
                    txtData.setText(null);
                    JOptionPane.showMessageDialog(Janela.this, exp.getMessage() ,"Erro",JOptionPane.ERROR_MESSAGE);
                    txtData.requestFocus();
                } catch(NumberFormatException | ArrayIndexOutOfBoundsException exp) {
                    txtData.setText(null);
                    JOptionPane.showMessageDialog(Janela.this, "Data é Inválida!", "Erro", JOptionPane.ERROR_MESSAGE);
                    txtData.requestFocus();
                }
            }
        });
        return btn;
    }
    
    
    private JButton criarBotaoLimpar() {
        JButton btn = new JButton("Limpar");
        btn.setMnemonic(KeyEvent.VK_L);
        btn.setToolTipText("Limpa a data");
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtData.setText(null);
                txtSemana.setText(null);
                lblExtenso.setText(null);
                txtData.requestFocus();
            }
        });
        return btn;
    }
    
    private Data lerData() {
        Data d = null;
        String[] data = txtData.getText().split("/");
        d = new Data(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]));
        return d;
    }
}
