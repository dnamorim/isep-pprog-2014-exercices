/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vencimentos.model;

/**
 * Representa um trabalhador à hora através do seu nome, do número de horas de
 * trabalho e do valor pago por hora de trabalho.
 *
 * @author ISEP-DEI-PPROG
 */
public class TrabHora extends Trabalhador {

    /**
     * O número de horas de trabalho do trabalhador à hora.
     */
    private int numHoras;

    /**
     * O pagamento por hora de trabalho do trabalhador à hora.
     */
    private float pagHora;

    /**
     * O valor por omissão do pagamento por hora de trabalho do trabalhador 
     * à hora.
     */
    private static final int PAGAMENTO_HORA_POR_OMISSAO = 10;

    /**
     * Constrói uma instância de TrabHora recebendo o nome, o número de horas 
     * de trabalho e o valor do pagamento por hora.
     *
     * @param nome o nome do trabalhador à hora
     * @param numHoras o número de horas de trabalho do trabalhador à hora
     * @param pagHora o pagamento por hora do trabalhador à hora
     */
    public TrabHora(String nome, int numHoras, float pagHora) {
        super(nome);
        this.numHoras = numHoras;
        this.pagHora = pagHora;
    }

    /**
     * Constrói uma instância de TrabHora recebendo o nome e atribuindo o 
     * número de horas zero e o pagamento hora por omissão.
     *
     * @param nome o nome do trabalhador à hora
     */
    public TrabHora(String nome) {
        super(nome);
        this.numHoras = 0;
        this.pagHora = TrabHora.PAGAMENTO_HORA_POR_OMISSAO;
    }

    /**
     * Constrói uma instância de TrabHora atribuindo o nome por omissão, o
     * número de horas zero e o pagamento hora por omissão.
     */
    public TrabHora() {
        super();
        this.numHoras = 0;
        this.pagHora = TrabHora.PAGAMENTO_HORA_POR_OMISSAO;
    }

    /**
     * Constrói uma instância de TrabHora que é um clone do trabalhador à hora
     * recebido.
     *
     * @param outroTrabHora o trabalhador à hora a clonar
     */
    public TrabHora(TrabHora outroTrabHora) {
        super(outroTrabHora);
        numHoras = outroTrabHora.numHoras;
        pagHora = outroTrabHora.pagHora;
    }

    /**
     * Devolve o número de horas de trabalho do trabalhador à hora.
     *
     * @return número de horas de trabalho do trabalhador à hora
     */
    public int getNumHoras() {
        return this.numHoras;
    }

    /**
     * Devolve o pagamento por hora de trabalho do trabalhador à hora.
     *
     * @return pagamento por hora de trabalho do trabalhador à hora
     */
    public float getPagHora() {
        return this.pagHora;
    }

    /**
     * Modifica o número de horas de trabalho do trabalhador à hora.
     *
     * @param numHoras o novo número de horas de trabalho do trabalhador à hora
     */
    public void setNumHoras(int numHoras) {
        this.numHoras = numHoras;
    }

    /**
     * Modifica o pagamento por hora de trabalho do trabalhador à hora.
     *
     * @param pagHora o novo pagamento por hora de trabalho do trabalhador 
     * à hora
     */
    public void setPagHora(float pagHora) {
        this.pagHora = pagHora;
    }

    /**
     * Devolve a descrição textual do trabalhador à hora
     *
     * @return caraterísticas do trabalhador à hora
     */
    @Override
    public String toString() {
        return String.format("Trabalhador à Hora: %s %nNº de Horas de Trabalho: "
                + "%d %nPagamento Hora: %.2f €",
                super.toString(), this.numHoras, this.pagHora);
    }

    /**
     * Compara o trabalhador à hora com o objeto recebido.
     *
     * @param outroObjeto o objeto a comparar com o trabalhador à hora
     * @return true se o objeto recebido representar outro trabalhador
     * equivalente ao trabalhador à hora. Caso contrário, retorna false.
     */
    @Override
    public boolean equals(Object outroObjeto) {
        if (!super.equals(outroObjeto)) {
            return false;
        }
        TrabHora th = (TrabHora) outroObjeto;
        return this.numHoras == th.numHoras && this.pagHora == th.pagHora;
    }

    /**
     * Devolve o vencimento do trabalhador à hora.
     *
     * @return vencimento do trabalhador à hora
     */
    public float vencimento() {
        return this.numHoras * this.pagHora;
    }

}
