/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testes;

import automovel.*;
import utilitarios.Data;

/**
 *
 * @author Duarte Nuno Amorim <1130674@isep.ipp.pt>
 */
public class TesteAutomovel {
    
    public static void main(String[] args) {
    
        Data d = new Data(2013,3,16);
        System.out.println(d.toAnoMesDiaString()+"\n");
        
        Automovel a1 = new Automovel("12-12-PP", "Kia", d);
        System.out.println(a1+"\n");
        
        d.setData(2013, 10, 10);
        System.out.println(d.toAnoMesDiaString()+"\n");
        
        Automovel a2 = new Automovel("13-13-QQ", "BMW", d);
        System.out.println(a2+"\n");
        
        System.out.println(a1);
        System.out.println(a2+"\n");
        
        System.out.println(MinhaData.dataActual());
        
        System.out.println("\n### Data de Registo por Omissão do Automóvel ###");
        System.out.println(new Automovel());
        
    }
    
}
