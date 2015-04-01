/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package escola;

/**
 *
 * @author Duarte Nuno Amorim <1130674@isep.ipp.pt>
 */
public class TesteEscola {
    public static void main(String[] args) {
        Professor p1 = new Professor("Alexandre Gouveia", "aas@isep.ipp.pt", 999999999, Professor.ADJUNTO);
        Professor p2 = new Professor("Fernando Duarte", "fjd@isep.ipp.pt", 999999999, Professor.ASSISTENTE);
        Professor p3 = new Professor("Luiz Faria", "lef@isep.ipp.pt", 999999999, Professor.COORDENADOR);
        
        Aluno a1 = new Aluno("André Azevedo", "1130740@isep.ipp.pt", 999999999, 1130740);
        Aluno a2 = new Aluno("Sara Silva", "sara@gmail.com", 999999999, 1130648);
        
        Bolseiro b1 = new Bolseiro("Duarte Amorim", "1130674@isep.ipp.pt", 258594306, 1130674, 1565.5f);
        Bolseiro b2 = new Bolseiro("Tiago Ferreira", "1130672@isep.ipp.pt", 999999999, 1130672, 2500f);
        
        
        Pessoa[] p = new Pessoa[10];
       
        p[0]=p1; 
        p[1]=p2;
        p[2]=p3;
        
        p[3]=a1;
        p[4]=a2;
        
        p[5]=b1;
        p[6]=b2;
    
        System.out.println("\n### Listar os nomes de professores e alunos acompanhados do nome da classe correspondente ###");
        for(int i=0; i<p.length; i++) {
            if(p[i] != null) {
                System.out.printf("Nome: %s Classe: %s%n%n", p[i].getNome(), p[i].getClass().getSimpleName());
            }
        }
        
        System.out.println("\n### Listar o nome e a categoria de cada um dos professores ###");
        for(int i=0; i<p.length; i++) {
            if(p[i] instanceof Professor) {
                System.out.printf("Nome: %s  Categoria: %s%n", p[i].getNome(),((Professor) p[i]).getCategoria());
            }
        }
        
        System.out.println("\n### Listar todos os alunos da escola ###");
        for(int i=0; i<p.length; i++) {
            if(p[i] instanceof Aluno) {
                System.out.println(p[i]);
            }
        }
        
        System.out.println("\n### Listar o número e o nome de cada um dos alunos que não recebem bolsa ###");
        for(int i=0; i<p.length; i++) {
            if(p[i] instanceof Aluno && !(p[i] instanceof Bolseiro)) {
                //if(p[i] != null && p[i].getClass() == Aluno.class)
                Aluno a = (Aluno) p[i];
                System.out.printf("Nr. Mec: %d  Nome: %s%n", a.getNrMec(), a.getNome());
            }
        }
        
        System.out.println("\n### Mostrar o encargo mensal da escola com os vencimentos dos professores e as bolsas dos alunos. ###");
        float encargos = 0;
        for(int i=0; i<p.length; i++) {
            if(p[i] instanceof Encargos) {
                encargos+=((Encargos) p[i]).encargo();
            }
        }
        System.out.printf("%Encargos com Vencimentos e Bolsas: %.2f €%n", encargos);
        
    }
}
