/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package impostos;

/**
 * 
 * @author Duarte Nuno Amorim <1130674@isep.ipp.pt> 
 */
public abstract class Contribuinte {
   
    /** 
     * Nome do Contribuinte
     */
    private String nome;
    
    /**
     * Morada do Contribuinte
     */
    private String morada;
    
    /**
     * Número de Identificação Fiscal (NIF) do Contribuinte
     */
    private int nif;
    
    /**
     * Rendimentos de Trabalho
     */
    private float rt;
    
    /**
     * Outros Rendimentos
     */
    private float or;
    
    /**
     * Nome do Contribuinte por Omissão
     */
    static final String NOME_POR_OMISSAO = "Nome não definido";
    
    /**
     * Morada do Contribuinte por Omissão
     */
    static final String MORADA_POR_OMISSAO = "Morada não definida";
    
    /**
     * NIF do Contribuinte por Omissão
     */
    static final int NIF_POR_OMISSAO = 999999999;
    
    /**
     * Rendimentos de Trabalho por omissão
     */
    static final float RT_POR_OMISSAO = 0;
    
    /**
     * Outros Rendimentos por Omissão
     */
    static final float OR_POR_OMISSAO = 0;
    
    /**
     * Constrói uma instância de {@code Contribuinte} recebento todos os atributos do Contribuinte
     * @param nome Nome do Contribuinte
     * @param morada Morada do Contribuinte 
     * @param nif NIF do Contribuinte
     * @param rt Rendimentos de Trabalho do Contribuinte
     * @param or Outros Rendimentos do Contribuinte
     */
    public Contribuinte (String nome, String morada, int nif, float rt, float or) {
        this.nome = nome;
        this.morada = morada;
        this.nif = nif;
        this.rt = rt;
        this.or = or;
    }
        
    /**
     * Constrói uma instância de {@code Contribuinte} com os valores por omissão
     */
    public Contribuinte() {
        this(NOME_POR_OMISSAO, MORADA_POR_OMISSAO, NIF_POR_OMISSAO, RT_POR_OMISSAO, OR_POR_OMISSAO);
    }
    
    /**
     * Constrói uma instância de {@code Contribuinte} com os mesmos atributos do Contribuinte recebido por parâmetro
     * @param outroContribuinte o contribuinte com as caracterísicas a copiar
     */
    public Contribuinte(Contribuinte outroContribuinte) {
        this(outroContribuinte.nome, outroContribuinte.morada, outroContribuinte.nif, outroContribuinte.rt, outroContribuinte.or);
    }
    
    /**
     * Devolve o Nome do Contribuinte
     * @return nome do contribuinte
     */
    public String getNome() {
        return this.nome;
    }
    
    /**
     * Devolve a Morada do Contribuinte
     * @return morada do contribuinte
     */
    public String getMorada() {
        return this.morada;
    }
    
    /**
     * Devolve o NIF do Contribuinte
     * @return NIF do Contribuinte
     */
    public int getNIF() {
        return this.nif;
    }
    
    /**
     * Devolve os Rendimentos de Trabalho do Contribuinte
     * @return 
     */
    public float getRT() {
        return this.rt;
    }
    
    /**
     * Devolve os Outros Rendimentos do Contribuinte
     * @return 
     */
    public float getOR() {
        return this.or;
    }
    
    
    /**
     * Modifica o Nome do Contribuinte
     * @param nome novo nome do contribuinte
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    /**
     * Modifica a Morada do Contribuinte
     * @param morada nova morada do contriubuinte
     */
    public void setMorada(String morada) {
        this.morada = morada;
    }
    
    /**
     * Modifica o NIF Contribuinte 
     * @param nif novo nif do contribuinte
     */
    public void setNIF (int nif) {
        this.nif = nif;
    }
    
    /**
     * Modifica os Rendimentos de Trabalho do Contribuinte
     * @param rt novos rendimentos de trabalho do contribuinte
     */
    public void setRT (float rt) {
        this.rt = rt;
    }
    
    /**
     * Modifica os Outros Rendimentos do Contribuinte
     * @param or novos outros rendimentos do contribuinte
     */
    public void setOR (float or) {
        this.or = or;
    }
    
    /**
     * Devolve uma descrição textual de um contribuinte
     * @return atributos de um contribuinte
     */
    @Override
    public String toString() {
        return String.format("Contribuinte NIF nº: %d%n Nome: %s%n Morada: %s%n%nRendimentos:%n Trabalho (RT): %.3f%n Outros (OR): %.3f%n", this.nif, this.nome, this.morada, this.rt, this.or);
    }
    
    /**
     * Compara o contribuinte com um objeto recebido.
     * 
     * @param outroObjecto o objeto a comparar com o contribuinte
     * @return true se o objeto recebido representar um contribuinte equivalente. Caso contrário, retorna false.
     */
    @Override
    public boolean equals(Object outroObjecto) {
        if(this == outroObjecto) {
            return true;
        }
        if(outroObjecto == null || this.getClass()  != outroObjecto.getClass()) {
            return false;
        }
        Contribuinte c = (Contribuinte) outroObjecto;
        return (this.nif != c.nif);
    }
    
    /**
     * Devolve a taxa de Rendimentos de Trabalho usando o Polimorfismo
     * @return taxaRT do contribuinte
     */
    protected abstract float taxaRT();
    
    /**
     * Devolve a taxa de Outros Rendimentos usando o Polimorfismo
     * @return taxaOR do contribuinte
     */
    protected abstract float taxaOR();
  
    /**
     * Calcula o imposto a pagar por um Contribuinte
     * @return imposto a pagar
     */
    public float calcularImposto() {
        return (this.rt * this.taxaRT() + this.or * this.taxaOR());
    }

 }
