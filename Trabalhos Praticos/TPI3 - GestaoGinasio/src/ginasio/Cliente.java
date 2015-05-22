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
public abstract class Cliente extends Pessoa {
    /**
     * Número Interno do Cliente
     */
    private int nrCliente;
    /**
     * Altura do Cliente (em metros)
     */
    private float altura;
    /**
     * Peso do Cliente (em quilogramas - kg)
     */
    private float peso;
    
    /**
     * Funcionário Angariador do Cliente
     */
    private Funcionario funcionarioAngariador;
    
    /**
     * Índice de Massa Corporal Mínimo (valor por defeito = 18)
     */
    private static int minIMC=18;
    /**
     * Índice de Massa Corporal Máximo (valor por defeito = 25)
     */
    private static int maxIMC=25;
    
    /**
     * Número de Cliente por defeito
     */
    protected static final int NRCLIENTE_POR_DEFEITO = 0;
    
    /**
     * Altura do CLiente por defeito
     */
    protected static final float ALTURA_POR_DEFEITO = 0f;
    
    /**
     * Peso do Cliente por defeito
     */
    protected static final float PESO_POR_DEFEITO = 0f;
    
    /**
     * Funcionário Angariador por Defeito
     */
    protected static final Funcionario FUNCIONARIO_POR_DEFEITO = new Funcionario();
    
    /**
     * Constrói uma instância de um Cliente com todos os atributos passados por parâmetro
     * @param nome nome do Cliente
     * @param sexo Sexo do Cliente
     * @param idade Idade do Cliente
     * @param nif NIF do Cliente
     * @param nrCliente Número Interno do Cliente
     * @param altura Altura do Cliente (em m)
     * @param peso Peso do Cliente (em kg)
     * @param funcionarioAngariador Funcionário que Angariou Cliente
     */
    public Cliente(String nome, char sexo, int idade, int nif, int nrCliente, float altura, float peso, Funcionario funcionarioAngariador) {
        super(nome, sexo, idade, nif);
        this.nrCliente = nrCliente;
        this.altura = altura;
        this.peso = peso;
        this.funcionarioAngariador = funcionarioAngariador;
        adicionarCliente();
    }
    
    
    /**
     * Constrói uma instância de um Cliente com os valores por defeito
     */
    public Cliente() {
        this(Pessoa.NOME_POR_DEFEITO, Pessoa.SEXO_POR_DEFEITO, Pessoa.IDADE_POR_DEFEITO, Pessoa.NIF_POR_DEFEITO, Cliente.NRCLIENTE_POR_DEFEITO, Cliente.ALTURA_POR_DEFEITO, Cliente.PESO_POR_DEFEITO, Cliente.FUNCIONARIO_POR_DEFEITO);
    }
    
    /**
     * Constrói uma instância de um Cliente, sendo um clone do Cliente recebido por parâmetro.
     * @param outroCliente cliente a clonar
     */
    public Cliente(Cliente outroCliente) {
        this(outroCliente.getNome(), outroCliente.getSexo(), outroCliente.getIdade(), outroCliente.getNif(), outroCliente.getNrCliente(), outroCliente.getAltura(), outroCliente.getPeso(), outroCliente.getFuncionarioAngariador());
    }
    
    /**
     * Devolve o Número Interno do Cliente
     * @return nrCliente
     */
    public int getNrCliente() {
        return this.nrCliente;
    }
    
    /**
     * Devolve a Altura do Cliente em metros (m).
     * @return altura
     */
    public float getAltura() {
        return this.altura;
    }
    
    /**
     * Devolve o Peso do Cliente em quilogramas (kg).
     * @return peso
     */
    public float getPeso() {
        return this.peso;
    }
    
    /**
     * Devolve a Referência do Funcionário Angariador
     * @return funcionario angariador
     */
    public Funcionario getFuncionarioAngariador() {
       return this.funcionarioAngariador; 
    }
    
