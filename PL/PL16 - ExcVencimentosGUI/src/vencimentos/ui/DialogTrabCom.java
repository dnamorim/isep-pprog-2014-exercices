/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vencimentos.ui;

import vencimentos.model.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 *
 * @author Duarte Nuno Amorim <1130674@isep.ipp.pt>
 */
public class DialogTrabCom extends JDialog {
    
    private JTextField txtNome, txtSalario, txtVendas, txtComissao;
    private TrabCom t;
    
    private static String TITULO_JANELA;
    private static final int DIALOGO_DESVIO_X = 100, DIALOGO_DESVIO_Y = 100;
    private static final Dimension LABEL_SIZE = new JLabel("Comissão (%):").getPreferredSize();
    
    public DialogTrabCom(Frame pai) {
        this(pai, null);
        
    }
    
    public DialogTrabCom(Frame pai, TrabCom t) {
        super(pai, true);
        TITULO_JANELA = ((t == null) ? "Criar " : "Alterar ")+"Trabalhador à Comissão";
        setTitle(TITULO_JANELA);
        
        this.t = t; 
        
        JPanel p1 = criarPainelNome();
        JPanel p2 = new JPanel(new GridLayout(3,1));
        JPanel p3 = criarPainelBotoes();
        
        p2.add(criarPainelSalario());
        p2.add(criarPainelVendas());
        p2.add(criarPainelComissao());
        
        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);
        add(p3, BorderLayout.SOUTH);
        
        setLocation(pai.getX() + DIALOGO_DESVIO_X, pai.getY() + DIALOGO_DESVIO_Y);
        pack();
        setResizable(false);
        setVisible(true);
    }
    
    private JPanel criarPainelNome() {
        JLabel lbl = new JLabel("Nome:", JLabel.RIGHT);
        lbl.setPreferredSize(LABEL_SIZE);
        
        final int CAMPO_LARGURA = 20;
        txtNome = new JTextField(CAMPO_LARGURA);
        txtNome.setText((t == null) ? "" : t.getNome());
        txtNome.requestFocus();
        
        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        p.setBorder(new EmptyBorder(10,0,0,0));
        
        p.add(lbl);
        p.add(txtNome);

        return p;
    }

    private JPanel criarPainelSalario() {
        JLabel lbl = new JLabel("Salário (€):", JLabel.RIGHT);
        lbl.setPreferredSize(LABEL_SIZE);
        
        final int CAMPO_LARGURA = 20;
        txtSalario = new JTextField(CAMPO_LARGURA);
        txtSalario.setText((t == null) ? "" : ""+t.getSalarioBase());
        
        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
       
        p.add(lbl);
        p.add(txtSalario);
        
        return p;
    }
    
    private JPanel criarPainelVendas() {
        JLabel lbl = new JLabel("Vendas (€):", JLabel.RIGHT);
        lbl.setPreferredSize(LABEL_SIZE);
        
        final int CAMPO_LARGURA = 20;
        txtVendas = new JTextField(CAMPO_LARGURA);
        txtVendas.setText((t == null) ? "" : ""+t.getVendas());
             
        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        p.add(lbl);
        p.add(txtVendas);
        
        return p;
    }
    
    private JPanel criarPainelComissao() {        
        JLabel lbl = new JLabel("Comissão (%):", JLabel.RIGHT);
        lbl.setPreferredSize(LABEL_SIZE);
        
        final int CAMPO_LARGURA = 20;
        txtComissao = new JTextField(CAMPO_LARGURA);
        txtComissao.setText((t == null) ? "" : ""+t.getComissao());
        
        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        p.add(lbl);
        p.add(txtComissao);
        
        return p;
    }
    
    private JPanel criarPainelBotoes() {
        JButton btnOk = criarBotaoOK();
        getRootPane().setDefaultButton(btnOk);
        
        JButton btnCancelar = criarBotaoCancelar();
        
        JPanel p = new JPanel();
        final int MARGEM_SUPERIOR = 0, MARGEM_INFERIOR = 10;
        final int MARGEM_ESQUERDA = 10, MARGEM_DIREITA = 10;
        p.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                MARGEM_INFERIOR, MARGEM_DIREITA));
        p.add(btnOk);
        p.add(btnCancelar);

        return p;
    }
    
    private JButton criarBotaoOK() {
        JButton btn = new JButton("OK");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nome = txtNome.getText();
                    float salario = Float.parseFloat(txtSalario.getText());
                    float vendas = Float.parseFloat(txtVendas.getText());
                    float comissao = Float.parseFloat(txtComissao.getText());
                    
                    if(t == null) {
                       Empresa.addWorker(new TrabCom(nome, salario, vendas, comissao));
                    } else {
                        t.setNome(nome);
                        t.setSalarioBase(salario);
                        t.setVendas(vendas);
                        t.setComissao(comissao);
                    }
                    dispose();
                } catch (NumberFormatException exp) {
                    JOptionPane.showMessageDialog(DialogTrabCom.this, 
                            "Tem que introduzir um valor numérico válido nos campos de Salário, Vendas e Comissão.",
                            TITULO_JANELA, JOptionPane.WARNING_MESSAGE);
                }
                //ATENÇÃO: Adicionar Excepções para nome Inserido e valores vencimento
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
