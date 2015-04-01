/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eleicoes;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author dnamorim
 */
public class DialogVotoElectronico extends JDialog {
    
    private JTextField txtNome, txtData;
    
    public DialogVotoElectronico(JFrame pai) {
        super(pai, "Novo Voto Electrónico", true);
        
        JPanel pCandidato = criarPainelCandidato();
        JPanel pData = criarPainelData();
        JPanel pBotao = criarPainelBotao();
        JPanel pWindow = new JPanel(new GridLayout(2,1));
        
        pWindow.add(pCandidato);
        pWindow.add(pData);
        add(pWindow, BorderLayout.CENTER);
        add(pBotao, BorderLayout.SOUTH);
        
        pack(); 
        //ou setSize(300, 300);
        setVisible(true);
    }

    private JPanel criarPainelCandidato() {
        JLabel lbl = new JLabel("Nome do Candidato", JLabel.LEFT);
        txtNome = new JTextField(20);

        JPanel p = new JPanel();
        p.add(lbl);
        p.add(txtNome);
        
        return p;
    }

    private JPanel criarPainelBotao() {
        JPanel p = new JPanel();
        
        JButton btn = new JButton("Mostrar Info");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = txtNome.getText();
                int data = Integer.parseInt(txtData.getText());
                
                Candidato c = new Candidato(nome);
                //data+2 para o voto ser sempre válido
                VotoElectronico ve = new VotoElectronico(c, data, data+2);
                
                System.out.println(ve);
                JOptionPane.showMessageDialog(null, ve.toString(), "Dados Voto", JOptionPane.PLAIN_MESSAGE);
            }
            
        });
        
        p.add(btn);
        return p;
    }

    private JPanel criarPainelData() {
        JLabel lbl = new JLabel("Data de Voto", JLabel.LEFT);
        txtData = new JTextField(20);

        JPanel p = new JPanel();
        p.add(lbl);
        p.add(txtData);
        
        return p;
    }
    
}
