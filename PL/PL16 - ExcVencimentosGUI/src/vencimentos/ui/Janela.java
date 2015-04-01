/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vencimentos.ui;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import vencimentos.model.*;

/**
 *
 * @author Duarte Nuno Amorim <1130674@isep.ipp.pt>
 */
public class Janela extends JFrame {
    
    private static final int JANELA_LARGURA = 500, JANELA_ALTURA=300;
    
    public Janela() {
        super("Gestão de Vencimentos");
        setInfoLanguage();
        
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.add(criarMenuCriacao());
        menuBar.add(criarMenuManutencao());
        menuBar.add(criarMenuGestao());
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                fechar();
            }
        });
        
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(JANELA_LARGURA, JANELA_ALTURA);
        setLocation(350,200);
        setMinimumSize(new Dimension(getWidth(), getHeight()));
        setResizable(false);
        setVisible(true);
    }
    
    private JMenu criarMenuCriacao() {
        JMenu menu = new JMenu("Criação");
        menu.setMnemonic(KeyEvent.VK_C);
        
        menu.add(criarItemTrabPeca());
        menu.add(criarItemTrabComissao());
        menu.add(criarItemTrabHora());
        menu.addSeparator();
        menu.add(criarItemCarregar());
        menu.addSeparator();
        menu.add(criarItemSair());
        
        return menu;
    }
    
    private JMenuItem criarItemTrabPeca() {
        JMenuItem item = new JMenuItem("Trabalhador à Peça", KeyEvent.VK_P);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DialogTrabPeca dialog = new DialogTrabPeca(Janela.this);
            }
        });
        
        return item;
    }
    
    private JMenuItem criarItemTrabComissao() {
        JMenuItem item = new JMenuItem("Trabalhador à Comissão", KeyEvent.VK_C);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DialogTrabCom dialog = new DialogTrabCom(Janela.this);
            }
        });
        
        return item;
    }
    
    private JMenuItem criarItemTrabHora() {
        JMenuItem item = new JMenuItem("Trabalhador à Hora", KeyEvent.VK_H);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.CTRL_MASK));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DialogTrabHora dialog = new DialogTrabHora(Janela.this);
            }
        });
        
        return item;
    }
    
    private JMenuItem criarItemCarregar() {
        JMenuItem item = new JMenuItem("Carregar Trabalhadores");
        item.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               JFileChooser chDialog = new JFileChooser();
               chDialog.setDialogTitle("Abrir");
               FileNameExtensionFilter filter = new FileNameExtensionFilter("Ficheiros de Texto (.txt, .csv)", "txt", "csv");
               chDialog.setFileFilter(filter);
                int returnVal = chDialog.showOpenDialog(Janela.this);
                if(returnVal == JFileChooser.APPROVE_OPTION) {
                   try {
                       Empresa.readFileText(chDialog.getSelectedFile().getAbsolutePath());
                   } catch (FileNotFoundException ex) {
                       JOptionPane.showMessageDialog(Janela.this, "O ficheiro fornecido não existe.", "Carregar Trabalhadores", JOptionPane.WARNING_MESSAGE);
                   }
                }
           }
        });
        
        return item;
    }
    
    private JMenuItem criarItemSair() {
        JMenuItem item = new JMenuItem("Sair", KeyEvent.VK_F4);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fechar();
            }
        });
        return item;
    }
    
    private JMenu criarMenuManutencao() {
        JMenu menu = new JMenu("Manutenção");
        menu.setMnemonic(KeyEvent.VK_M);
        
        menu.add(criarItemAlterar());
        menu.add(criarItemEliminar());
        
        return menu;
    }
    
    private JMenuItem criarItemAlterar() {
        JMenuItem item = new JMenuItem("Alterar", KeyEvent.VK_A);
        item.setMnemonic(KeyEvent.VK_A);
        
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Empresa.qtyWorkers() != 0) {
                    String[] workers = Empresa.getTrabalhadoresAbrv();
                    String aux = (String) JOptionPane.showInputDialog(Janela.this, 
                            "Escolha um Trabalhador:", "Alterar Trabalhador", JOptionPane.PLAIN_MESSAGE, null, workers, workers[0]);
                    String[] trab = aux.split(":");
                    Trabalhador t = Empresa.obterTrabalhador(trab[1].trim());
                    
                    if(t != null) {
                        if(t instanceof vencimentos.model.TrabCom) {
                            DialogTrabCom dialog = new DialogTrabCom(Janela.this, (TrabCom) t);
                        } else if(t instanceof vencimentos.model.TrabHora) {
                            DialogTrabHora dialog = new DialogTrabHora(Janela.this, (TrabHora) t);
                        } else if(t instanceof vencimentos.model.TrabPeca) {
                            DialogTrabPeca dialog = new DialogTrabPeca(Janela.this, (TrabPeca) t);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(Janela.this, "Não existem Trabalhadores.", "Alterar", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        
        return item;
    }
    
    private JMenuItem criarItemEliminar() {
        JMenuItem item = new JMenuItem("Eliminar", KeyEvent.VK_E);
        item.setMnemonic(KeyEvent.VK_E);
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Empresa.qtyWorkers() != 0) {
                    String[] workers = Empresa.getTrabalhadoresAbrv();
                    
                    String aux = (String) JOptionPane.showInputDialog(Janela.this, 
                            "Escolha um Trabalhador:", "Eliminar Trabalhador", JOptionPane.PLAIN_MESSAGE, null, workers, workers[0]);
                    String[] trab = aux.split(":");
                    Trabalhador t = Empresa.obterTrabalhador(trab[1].trim());
                    
                    if(t != null) {
                        String[] opt = {"Sim", "Não"};
                        int ans = JOptionPane.showOptionDialog(Janela.this, "Eliminar\n"+t.toString()+"?", "Eliminar Conta", 0, JOptionPane.QUESTION_MESSAGE, null, opt, opt[1]);
                        final int YES = 0;
                        if (ans == YES) {
                            Empresa.removeWorker(t);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(Janela.this, "Não existem Trabalhadores.", "Eliminar", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        
        return item;
    }
    
    private JMenu criarMenuGestao() {
        JMenu menu = new JMenu("Gestão");
        menu.setMnemonic(KeyEvent.VK_G);
        
        menu.add(criarSubMenuListar());
        menu.add(criarItemVencimento());
        
        return menu;
    }
    
    private JMenu criarSubMenuListar() {
        JMenu menu = new JMenu("Listar");
        menu.setMnemonic(KeyEvent.VK_L);
        
        menu.add(criarItemListarEcra());
        menu.add(criarItemListarFicheiro());
        
        return menu;
    }
    
    private JMenuItem criarItemListarEcra() {
        JMenuItem item = new JMenuItem("Ecrã");
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Empresa.qtyWorkers() != 0) {
                    JList<String> lst = new JList<>(Empresa.listaTrabalhadores());
                    JScrollPane scrollPane = new JScrollPane(lst);
                    lst.setEnabled(true);
                    JOptionPane.showMessageDialog(Janela.this, scrollPane, "Listar", JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(Janela.this, "Não existem trabalhadores.", "Listar", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        return item;
    }
    
    private JMenuItem criarItemListarFicheiro() {
        JMenuItem item = new JMenuItem("Ficheiro");
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Empresa.qtyWorkers() == 0) {
                    JOptionPane.showMessageDialog(Janela.this, "Não existem trabalhadores para exportar para um ficheiro.",
                            "Listar Ficheiro", JOptionPane.WARNING_MESSAGE);
                } else {
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setDialogTitle("Guardar como");
                    FileNameExtensionFilter filter = new FileNameExtensionFilter("Ficheiros de Texto (.txt)", "txt");
                    fileChooser.setFileFilter(filter);
                    
                    int userSelection = fileChooser.showSaveDialog(Janela.this);
                    if(userSelection == JFileChooser.APPROVE_OPTION) {
                       String fileToSave = fileChooser.getSelectedFile().getAbsolutePath();
                       
                       if (!fileToSave.endsWith(".txt")) {
                            fileToSave += ".txt";
                       }
                       try {
                            Empresa.saveToTextFile(fileToSave);
                            JOptionPane.showMessageDialog(Janela.this, "A listagem foi exportada com sucesso para:\n"+
                                    fileToSave+ ".", "Listar Ficheiro", JOptionPane.INFORMATION_MESSAGE);
                            
                        } catch (FileNotFoundException ex) {
                            JOptionPane.showMessageDialog(Janela.this, "Não foi possível gravar os dados em ficheiro.", "Listar Ficheiro", JOptionPane.WARNING_MESSAGE);
                        } catch (UnsupportedEncodingException ex) {
                            JOptionPane.showMessageDialog(Janela.this, "Não foi possível codificar os dados no ficheiro.", "Listar Ficheiro", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                }
            }
        });
        return item;
    }
    
    private JMenuItem criarItemVencimento() {
        JMenuItem item = new JMenuItem("Calcular Vencimento", KeyEvent.VK_C);
        item.setMnemonic(KeyEvent.VK_C);
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Empresa.qtyWorkers() != 0) {
                    DialogCalcularVencimento dialog = new DialogCalcularVencimento(Janela.this);
                } else {
                    JOptionPane.showMessageDialog(Janela.this, "Não existem trabalhadores.", "Calcular Vencimento", JOptionPane.WARNING_MESSAGE);
                }
            }   
        });
        return item;
    }
    
    private void fechar() {
        String[] optYesNo = {"Sim", "Não"};
        int ans = JOptionPane.showOptionDialog(this, "Pretende fechar a Aplicação?", "Sair", 0, JOptionPane.QUESTION_MESSAGE, null, optYesNo, optYesNo[1]);
        final int YES = 0;
        
        if(ans == YES) {
            try {
                Empresa.saveFile();
                dispose();
            } catch(IOException exp) {
                ans = JOptionPane.showOptionDialog(this, "Ocorreu um erro ao gravar a informação.\nPretende continuar o fecho da Aplicação?", "Erro ao Gravar Informação", YES, JOptionPane.WARNING_MESSAGE, null, optYesNo, optYesNo[1]);
                if(ans == YES) {
                    dispose();
                }
            }
        }
    }
    
    private void setInfoLanguage() {
        UIManager.put("FileChooser.openButtonText","Abrir");
        UIManager.put("FileChooser.cancelButtonText","Cancelar");
        UIManager.put("FileChooser.saveButtonText","Gravar");
        UIManager.put("FileChooser.cancelButtonToolTipText","Cancelar Operação");
        UIManager.put("FileChooser.saveButtonToolTipText", "Gravar Ficheiro");
        UIManager.put("FileChooser.openButtonToolTipText", "Seleccionar Ficheiro");
        UIManager.put("FileChooser.lookInLabelText", "Procurar:");
        UIManager.put("FileChooser.fileNameLabelText", "Nome do Ficheiro:");
        UIManager.put("FileChooser.filesOfTypeLabelText", "Tipo de Ficheiro:");
        UIManager.put("FileChooser.upFolderToolTipText", "Subir de nível");
        UIManager.put("FileChooser.homeFolderToolTipText", "Ambiente de Trabalho");
        UIManager.put("FileChooser.newFolderToolTipText", "Nova Pasta");
        UIManager.put("FileChooser.listViewButtonToolTipText","Lista");
        UIManager.put("FileChooser.detailsViewButtonToolTipText", "Detalhes");
    }
}
