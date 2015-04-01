package figuras;

/**
 * Esta classe permite a construção de uma hierarquia de classes que 
 * representem diferentes tipos de figuras geométricas. Define membros    
 * que são comuns a essas classes.
 *
 * @author ISEP-DEI-PPROG
 */
public abstract class Figura {

    /**
     * A cor da figura.
     */
    private String cor;

    /**
     * A cor da figura usada por omissão.
     */
    protected static final String COR_POR_OMISSAO = "cinzento";

    /**
     * Inicializa a cor.
     *
     * @param cor a cor da figura
     */
    public Figura(String cor) {
        this.cor = cor;
    }

    /**
     * Inicializa a cor com o valor por omissão.
     */
    public Figura() {
        this(Figura.COR_POR_OMISSAO);
    }    

    /**
     * Devolve a cor da figura.
     *
     * @return cor da figura
     */
    public String getCor() {
        return this.cor;
    }

    /**
     * Modifica a cor da figura.
     *
     * @param cor a nova cor da figura
     */
    public void setCor(String cor) {
        this.cor = cor;
    }

    /**
     * Devolve a descrição textual da cor.
     *
     * @return cor da figura
     */
    @Override
    public String toString() {
        return "cor=" + this.cor;
    }

    /**
     * Permite o cálculo da área de uma figura através do polimorfismo.
     *
     * @return área da figura
     */
    public abstract double area();    

}
