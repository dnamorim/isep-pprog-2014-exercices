/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package listaespera;

import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author Duarte Nuno Amorim <1130674@isep.ipp.pt>
 */
public class TesteListaEspera {

    static Scanner in = new Scanner(System.in, "ISO8859-1");
    static Formatter out = new Formatter(System.out);
    
    public static void main(String[] args) {
        ListaEspera le = new ListaEspera();
        
        int opt=0;
        boolean dadosInvalidos = false;
        do {
            try {
                menu();
                opt = in.nextInt();
                switch(opt) {
                    case 1:
                        in.nextLine();
                        out.format("Nome? ");
                        le.addLista(in.nextLine());
                        out.format("%n");
                        break;
                    case 2:
                        in.nextLine();
                        out.format("Confirma Operação? (Y para confirmar) ");
                        if(in.nextLine().equalsIgnoreCase("Y")) {
                            le.removeLastLista();
                        }
                        out.format("%n");
                        break;
                    case 3:
                        in.nextLine();
                        out.format("%nLISTA DE ESPERA%n----------------%n%s", le.showLista());
                        out.format("%n");
                        break;
                    case 4:
                        System.exit(0);
                        break;
                    default:
                        out.format("ERRO: Opção Inválida.%n%n"); 
                        break;
                    }  
                    dadosInvalidos = true;
            } catch(InputMismatchException exp) {
                out.format("ERRO: Não inseriu uma opção no formato numérico válido.%n"+ "Introduza novamente uma opção.%n%n");
                in.nextLine();
            } catch(NoSuchElementException exp) {
                out.format("ERRO: A Lista não contém Utentes.%n%n");
            } 
        } while(!dadosInvalidos || opt != 4);
    }
    
    public static void menu() {
        out.format("----- GESTÃO DE LISTA DE ESPERA ------%n%n%s%n%s%n%s%n%s%n",
                "1. Adicionar Utente", "2. Eliminar Último Utente Atendido", 
                "3. Listar Utentes em Espera", "4. Terminar Aplicação");
        out.format("Insira uma Opção: ");
    }
}
