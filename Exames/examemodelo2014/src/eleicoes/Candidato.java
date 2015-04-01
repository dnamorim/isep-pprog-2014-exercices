/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eleicoes;

/**
 * (Questão 1)
 * Representa uma pessoa que se candidata ao lugar de líder do partido.
 * @author dnamorim
 */
public class Candidato {
    
   /**
    * Nome do Candidato
    */
   private String nome;
   /**
    * Número de Votos do Candidato
    */
   private int numVotos;
   
   /**
    * Constrói uma instância de Candidado com um nome enviado por parâmetro e o número de votos a zero (0).
    * @param nome nome do candidato
    */
   public Candidato(String nome) {
       this.nome = nome;
       this.numVotos = 0;
   }
   
   /**
    * Contrói uma instância clone de um objecto Candidato enviado por parâmetro
    * @param clone objecto candidato a clonar
    */
   public Candidato(Candidato clone) {
       this.nome = clone.getNome();
       this.numVotos = clone.getNumVotos();
   }
   
   /**
    * Incrementa o Número de Votos do candidato (1 por cada chamada)
    */
   public void incrementarVotos() {
       this.numVotos++;
   }
   
   /**
    * Inicializa o número de votos do candidato a zero (0).
    */
   public void inicializarNumVotos() {
       this.numVotos = 0;
   }
   
   //Métodos que "supostamente" estão feitos
   
   /**
    * Devolve o número de votos do candidato
    * @return número de votos
    */
   public int getNumVotos() {
       return this.numVotos;
   }
   
   /**
    * Devolve o nome do candidato
    * @return nome do candidato
    */
   public String getNome() {
       return this.nome;
   }
   
  
    
}
