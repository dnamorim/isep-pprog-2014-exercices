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
public interface Pagamento {

    /**
     * Calcula o valor a Pagar por um Cliente Pagador do Ginasio
     * @return valor a Pagar
     */
    public abstract float pagar();
}
