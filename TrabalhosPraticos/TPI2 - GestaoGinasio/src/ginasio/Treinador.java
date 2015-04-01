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
public class Treinador extends Trabalhador {
    
    /**
     * Salário de um Treinador
     */
    private float salario;
    
    protected static float SALARIO_POR_DEFEITO = 0;

    /**
     * Constrói uma instância de um Treinador com todos os atributos passados por parâmetro
     * @param nome nome do Treinador
     * @param sexo sexo do Treinador
     * @param idade idade do Treinador
     * @param nif nif do Treinador
     * @param nrTrabalhador Número Interno de Trabalhador
     * @param salario Salário do Treinador
     */
    public Treinador(String nome, char sexo, int idade, int nif, int nrTrabalhador, float salario) {
        super(nome, sexo, idade, nif, nrTrabalhador);
        this.salario = salario;
    }
    
    /**
     * Constrói uma instância de um Treinador com os valores por defeito
     */
    public Treinador() {
        this(Pessoa.NOME_POR_DEFEITO, Pessoa.SEXO_POR_DEFEITO, Pessoa.IDADE_POR_DEFEITO, Pessoa.NIF_POR_DEFEITO, Trabalhador.NRTRABALHADOR_POR_DEFEITO, Treinador.SALARIO_POR_DEFEITO);
    }
    
    /**
     * Constrói uma instância de um Treinador, sendo um clone do Treinador recebido por parâmetro.
     * @param outroTreinador objecto treinador a clonar
     */
    public Treinador(Treinador outroTreinador) {
        this(outroTreinador.getNome(), outroTreinador.getSexo(), outroTreinador.getIdade(), outroTreinador.getNif(), outroTreinador.getNrTrabalhador(), outroTreinador.getSalario());
    }
    
    /**
     * Devolve o valor do salário de um treinador
     * @return valor Salario
     */
    public float getSalario() {
        return this.salario;
    }
    
    /**
     * Altera o valor do salário de um treinador
     * @param salario novo valor do salário de um treinador
     */
    public void setSalario(float salario) {
        this.salario = salario;
    }
    
    /**
     * Devolve o vencimento de um Treinador
     * @return salario Treinador
     */
    @Override
    public float vencimentoTrabalhador() {
        return this.salario;
    }
    
    /**
     * Devolve a descrição textual de um Treinador
     * @return atributos de um treinador
     */
    @Override
    public String toString() {
        return String.format("Treinador:%n%s%nSalário: %.2f €", super.toString(), this.salario);
    }
    
    /**
     * Compara o treinador com outro objecto recebido por parâmetro
     * @param outroObjecto outro objecto a ser comparado
     * @return true se o objecto for igual ao treinador. Caso Contrário, false.
     */
    @Override
    public boolean equals(Object outroObjecto) {
        if(!super.equals(outroObjecto)) {
            return false;
        }
        Treinador t = (Treinador) outroObjecto;
        return (this.salario == t.getSalario());
    }
    

    
}

