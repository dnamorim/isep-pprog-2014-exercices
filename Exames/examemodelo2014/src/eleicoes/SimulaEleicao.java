/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eleicoes;

import java.util.ArrayList;

/**
 * Representação de uma Eleição
 * @author dnamorim
 */
public class SimulaEleicao {
    
    /**
     * Contentor ArrayList dos Votos de uma Eleição
     */
    private ArrayList<Voto> votos;
    
    /**
     * Constrói uma nova instância de uma Simulação de Eleição
     */
    public SimulaEleicao() {
        this.votos = new ArrayList();
    }
    
    /**
     * Adiciona um novo voto ao contentor de votos
     * @param v voto a adicionar
     */
    public void adicionarVoto(Voto v) {
        votos.add(v);
    }
    
    /**
     * Devolve o contentor com os Votos de uma Eleição
     * @return arraylist de votos da eleição
     */
    public ArrayList<Voto> getVotos() {
        return votos;
    }
    
    /**
     * Actualizar o Número de Votos Válidos para cada Candidato
     * @param votos Lista com os votos registados
     */
    public void contarVotos(ArrayList<Voto> votos) {
        for (Voto v : votos) {
            if(v.eValido()) {
                v.getCandidato().incrementarVotos();
            }
        }
    }
}
