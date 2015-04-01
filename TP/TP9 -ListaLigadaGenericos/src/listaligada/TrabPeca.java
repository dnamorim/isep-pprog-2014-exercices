/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package listaligada;

/**
 * Representa um trabalhador à peça através do seu nome e dos números de peças
 * produzidas do tipo 1 e do tipo 2.
 *
 * @author ISEP-DEI-PPROG
 */
public class TrabPeca extends Trabalhador {

    /**
     * O número de peças do tipo 1 do trabalhador à peça.
     */
    private int numPecas1;

    /**
     * O número de peças do tipo 2 do trabalhador à peça.
     */
    private int numPecas2;

    /**
     * O pagamento por uma peça do tipo 1 aplicado a todos os trabalhadores à
     * peça.
     */
    private static float pagPeca1 = 15.5f;

    /**
     * O pagamento por uma peça do tipo 2 aplicado a todos os trabalhadores à
     * peça.
     */
    private static float pagPeca2 = 20;

    /**
     * Constrói uma instância de TrabPeca recebendo o nome, o número de peças 1
     * e o número de peças 2.
     *
     * @param nome o nome do trabalhador à peça
     * @param numPecas1 o número de peças 1 do trabalhador à peça
     * @param numPecas2 o número de peças 2 do trabalhador à peça
     */
    public TrabPeca(String nome, int numPecas1, int numPecas2) {
        super(nome);
        this.numPecas1 = numPecas1;
        this.numPecas2 = numPecas2;
    }

    /**
     * Constrói uma instância de TrabPeca recebendo o nome e atribuindo zero
     * ao número de peças 1 e ao número de peças 2.
     *
     * @param nome o nome do trabalhador à peça
     */
    public TrabPeca(String nome) {
        super(nome);
        this.numPecas1 = 0;
        this.numPecas2 = 0;
    }

    /**
     * Constrói uma instância de TrabPeca atribuindo o nome por omissão e zero 
     * ao número de peças 1 e zero ao número de peças 2.
     */
    public TrabPeca() {
        super();
        this.numPecas1 = 0;
        this.numPecas2 = 0;
    }

    /**
     * Constrói uma instância de TrabPeca que é um clone do trabalhador à peça
     * recebido.
     *
     * @param outroTrabPeca o trabalhador à peça a clonar
     */
    public TrabPeca(TrabPeca outroTrabPeca) {
        super(outroTrabPeca);
        this.numPecas1 = outroTrabPeca.numPecas1;
        this.numPecas2 = outroTrabPeca.numPecas2;
    }

    /**
     * Devolve o número de peças 1 do trabalhador à peça.
     *
     * @return número de peças 1 do trabalhador à peça
     */
    public int getNumPecas1() {
        return this.numPecas1;
    }

    /**
     * Devolve o número de peças 2 do trabalhador à peça.
     *
     * @return número de peças 2 do trabalhador à peça
     */
    public int getNumPecas2() {
        return this.numPecas2;
    }

    /**
     * Modifica o número de peças 1 do trabalhador à peça.
     *
     * @param numPecas1 o novo número de peças 1 do trabalhador à peça
     */
    public void setNumPecas1(int numPecas1) {
        this.numPecas1 = numPecas1;
    }

    /**
     * Modifica o número de peças 2 do trabalhador à peça.
     *
     * @param numPecas2 o novo número de peças 2 do trabalhador à peça
     */
    public void setNumPecas2(int numPecas2) {
        this.numPecas2 = numPecas2;
    }

    /**
     * Devolve a descrição textual do trabalhador à peça.
     *
     * @return caraterísticas do trabalhador à peça
     */
    @Override
    public String toString() {
        return String.format("Trabalhador à Peça: %s %nNº de Peças 1: "
                + "%d %nNº de Peças 2: %d",
                super.toString(), this.numPecas1, this.numPecas2);
    }

    /**
     * Compara o trabalhador à peça com o objeto recebido.
     *
     * @param outroObjeto o objeto a comparar com o trabalhador à peça
     * @return true se o objeto recebido representar outro trabalhador
     * equivalente ao trabalhador à peça. Caso contrário, retorna false.
     */
    @Override
    public boolean equals(Object outroObjeto) {
        if (!super.equals(outroObjeto)) {
            return false;
        }
        TrabPeca tp = (TrabPeca) outroObjeto;
        return this.numPecas1 == tp.numPecas1
                && this.numPecas2 == tp.numPecas2;
    }

    /**
     * Devolve o vencimento do trabalhador à peça.
     *
     * @return vencimento do trabalhador à peça
     */
    public float vencimento() {
        return this.numPecas1 * TrabPeca.pagPeca1
                + this.numPecas2 * TrabPeca.pagPeca2;
    }

    /**
     * Devolve o pagamento de uma peça do tipo 1.
     *
     * @return pagamento de uma peça do tipo 1
     */
    public static float getPagPeca1() {
        return TrabPeca.pagPeca1;
    }

    /**
     * Devolve o pagamento de uma peça do tipo 2.
     *
     * @return pagamento de uma peça do tipo 2
     */
    public static float getPagPeca2() {
        return TrabPeca.pagPeca2;
    }

    /**
     * Modifica o pagamento de uma peça do tipo 1.
     *
     * @param pagPeca1 o novo pagamento de uma peça do tipo 1
     */
    public static void setPagPeca1(float pagPeca1) {
        TrabPeca.pagPeca1 = pagPeca1;
    }

    /**
     * Modifica o pagamento de uma peça do tipo 2.
     *
     * @param pagPeca2 o novo pagamento de uma peça do tipo 2
     */
    public static void setPagPeca2(float pagPeca2) {
        TrabPeca.pagPeca2 = pagPeca2;
    }

}

