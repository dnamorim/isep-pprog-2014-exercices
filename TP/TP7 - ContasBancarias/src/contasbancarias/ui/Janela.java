package contasbancarias.ui;

import contasbancarias.model.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Janela extends JFrame {

    private static final int JANELA_POSICAO_X = 200, JANELA_POSICAO_Y = 200;

    public Janela() {

        super("Gestão de Contas Bancárias");

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.add(criarMenuGestao());
        menuBar.add(criarMenuAjuda());

        add(new JLabel(new ImageIcon("isep_logo.jpg")));

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                fechar();
            }
        });
        
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        pack();
        setResizable(false);
        setLocation(JANELA_POSICAO_X, JANELA_POSICAO_Y);
        setVisible(true);

    }

    private JMenu criarMenuGestao() {
        JMenu menu = new JMenu("Gestão");
        menu.setMnemonic(KeyEvent.VK_G);

        menu.add(criarItemCriar());
        menu.add(criarItemConsultar());
        menu.add(criarItemEliminar());
        menu.add(criarSubMenuListar());
        menu.addSeparator();
        menu.add(criarItemSair());

        return menu;
    }

    private JMenuItem criarItemCriar() {
        JMenuItem item = new JMenuItem("Criar", KeyEvent.VK_C);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DialogCriarConta dialog = new DialogCriarConta(Janela.this);
            }
        });

        return item;
    }

    private JMenuItem criarItemConsultar() {
        JMenuItem item = new JMenuItem("Consultar", KeyEvent.VK_A);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Banco.quantidadeDeContas() != 0) {
                    DialogConsultarConta dialog = new DialogConsultarConta(Janela.this);
                } else {
                    JOptionPane.showMessageDialog(Janela.this,
                            "Não há contas.",
                            "Consultar",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        return item;
    }

    private JMenuItem criarItemEliminar() {
        JMenuItem item = new JMenuItem("Eliminar", KeyEvent.VK_E);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Banco.quantidadeDeContas() != 0) {
                    Conta[] opcoes = Banco.getContas();
                    Conta c = (Conta) JOptionPane.showInputDialog(Janela.this,
                            "Escolha uma conta:", "Eliminar Conta",
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            opcoes,
                            opcoes[0]);
                    if (c != null) {
                        String[] opcoes2 = {"Sim", "Não"};
                        int resposta = JOptionPane.showOptionDialog(Janela.this,
                                "Eliminar\n" + c.toString(),
                                "Eliminar Conta",
                                0,
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                opcoes2,
                                opcoes2[1]);
                        final int SIM = 0;
                        if (resposta == SIM) {
                            Banco.removerConta(c);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(Janela.this,
                            "Não há contas.",
                            "Eliminar",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        return item;
    }

    private JMenu criarSubMenuListar() {
        JMenu menu = new JMenu("Listar");
        menu.setMnemonic(KeyEvent.VK_L);

        menu.add(criarItemTitulares());
        menu.add(criarItemSaldos());

        return menu;
    }

    private JMenuItem criarItemTitulares() {
        JMenuItem item = new JMenuItem("Titulares", KeyEvent.VK_T);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.ALT_MASK));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Banco.quantidadeDeContas() != 0) {
                    JList<String> lstTitulares = new JList<>(Banco.listaDeTitulares());
                    JScrollPane scrollPane = new JScrollPane(lstTitulares);
                    lstTitulares.setEnabled(false);
                    JOptionPane.showMessageDialog(Janela.this,
                            scrollPane,
                            "Titulares",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(Janela.this,
                            "Não há contas.",
                            "Listar Titulares",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        return item;
    }

    private JMenuItem criarItemSaldos() {
        JMenuItem item = new JMenuItem("Saldos", KeyEvent.VK_D);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,InputEvent.ALT_MASK));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Banco.quantidadeDeContas() != 0) {
                    JPanel pLista = new JPanel(new BorderLayout());
                    JLabel lbl = new JLabel(String.format("%-22s Saldo (€)", "Nr. Conta"));
                    pLista.add(lbl, BorderLayout.NORTH);
                    JList<String> lstSaldos = new JList<>(Banco.listaDeSaldos());
                    JScrollPane scrollPane = new JScrollPane(lstSaldos);
                    pLista.add(scrollPane, BorderLayout.SOUTH);
                    JOptionPane.showMessageDialog(Janela.this,
                            pLista,
                            "Saldos",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(Janela.this,
                            "Não há contas.",
                            "Listar Saldos",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        return item;
    }

    private JMenuItem criarItemSair() {
        JMenuItem item = new JMenuItem("Sair", KeyEvent.VK_S);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.ALT_MASK));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fechar();
            }
        });

        return item;
    }

    private JMenu criarMenuAjuda() {
        JMenu menu = new JMenu("Ajuda");
        menu.setMnemonic(KeyEvent.VK_A);

        menu.add(criarItemAcerca());

        return menu;
    }

    private JMenuItem criarItemAcerca() {
        JMenuItem item = new JMenuItem("Acerca", KeyEvent.VK_C);
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(Janela.this,
                        "@Copyright\nPPROG 2013/2014",
                        "Gestão de Contas Bancárias",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
        return item;
    }

    private void fechar() {
        String[] opSimNao = {"Sim", "Não"};
        int resposta = JOptionPane.showOptionDialog(this,
                "Deseja fechar a aplicação?",
                "Gestão de Contas Bancárias",
                0,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opSimNao,
                opSimNao[1]);
        
        final int SIM = 0;
        if (resposta == SIM) {
            dispose();
        }
    }

}
