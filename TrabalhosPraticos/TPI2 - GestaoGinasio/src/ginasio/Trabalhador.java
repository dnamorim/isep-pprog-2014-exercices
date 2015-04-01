/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ginasio;

/**
 *
 * @author Duarte Nuno Amorim <1130674@isep.ipp.pt>
 */
public abstract class Trabalhador extends Pessoa {
    
    /**
     * Número Interno de Trabalhador
     */
    private int nrTrabalhador;
    
    /**
     * Número Interno de Trabalhador por defeito
     */
    protected static final int NRTRABALHADOR_POR_DEFEITO = 0;
    
    /**
     * Constrói uma instância de um Trabalhador com todos os atributos passados por parametro
     * @param nome nome do trabalhador
     * @param sexo sexo do trabalhador
     * @param idade idade do trabalhador
     * @param nif nif do trabalhador
     * @param nrTrabalhador numero interno do trabalhador
     */
    public Trabalhador(String nome, char sexo, int idade, int nif, int nrTrabalhador) {
        super(nome, sexo, idade, nif);
        this.nrTrabalhador = nrTrabalhador;
    }
    
    /**
     * Constrói uma instância de um Trabalhador onde os atributos assumem os valores por defeito
     */
    public Trabalhador() {
        this(Pessoa.NOME_POR_DEFEITO, Pessoa.SEXO_POR_DEFEITO, Pessoa.IDADE_POR_DEFEITO, Pessoa.NIF_POR_DEFEITO, Trabalhador.NRTRABALHADOR_POR_DEFEITO);
    }
    
    /**
     * Constrói uma instância de um Trabalhador, sendo um clone do Trabalhador recebido por parâmetro.
     * @param outroTrabalhador objecto trabalhador a clonar
     */
    public Trabalhador(Trabalhador outroTrabalhador) {
        this(outroTrabalhador.getNome(), outroTrabalhador.getSexo(), outroTrabalhador.getIdade(), outroTrabalhador.getNif(), outroTrabalhador.getNrTrabalhador());
    }
    
    /**
     * Devolve o Número interno do Trabalhador
     * @return numero trabalhador
     */
    public int getNrTrabalhador() {
        return this.nrTrabalhador;
    }
    
    /**
     * Altera o Número Interno do Trabalhador
     * @param nrTrabalhador Novo número de trabalhador
     */
    public void setNrTrabalhador(int nrTrabalhador) {
        this.nrTrabalhador = nrTrabalhador;
    }
    
    /**
     * Devolve a descrição textual de um trabalhador
     * @return atributos do trabalhador
     */
    @Override
    public String toString() {
        return String.format("%s%nNr. Trabalhador: %d", super.toString(), this.nrTrabalhador);
    }
    
    /**
     * Calcula o Salário de um Trabalhador utilizando o Polimorfismo
     * @return vencimentoTrabalhador
     */
    public abstract float vencimentoTrabalhador();
    
    /**
     * Compara um Trabalhador com outro Objecto Trabalhador recebido 
     * @param outroObjecto o outro Trabalhador a comparar
     * @return true se o objecto recebido representar o mesmo Trabalhador. Caso contrário, retorna false.
     */
    @Override
    public boolean equals(Object outroObjecto) {
        if(!super.equals(outroObjecto)) {
            return false;
        }
        Trabalhador t = (Trabalhador) outroObjecto;
        return this.nrTrabalhador == t.getNrTrabalhador();
    }
    
}

