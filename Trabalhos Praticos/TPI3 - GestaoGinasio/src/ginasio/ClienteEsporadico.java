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
public class ClienteEsporadico extends ClientePagador implements Pagamento {
    
    /**
     * Número de Horas de um Sessão no Ginásio de um Cliente Esporádico
     */
    private int horasSessao;
    
    /**
     * Preço Por Hora de Utilização do Ginásio para Clientes Esporadicos
     */
    private static float precoPorHora = 5.2f;
    
    /**
     * Horas por Sessão de um Cliente Esporádico por defeito
     */
    protected static final int HORASSESSAO_POR_DEFEITO = 0;
    
    /**
     * Cria uma Instância de um Cliente Esporádico, sendo passado por parâmetro todos os valores dos atributos.
     * @param nome Nome Cliente
     * @param sexo Sexo Cliente
     * @param idade Idade Cliente
     * @param nif NIF Cliente
     * @param nrCliente Número Interno Cliente
     * @param altura Altura do Cliente (em m)
     * @param peso Peso do Cliente (em kg)
     * @param funcionarioAngariador Funcionário que Angariou o Cliente
     * @param estado Estado do Cliente 
     * @param horasSessao Horas da Primeira Sessão de um Cliente Esporádico
     */
    public ClienteEsporadico(String nome, char sexo, int idade, int nif, int nrCliente, float altura, float peso, Funcionario funcionarioAngariador, int estado, int horasSessao) {
        super(nome, sexo, idade, nif, nrCliente, altura, peso, funcionarioAngariador, estado);
        this.horasSessao = horasSessao;
    }
    
        /**
     * Cria uma Instância de um Cliente Esporádico, sendo passado por parâmetro todos os valores dos atributos.
     * @param nome Nome Cliente
     * @param sexo Sexo Cliente
     * @param idade Idade Cliente
     * @param nif NIF Cliente
     * @param nrCliente Número Interno Cliente
     * @param altura Altura do Cliente (em m)
     * @param peso Peso do Cliente (em kg)
     * @param estado Estado do Cliente 
     * @param horasSessao Horas da Primeira Sessão de um Cliente Esporádico
     */
    public ClienteEsporadico(String nome, char sexo, int idade, int nif, int nrCliente, float altura, float peso, int estado, int horasSessao) {
        this(nome, sexo, idade, nif, nrCliente, altura, peso, Cliente.FUNCIONARIO_POR_DEFEITO, estado, horasSessao);
    }
    
    /**
     * Cria uma Instância de um Cliente Esporádico com os valores por defeito.
     */
    public ClienteEsporadico() {
        this(Pessoa.NOME_POR_DEFEITO, Pessoa.SEXO_POR_DEFEITO, Pessoa.IDADE_POR_DEFEITO, Pessoa.NIF_POR_DEFEITO, Cliente.NRCLIENTE_POR_DEFEITO, Cliente.ALTURA_POR_DEFEITO, Cliente.PESO_POR_DEFEITO, Cliente.FUNCIONARIO_POR_DEFEITO, ClientePagador.ESTADO_POR_DEFEITO, ClienteEsporadico.HORASSESSAO_POR_DEFEITO);
    }
    
    /**
     * Cria uma Instânca de um Cliente Esporádico, sendo um clone do objecto passado por parâmetro
     * @param outroClienteEsporadico objecto a ser clonado
     */
    public ClienteEsporadico(ClienteEsporadico outroClienteEsporadico) {
        this(outroClienteEsporadico.getNome(), outroClienteEsporadico.getSexo(), outroClienteEsporadico.getIdade(), outroClienteEsporadico.getNif(), outroClienteEsporadico.getNrCliente(), outroClienteEsporadico.getAltura(), outroClienteEsporadico.getPeso(), outroClienteEsporadico.getFuncionarioAngariador(), outroClienteEsporadico.getEstado(), outroClienteEsporadico.getHorasSessao());
    }
    
    /**
     * Devolve o valor de Horas Sessão de um Cliente Esporádico
     * @return número de horas de uma sessão
     */
    public int getHorasSessao() {
        return this.horasSessao;
    }
    
    /**
     * Altera o valor de Horas Sessão de um Cliente Esporádico
     * @param horasSessao novo número de horas de uma sessão 
     */
    public void setHorasSessao(int horasSessao) {
        this.horasSessao = horasSessao;
    }
    
    /**
     * Devolve uma descrição textual de um Cliente Esporádico
     * @return atributos de um cliente esporádico
     */
    @Override
    public String toString() {
        return String.format("Cliente Esporádico:%n%sHoras de Sessão: %d h%n", super.toString(), this.horasSessao);
    }
    
    /**
     * Devolve o valor a pagar pelo Cliente Esporádico após uma Sessão
     * @return valor a Pagar após uma Sessão
     */
    @Override
    public float pagar() {
        return (ClienteEsporadico.precoPorHora * this.horasSessao);
    }
    
    /**
     * Devolve o Preço por Hora praticado pelo Ginásio aos Clientes Esporádicos
     * @return preco por hora actual
     */
    public static float getPrecoPorHora() {
        return ClienteEsporadico.precoPorHora;
    }
    
    /**
     * Altera o Preço por Hora praticado pelo Ginásio aos Clientes Esporádicos
     * @param precoPorHora novo preço por hora
     */
    public static void setPrecoPorHora(float precoPorHora) {
        ClienteEsporadico.precoPorHora = precoPorHora;
    }
    
    /**
     * Compara um Cliente Esporádico com um objecto recebido por parâmetro
     * @param outroObjecto objecto a ser comparado
     * @return true caso os objectos refiram-se ao mesmo Cliente Esporádico. Caso contrário, false.
     */
    @Override
    public boolean equals(Object outroObjecto) {
        if(!super.equals(outroObjecto)) {
            return false;
        }
        ClienteEsporadico ce = (ClienteEsporadico) outroObjecto;
        return this.horasSessao == ce.getHorasSessao();
    }
}

