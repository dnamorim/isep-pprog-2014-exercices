/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vencimentos.model;

/**
 * Representa um trabalhador à comissão através do seu nome, salário base,
 * montante de vendas e percentagem da comissão de vendas.
 *
 * @author ISEP-DEI-PPROG
 */
public class TrabCom extends Trabalhador {

    /**
     * O salário base do trabalhador à comissão.
     */
    private float salarioBase;

    /**
     * O montante de vendas realizadas pelo trabalhador à comissão.
     */
    private float vendas;

    /**
     * A percentagem da comissão de vendas do trabalhador à comissão.
     */
    private float comissao;

    /**
     * O valor por omissão do salário base do trabalhador à comissão.
     */
    private static final int SALARIO_BASE_POR_OMISSAO = 485;

    /**
     * Constrói uma instância de TrabCom recebendo o nome, o salário base, o
     * montante de vendas e a percentagem da comissão de vendas do trabalhador à
     * comissão.
     *
     * @param nome o nome do trabalhador à comissão
     * @param salarioBase o salário base do trabalhador à comissão
     * @param vendas o montante de vendas do trabalhador à comissão
     * @param comissao a percentagem da comissão de vendas do trabalhador à
     * comissão
     */
    public TrabCom(String nome, float salarioBase, float vendas, float comissao) {
        super(nome);
        this.salarioBase = salarioBase;
        this.vendas = vendas;
        this.comissao = comissao;
    }

    /**
     * Constrói uma instância de TrabCom recebendo o nome e atribuindo o salário
     * base por omissão e zero ao montante das vendas e à percentagem da
     * comissão de vendas do trabalhador à comissão.
     *
     * @param nome o nome do trabalhador à comissão
     */
    public TrabCom(String nome) {
        super(nome);
        this.salarioBase = TrabCom.SALARIO_BASE_POR_OMISSAO;
        this.vendas = 0;
        this.comissao = 0;
    }

    /**
     * Constrói uma instância de TrabCom atribuindo o nome por omissão, o
     * salário base por omissão e zero ao montante das vendas e à percentagem da
     * comissão de vendas do trabalhador à comissão.
     */
    public TrabCom() {
        super();
        this.salarioBase = TrabCom.SALARIO_BASE_POR_OMISSAO;
        this.vendas = 0;
        this.comissao = 0;
    }

    /**
     * Constrói uma instância de TrabCom que é um clone do trabalhador à
     * comissão recebido.
     *
     * @param outroTrabCom o trabalhador à comissão a clonar
     */
    public TrabCom(TrabCom outroTrabCom) {
        super(outroTrabCom);
        this.salarioBase = outroTrabCom.salarioBase;
        this.vendas = outroTrabCom.vendas;
        this.comissao = outroTrabCom.comissao;
    }

    /**
     * Devolve o salário base do trabalhador à comissão.
     *
     * @return salário base do trabalhador à comissão.
     */
    public float getSalarioBase() {
        return this.salarioBase;
    }

    /**
     * Devolve o montante de vendas do trabalhador à comissão.     
     *
     * @return montante das vendas do trabalhador à comissão
     */
    public float getVendas() {
        return this.vendas;
    }

    /**
     * Devolve a percentagem da comissão de vendas do trabalhador à comissão.
     *
     * @return percentagem da comissão de vendas do trabalhador à comissão
     */
    public float getComissao() {
        return this.comissao;
    }

    /**
     * Modifica o salário base do trabalhador à comissão.
     *
     * @param salarioBase o novo salário base do trabalhador à comissão
     */
    public void setSalarioBase(float salarioBase) {
        this.salarioBase = salarioBase;
    }

    /**
     * Modifica o montante de vendas do trabalhador à comissão.
     *
     * @param vendas o novo montante de vendas do trabalhador à comissão
     */
    public void setVendas(float vendas) {
        this.vendas = vendas;
    }

    /**
     * Modifica a percentagem da comissão de vendas do trabalhador à comissão.
     *
     * @param comissao a nova percentagem da comissão de vendas do trabalhador 
     * à comissão
     */
    public void setComissao(float comissao) {
        this.comissao = comissao;
    }

    /**
     * Devolve a descrição textual do trabalhador à comissão.
     *
     * @return caraterísticas do trabalhador à comissão
     */
    @Override
    public String toString() {
        return String.format("Trabalhador à Comissão: %s "
                + "%nSalário Base: %.2f Euros "
                + "%nVendas: %.2f Euros "
                + "%nComissão: %.1f%%",
                super.toString(), this.salarioBase, this.vendas, this.comissao);
    }

    /**
     * Compara o trabalhador à comissão com o objeto recebido.
     *
     * @param outroObjeto o objeto a comparar com o trabalhador à comissão
     * @return true se o objeto recebido representar outro trabalhador
     * equivalente ao trabalhador à comissão. Caso contrário, retorna false.
     */
    @Override
    public boolean equals(Object outroObjeto) {
        if (!super.equals(outroObjeto)) {
            return false;
        }
        TrabCom tc = (TrabCom) outroObjeto;
        return this.salarioBase == tc.salarioBase && this.vendas == tc.vendas
                && this.comissao == tc.comissao;
    }

    /**
     * Devolve o vencimento do trabalhador à comissão.
     *
     * @return vencimento do trabalhador à comissão
     */
    public float vencimento() {
        return this.salarioBase + this.vendas * (this.comissao / 100);
    }

}

