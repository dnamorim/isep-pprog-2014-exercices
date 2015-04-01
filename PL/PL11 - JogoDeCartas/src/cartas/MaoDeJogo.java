package cartas;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Representa uma mão de jogo.
 *
 * @author ISEP-DEI-PPROG
 */
public class MaoDeJogo extends ArrayList<Carta> {

    /**
     * Constrói uma instância de {@code MaoDeJogo} recebendo um conjunto de
     * cartas.
     * 
     * @param mao o conjunto de cartas
     */
    public MaoDeJogo(ArrayList<Carta> mao) {
        super(mao);
    }

    /**
     * Constrói uma instância de {@code MaoDeJogo} vazia, ou seja, sem cartas.
     */
    public MaoDeJogo() {
        super();
    }

    /**
     * Constrói uma instância de {@code MaoDeJogo} com as mesmas caraterísticas
     * da mão de jogo recebida por parâmetro.
     * 
     * @param outraMaoDeJogo a mão de jogo com as caraterísticas a copiar
     */
    public MaoDeJogo(MaoDeJogo outraMaoDeJogo) {
        for(Carta c : outraMaoDeJogo) {
            this.add(new Carta(c));
        }
    }

    /**
     * Devolve a descrição textual da mão de jogo (uma carta por linha).
     * 
     * @return caraterísticas das cartas da mão de jogo
     */
    @Override
    public String toString() {
        String s = "";
        for (Carta c : this) {
            s = s + c.toString() + "\n";
        }
        return s;
    }

    /**
     * Devolve um conjunto com os vários tipos de carta (duque, terno, etc.)
     * existentes na mão de jogo.
     * 
     * @return {@code ArrayList} com os tipos de carta existentes na mão de jogo
     */
    public ArrayList<Carta.Tipo> tiposDeCarta() {
        ArrayList<Carta.Tipo> tc = new ArrayList<>();
        for (Carta c : this) {
            if (!tc.contains(c.getTipo())) {
                tc.add(c.getTipo());
            }
        }
        return tc;
    }

    /**
     * Determina quantas cartas de um dado tipo existem na mão de jogo
     * 
     * @param tipo o tipo de carta
     * @return quantidade de cartas do tipo, que existem na mão de jogo
     */
    public int contarCartasDoTipo(Carta.Tipo tipo) {
        int nrTipo = 0;
        for (Carta c : this) {
            if(c.getTipo() == tipo) {
                nrTipo++;
            }
        }
        return nrTipo;
    }

    /**
     * Ordena a mão de jogo por naipe e, dentro do mesmo naipe, ordena por tipo
     */
    public void ordenar() {
        // A classe Carta deve implementar a interface Comparable, devendo
        // implementar especificamente Comparable<Carta>
        Collections.sort(this);
    }

}
