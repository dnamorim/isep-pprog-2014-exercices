/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tempo;



/**
 *
 * @author Duarte Nuno Amorim <1130674@isep.ipp.pt> 
 */
public class TesteTempo {
    
    public static void main(String[] args) {
        //2a. Crie uma instância da classe Tempo com o nome t1 e que represente o tempo: 5 horas, 30 minutos e 12 segundos.
        Tempo t1 = new Tempo(5,30,12);
        
        //2b. Mostre o tempo t1 usando o formato "hh:mm:ss AM (ou PM)". 
        System.out.println(t1.toStringAMPM());
        
        //2c. Acrescente 1 segundo ao tempo t1
        t1.addOneSecond();
        
        //2d. Mostre novamente t1 usando o formato "hh:mm:ss AM (ou PM)".
        System.out.println(t1.toStringAMPM());
        
        //2e. Crie uma outra instância da classe Tempo chamada t2 que guarde o tempo: 18 horas, 5 minutos e 20 segundos.
        Tempo t2 = new Tempo(18,5,20);
    
        //2f. Mostre o tempo t2 usando o formato "hh:mm:ss AM (ou PM)".
        System.out.println(t2.toStringAMPM());
        
        //2g. Verifique se o tempo t1 é maior do que o tempo t2.
        System.out.println(t1.isTempoMaior(t2));
        
        //2h. Verifique se o tempo t1 é maior do que o tempo 23 horas, 7 minutos e 4 segundos usando o método que recebe por parâmetro as horas, os minutos e os segundos de um tempo.
        System.out.println(t1.isTempoMaior(23,7,4));
        
        //2i. Determinar a diferença entre o tempo t1 e o tempo t2:
        //2i1. em segundos;
        System.out.println(t1.diferencaTempoSegundos(t2));
        
        //2i2. em Tempo.
        Tempo difTempo = t1.diferencaTempo(t2);
        System.out.println(difTempo.toString());
    }

}
