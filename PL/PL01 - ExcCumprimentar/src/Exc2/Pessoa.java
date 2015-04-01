/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Exc2;

/**
 * Representa uma Pessoa através do seu Nome
 * @author Duarte Nuno Amorim
 */
public class Pessoa {
   /**
     * As variáveis de instância que representam uma Pessoa: o nome.
     */
    private String nome; 
    
    //Construtor com Parâmetro - igual ao nome da classe
    /**
     * Constrói uma instância de um Objecto do tipo Pessoa, passando por parâmetro o nome da Pessoa.
     * @param nome O nome da pessoa
     */
    public Pessoa(String nome) {
        this.nome = nome;
    }
    
    /**
     * Constrói uma instância do Objecto do tipo Pessoa, não passando parâmetros e atríbuindo o nome por defeito o valor "Não Atríbuido".
     */
    public Pessoa() {
        this.nome = "Não Atríbuido";
    }
    
    /**
     * Método que permite definir um novo nome da Pessoa
     * @param nome Novo nome da Pessoa
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    /**
     * Método que permite obter o nome actual de uma Pessoa
     * @return Nome do Objecto Pessoa
     */
    public String getNome() {
        return this.nome;
    }
    
    /**
     * Método que retorna uma descrição textual representativo da Pessoa
     * @return a descrição textual do objecto (Ex: O nome é Duarte.)
     */
    public String toString( ) {
        return ("O nome é "+this.nome);
    }
    
    
}
