/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package clubedesportivo;

import java.io.Serializable;

/**
 * Representação de um Atleta Amador no Sistema
 * @author dnamorim
 */
public class Amador extends Atleta implements Serializable {

    /**
     * Profissão de um Atleta Amador
     */
    private String profissao;

    /**
     * Constrói uma instãncia de um atleta amador no Sistema
     * @param nome Nome de um atleta amador
     * @param modalidade modalidade de um atleta amador
     * @param numero número de um atleta amador
     * @param profissao profissao de um atleta amador
     */
    public Amador(String nome, Modalidade modalidade, int numero, String profissao) {
        super(nome, modalidade, numero);
        this.profissao = profissao;
    }
    
    /**
     * Devolve a profissão de um atleta amador
     * @return profissao
     */
    public String getProfissao() {
        return profissao;
    }

    /**
     * Define uma nova profissão de um atleta amador
     * @param profissao nova profissao
     */
    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }
    
    
}
