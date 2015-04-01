/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package clubedesportivo;

/**
 * Representação do Desempenho de um Atleta
 * @author dnamorim
 */
public enum Desempenho {
    
    ALTO(0.5f), RAZOAVEL(0.1f), BAIXO(0f);
    
    /**
     * Percentagem/Taxa de Valorização do Desempenho do Atleta
     */
    private final float taxaValorizacao;
    
    /**
     * Construtor da classe enum que recebe como parâmetro a taxa de valorização do desempenho.
     *
     * @param tipo percentagem de valorizacao 
     */
    Desempenho(float percDes) {
        this.taxaValorizacao = percDes;
    }
    
    /**
     * Devolve a Taxa de Valorização associada a um Desempenho
     * @return taxa de valorização
     */
    public float getTaxaValorizacao() {
        return this.taxaValorizacao;
    }
        
}
