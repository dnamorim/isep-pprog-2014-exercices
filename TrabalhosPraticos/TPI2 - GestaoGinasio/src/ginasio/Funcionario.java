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
public class Funcionario extends Trabalhador {
    
    /**
     * Número de Clientes Angariados do funcionario
     */
    private int nrClientes;
    
    /**
     * Salário Base dos Funcionários (valor por defeito = 750) 
     */
    private static float salarioBase = 750f;
    
    /**
     * Bónus por cada Cliente angariado pelos Funcionários (valor por defeito = 6)
     */
    private static float bonusCliente = 6f;
    
    /**
    * Número de Clientes angariados por defeito
    */
    protected static int NRCLIENTES_POR_DEFEITO = 0;
    
    /**
     * Constrói uma instância de Funcionário sendo todos os atributos passados por parâmetro
     * @param nome Nome do funcionário
     * @param sexo Sexo do Funcionário
     * @param idade Idade do Funcionário
     * @param nif NIF do Funcionário
     * @param nrTrabalhador Número Interno de Trabalhador
     * @param nrClientes Número de Clientes Angariados pelo Funcionário
     */
    public Funcionario(String nome, char sexo, int idade, int nif, int nrTrabalhador, int nrClientes) {
        super(nome, sexo, idade, nif, nrTrabalhador);
        this.nrClientes = nrClientes;
    }
    
    /**
     * Constrói uma instância de Funcionário com os valores por defeito
     */
    public Funcionario() {
        this(Pessoa.NOME_POR_DEFEITO, Pessoa.SEXO_POR_DEFEITO, Pessoa.IDADE_POR_DEFEITO, Pessoa.NIF_POR_DEFEITO, Trabalhador.NRTRABALHADOR_POR_DEFEITO, Funcionario.NRCLIENTES_POR_DEFEITO);
    }
    
    /**
     * Constrói uma instância de Funcionário, sendo um clone do Funcionário passado por parâmetro. 
     * @param outroFuncionario funcionário a ser clonado
     */
    public Funcionario(Funcionario outroFuncionario) {
        this(outroFuncionario.getNome(), outroFuncionario.getSexo(), outroFuncionario.getIdade(), outroFuncionario.getNif(), outroFuncionario.getNrTrabalhador(), outroFuncionario.getNrClientes());
    }
    
    /**
     * Devolve o número de clientes angariados por um funcionário.
     * @return nrClientes Angariados
     */
    public int getNrClientes() {
        return this.nrClientes;
    }
    
    /**
     * Altera o número de clientes angariados por um funcionário
     * @param nrClientes Novo número de clientes angariados.
     */
    public void setNrClientes(int nrClientes) {
        this.nrClientes = nrClientes;
    }
    
    /**
     * Devolve o vencimento de um Funcionário 
     * @return vencimento Funcionário - Fórumula Cálculo: salarioBase + clientesAngariados*BonusPorClienteAngariado
     */
    @Override
    public float vencimentoTrabalhador() {
        return Funcionario.salarioBase + (this.nrClientes*Funcionario.bonusCliente);
    }
    
    /**
     * Devolve a descrição textual de um funcionário
     * @return atributos de um funcionário
     */
    @Override
    public String toString() {
        return String.format("Funcionário:%n%s%nNº Clientes Angariados: %d", super.toString(), this.nrClientes);
    }
    
    /**
     * Devolve o Bónus por Ciente Angariado dos Funcionários
     * @return bonus por Cliente
     */
    public static float getBonusCliente() {
        return Funcionario.bonusCliente;
    }
    
    /**
     * Devolve o salário base dos Funcionários
     * @return salario base
     */
    public static float getSalarioBase () {
        return Funcionario.salarioBase;
    }
       
    /**
     * Altera o valor do Bónus por Cliente angariado para os Funcionários
     * @param bonus novo valor do Bónus
     */
    public static void setBonusCliente(float bonus) {
        Funcionario.bonusCliente = bonus;
    }
    
    /**
     * Altera o valor do Salário Base para os funcionários
     * @param salario 
     */
    public static void setSalarioBase (float salario) {
        Funcionario.salarioBase = salario;
    }
    
    /**
     * Compara o funcionário com outro objecto passado por parâmetro
     * @param outroObjecto objecto a comparar
     * @return true se o objecto se tratar funcionário da comparação. Caso contrário, false.
     */
    @Override
    public boolean equals(Object outroObjecto) {
        if(!super.equals(outroObjecto)) {
            return false;
        }
        Funcionario f = (Funcionario) outroObjecto;
        return this.nrClientes == f.getNrClientes();
    }

}

