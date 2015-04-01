/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

import java.util.Scanner;

/**
 *
 * @author Duarte Nuno Amorim <1130674@isep.ipp.pt>
 */
public class TesteData {
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        boolean dadosInvalidos = false;
        Data d = null;
        System.out.print("Introduza uma data no formato aaaa/mm/dd: ");
        do {
            try {
                String[] dataIn = in.nextLine().split("/");
                
                if(dataIn.length != 3) {
                    throw new NumberFormatException();
                }
                
                d = new Data(Integer.parseInt(dataIn[0]), Integer.parseInt(dataIn[1]), Integer.parseInt(dataIn[2]));
                System.out.printf("%nData por Extenso: %s%n", d);
                dadosInvalidos = true;
            }
            catch (MesInvalidoException | DiaInvalidoException exp) {
                System.out.println("\nERRO: "+exp.getMessage()+"\n");
                System.out.print("Introduza novamente uma data no formato aaaa/mm/dd: ");
            } 
            catch(NumberFormatException exp) {
                System.out.println("\nERRO: Não inseriu uma data no formato numérico válido.\n");
                System.out.print("Introduza novamente uma data no formato aaaa/mm/dd: ");
            }
        } while (!dadosInvalidos);
        
    }
}
