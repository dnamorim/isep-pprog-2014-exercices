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
public abstract class ClientePagador extends Cliente {
    
    /**
     * Estado de um Cliente Pagador (1 = Activo / 0 = Inactivo)
     */
    private int estado;
    
    /**
     * Estado de um Cliente Pagador por defeito = 0
     */
    protected static final int ESTADO_POR_DEFEITO = 0;

    /**
     * Constrói uma instância de um Cliente Pagador, passando todos os valores dos atributos por parâmetro
     * @param nome Nome do Cliente Pagador
     * @param sexo Sexo do Cliente Pagador
     * @param idade Idade do Cliente Pagador
     * @param nif NIF do Cliente Pagador
     * @param nrCliente Número Interno de Cliente
     * @param altura Altura do Cliente (em m)
     * @param peso Peso do Cliente (em kg)
     * @param estado Estado do Cliente Pagador
     * @param funcionarioAngariador Funcionário que Angariou Cliente
     */
    public ClientePagador(String nome, char sexo, int idade, int nif, int nrCliente, float altura, float peso, Funcionario funcionarioAngariador, int estado) {
        super(nome, sexo, idade, nif, nrCliente, altura, peso, funcionarioAngariador);
        this.estado = estado;
    }
    
    /**
     * Constrói uma instância de um ClientePagador com os valores por defeito
     */
    public ClientePagador() {
        this(Pessoa.NOME_POR_DEFEITO, Pessoa.SEXO_POR_DEFEITO, Pessoa.IDADE_POR_DEFEITO, Pessoa.NIF_POR_DEFEITO, Cliente.NRCLIENTE_POR_DEFEITO, Cliente.ALTURA_POR_DEFEITO, Cliente.PESO_POR_DEFEITO, Cliente.FUNCIONARIO_POR_DEFEITO, ClientePagador.ESTADO_POR_DEFEITO);
    }

    /**
     * Constrói uma instância de um ClientePagador, sendo um clone do objecto recebido por parâmetro
     * @param outroClientePag o objecto a ser clonado
     */
    public ClientePagador(ClientePagador outroClientePag) {
        this(outroClientePag.getNome(), outroClientePag.getSexo(), outroClientePag.getIdade(), outroClientePag.getNif(), outroClientePag.getNrCliente(), outroClientePag.getAltura(), outroClientePag.getPeso(), outroClientePag.getFuncionarioAngariador(), outroClientePag.getEstado());
    }
    
    /**
     * Devolve o estado de um Cliente Pagador
     * @return estado Cliente Pagador 
     */
    public int getEstado() {
        return this.estado;
    }
    
    /**
     * Permite Alterar o estado de um Cliente Pagador
     * @param estado novo estado de um ClientePagador
     */
    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    /**
     * Verifica se o Cliente Pagador está Activo
     * @return true se o ClientePagador está activo, caso contrário false.
     */
    public boolean isClientePagadorActivo() {
        return (this.getEstado() == 1);
    }
    
    /**
     * Devolve o Estado do Cliente Pagador em formato textual
     * @return descricaoTextual do Estado
     */
    public String descricaoEstadoCliente() {
        switch (estado) {
            case 1:
                return "Activo";
            case 2: 
                return "Inactivo";
            default:
                return "Estado Não-Reconhecido";
        }
    }
    
    /**
     * Descrição Textual de um Cliente Pagador
     * @return atributos do Cliente Pagador
     */
    @Override
    public String toString() {
        return String.format("%sEstado: %s (%d)%n", super.toString(), (this.estado == 1) ? "Activo" : "Inactivo", this.estado);
    }
    
    /**
     * Verifica se um Cliente Pagador passado por parametro esta activo
     * @param clientePagador objecto a ser verificado
     * @return true se o cliente pagador está activo, caso contrário false.
     */
    public static boolean isClientePagadorActivo(ClientePagador clientePagador) {
        return (clientePagador.getEstado() == 1);
    }
    
    /**
     * Compara o ClientePagador com outro objecto recebido por parâmetro.
     * @param outroObjecto objecto a ser comparado
     * @return true se forem o mesmo ClientePagador. Caso contrário, false.
     */
    @Override
    public boolean equals(Object outroObjecto) {
        if(!super.equals(outroObjecto)) {
            return false;
        }
        ClientePagador cp = (ClientePagador) outroObjecto;
        return this.estado == cp.getEstado();
    }
    
    
}

