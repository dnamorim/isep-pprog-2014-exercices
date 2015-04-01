/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Exc2;

/**
 *
 * @author Duarte Nuno Amorim
 */
public class TestePessoa {
    public static void main (String[] args) {
        Pessoa p1; //inicializar variável do tipo Pessoa (classe)
        p1 = new Pessoa("João"); //criar objecto
        
        Pessoa p2 = new Pessoa("Joana");
        
        //devolve os Nomes (get)
        p1.getNome();
        p2.getNome();
        
        //edita os Nomes (set)
        p1.setNome("Tiago");
        
        //Output com o método toString
        System.out.printf("%s.%n",p1.toString());
    }
}
