/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ginasio;

import java.util.ArrayList;

/**
 *
 * @author Duarte Nuno Amorim <1130674@isep.ipp.pt>
 */
public class Funcionario extends Pessoa implements Trabalhador, Recebimento {
    
    /**
     * Lista de Clientes Angariados do funcionario
     */
    private ArrayList<Cliente> listaClientes;
    
    /**
     * Salário Base dos Funcionários (valor por defeito = 750) 
     */
    private static float salarioBase = 750f;
    
    /**
     * Bónus por cada Cliente angariado pelos Funcionários (valor por defeito = 6)
     */
    private static float bonusCliente = 6f;
    
    /**
     * Lista de Clientes Angariados por Defeito
     */
    protected static ArrayList<Cliente> LISTACLIENTES_POR_DEFEITO = new ArrayList(); 
    
    
    /**
     * Constrói uma instância de Funcionário sendo todos os atributos passados por parâmetro
     * @param nome Nome do funcionário
     * @param sexo Sexo do Funcionário
     * @param idade Idade do Funcionário
     * @param nif NIF do Funcionário
     * @param listaClientes Lista dos Clientes Angariados pelo funcionário
     */
    public Funcionario(String nome, char sexo, int idade, int nif, ArrayList<Cliente> listaClientes) {
        super(nome, sexo, idade, nif);
        this.listaClientes = new ArrayList(listaClientes);
    }
    
    /**
     * Constrói uma instância de Funcionário sendo todos os atributos de uma pessoa passados por parâmetro
     * @param nome Nome do funcionário
     * @param sexo Sexo do Funcionário
     * @param idade Idade do Funcionário
     * @param nif NIF do Funcionário
     */
    public Funcionario(String nome, char sexo, int idade, int nif) {
        this(nome, sexo, idade, nif, Funcionario.LISTACLIENTES_POR_DEFEITO);
    }
    
    /**
     * Constrói uma instância de Funcionário com os valores por defeito
     */
    public Funcionario() {
        this(Pessoa.NOME_POR_DEFEITO, Pessoa.SEXO_POR_DEFEITO, Pessoa.IDADE_POR_DEFEITO, Pessoa.NIF_POR_DEFEITO, Funcionario.LISTACLIENTES_POR_DEFEITO);
    }
    
    /**
     * Constrói uma instância de Funcionário, sendo um clone do Funcionário passado por parâmetro. 
     * @param outroFuncionario funcionário a ser clonado
     */
    public Funcionario(Funcionario outroFuncionario) {
        this(outroFuncionario.getNome(), outroFuncionario.getSexo(), outroFuncionario.getIdade(), outroFuncionario.getNif(), outroFuncionario.getListaClientes());
    }
    
    /**
     * Devolve a lista de Clientes de um Funcionário
     * @return lista Clientes Angariados 
     */
    public ArrayList<Cliente> getListaClientes() {
        return new ArrayList(this.listaClientes);
    }
    
    /**
     * Define uma nova lista de Clientes de um Funcionário
     * @param listaClientes nova lista de Clientes Angariados
     */
    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }
    
    
    /**
     * Devolve o vencimento de um Funcionário 
     * @return vencimento Funcionário - Fórumula Cálculo: salarioBase + clientesAngariados*BonusPorClienteAngariado
     */
    @Override
    public float receber() {
        return Funcionario.salarioBase + (listaClientes.size()*Funcionario.bonusCliente);
    }
    
    /**
     * Remove um Cliente da Lista de Clientes Angariados do Funcionário
     * @param cliente cliente a remover da lista
     */
    public void removeClienteLista(Cliente cliente) {
        this.listaClientes.remove(cliente);
    }
    
    /**
     * Adiciona um Cliente à Lista de Clientes Angariados do Funcionário
     * @param cliente cliente a adicionar à lista
     */
    public void addClienteLista(Cliente cliente) {
        this.listaClientes.add(cliente);
    }
    
    
    /**
     * Devolve a descrição textual de um funcionário
     * @return atributos de um funcionário
     */
    @Override
    public String toString() {
        return String.format("Funcionário:%n%s%nNº Clientes Angariados: %d%n", super.toString(), listaClientes.size());
    }
     /**
     * Devolve a descrição textual de um funcionário com Listagem de Cleintes
     * @return atributos de um funcionário e listagem de clientes
     */
    public String toStringListagem() {
        return String.format("%s%n --- CLIENTES ANGARIADOS --- %n%s", this.toString(), (listaClientes.isEmpty()) ? "Sem Clientes Angariados" : this.printListaClientes());
    }
    
    /**
     * Devolve a Listagem dos Clientes Angariados do Funcionário
     * @return lista Clientes
     */
    public String printListaClientes() {
        String strLista = "";
        for (Cliente cliente : this.listaClientes) {
            strLista += String.format("%s%n", cliente);
        }
        return strLista;
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
        return this.listaClientes.equals(f.listaClientes);
    }

}

