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
public abstract class Pessoa {
    /**
     * Nome da Pessoa
     */
    private String nome;
    
    /**
     * Sexo/Género da Pessoa - Exemplo: M, F
     */
    private char sexo;
    
    /**
     * Idade da Pessoa
     */
    private int idade;
    
    /**
     * Número de Identificação Fiscal da Pessoa (NIF)
     */
    private int nif;
    
    
    /**
     * Nome da Pessoa Utilizada por Omissao
     */
    protected static final String NOME_POR_DEFEITO = "Sem Nome";
    
    /**
     * Sexo da Pessoa Utilizada por Omissao
     */
    protected static final char SEXO_POR_DEFEITO = 'N';
    
    /**
     * Idade da Pessoa Utilizada por Omissao
     */
    protected static final int IDADE_POR_DEFEITO = 0;
    
    /**
     * Número de Identificação Fiscal da Pessoa utilizada por Omissao
     */
    protected static final int NIF_POR_DEFEITO = 999999999;
    
    /**
     * Constrói uma instância de Pessoa com todos os atributos passados por parâmetro
     * @param nome Nome da Pessoa
     * @param sexo Sexo da Pessoa
     * @param idade Idade da Pessoa
     * @param nif Nº Contribuinte da Pessoa
     */
    public Pessoa(String nome, char sexo, int idade, int nif) {
        this.nome=nome;
        this.idade=idade;
        this.sexo=sexo;
        this.nif=nif;
    }
    
    /**
     * Constrói uma instância de Pessoa tendo os atributos com os valores por omissão
     */
    public Pessoa() {
        this(Pessoa.NOME_POR_DEFEITO, Pessoa.SEXO_POR_DEFEITO, Pessoa.IDADE_POR_DEFEITO, Pessoa.NIF_POR_DEFEITO);
    }
    
    /**
     * Constrói uma instância de Pessoa copiando o valor dos atributos de outro objecto Pessoa
     * @param outraPessoa objecto Pessoa com valores a atribuir
     */
    public Pessoa(Pessoa outraPessoa) {
        this(outraPessoa.getNome(), outraPessoa.getSexo(), outraPessoa.getIdade(), outraPessoa.getNif());
    }
    
    
    /**
     * Devolve o Nome da Pessoa
     * @return nome
     */
    public String getNome() {
        return this.nome;
    }
    
    /**
     * Devolve o Sexo da Pessoa (M ou F)
     * @return sexo
     */
    public char getSexo() {
        return this.sexo;
    }
    
    /**
     * Devolve a Idade da Pessoa
     * @return idade
     */
    public int getIdade() {
        return this.idade;
    }
    
    /**
     * Devolve o Número de Contribuinte da Pessoa
     * @return nif
     */
    public int getNif() {
        return this.nif;
    }
    
    /**
     * Altera o Nome da Pessoa para o nome recebido por parâmetro
     * @param nome Novo Nome da Pessoa
     */
    public void setNome(String nome) {
        this.nome=nome;
    }
    
    /**
     * Altera o Sexo da pessoa para o sexo recebido por parâmetro
     * @param sexo Novo Sexo da pessoa
     */
    public void setSexo(char sexo) {
        this.sexo=sexo;
    }
    
    /**
     * Altera a idade da pessoa para a idade recebida por parâmetro
     * @param idade Nova Idade da pessoa
     */
    public void setIdade(int idade) {
        this.idade=idade;
    }
    
    /**
     * Altera o nif da pessoa para o nif recebido por parâmetro 
     * @param nif novo nif da pessoa
     */
    public void setNif(int nif) {
        this.nif = nif;
    }
    
    /**
     * Devolve a Descrição Textual de uma Pessoa
     * @return atributos de uma pessoa
     */
    @Override
    public String toString() {
        return String.format("Nome: %s  Sexo: %s  Idade: %d  NIF: %d", this.nome, this.sexo, this.idade, this.nif);
    }
    
    /**
     * Compara uma Pessoa com outro objeto recebido.
     *
     * @param outroObjecto o objeto a comparar com a Pessoa
     * @return true se o objeto recebido representar a mesma Pessoa. Caso contrário, retorna false. 
     */
    @Override
    public boolean equals(Object outroObjecto) {
        if (this == outroObjecto) {
            return true;
        }
        if (outroObjecto == null || this.getClass() != outroObjecto.getClass()) {
            return false;
        }
        Pessoa p = (Pessoa) outroObjecto;
        return (this.nome.equalsIgnoreCase(p.nome) && this.sexo == p.getSexo() && this.idade == p.getIdade() && this.nif == p.getNif());
    }


}

