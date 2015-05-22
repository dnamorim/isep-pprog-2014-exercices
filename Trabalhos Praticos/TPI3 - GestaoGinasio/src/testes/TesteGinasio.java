/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testes;

import ginasio.*;
import java.util.ArrayList;


/**
 *
 * @author Duarte Nuno Amorim <1130674@isep.ipp.pt>
 */
public class TesteGinasio {
    
    public static void main(String[] args) {
        
        //2 Funcionários
        Funcionario f1 = new Funcionario("Margarida", 'F', 38, 999999999);
        Funcionario f2 = new Funcionario("Frederico", 'M', 42, 999999999);
        
        //2 Clientes Regulares
        ClienteRegular cr1 = new ClienteRegular("Duarte", 'M', 19, 258594306, 1254, 1.76f, 62, f1, 1, 39.9f);
        ClienteRegular cr2 = new ClienteRegular("Inês", 'F', 21, 999999999, 1474, 1.62f, 56, f1, 1, 42.5f);
        
        //1 Cliente Esporádico
        ClienteEsporadico ce1 = new ClienteEsporadico("Joana", 'F', 18, 999999999, 1354, 1.60f, 59, f2, 1, 2);
        
        //2 Convidados
        ClienteConvidado cc1 = new ClienteConvidado("Francisco", 'M', 19, 999999999, 9991, 1.82f, 65, f2, 10);
        ClienteConvidado cc2 = new ClienteConvidado("Tomás", 'M', 25, 999999999, 9992, 1.72f, 58, f1, 8);
        
        //1 Treinador
        Treinador t1 = new Treinador("Alexandre", 'M', 40, 999999999, 1250f);
        
        //Defenição de Arraylist
        ArrayList<Pessoa> pGin = new ArrayList();
        pGin.add(f1);
        pGin.add(f2);
        pGin.add(t1);
        pGin.add(cr1);
        pGin.add(cr2);
        pGin.add(cc1);
        pGin.add(cc2);
        pGin.add(ce1);
        
        //Criação de Objecto Ginásio
        Ginasio gym1 = new Ginasio("ISEP Gym", pGin);
        //Apresenta Movimentos do Ginásio
        System.out.println(gym1.movimentosGinasio());
        //Apresenta Saldo do Ginásio e o Nº de Trabalhadores e Clientes Pagadores
        System.out.printf("%nSaldo do Ginásio = %.1f%nClientes Pagadores = %d%nFuncionários + Treinadores = %d%n%n", gym1.saldoGinasio(), gym1.getNrTrabalhadores(), gym1.getNrClientesPagadores());
    
        

    }

}
