/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

import java.util.Calendar;

/**
 * Testes da Classe Data
 * @author Duarte Nuno Amorim <1130674@isep.ipp.pt> 
 */
public class TesteData {
    
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        
        //2a. Crie uma instância da classe Data com o nome data1 e que represente a data de hoje.
        Data data1 = new Data(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1, cal.get(Calendar.DAY_OF_MONTH));
        
        //2b. Mostre data1 usando o formato por extenso.
        data1.toString();
    
        //2c. Crie uma outra instância da classe Data chamada data2 que guarde a data 25 de abril de 1974.
        Data data2 = new Data(1974,4,25);
        
        //2d. Mostre data2 no formato "ano/mês/dia".
        data2.toAnoMesDiaString();
        
        //2e. Utilize o método de instância isMaior para confirmar que, de facto, data1 é mais recente do que data2.
        if(data1.isMaior(data2)) {
            System.out.println(data1.toAnoMesDiaString()+" é mais recente do que "+data2.toAnoMesDiaString());
        } else {
            System.out.println(data1.toAnoMesDiaString()+" não é mais recente do que "+data2.toAnoMesDiaString());
        }
        
        //2f. Determine o número de dias entre data1 e data2.
        System.out.println("Diferença de dias ente "+data1.toAnoMesDiaString()+" e "+data2.toAnoMesDiaString()+": "+data1.diferenca(data2));
        
        //2g. Determine o número de dias que faltam para o Natal, usando o método que recebe, por parâmetro, o dia, o mês e o ano de uma data.
        System.out.println("Diferença de dias ente "+data1.toAnoMesDiaString()+" e o dia de Natal ("+cal.get(Calendar.YEAR)+"/12/25): "+data1.diferenca(cal.get(Calendar.YEAR), 12, 25));
        
        //2h. Determine o dia da semana em que ocorreu o dia 25 de abril de 1974.
        System.out.println("O "+data2.toAnoMesDiaString()+" ocorreu numa "+data2.diaDaSemana()+".");

        //2i. Verifique se o ano 1974 foi bissexto, invocando o método de classe isAnoBissexto: 
        //2i1. Através do objeto data2; 
        if(data2.isAnoBissexto(data2.getAno())) {
            System.out.println("O Ano "+data2.getAno()+" é bissexto.");
        } else {
            System.out.println("O Ano "+data2.getAno()+" não é bissexto.");
        }
            
        //2i2. Através da classe Data.
        if(Data.isAnoBissexto(1974)) {
            System.out.println("O Ano 1974 é bissexto.");
        } else {
            System.out.println("O Ano 1974 não é bissexto.");
        }
    }
}
