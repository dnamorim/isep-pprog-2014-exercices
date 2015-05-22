/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ginasio;

/**
 *
 * @author Duarte Nuno Amorim <1130674@isep.ipp.pt>
 */
public interface Recebimento {

    /**
     * Calcula o Valor a Receber por um Trabalhador usando Polimorfismo
     * @return valor do Salário do trabalhador
     */
    public abstract float receber();
}
