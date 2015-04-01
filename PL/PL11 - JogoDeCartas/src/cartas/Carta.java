package cartas;

/**
 * Representa uma carta.
 *
 * @author ISEP-DEI-PPROG
 */
public class Carta implements Comparable<Carta> {

    /**
     * Tipos de carta.
     */
    public static enum Tipo {Duque, Terno, Quadra, Quina, Sena, Oito, Nove, Dez,
    Dama, Valete, Rei, Manilha, As};

    /**
     * Naipes de carta.
     */
    public static enum Naipe {Copas, Ouros, Espadas, Paus};

    /**
     * O tipo da carta.
     */
    private Tipo tipo;

    /**
     * O naipe da carta.
     */
    private Naipe naipe;

    /**
     * Tipo de carta por omissão.
     */
    private static final Tipo TIPO_POR_OMISSAO = Tipo.Duque;

    /**
     * Naipe por omissão.
     */
    private static final Naipe NAIPE_POR_OMISSAO = Naipe.Copas;

    /**
     * Constrói uma instância de {@code Carta} recebendo o tipo e o naipe.
     * 
     * @param tipo o tipo da carta
     * @param naipe o naipe da carta
     */
    public Carta(Tipo tipo, Naipe naipe) {
        this.tipo = tipo; 
        this.naipe = naipe;
    }

    /**
     * Constrói uma instância de {@code Carta} recebendo uma {@code String} com
     * a descrição da carta a criar, no formato: {@link Tipo} de {@link Naipe}.
     * Exemplo: "As de Ouros".
     * 
     * @param descricao {@code String} com a descrição da carta a criar
     */
    public Carta(String descricao) {
        String[] arrayDescricao = descricao.split(" ");
        this.tipo = Tipo.valueOf(arrayDescricao[0]);
        this.naipe = Naipe.valueOf(arrayDescricao[2]);
    }

    /**
     * Constrói uma instância de {@code Carta} com o tipo Duque e o naipe Copas.
     */
    public Carta() {
        this(TIPO_POR_OMISSAO, NAIPE_POR_OMISSAO);
    }

    /**
     * Constrói uma instância de {@code Carta} com as mesmas caraterísticas da
     * carta recebida por parâmetro.     
     * @param outraCarta a carta com as características a copiar
     */    
    public Carta(Carta outraCarta) {
        this(outraCarta.tipo, outraCarta.naipe);
    }

    /**
     * Devolve o tipo da carta.
     * 
     * @return tipo da carta
     */
    public Tipo getTipo() {
        return this.tipo;
    }

    /**
     * Devolve o naipe da carta
     * 
     * @return naipe da carta
     */
    public Naipe getNaipe() {
        return this.naipe;
    }

    /**
     * Modifica o tipo da carta.
     *
     * @param tipo o novo tipo da carta
     */
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    
    }

    /**
     * Modifica o naipe da carta.
     *
     * @param naipe o novo naipe da carta
     */
    public void setNaipe(Naipe naipe) {
        this.naipe = naipe;
    
    }

    /**
     * Devolve a descrição textual da carta no formato: {@link Tipo} de
     * {@link Naipe}.
     * Exemplo: "As de Ouros".
     * 
     * @return caraterísticas da carta
     */
    @Override
    public String toString() {
        return this.tipo.toString() + " de " + this.naipe.toString();
    }

    /**
     * Compara a carta com o objeto recebido.
     * 
     * @param outroObjeto o objeto a comparar com a carta
     * @return true se o objeto recebido representar outra carta equivalente à
     * carta. Caso contrário, retorna false.
     */
    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || this.getClass() != outroObjeto.getClass()) {
            return false;
        }
        Carta outraCarta = (Carta) outroObjeto;
        return this.tipo == outraCarta.tipo
                && this.naipe == outraCarta.naipe;
    }
    
    /**
     * Compara o naipe e o tipo de duas cartas.
     * 
     * @param outraCarta a outra carta a ser comparada
     * @return 
     */
    @Override
    public int compareTo(Carta outraCarta) {
        if (this.naipe != outraCarta.naipe) {
            return this.naipe.compareTo(outraCarta.naipe);
        } else {
            return this.tipo.compareTo(outraCarta.tipo);
        }
    }

}