    /**
     * Altera o número do cliente para um número recebido por parâmetro
     * @param nrCliente Novo número de cliente
     */
    public void setNrCliente(int nrCliente) {
        this.nrCliente = nrCliente;
    }
    
    /**
     * Altera a Altura do Cliente para uma altura recebida por parâmetro.
     * @param altura Nova Altura do Utente, em metros (m)
     */
    public void setAltura(float altura) {
        this.altura=altura;
    }
    
    /**
     * Altera o Peso do Cliente para um peso recebido por parâmetro.
     * @param peso Novo peso do Utente, em quilogramas (kg).
     */
    public void setPeso(float peso) {
        this.peso=peso;
    }
    
    /**
     * Altera o Funcionario Angariador de um Cliente
     * @param funcionarioAngariador novo funcionario angariador
     */
    public void setFuncionarioAngariador(Funcionario funcionarioAngariador) {
        this.removerCliente();
        this.funcionarioAngariador = funcionarioAngariador;
        this.adicionarCliente();
    }
    
    /**
     * Devolve o valor do Índice de Massa Corporal (IMC) do Cliente.
     * @return imc
     */
    public float calcularIMC() {
        return (float) (this.peso / Math.pow((double) this.altura, 2));
    }
    
    /**
     * Adiciona o Cliente à Lista de Clientes Angariados por um Funcionário
     */
    private void adicionarCliente() {
        this.funcionarioAngariador.addClienteLista(this);
    }
    
    /**
     * Remove o Cliente da Lista de Clientes Angariados por um Funcionário
     */
    private void removerCliente() {
        this.funcionarioAngariador.removeClienteLista(this);
    }
    
    /**
     * Devolve a descrição textual de um Cliente 
     * @return atributos de um Cliente
     */
    @Override
    public String toString() {
        return String.format("%s%nNr. Cliente: %d  Altura: %.2f m  Peso: %.2f kg%nAngariador - %s", super.toString(), this.nrCliente, this.altura, this.peso, (this.funcionarioAngariador == null) ? "Não foi Angariado" : this.funcionarioAngariador);
    }
    
    /**
     * Compara o Cliente com outro Objecto recebido por parâmetro
     * @param outroObjecto objecto a ser comparado
     * @return true se forem o mesmo cliente. Caso Contrário, false.
     */
    @Override
    public boolean equals(Object outroObjecto) {
        if(!super.equals(outroObjecto)) {
            return false;
        }
        Cliente c = (Cliente) outroObjecto;
        return (this.nrCliente == c.getNrCliente() && this.altura == c.getAltura() && this.peso == c.getPeso() && this.funcionarioAngariador.equals(c.getFuncionarioAngariador()));
    }
    
    /**
     * Devolve uma Descrição do grau de obesidade de um Utente, tendo por base o IMC e os valores de referência.
     * @return descricaoObesidadeUtente
     */
    public String descricaoObesidade() {
        float imc = this.calcularIMC();
        if(imc < minIMC) {
            return "Magro";
        } else if(imc > maxIMC) {
            return "Obeso";
        }
        return "Saudável";
    }
    
    /**
     * Devolve o Valor Mínimo do Índice de Massa Corporal (IMC).
     * @return minIMC
     */
    public static int getMinIMC() {
        return minIMC;
    }
    
    /**
     * Devolve o Valor Máximo do Índice de Massa Corporal (IMC).
     * @return maxIMC
     */
    public static int getMaxIMC() {
        return maxIMC;
    }
    
    /**
     * Permite alterar o Valor Mínimo do Índice de Massa Corporal (IMC) para o cálculo da Obesidade
     * @param min Novo Valor Mínimo de IMC
     */
    public static void setMinIMC(int min) {
        minIMC=min;
    }
    
    /**
     * 
     * Permite alterar o Valor Mánimo do Índice de Massa Corporal (IMC) para o cálculo da Obesidade
     * @param max Novo Valor Máximo de IMC
     */
    public static void setMaxIMC(int max) {
        maxIMC=max;
    }
}

