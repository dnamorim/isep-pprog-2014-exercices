/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tributaveis;

import java.util.*;

/**
 *
 * @author Duarte Nuno Amorim <1130674@isep.ipp.pt> 
 */
public class TesteTributaveis {
    
    public static void main(String[] args) {
        
        Veiculo v1 = new Veiculo("22-33-CC", 1000, "Encarnado");
        System.out.println(v1);
    
        Veiculo v2= new Veiculo("44-55-DD", 2500, Cores.AZUL);
        System.out.println(v2); 
        
        Veiculo v3 = new Veiculo("11-22-BB", 1400, Veiculo.VERDE);
        System.out.println(v3);
        
        Moradia m1 = new Moradia("Rua do Bocage", 90, Moradia.CINZENTO);
        System.out.println(m1);
        
        Cores c = v1; //Atribui
        c = m1; //Substitui
        
        Tributavel[] tributaveis = new Tributavel[4];
        
        tributaveis[0] = v1;
        tributaveis[1] = v2;
        tributaveis[2] = v3;
        tributaveis[3] = m1;
        
        float totImpostos = 0;
        for(int i=0; i < tributaveis.length; i++) {
            if(tributaveis[i] != null) {
                totImpostos+=tributaveis[i].calcularImposto();
            }
        }
        
        System.out.printf("%n### Total de impostos a pagar: %.2f €%n", totImpostos);
        
        System.out.println("\n\n### Tributáveis por ordem crescente de imposto a pagar (Objectos Comparable)");
        Arrays.sort(tributaveis); //Ordena baseado no compareTo da classe
        listar(tributaveis);
        
        System.out.println("\n\n### Tributáveis por ordem decrescente de imposto a pagar (Objectos Comparable)");
        //reverseOrder - inverte a ordem definida no compareTo
        Arrays.sort(tributaveis, Collections.reverseOrder());
        listar(tributaveis);
        
        System.out.println("\n\n### Tributáveis por ordem crescente de imposto a pagar (Objectos não Comparable)");
        Comparator criterio1 = new Comparator() {
            @Override
            public int compare(Object obj1, Object obj2) {
                float imposto1 = ((Tributavel) obj1).calcularImposto();
                float imposto2 = ((Tributavel) obj2).calcularImposto();
                
                if (imposto1 < imposto2) {
                    return -1;
                } else if (imposto1 > imposto2) {
                    return 1;
                } else
                    return 0;
                }
        };
        
        Arrays.sort(tributaveis, criterio1);
        listar(tributaveis);
      
        
        System.out.println("\n\n### Tributáveis por ordem derescente de imposto a pagar (Objectos não Comparable)");
        Arrays.sort(tributaveis, Collections.reverseOrder(criterio1));
        listar(tributaveis);
    }
    
    private static void listar(Tributavel[] tributaveis) {
        for (int i=0; i<tributaveis.length; i++) {
            if(tributaveis[i] != null) {
                System.out.printf("%s imposto = %.1f €%n", tributaveis[i], tributaveis[i].calcularImposto());
            }
        }
    }
}
