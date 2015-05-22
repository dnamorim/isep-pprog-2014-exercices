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
public class ClienteConvidado extends Cliente {
    
    /**
     * Número de Horas do Convidado
     */
    private int nrHoras;
    
    /**
     * Número de Horas do Convidado por Defeito
     */
    protected static final int NRHORAS_POR_DEFEITO = 0;

    /**
     * Constrói uma instância de um ClienteConvidado, onde todos os valores dos atributos são passados por parâmetro
     * @param nome Nome do Convidado
     * @param sexo Sexo do Convidado
     * @param idade Idade do Convidado
     * @param nif NIF do Convidado
     * @param nrCliente Número Interno de Cliente
     * @param altura Altura do Convidado
     * @param peso Peso do Convidado
     * @param funcionarioAngariador Funcionário que Angariou Cliente
     * @param nrHoras Número de Horas Atribuidas ao Convidado
     */
    public ClienteConvidado(String nome, char sexo, int idade, int nif, int nrCliente, float altura, float peso, Funcionario funcionarioAngariador, int nrHoras) {
        super(nome, sexo, idade, nif, nrCliente, altura, peso, funcionarioAngariador);
        this.nrHoras = nrHoras;
    }
    
        /**
     * Constrói uma instância de um ClienteConvidado, onde são passados todos os atributos exceptp o funcionário Angariador.
     * @param nome Nome do Convidado
     * @param sexo Sexo do Convidado
     * @param idade Idade do Convidado
     * @param nif NIF do Convidado
     * @param nrCliente Número Interno de Cliente
     * @param altura Altura do Convidado
     * @param peso Peso do Convidado
     * @param nrHoras Número de Horas Atribuidas ao Convidado
     */
    public ClienteConvidado(String nome, char sexo, int idade, int nif, int nrCliente, float altura, float peso, int nrHoras) {
        this(nome, sexo, idade, nif, nrCliente, altura, peso, Cliente.FUNCIONARIO_POR_DEFEITO, nrHoras);
    }
    
    /**
     * Constrói uma instância de um Cliente Convidado com os valores por defeito
     */
    public ClienteConvidado() {
       this(Pessoa.NOME_POR_DEFEITO, Pessoa.SEXO_POR_DEFEITO, Pessoa.IDADE_POR_DEFEITO, Pessoa.NIF_POR_DEFEITO, Cliente.NRCLIENTE_POR_DEFEITO, Cliente.ALTURA_POR_DEFEITO, Cliente.PESO_POR_DEFEITO, Cliente.FUNCIONARIO_POR_DEFEITO, ClienteConvidado.NRHORAS_POR_DEFEITO); 
    }

    /**
     * Constrói uma instância de um ClienteCovidado, sendo um clone do objecto Convidado recebido por parâmetro
     * @param outroConvidado objecto a ser clonado
     */
    public ClienteConvidado(ClienteConvidado outroConvidado) {
        this(outroConvidado.getNome(), outroConvidado.getSexo(), outroConvidado.getIdade(), outroConvidado.getNif(), outroConvidado.getNrCliente(), outroConvidado.getAltura(), outroConvidado.getPeso(), outroConvidado.getFuncionarioAngariador(), outroConvidado.getNrHoras());
    } 
    
    /**
     * Devolve o Número de Horas Restantes do Convidado
     * @return horas Restantes no Ginasio
     */
    public int getNrHoras() {
        return this.nrHoras;
    }
    
    /**
     * Altera o Número de Horas Restantes do Convidado
     * @param nrHoras novo numero de Horas do Convidado
     */
    public void setNrHoras(int nrHoras) {
        this.nrHoras = nrHoras;
    }
    
    /**
     * Decrementa o Número de Horas disponíveis do Convidado após uma visita ao Ginasio
     * @param horasUtilizadas Horas utilizadas pelo Convidado numa visita
     */
    public void decrementHoras(int horasUtilizadas) {
        this.setNrHoras(this.getNrHoras() - horasUtilizadas);
    }
    
    /**
     * Devolve a descrição textual de um Convidado
     * @return atributos associados ao Convidado
     */
    @Override
    public String toString() {
        return String.format("Convidado:%n%sNº Horas Disponíveis: %d%n", super.toString(), this.nrHoras);
    }
    
    /**
     * Compara o Convidado com outro objecto recebido por parâmetro
     * @param outroObjecto o objecto a ser comparado
     * @return true caso os objectos se refiram ao mesmo Convidado. Caso contrário, false.
     */
    @Override
    public boolean equals(Object outroObjecto) {
        if(!super.equals(outroObjecto)) {
            return false;
        }
        ClienteConvidado cc = (ClienteConvidado) outroObjecto;
        return this.nrHoras == cc.getNrHoras();
    }
}

