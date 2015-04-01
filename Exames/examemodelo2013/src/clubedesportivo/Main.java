/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package clubedesportivo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Resolução da Questão 2: main - classe de testes
 * @author dnamorim
 */
public class Main {
    
    public static void main(String[] args) {
        
        //Objectos para cada classe instanciável
        Seccionista s1 = new Seccionista("Pinto da Costa", Modalidade.NATACAO, 800f);
        Profissional p1 = new Profissional("Michael Phelps", Modalidade.NATACAO, 15234, 1500f, Desempenho.ALTO);
        Amador a1 = new Amador("Rui Costa", Modalidade.TENIS, 15423, "Gestor");
        
        //Criar Contentor para guardar todos objectos existentes
        ArrayList<Pessoa> container = new ArrayList<Pessoa>();
        
        //Adicionar pessoas ao contentor
        container.add(s1);
        container.add(p1);
        container.add(a1);
        
        //Listagem com descrição de todos os objectos
        System.out.println("---- LISTAGEM DE OBJECTOS ----");
        for (Pessoa pessoa : container) {
            if (pessoa instanceof Seccionista) {
                Seccionista s = (Seccionista) pessoa;
                System.out.println(String.format("Seccionista %s - Modalidade: %s", s.getNome(), s.getModalidade().toString()));
            }
            
            if(pessoa instanceof Profissional) {
                Profissional p = (Profissional) pessoa;
                System.out.println(String.format("Atleta Profissional %s - Modalidade: %s, Número: %d, Nível Desempenho: %s", p.getNome(), p.getModalidade(), p.getNumero(), p.getDesempenho()));
            }
            
            if (pessoa instanceof Amador) {
                Amador a = (Amador) pessoa;
                System.out.println(String.format("Atleta Amador %s - Modalidade: %s, Número: %d, Profissão: %s", a.getNome(), a.getModalidade(), a.getNumero(), a.getProfissao()));
            }
        }
        
        //Listagem com a descrição de todas os objectos com Vencimento
        System.out.println("--- LISTAGEM OBJECTOS COM VENCIMENTO");
        for (Pessoa pessoa : container) {
            if (pessoa instanceof Vencimento) {
                
                //Divide-se assim para obter a descrição completa dos intervenientes com vencimento
                if (pessoa instanceof Seccionista) {
                    Seccionista s = (Seccionista) pessoa;
                    System.out.println(String.format("Seccionista %s - Modalidade: %s%nVencimento: %.2f €", s.getNome(), s.getModalidade().toString(), s.calcularVencimento()));
                }
            
                if(pessoa instanceof Profissional) {
                    Profissional p = (Profissional) pessoa;
                    System.out.println(String.format("Atleta Profissional %s - Modalidade: %s, Número: %d, Nível Desempenho: %s%nVencimento: %.2f €", p.getNome(), p.getModalidade(), p.getNumero(), p.getDesempenho(), p.calcularVencimento()));
                }
            }
        }
        
        //Armazenar o contentor num ficheiro binário com tratamento de excepções
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data.bin"));
            out.writeObject(container);
            out.close();
            System.out.println("Objecto gravado em binário com sucesso.");
        } catch (IOException ex) {
            System.out.println("Ocorreu um erro ao gravar o ficheiro binário.");
        }
    }
}
