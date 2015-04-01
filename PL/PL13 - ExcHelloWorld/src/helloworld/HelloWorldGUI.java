/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package helloworld;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Duarte Nuno Amorim <1130674@isep.ipp.pt>
 */
public class HelloWorldGUI extends JFrame {

    private JLabel lblHello;
    
    private static final int LARGURA_JANELA = 350;
    private static final int ALTURA_JANELA = 175;
    private static final String MENSAGEM_POR_DEFEITO = "Hello World!";

     
    public HelloWorldGUI(String msg) {
        super("Excercício Hello World");
        
        criarPainelHelloWorld(msg);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(LARGURA_JANELA, ALTURA_JANELA);
        //pack();
        
        setMinimumSize(new Dimension(getWidth(), getHeight()));
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public HelloWorldGUI() {
        this(HelloWorldGUI.MENSAGEM_POR_DEFEITO);
    }
     
     private void criarPainelHelloWorld(String msg) {
         lblHello = new JLabel(msg, JLabel.CENTER);
         lblHello.setFont(new Font("Segoe UI", Font.BOLD, 30));
         lblHello.setForeground(Color.BLUE);
         add(lblHello, BorderLayout.CENTER);
     }
    
}
