/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package clubedesportivo;

import java.io.Serializable;

/**
 * Representa um Atleta Profissional no sistema
 * @author dnamorim
 */
public class Profissional extends Atleta implements Serializable, Vencimento {

    /**
     * Vencimento Base de um Atleta Profisisonal
     */
    private float vencimento;
    /**
     * Desempenho de um Atleta Profissional
     */
    private Desempenho desempenho;
    
    /**
     * Constrói uma instância de um Atleta Profissional
     * @param nome nome do Atleta Profissional
     * @param modalidade modalidade do Atleta Profissional
     * @param numero Número do Atleta Profissional
     * @param vencimento Vencimento base do Atleta Profissional
     * @param desempenho Desempenho do Atleta Profissional
     */
    public Profissional(String nome, Modalidade modalidade, int numero, float vencimento, Desempenho desempenho) {
        super(nome, modalidade, numero);
        this.desempenho = desempenho;
    }

    /**
     * Devolve o vencimento base do atleta profissional
     * @return vencimento 
     */
    public float getVencimento() {
        return this.vencimento;
    }

    /**
     * Devolve o Desempenho do Atleta Profissional
     * @return desempenho
     */
    public Desempenho getDesempenho() {
        return this.desempenho;
    }
    
    /**
     * Define um novo desempenho do atleta profissional
     * @param desempenho novo desempenho
     */
    public void setDesempenho(Desempenho desempenho) {
        this.desempenho = desempenho;
    }
    
    /**
     * Define um novo vencimento do atleta profissional
     * @param vencimento novo vencimento
     */
    @Override
    public void setVencimento(float vencimento) {
        this.vencimento = vencimento;
    }

    /**
     * Devolve o valor do vencimento de um atleta profissional, tendo em conta o seu desempenho e respectiva valorização.
     * @return vencimento total
     */
    @Override
    public float calcularVencimento() {
        return (this.vencimento * (1+this.desempenho.getTaxaValorizacao()));
    }
    
}
