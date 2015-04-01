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
public class DialogTrabPeca extends JDialog {
    
    private JTextField txtNome, txtNrPecas1, txtNrPecas2;
    private TrabPeca t;
    
    private static String TITULO_JANELA;
    private static final int DIALOGO_DESVIO_X = 100, DIALOGO_DESVIO_Y = 100;
    private static final Dimension LABEL_SIZE = new JLabel("Nrº de Peças Tipo 1:").getPreferredSize();
    
    public DialogTrabPeca(Frame pai) {
        this(pai, null);
        
    }
    
    public DialogTrabPeca(Frame pai, TrabPeca t) {
        super(pai, true);
        TITULO_JANELA = ((t == null) ? "Criar " : "Alterar ")+"Trabalhador à Peça";
        setTitle(TITULO_JANELA);
        
        this.t = t; 
        
        JPanel p1 = criarPainelNome();
        JPanel p2 = new JPanel(new GridLayout(2,1));
        JPanel p3 = criarPainelBotoes();
        
        p2.add(criarPainelNrPecas1());
        p2.add(criarPainelNrPecas2());
        
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

    private JPanel criarPainelNrPecas1() {
        JLabel lbl1 = new JLabel("Nrº de Peças Tipo 1:", JLabel.RIGHT);
        lbl1.setPreferredSize(LABEL_SIZE);
        
        final int CAMPO_LARGURA = 20;
        txtNrPecas1 = new JTextField(CAMPO_LARGURA);
        txtNrPecas1.setText((t == null) ? "" : Integer.toString(t.getNumPecas1()));
        
        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        p.add(lbl1);
        p.add(txtNrPecas1);
       
        return p;
    }
    
    private JPanel criarPainelNrPecas2() {
        JLabel lbl =  new JLabel("Nrº de Peças Tipo 2:", JLabel.RIGHT);
        lbl.setPreferredSize(LABEL_SIZE);
        
        final int CAMPO_LARGURA = 20;
        txtNrPecas2 = new JTextField(CAMPO_LARGURA);
        txtNrPecas2.setText((t == null) ? "" : ""+t.getNumPecas2());
        
        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        p.add(lbl);
        p.add(txtNrPecas2);
        
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
                    int nrPecas1 = Integer.parseInt(txtNrPecas1.getText());
                    int nrPecas2 = Integer.parseInt(txtNrPecas2.getText());
                    if(t == null) {
                       Empresa.addWorker(new TrabPeca(nome, nrPecas1, nrPecas2));
                    } else {
                        t.setNome(nome);
                        t.setNumPecas1(nrPecas1);
                        t.setNumPecas2(nrPecas2);
                    }
                    dispose();
                } catch (NumberFormatException exp) {
                    JOptionPane.showMessageDialog(DialogTrabPeca.this, 
                            "Tem que introduzir um valor numérico no Nrº de Peças do Trabalhador.",
                            TITULO_JANELA, JOptionPane.WARNING_MESSAGE);
                }
                //ATENÇÃO: Adicionar Excepções para nome Inserido e Nr Pecas
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
