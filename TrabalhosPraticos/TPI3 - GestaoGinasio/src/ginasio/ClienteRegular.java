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
public class ClienteRegular extends ClientePagador implements Pagamento{

    /**
     * Mensalidade do Cliente Regular
     */
    private float mensalidade;
    
    /**
     * Mensalidade do Cliente Regular por defeito
     */
    protected static final float MENSALIDADE_POR_DEFEITO = 0f;
    
    /**
     * Constrói uma instância de um ClienteRegular, sendo passado por parâmetro todos os valores dos atributos.
     * @param nome Nome do Cliente 
     * @param sexo Sexo do Cliente 
     * @param idade Idade do Cliente
     * @param nif NIF do Cliente
     * @param nrCliente Número Interno do Cliente
     * @param altura Altura do Cliente
     * @param peso Peso do Cliente
     * @param funcionarioAngariador Funcionário que Angariou o Cliente
     * @param estado Estado do Cliente
     * @param mensalidade Mensalidade do Cliente
     */
    public ClienteRegular(String nome, char sexo, int idade, int nif, int nrCliente, float altura, float peso, Funcionario funcionarioAngariador, int estado, float mensalidade) {
        super(nome, sexo, idade, nif, nrCliente, altura, peso, funcionarioAngariador, estado);
        this.mensalidade = mensalidade;
    }
    
    /**
     * Constrói uma instância de um ClienteRegular, sendo passado por parâmetro todos os valores dos atributos excepto o funcionário angariador
     * @param nome Nome do Cliente 
     * @param sexo Sexo do Cliente 
     * @param idade Idade do Cliente
     * @param nif NIF do Cliente
     * @param nrCliente Número Interno do Cliente
     * @param altura Altura do Cliente
     * @param peso Peso do Cliente
     * @param estado Estado do Cliente
     * @param mensalidade Mensalidade do Cliente
     */
    public ClienteRegular(String nome, char sexo, int idade, int nif, int nrCliente, float altura, float peso, int estado, float mensalidade) {
        this(nome, sexo, idade, nif, nrCliente, altura, peso, Cliente.FUNCIONARIO_POR_DEFEITO, estado, mensalidade);
    }
    
    /**
     * Constrói uma instância de um ClienteRegular com os valores por defeito
     */
    public ClienteRegular() {
        this(Pessoa.NOME_POR_DEFEITO, Pessoa.SEXO_POR_DEFEITO, Pessoa.IDADE_POR_DEFEITO, Pessoa.NIF_POR_DEFEITO, Cliente.NRCLIENTE_POR_DEFEITO, Cliente.ALTURA_POR_DEFEITO, Cliente.PESO_POR_DEFEITO, Cliente.FUNCIONARIO_POR_DEFEITO, ClientePagador.ESTADO_POR_DEFEITO, ClienteRegular.MENSALIDADE_POR_DEFEITO);
    }
    
    /**
     * Constrói uma instância de um ClienteRegular, sendo um clone do objecto passado por parâmetro
     * @param outroClienteRegular objecto a ser clonado
     */
    public ClienteRegular(ClienteRegular outroClienteRegular) {
        this(outroClienteRegular.getNome(), outroClienteRegular.getSexo(), outroClienteRegular.getIdade(), outroClienteRegular.getNif(), outroClienteRegular.getNrCliente(), outroClienteRegular.getAltura(), outroClienteRegular.getPeso(), outroClienteRegular.getFuncionarioAngariador(), outroClienteRegular.getEstado(), outroClienteRegular.getMensalidade());
    } 
    
    /**
     * Devolve o valor da Mensalidade de um Cliente Regular 
     * @return valor da Mensalidade
     */
    public float getMensalidade() {
        return this.mensalidade;
    }
    
    /**
     * Altera o valor da Mensalidade de um Cliente Regular
     * @param mensalidade novo valor da Mensalidade
     */
    public void setMensalidade(float mensalidade) {
        this.mensalidade = mensalidade;
    }
    
    /**
     * Devolve a descrição textual de um Cliente Regular
     * @return atributos do Cliente Regular
     */
    @Override
    public String toString() {
        return String.format("Cliente Regular:%n%sMensalidade: %.2f €%n", super.toString(), this.mensalidade);
    }
    
    /**
     * Devolve o Valor a pagar por um Cliente Regular ao Ginásio
     * @return valor a pagar
     */
    @Override
    public float pagar() {
        return this.mensalidade;
    }
    
    /**
     * Compara o Cliente Regular com outro Objecto Recebido por parâmetro
     * @param outroObjecto objecto a ser comparado
     * @return true se ambos referirem ao mesmo ClienteRegular. Caso contrário, false.
     */
    @Override
    public boolean equals(Object outroObjecto) {
        if(!super.equals(outroObjecto)) {
            return false;
        }
        ClienteRegular cr = (ClienteRegular) outroObjecto;
        return this.mensalidade == cr.getMensalidade();
    }
    
}

