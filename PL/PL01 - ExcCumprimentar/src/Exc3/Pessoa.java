/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Exc3;

/**
 * Representa uma pessoa através do seu nome e idade
 * @author Duarte Nuno Amorim
 */
public class Pessoa {
    /**
     * As variáveis de instância que representam uma Pessoa: o nome e a idade.
     */
    private String nome; //variável de instância
    private int idade;
    
    //Construtor com Parâmetro - igual ao nome da classe
    /**
     * Contrói uma instância de um Objecto do tipo Pessoa em que é passado parâmetros (recebe o nome e idade)
     * @param nome Nome da Pessoa
     * @param idade Idade da Pessoa
     */
    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }
    
    /** Constrói uma instância de um Objecto do tipo Pessoa em que é passado por Parâmetro o nome da Pessoa e definida a idade como 0.
     * @param nome Nome da Pessoa 
     */
    public Pessoa (String nome) {
        this.nome = nome;
        this.idade = 0;
    }
    //Construtor sem Parâmetros
    /** Constrói uma instância de um Objecto do tipo Pessoa em que o nome é "sem nome" e a idade 0
     */
    public Pessoa() {
        this.nome="sem nome";
        this.idade=0;
    }

     /**
     * Método que retorna a idade de uma Pessoa
     * @return Idade do objecto Pessoa
     */
    public int getIdade() {
        return this.idade;
    }
    
    /**
     * Método que retorna o nome de uma Pessoa
     * @return nome do objecto pessoa
     */
    public String getNome() {
        return this.nome;
    }
    
    /**
     * Método que permite alterar uma idade
     * @param idade Nova idade do Objecto Pessoa 
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    /**
     * Método que permite alterar o nome de uma Pessoa, recebendo o novo nome por parâmetro
     * @param nome Novo Nome do Objecto Pessoa
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    /**
     * Método que devolve a descrição textual de uma Pessoa
     * @return Frase com o nome e a idade (Ex: O Rui tem 15 anos.)
     */
    public String toString( ) {
        if(this.idade == 0) {
            return ("O nome é "+this.nome+".");
        }
        return (this.nome+" tem "+this.idade+" anos.");
    }
    
    
}
