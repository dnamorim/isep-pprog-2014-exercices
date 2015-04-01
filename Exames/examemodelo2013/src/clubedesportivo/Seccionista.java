/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package clubedesportivo;

import java.io.Serializable;

/**
 * Representa um Seccionista do Clube
 * @author dnamorim
 */
public class Seccionista extends Pessoa implements Serializable, Vencimento {
    /**
     * Vencimento do Seccionista
     */
    private float vencimento;
    
    /**
     * Cria uma instância de um Seccionista
     * @param nome nome do seccionista
     * @param modalidade modalidade da responsabilidade do seccionista
     * @param vencimento vencimento do seccionista
     */
    public Seccionista(String nome, Modalidade modalidade, float vencimento) {
        super(nome, modalidade);
        this.vencimento = vencimento;
    }

    /**
     * Calcula o valor a receber pelo Seccionista
     * @return valor do vencimento
     */
    @Override
    public float calcularVencimento() {
        return this.vencimento;
    }

    /**
     * Devolve o valor do vencimento do Seccionista
     * @return vencimento do seccionista
     */
    public float getVencimento() {
        return this.vencimento;
    }
     
    /**
     * Define um novo vencimento do seccionista
     * @param vencimento novo vencimento do seccionista
     */
    @Override
    public void setVencimento(float vencimento) {
        this.vencimento = vencimento;
    }

   
    
    
    
}
