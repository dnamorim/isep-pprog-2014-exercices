/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eleicoes;

import java.util.ArrayList;

/**
 *
 * @author dnamorim
 */
public class TesteEleicoes {
    
    public static void main(String[] args) {
        //Apresenta Dialog
        //showDialog();
        
        //Candidatos de Exemplo
        Candidato c1 = new Candidato("MIT");
        Candidato c2 = new Candidato("Cavaco Silva");
        Candidato c3 = new Candidato("Passos Coelho");
        
        //Votos Electronicos
        VotoElectronico ve1 = new VotoElectronico(c1, 1, 5);
        VotoElectronico ve2 = new VotoElectronico(c3, 2, 2);
        
        //Votos por Correio
        VotoCorreio vc1 = new VotoCorreio(c2, 3, 5, false);
        VotoCorreio vc2 = new VotoCorreio(c1, 4, 5, true);
        
        //VotosPapel
        VotoPapel vp1 = new VotoPapel(c1, 4, 5, true);
        VotoPapel vp2 = new VotoPapel(c2, 4, 5, false);
        
        SimulaEleicao se = new SimulaEleicao();
        
        //Adicionar Votos ao ArrayList 
        se.adicionarVoto(ve1);
        se.adicionarVoto(ve2);
        se.adicionarVoto(vc1);
        se.adicionarVoto(vc2);
        se.adicionarVoto(vp1);
        se.adicionarVoto(vp2);
        
        //Descrição dos Votos
        for (Voto v : se.getVotos()) {
            System.out.println(v);
        }
    }
    
    public static void showDialog() {
        new DialogVotoElectronico(null);
    }
}
