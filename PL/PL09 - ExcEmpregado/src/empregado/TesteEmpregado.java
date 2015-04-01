/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package empregado;

import utilitarios.Data;
import utilitarios.Tempo;

/**
 *
 * @author Duarte Nuno Amorim <1130674@isep.ipp.pt>
 */
public class TesteEmpregado {

    public static void main(String[] args) {
        Data d = TodayDate.dataActual();
        System.out.println(d);
        
        Tempo t1 = new Tempo(9,0);
        System.out.println(t1);
        Tempo t2 = new Tempo(18,0);
        System.out.println(t2);
        
        Empregado e1 = new Empregado("Duarte", "Amorim", d, t1, t2);
        Empregado e2 = new Empregado("Tiago", "Ferreira", d, t1, t2);
       
        if(e1.getDataContrato() == e2.getDataContrato()) {
            System.out.println("Referência Data Partilhada");
        } else {
            System.out.println("Nenhuma Referência Data Partilhada");
        }
        
        if (e1.getHoraEntrada() == e2.getHoraEntrada() || e1.getHoraSaida() == e2.getHoraSaida()) {
            System.out.println("Referência Tempo Partilhada");
        } else {
            System.out.println("Nenhuma Referência Tempo Partilhada");
        }
        
        d.setData(2013, 12, 25);
        
        t1.setTempo(8, 30, 0);
        t2.setTempo(17, 30, 0);
        System.out.println("\nData "+d+"\nTempo 1 "+t1+"\nTempo 2 "+t2+"\n");
        System.out.println(e1);
        System.out.println(e2+"\n");
       
        e2.setDataContrato(new Data(2012,9,10));
        e2.setHoraEntrada(new Tempo(15,30));
        e2.setHoraSaida(new Tempo(22,50));
        
        Empregado[] e = {e1, e2};
        
        for (int i = 0; i < e.length; i++) {
            System.out.println(e[i]);
        }
        
        System.out.println("");
        
        for (int i = 0; i < e.length; i++) {
            System.out.printf("Nome: %s %s  NºHoras Semanal: %s  Antiguidade: %d anos%n", e[i].getPrimeiroNome(), e[i].getUltimoNome(), e[i].calculoHorasSemanais().toString(), e[i].tempoContrato());
        }
        
        
        
    }
}
