/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

/**
 *
 * @author Duarte Nuno Amorim <1130674@isep.ipp.pt>
 */
public class DiaInvalidoException extends IllegalArgumentException {
    public DiaInvalidoException() {
        super("Dia inserido Inválido!");
    }
    
    public DiaInvalidoException(String msg) {
        super(msg);
    }
}
