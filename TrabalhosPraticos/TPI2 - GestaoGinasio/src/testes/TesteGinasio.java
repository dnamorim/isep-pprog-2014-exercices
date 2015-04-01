/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testes;

import ginasio.*;

/**
 *
 * @author Duarte Nuno Amorim <1130674@isep.ipp.pt>
 */
public class TesteGinasio {
    
    public static void main(String[] args) {
        
        //2 Clientes Regulares
        ClienteRegular cr1 = new ClienteRegular("Duarte", 'M', 19, 258594306, 1254, 1.76f, 62, 1, 39.9f);
        ClienteRegular cr2 = new ClienteRegular("Inês", 'F', 21, 999999999, 1474, 1.62f, 56, 1, 42.5f);
        
        //1 Cliente Esporádico
        ClienteEsporadico ce1 = new ClienteEsporadico("Joana", 'F', 18, 999999999, 1354, 1.60f, 59, 1, 2);
        
        //2 Convidados
        ClienteConvidado cc1 = new ClienteConvidado("Francisco", 'M', 19, 999999999, 9991, 1.82f, 65, 10);
        ClienteConvidado cc2 = new ClienteConvidado("Tomás", 'M', 25, 999999999, 9992, 1.72f, 58, 8);
        
        //1 Treinador
        Treinador t1 = new Treinador("Alexandre", 'M', 40, 999999999, 11314, 1250f);
        
        //2 Funcionários
        Funcionario f1 = new Funcionario("Margarida", 'F', 38, 999999999, 12354, 12);
        Funcionario f2 = new Funcionario("Frederico", 'M', 42, 999999999, 12478, 8);
        
        
        //crie um Array, denominado utilizadoresGinasio que armazene as referências para todos os objectos criados
        //Pessoa[] utilizadoresGinasio = new Pessoa[10]; 
        Pessoa[] utilizadoresGinasio = {cr1, cr2, ce1, cc1, cc2, t1, f1, f2};
        
        float saldoGinasio=0f;
        int clientesPagadores=0, trabalhadores=0;
        
        //percorra 1x o array e imprima no ecra o valor a receber pelos clientes e a pagar pelo pessoal
        for (int i = 0; i < utilizadoresGinasio.length; i++) {
            //System.out.println(utilizadoresGinasio[i]); - instrução para output toString Objecto
            if(utilizadoresGinasio[i] instanceof Trabalhador) {
                saldoGinasio-=((Trabalhador) utilizadoresGinasio[i]).vencimentoTrabalhador();
                System.out.printf("- %.1f%n", ((Trabalhador) utilizadoresGinasio[i]).vencimentoTrabalhador());
                trabalhadores++;
            } else if(utilizadoresGinasio[i] instanceof ClientePagador) {
                ClientePagador cp = (ClientePagador) utilizadoresGinasio[i];
                if(cp.isClientePagadorActivo()) {
                    saldoGinasio+=cp.valorPagamentoCliente();
                    System.out.printf("+ %.1f%n", cp.valorPagamentoCliente());
                    clientesPagadores++;
                }
            }
            
        }
        
        System.out.printf("%nSaldo do Ginásio = %.1f%nClientes Pagadores = %d%nFuncionários + Treinadores = %d%n", saldoGinasio, clientesPagadores, trabalhadores);
        
    }

}
