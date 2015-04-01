/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pessoa;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 *
 * @author Duarte Nuno Amorim <1130674@isep.ipp.pt>
 */
public class TestePessoa3 {
    public static void main(String[] args) {
        Pessoa3 p = null;
        try {
            p = new Pessoa3("Rui", -1);
            System.out.println("Pessoa dentro do try:\n"+p);
        } catch (ValorForaDosLimitesException | InputMismatchException excepcao) {
            System.out.println("\nERRO: " + excepcao.getMessage() + "(" + excepcao.getClass().getSimpleName() + ")");
        }
    }
}
