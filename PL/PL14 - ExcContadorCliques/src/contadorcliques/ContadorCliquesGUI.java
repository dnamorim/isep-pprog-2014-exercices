/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package contadorcliques;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Duarte Nuno Amorim <1130674@isep.ipp.pt>
 */
public class ContadorCliquesGUI extends JFrame {

    private JLabel lblContador;
    private JButton btnClick;
    private JPanel pContador, pClick;
    
    private int nrClick = 0;
    
    private static final int LARGURA_JANELA = 350;
    private static final int ALTURA_JANELA = 175;
    private static final String MENSAGEM_CONTADOR = "Número de Cliques";
    
    public ContadorCliquesGUI() {
        super("PPROG-PL12: Exercício Contador Cliques");
        
        criarPainelContador();
        criarPainelClick();
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(LARGURA_JANELA, ALTURA_JANELA);
        //pack();
        
        setMinimumSize(new Dimension(getWidth(), getHeight()));
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private void criarPainelContador() {
        pContador = new JPanel();
        pContador.setLayout(new BorderLayout());
        lblContador = new JLabel(String.format("%s: %d", MENSAGEM_CONTADOR, nrClick), JLabel.CENTER);
        lblContador.setFont(new Font("Helvetica", Font.BOLD, 20));
        lblContador.setForeground(Color.BLACK);
        pContador.add(lblContador, BorderLayout.CENTER);
        add(pContador, BorderLayout.CENTER);
    }
    
    private void setDadosLblContador() {
        lblContador.setText(String.format("%s: %d", MENSAGEM_CONTADOR, nrClick));
    }
    
    private void criarPainelClick() {
        pClick = new JPanel();
        btnClick = new JButton("Clica aqui!");
        btnClick.setMnemonic('C');
        btnClick.setToolTipText("Permite incrementar o número de cliques.");
        btnClick.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nrClick++;
                setDadosLblContador();
                btnClick.requestFocus();
            }
        });
        pClick.add(btnClick);
        getRootPane().setDefaultButton(btnClick);
        add(pClick, BorderLayout.SOUTH);
    }
}
