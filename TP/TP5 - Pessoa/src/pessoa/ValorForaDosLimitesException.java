/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pessoa;

/**
 *
 * @author Duarte Nuno Amorim <1130674@isep.ipp.pt>
 */
public class ValorForaDosLimitesException extends Exception{

    public ValorForaDosLimitesException() {
        super("Valor Fora dos Limites!");
    }
        
    public ValorForaDosLimitesException(String mensagem) {
        super(mensagem);
    }
}
