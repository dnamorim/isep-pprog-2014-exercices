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
public class TestePessoa {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
    
        Pessoa p = null;
        boolean dadosInvalidos=true;
        
        do {
            try {
                p = new Pessoa();
                System.out.print("Nome: ");
                String nome = in.nextLine();
                p.setNome(nome);
        
                System.out.print("Número BI: ");
                int numeroBI = in.nextInt();
                in.nextLine();
                p.setNumeroBI(numeroBI);
        
                System.out.println("Pessoa dentro do try\n"+p);
                dadosInvalidos=false;
            } catch(IllegalArgumentException excepcao) {
                System.out.println("\nERRO: "+excepcao.getMessage());
            } catch(InputMismatchException excepcao) {
                System.out.println("\nERRO: Número de BI Inválido! ("+excepcao.getClass().getSimpleName()+")");
            }
        } while(dadosInvalidos);
        System.out.println("Pessoa depois do catch: "+p);
    }
}
