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
public class Ginasio {
    
    /**
     * Nome de um Ginásio
     */
    private String nomeGinasio;
    
    /**
     * Lista dos Clientes e Colaboradores do Ginasio
     */
    private ArrayList<Pessoa> pessoalGinasio;

    /**
     * Nome do Ginásio por Defeito
     */
    protected static final String NOMEGINASIO_POR_DEFEITO = "Sem Nome";
    
    /**
     * Lista do Pessoal do Ginásio por Defeito
     */
    protected static final ArrayList<Pessoa> PESSOALGINASIO_POR_DEFEITO = new ArrayList();
    
    /**
     * Constrói uma instância de Ginásio, com todos os atributos passados por parâmetro
     * @param nomeGinasio Nome do Ginásio
     * @param pessoalGinasio A Lista de Clientes/Colaboradores do Ginásio
     */
    public Ginasio(String nomeGinasio, ArrayList<Pessoa> pessoalGinasio) {
        this.nomeGinasio = nomeGinasio;
        this.pessoalGinasio = new ArrayList(pessoalGinasio);
    }
    
    /**
     * Constrói uma instância de Ginásio com os valores por defeito
     */
    public Ginasio() {
        this(Ginasio.NOMEGINASIO_POR_DEFEITO, Ginasio.PESSOALGINASIO_POR_DEFEITO);
    }
    
    /**
     * Constrói uma instância de Ginásio, sendo apenas passado o nome do mesmo
     * @param nomeGinasio nome do Ginásio
     */
    public Ginasio(String nomeGinasio) {
        this(nomeGinasio, Ginasio.PESSOALGINASIO_POR_DEFEITO);
    }
    
    /**
     * Constrói uma instância de Ginásio, sendo um clone do objecto passado por parâmetro
     * @param outroGinasio ginásio a ser clonado
     */
    public Ginasio(Ginasio outroGinasio) {
        this(outroGinasio.getNomeGinasio(), outroGinasio.getPessoalGinasio());
    }
    
    /**
     * Devolve o Nome do Ginásio
     * @return nome do Ginásio
     */
    public String getNomeGinasio() {
        return this.nomeGinasio;
    }
    
    /**
     * Devolve a Lista de Colaboradores e Clientes do Ginásio
     * @return lista pessoal Ginásio
     */
    public ArrayList<Pessoa> getPessoalGinasio() {
        return this.pessoalGinasio;
    }
    
    /**
     * Altera o nome do Ginásio
     * @param nomeGinasio novo nome do ginásio
     */
    public void setNomeGinasio(String nomeGinasio) {
        this.nomeGinasio = nomeGinasio;
    }
    
    /**
     * Altera a Lista de Pessoal do Ginásio
     * @param pessoalGinasio nova lista de pessoal do ginásio
     */
    public void setPessoalGinasio(ArrayList<Pessoa> pessoalGinasio) {
       this.pessoalGinasio = pessoalGinasio;
    }
    
    /**
     * Adiciona uma Nova Pessoa ao Ginásio
     * @param p nova pessoa do ginásio
     */
    public void adicionarPessoa(Pessoa p) {
        this.pessoalGinasio.add(p);
    }
    
    /**
     * Elimina uma Pessoa do Ginásio
     * @param p pessoa a ser eliminada do ginásio
     */
    public void eliminarPessoa(Pessoa p) {
        this.pessoalGinasio.remove(p);
    }
    
    /**
     * Devolve o Valor do Saldo Mensal do Ginásio
     * @return saldo mensal
     */
    public float saldoGinasio() {
        return (this.valoresAReceber() - this.valoresAPagar());
    }
    
    /**
     * Devolve o Número de Trabalhadores do ginásio
     * @return nr. funcionários e Treinadores
     */
    public int getNrTrabalhadores() {
        int i=0;
        for (Pessoa pessoa : this.pessoalGinasio) {
            if(pessoa instanceof Trabalhador) {
                i++;
            }
        }
        return i;
    }
    
    /**
     * Devolve o Número de Clientes Pagadores do Ginásio
     * @return nr. de clientes Regulares e Esporádicos
     */
    public int getNrClientesPagadores() {
        int i=0;
        for (Pessoa pessoa : this.pessoalGinasio) {
            if(pessoa instanceof ClientePagador) {
                i++;
            }
        }
        return i;
    }
    
    /**
     * Calcula os valores a Pagar pelo Ginásio aos Trabalhadores
     * @return valor a pagar dos trabalhadores
     */
    public float valoresAPagar() {
        float i=0;
        for (Pessoa pessoa : this.pessoalGinasio) {
            if(pessoa instanceof Recebimento) {
                i+=((Recebimento) pessoa).receber();
            }
        }
        return i;
    }
    
    /**
     * Calcula o valor a Receber pelo Ginásio dos Clientes Pagadores
     * @return valor a receber dos clientes
     */
    public float valoresAReceber() {
        float i=0;
        for (Pessoa pessoa : this.pessoalGinasio) {
            if (pessoa instanceof Pagamento && ((ClientePagador) pessoa).isClientePagadorActivo()) {
                    i+=((Pagamento) pessoa).pagar();
            }
        }
        return i;
    }
    
    /**
     * Devolve os Movimentos de Entrada e Saída de Caixa do ginásio
     * @return movimentos do ginasio por pessoa
     */
    public String movimentosGinasio() {
        String movim="";
        for (Pessoa pessoa : this.pessoalGinasio) {
            if(pessoa instanceof ClientePagador && ((ClientePagador) pessoa).isClientePagadorActivo()) {
                movim += String.format("+ %.2f%n", ((Pagamento) pessoa).pagar());
            } else if (pessoa instanceof Trabalhador) {
                movim += String.format("- %.2f%n", ((Recebimento) pessoa).receber());
            }
        }
        return movim;
    }
    
    /**
     * Devolve uma listagem das Pessoas associadas ao ginasio
     * @return pessoas do ginásio
     */
    public String listagemPessoal() {
        String pessoal="";
        for (Pessoa pessoa : this.pessoalGinasio) {
            if(pessoa != null) {
                pessoal += String.format("%s%n", pessoa);
            }
        }
        return pessoal;
    }
    
    /**
     * Devolve uma descrição textual do ginásio
     * @return nome do ginásio e respectivo pessoal (os atributos)
     */
    @Override
    public String toString() {
        return String.format("Nome Ginásio: %s%n --- PESSOAS DO GINÁSIO ---%n%n%s", this.nomeGinasio, this.listagemPessoal());
    }
    
    
    

}
