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
import javax.swing.border.EmptyBorder;
/**
 *
 * @author Duarte Nuno Amorim <1130674@isep.ipp.pt>
 */
public class DialogCalcularVencimento extends JDialog {

    private JLabel lblVencimento;
    
    public DialogCalcularVencimento(JFrame pai) {
        super(pai, "Calcular Vencimento", true);
        
        JPanel p1 = criarPainelSeleccionarTrab();
        JPanel p2 = criarPainelVencimento();
        JPanel p3 = criarPainelBotao();
        
        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);
        add(p3, BorderLayout.SOUTH);
        
        setLocation(pai.getX() + 100, pai.getY() + 100);
        setMinimumSize(new Dimension(300,180));
        setResizable(false);
        setVisible(true);
        
    }
    
    private JPanel criarPainelSeleccionarTrab() {
        JLabel lbl = new JLabel("Escolha o Trabalhador: ");
        
        final JComboBox<String> cmbTrab = new JComboBox<>(Empresa.listaTrabalhadores());
        cmbTrab.setSelectedIndex(-1);
        cmbTrab.setMaximumRowCount(3);
        cmbTrab.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] aux = ((String) (cmbTrab.getSelectedItem())).split(":");
                
                Trabalhador t = Empresa.obterTrabalhador(aux[1].trim());
                lblVencimento.setText(String.format("Vencimento: %.2f €", t.vencimento()));
            }
        });
        
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(2,1));
        p.setBorder(new EmptyBorder(10,10,10,10));
        p.add(lbl);
        p.add(cmbTrab);
        
        return p;
    }
    
    private JPanel criarPainelVencimento() {
        JPanel p = new JPanel();
        lblVencimento = new JLabel("Vencimento:", JLabel.CENTER);
        p.add(lblVencimento);
        
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
        p.add(btnOk);
        
        return p;
    }
    
}
