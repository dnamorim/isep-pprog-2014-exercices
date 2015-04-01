/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pessoa;

import java.util.ArrayList;

/**
 *
 * @author Duarte Nuno Amorim <1130674@isep.ipp.pt>
 */
public class TesteArrayList {
    
    public static void main(String[] args) {
        //ArrayLists Não-Genéricos
        Pessoa p1 = new Pessoa("João", 1111);
        Pessoa p2 = new Pessoa("Ana", 2222);
        Pessoa p3 = new Pessoa("Duarte", 3333);
        
        System.out.println("Criar Contentor");
        ArrayList a1 = new ArrayList();
        
        System.out.println("Tamanho: " + a1.size());
        
        System.out.println("Adicionar Objectos Ao Contentor");
        a1.add(p1);
        a1.add(p2);
        a1.add(p3);
        
        System.out.println("Tamanho: " + a1.size());
        
        System.out.println("\nListar 1:");
        listar(a1);
        System.out.println("\nListar 2:");
        listar2(a1);
        System.out.println("\nListar 3:");
        listar3(a1);
        
        System.out.println("\nSubstituir o último elemento do contentor");
        listar2(a1);
        a1.set(a1.size()-1 , new Pessoa("Sofia", 4444));
        System.out.println("");
        listar2(a1);
                
        System.out.println("\nRemover Último Elemento");        
        Object obj = a1.remove(a1.size()-1);
        
        
        a1.add(1, obj);
        System.out.println("\nObjecto adiconado entre outros: " +obj);
        listar2(a1);
        
        System.out.println("\nTestar o contains");
        if (a1.contains(obj)) {
            System.out.println(obj + "armazenado no contentor");
        } else {
            System.out.println(obj + "não armazenado no contrntor");
        }
        
        ArrayList a2 = new ArrayList(a1);
        listar2(a2);
        
        System.out.println("\nTestar o Equals 1");
        if (a2.equals(a1)) {
            System.out.println("Contentores Equivalentes");
        } else {
            System.out.println("Contentores não equivalentes");
        }
        
        System.out.println("\nRemover um objecto do contentor 2");
        listar2(a2);
        a2.remove(1);
        System.out.println();
        listar2(a2);
        
        System.out.println("\nTestar o Equals 2");
        if (a1.equals(a2)) {
            System.out.println("Contentores Equivalentes");
        } else {
            System.out.println("Contentores não equivalentes");
        }
        
        
        System.out.println("\nTestar o containsAll");
        if (a1.containsAll(a2)) {
            System.out.println("Contentor 1 possui todos os objectos do contentor 2");
        } else {
            System.out.println("Contentor q não possui todos os objectos do contentor 2");
        }
        
        System.out.println("\nEsvaziar o contentor 2");
        a2.clear();
    
        if (a2.isEmpty()) {
            System.out.println("Contentor 2 está vazio.");
        } else {
            System.out.println("Contentor 2 não está vazio.");
        }
    }
    
    private static void listar(ArrayList a) {
        for (int i=0; i < a.size(); i++) {
            if(a.get(i) != null) {
                System.out.println(a.get(i));
            }
        }
    }
    
    private static void listar2(ArrayList a) {
        for(Object obj : a) {
            if(obj != null) {
                System.out.println(obj.toString());
            }
        }
    }
    
    private static void listar3(ArrayList a) {
        for(Object obj : a) {
            if(obj != null) {
                System.out.println(((Pessoa) obj).getNome());
            }
        }
    }
    
    
}
