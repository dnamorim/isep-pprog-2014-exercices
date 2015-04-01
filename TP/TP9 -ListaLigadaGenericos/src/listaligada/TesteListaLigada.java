/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package listaligada;

import java.util.ArrayList;

/**
 *
 * @author Duarte Nuno Amorim <1130674@isep.ipp.pt>
 */
public class TesteListaLigada {
    
    public static void main(String[] args) {
        ArrayList<String> lista = new ArrayList<>();
        lista.add("A");
        lista.add("B");
        lista.add("C");
        
        ListaLigada<String> lista2 = new ListaLigada<>(lista);
        listar(lista2);
        
        //Teste médoto paraVector
        String[] v1 = new String[2];
        String[] v2 = lista2.paraVector(v1);
        System.out.println("\nTeste método paraVector 1");
        for (int i = 0; i < v2.length; i++) {
            System.out.println(v2[i]);
        }
        
        String[] v3 = new String[5];
        String[] v4 = lista2.paraVector(v3);
        System.out.println("\nTeste método paraVrector 2");
        for (int i = 0; i < v4.length; i++) {
            System.out.println(v4[i]);
        }
        
        //Tetse método adicionarTodos
        System.out.println("\nTeste método adicionarTodos");
        ArrayList<String> lista3 = new ArrayList<>();
        lista3.add("E");
        lista3.add("F");
        lista2.adicionarTodos(lista3);
        listar(lista2);
        
        System.out.println("\nObjecto Removido: "+lista2.removerPrimeiro());
        listar(lista2);
        
        System.out.println("\nObjecto Removido: "+lista2.removerPrimeiro());
        listar(lista2);
        
        lista2.adicionar(0, "G");
        lista2.adicionar(1, "H");
        lista2.adicionar(2, "I");
        
        //Teste com tipo interface
        ListaLigada<Comparable<String>> lista1 = new ListaLigada<>();
        lista1.adicionar(0, "teste");
        listar(lista1);
        
        ListaLigada<TrabPeca> listaTP = new ListaLigada<TrabPeca>();
        //ListaLigada<Trabalhador> listaT = listaTP; //ilegal - tipos incompatives
    }
    
    public static <E> void listar(ListaLigada<E> lista) {
        System.out.println("Lista Ligada - tamanho: "+lista.getTamanho());
        for (int i = 0; i < lista.getTamanho(); i++) {
            System.out.println(lista.obter(i));
        }
    }

}
