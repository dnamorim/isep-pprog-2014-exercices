/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package clubedesportivo;

/**
 * Representa um Atleta no sistema
 * @author dnamorim
 */
public abstract class Atleta extends Pessoa {

    /**
     * Número Identificador do Atleta
     */
    private int numero;
    
    /**
     * Constrói uma instância do Atleta
     * @param nome
     * @param modalidade 
     * @param numero 
     */
    public Atleta(String nome, Modalidade modalidade, int numero) {
        super(nome, modalidade);
        this.numero = numero;
    }

    /**
     * Devolve o Número do Atleta
     * @return numero do atleta
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Define um novo Número do Atleta
     * @param numero número do atleta
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    
    
}
