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
public class DialogTrabHora extends JDialog {
    
    private JTextField txtNome, txtNrHoras, txtPagamentoHora;
    private TrabHora t;
    
    private static String TITULO_JANELA;
    private static final int DIALOGO_DESVIO_X = 100, DIALOGO_DESVIO_Y = 100;
    private static final Dimension LABEL_SIZE = new JLabel("Pagamento p/ Hora (€):").getPreferredSize();
    
    public DialogTrabHora(Frame pai) {
        this(pai, null);
        
    }
    
    public DialogTrabHora(Frame pai, TrabHora t) {
        super(pai, true);
        TITULO_JANELA = ((t == null) ? "Criar " : "Alterar ")+"Trabalhador à Hora";
        setTitle(TITULO_JANELA);
        
        this.t = t; 
        
        JPanel p1 = criarPainelNome();
        JPanel p2 = new JPanel(new GridLayout(2,1));
        JPanel p3 = criarPainelBotoes();
        
        p2.add(criarPainelHoras());
        p2.add(criarPainelPagamento());
        
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

    private JPanel criarPainelHoras() {
        JLabel lbl = new JLabel("Nº de Horas:", JLabel.RIGHT);
        lbl.setPreferredSize(LABEL_SIZE);
        
        final int CAMPO_LARGURA = 20;
        txtNrHoras = new JTextField(CAMPO_LARGURA);
        txtNrHoras.setText((t == null) ? "" : Integer.toString(t.getNumHoras()));
       
        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p.add(lbl);
        p.add(txtNrHoras);
            
        return p;
    }
    
    private JPanel criarPainelPagamento() {
        JLabel lbl = new JLabel("Pagamento p/ Hora (€):", JLabel.RIGHT);
        lbl.setPreferredSize(LABEL_SIZE);
        
        final int CAMPO_LARGURA = 20;
        txtPagamentoHora = new JTextField(CAMPO_LARGURA);
        txtPagamentoHora.setText((t == null) ? "" : ""+t.getPagHora());
        
        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p.add(lbl);
        p.add(txtPagamentoHora);
    
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
                    int nrHoras = Integer.parseInt(txtNrHoras.getText());
                    float pagHora = Float.parseFloat(txtPagamentoHora.getText());
                    if(t == null) {
                       Empresa.addWorker(new TrabHora(nome, nrHoras, pagHora));
                    } else {
                        t.setNome(nome);
                        t.setNumHoras(nrHoras);
                        t.setPagHora(pagHora);
                    }
                    dispose();
                } catch (NumberFormatException exp) {
                    JOptionPane.showMessageDialog(DialogTrabHora.this, 
                            "Tem que introduzir um valor numérico válido nos Pagamento p/ Hora e/ou Nº de Horas.",
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
