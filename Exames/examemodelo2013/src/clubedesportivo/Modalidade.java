/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package clubedesportivo;

import java.io.Serializable;

/**
 *
 * @author dnamorim
 */
public enum Modalidade implements Serializable {

    NATACAO("Natação"), TENIS("Ténis"), FUTEBOL("Futebol"), NAPLICAVEL ("Não Aplicável");

    private final String modalidade;

    /**
     * Construtor da classe que recebe como parâmetro a modalidade.
     *
     * @param tipo String com a modalidade a adicionar
     */
    Modalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    /**
     * Devolve a descrição do tipo do ficheiro.
     *
     * @return tipo sob forma de String
     */
    @Override
    public String toString() {
        return this.modalidade;
    }
}
