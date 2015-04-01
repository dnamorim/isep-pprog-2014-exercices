/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package disciplinas;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author Duarte Nuno Amorim <1130674@isep.ipp.pt>
 */
public class Teste {
    
    public static void main(String[] args) {
        Professor p1 = new Professor("João Cardoso", HabilitacoesAcademicas.DOUTORAMENTO);
        Professor p2 = new Professor("Ana Amorim", HabilitacoesAcademicas.MESTRADO);
        Professor p3 = new Professor("Rui Almeida", HabilitacoesAcademicas.MESTRADO);
        Professor p4 = new Professor("Rui Almeida", HabilitacoesAcademicas.LICENCIATURA);
        
        Professor[] profs = {p1, p2, p3, p4};
        listar(profs);
        System.out.println("");
        
        Disciplina d1 = new Disciplina("Inglês", "ING1", 1, p1);
        Disciplina d2 = new Disciplina("Programação", "PROG", 2, p2);
        Disciplina d3 = new Disciplina("Projecto", "PROJ", 3, p3);
        Disciplina d4 = new Disciplina("Matemática I", "MATE1", 1);
        Disciplina d5 = new Disciplina("Matemática II", "MATE2", 2);
    
        Disciplina[] discip = {d1, d2, d3, d4, d5};
        listar(discip);
        
        d4.setRegente(p4);
        d5.setRegente(p4);
        
        System.out.println("\n"+p4);
        p4.setHabilitacao(HabilitacoesAcademicas.DOUTORAMENTO);
        System.out.println(p4+"\n");
        
        for (Disciplina d : discip) {
            if(d.getRegente() == p4) {
                System.out.printf("%s - %s%n", d.getDesignacao(), d.getAbreviatura());
            }
        }
        System.out.println("");
        
        for (Disciplina d : discip) {
            if(d.getRegente().getHabilitacao() == HabilitacoesAcademicas.DOUTORAMENTO) { 
                System.out.println(d.getDesignacao());
            }
        }
        System.out.println("");
        
        Comparator critDisciplina = new Comparator() {
            @Override
            public int compare(Object obj1, Object obj2) {
                String nome1 = ((Disciplina) obj1).getDesignacao();
                String nome2 = ((Disciplina) obj2).getDesignacao();
                
                return nome1.compareTo(nome2);
            }
        };
        
        Comparator critProfessorDiscip = new Comparator() {
            @Override
            public int compare(Object obj1, Object obj2) {
                String nome1 = ((Disciplina) obj1).getRegente().getNome();
                String nome2 = ((Disciplina) obj2).getRegente().getNome();
                
                return nome1.compareTo(nome2);
            }
        };
        
        Comparator critProfessor = new Comparator() {
            @Override
            public int compare(Object obj1, Object obj2) {
                String nome1 = ((Professor) obj1).getNome();
                String nome2 = ((Professor) obj2).getNome();
                
                return nome1.compareTo(nome2);
            }
        };
        
        Arrays.sort(discip, critDisciplina);
        Arrays.sort(discip, critProfessorDiscip);
        Arrays.sort(profs, critProfessor);
        
        for (Professor p : profs) {
            if(p != null) {
                System.out.printf("Professor %s:%n", p.getNome());
            }
            for (Disciplina d : discip) {
                if (d.getRegente() == p) {
                    System.out.printf(" - %s (%s)%n", d.getDesignacao(), d.getAbreviatura());
                }
            }
        }
    }
    
    public static void listar(Object[] vec) {
        for (Object obj : vec) {
            if(obj != null) {
                System.out.println(obj);
            }
        }
    }
}
