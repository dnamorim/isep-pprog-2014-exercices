/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package clubedesportivo;

/**
 *
 * @author dnamorim
 */
public interface Vencimento {

    /**
     * Devolve o valor a receber
     * @return valor a receber
     */
    public abstract float calcularVencimento();
    /**
     * Define um novo vencimento
     * @param vencimento novo vencimento
     */
    public abstract void setVencimento(float vencimento);
}
