package clubedesportivo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Representa uma pessoa no Sistema
 * @author dnamorim
 */
public abstract class Pessoa {
    /**
     * Nome de uma Pessoa
     */
    private String nome;
    /**
     * Modalidade da Pessoa
     */
    private Modalidade modalidade;
    
    /**
     * Constrói uma instãncia de uma Pessoa
     * @param nome Nome da Pessoa
     * @param modalidade Modalidade associada à Pessoa
     */
    public Pessoa(String nome, Modalidade modalidade) {
        this.nome = nome;
        this.modalidade = modalidade;
    }

    /**
     * Devolve o Nome da Pessoa
     * @return nome 
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define um novo Nome para a Pessoa
     * @param nome novo nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Devolve a modalidade da Pesosa
     * @return modalidade
     */
    public Modalidade getModalidade() {
        return modalidade;
    }

    /**
     * Define uma nova modalidade para a Pessoa
     * @param modalidade 
     */
    public void setModalidade(Modalidade modalidade) {
        this.modalidade = modalidade;
    }
    
    
    
}
