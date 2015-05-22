/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ginasio;

import java.util.*;

/**
 * Classe de Testes dos Utentes do Ginásio
 * @author Duarte Nuno Amorim <1130674@isep.ipp.pt> 
 */
public class TesteUtente {

    static Scanner in = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        //1. Criar Utentes (3)
        int size = definirNrUtentes();
        in.nextLine();
        
        Utente[] ut = new Utente[size];
        
        for(int i=0; i<ut.length; i++) {
            ut[i]=lerDadosUtente(ut[i]);
            pausa();
        } 
        
        //2. Para cada utente calcule e visualize o IMC e o respectivo grau de obesidade
        for (int i=0; i<ut.length; i++) {
            mostrarDadosUtente(ut[i]);
            pausa();
        }
        
        //3. Altere o valor de referência do IMC min de 18 para 24
        System.out.println("Alteração do IMC Mínimo de 18 para 24.");
        pausa();
        Utente.setMinIMC(24);
        
        System.out.println("Nova Listagem após alteração IMC.");
        pausa();
        //4. Repetir o Passo 2 e verificar eventuais alterações
        for (int i=0; i<ut.length; i++) {
            mostrarDadosUtente(ut[i]);
            pausa();
        }
    }
    public static void executarTesteManual() {
        //1. Crie três Utentes
        
        Utente ut1 = new Utente("Duarte","Masc", 19, (float) 1.76, 61);
        Utente ut2 = new Utente("Joana", "Fem", 18, (float) 1.45, 75);
        Utente ut3 = new Utente("Tiago", "Masc", 17, (float) 1.95, 55);
        
        
        //2. Para cada utente calcule e visualize o IMC e o respectivo grau de obesidade
        mostrarDadosUtente(ut1);
        mostrarDadosUtente(ut2);
        mostrarDadosUtente(ut3);
        
        //3. Altere o valor de referência do IMC min de 18 para 24
        Utente.setMinIMC(24);
        
        //4. Execute novamente o passo 2 e verifique eventuais alterações no resultado.
        mostrarDadosUtente(ut1);
        mostrarDadosUtente(ut2);
        mostrarDadosUtente(ut3);
    }
    
    public static void mostrarDadosUtente(Utente ut) {
        System.out.println(ut.toString());
        System.out.printf("%17s: %.2f %n%17s: %s%n%n", "IMC", ut.calcularIMC(), "Grau de Obesidade", ut.descricaoObesidade());
    }
    
    public static int definirNrUtentes() {
        System.out.print("Nº de Utentes a ler? ");
        return in.nextInt();
    }
    
    public static Utente lerDadosUtente(Utente ut) {
        System.out.print("Nome do Utente? ");
        String nome = in.nextLine();
        System.out.print("Sexo do Utente? ");
        String sexo = in.nextLine();
        System.out.print("Idade do Utente? ");
        int idade = in.nextInt();
        bufferCleaner();
        System.out.print("Altura do Utente (em m)? ");
        float altura = in.nextFloat();
        bufferCleaner();
        System.out.print("Peso do Utente (em kg)? ");
        float peso = in.nextFloat();
        bufferCleaner();
        ut = new Utente(nome,sexo,idade,altura,peso);
        return ut;
    }
    
    public static void pausa() {
        System.out.println("-- Pressione qualquer tecla para continuar. ---");
        in.nextLine();
    }
    
    public static void bufferCleaner() {
        in.nextLine();
    }
    
}
