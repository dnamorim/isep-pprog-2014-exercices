/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package disciplinas;

/**
 *
 * @author Duarte Nuno Amorim <1130674@isep.ipp.pt>
 */
public enum HabilitacoesAcademicas {
    LICENCIATURA ("Licenciatura"), 
    MESTRADO ("Mestrado"), 
    DOUTORAMENTO ("Doutoramento"), 
    PÓSGRADUAÇÃO ("Pós-Graduação"),
    NAODEFINIDO("Não-Definido");
    
    private final String habilitacao;
    
    HabilitacoesAcademicas(String habilitacao) {
        this.habilitacao = habilitacao;
    }
    
    String descricaoHabilitacao() {
        return this.habilitacao;
    }
}
