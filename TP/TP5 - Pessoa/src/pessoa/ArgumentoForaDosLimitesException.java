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
public class ArgumentoForaDosLimitesException extends IllegalArgumentException {
    public ArgumentoForaDosLimitesException() {
        super("Argumento fora dos Limites!");
    }
    
    public ArgumentoForaDosLimitesException(String mensagem) {
        super(mensagem);
    }
}
