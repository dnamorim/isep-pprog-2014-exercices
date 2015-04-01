/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package calendario;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author dnamorim
 */
public class Calendario extends JFrame {
    
    private int ano;
    private int mes;
    private Data d;
    private JLabel lblInfoMesAno;
    
    public Calendario() {
        super("Calendário");
        this.ano = 2013;
        this.mes = 6;
        
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.add(criarMenu());
        
        add(criarPainelControl(), BorderLayout.NORTH);
        refreshMes();
        
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        
    }
    
    public static void main(String[] args) {
        new Calendario();
    }
    
    public JMenu criarMenu() {
        JMenu menuModificar = new JMenu("Modificar");
        menuModificar.add(criarItemAno());
        
        return menuModificar;
    }
    
    public JMenuItem criarItemAno() {
        JMenuItem itemAno = new JMenuItem("Ano");
        
        
        
        itemAno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] anos = new String[70];
                for (int i = 1950; i < 2020; i++) {
                    anos[i-1950] = i+"";
                }
                JComboBox cbxAno = new JComboBox(anos);
                JOptionPane.showMessageDialog(null, cbxAno, "Modificar o Ano", JOptionPane.PLAIN_MESSAGE);
                String anoSel = (String) cbxAno.getSelectedItem();
                ano = Integer.parseInt(anoSel);
                refreshMes();
            }   
        });
        
        return itemAno;
    }

    private JPanel criarPainelControl() {
        JPanel p = new JPanel(new BorderLayout());
        
        JButton btnBack = new JButton("<");
        JButton btnNext = new JButton(">");
        lblInfoMesAno = new JLabel("", JLabel.CENTER);
        
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mes == 1) {
                    mes = 12;
                    ano--;
                } else {
                    mes--;
                }
                refreshMes();
            }
        });
        btnNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mes == 12) {
                    mes = 1;
                    ano++;
                } else {
                    mes++;
                }
                refreshMes();
            }
        });
        
        p.add(btnBack, BorderLayout.WEST);
        p.add(lblInfoMesAno, BorderLayout.CENTER);
        p.add(btnNext, BorderLayout.EAST);
        
        return p;
    }

    private JPanel criarPainelMes() {
        JPanel p = new JPanel(new GridLayout(7,7));
        
        String[] diasSemana = {"D", "S", "T", "Q", "Q", "S", "S"};
        for (String s : diasSemana) {
            p.add(new JLabel(s));
        }
        
        lblInfoMesAno.setText(String.format("%s %d", d.nomeDoMes(), d.getAno()));
        if(d.diaDaSemana() != 0 ) {
            for (int i = 0; i < d.diaDaSemana(); i++) {
                p.add(new JLabel(""));
            }
        }
        
        for (int i = 1; i <= d.diasDoMes(); i++) {
            p.add(new JLabel(i+""));
        }
        
        return p;
    }

    private void refreshMes() {
        d = new Data(this.ano, this.mes, 1);
        this.add(criarPainelMes(), BorderLayout.CENTER);
        
    }
    
    
}
