package figuras;

/**
 * Representa um retângulo através da sua cor, comprimento e largura.
 */
public class Retangulo extends Figura {

    /**
     * O comprimento do retângulo.
     */
    private double comprimento;

    /**
     * A largura do retângulo.
     */
    private double largura;

    /**
     * O comprimento do retângulo usado por omissão.
     */
    protected static final int COMPRIMENTO_POR_OMISSAO = 2;

    /**
     * A largura do retângulo usada por omissão.
     */
    protected static final int LARGURA_POR_OMISSAO = 1;

    /**
     * Constrói uma instância de Retangulo recebendo o comprimento, a largura
     * e a cor.
     *
     * @param comprimento o comprimento do retângulo
     * @param largura a largura do retângulo
     * @param cor a cor do retângulo
     */
    public Retangulo(double comprimento, double largura, String cor) {
        super(cor);
        this.comprimento = comprimento;
        this.largura = largura;
    }

    /**
     * Constrói uma instância de Retangulo recebendo o comprimento e a largura
     * e atribuindo a cor por omissão.
     *
     * @param comprimento o comprimento do retângulo
     * @param largura a largura do retângulo
     */
    public Retangulo(double comprimento, double largura) {
        super();
        this.comprimento = comprimento;
        this.largura = largura;
        // Alternativa: this(comprimento,largura,Figura.COR_POR_OMISSAO);   
    }

    /**
     * Constrói uma instância de Retangulo recebendo a cor e atribuindo o
     * comprimento e a largura por omissão.
     *
     * @param cor a cor do retângulo
     */
    public Retangulo(String cor) {
        this(Retangulo.COMPRIMENTO_POR_OMISSAO,
                Retangulo.LARGURA_POR_OMISSAO,
                cor);
    }

    /**
     * Constrói uma instância de Retangulo com comprimento, largura e cor por
     * omissão.
     *
     */
    public Retangulo() {
        this(Retangulo.COMPRIMENTO_POR_OMISSAO,
                Retangulo.LARGURA_POR_OMISSAO,
                Figura.COR_POR_OMISSAO);
    }

    /**
     * Constrói uma instância de Retangulo que é um clone do retângulo 
     * recebido por parâmetro.
     *
     * @param outroRetangulo o retângulo a clonar
     */
    public Retangulo(Retangulo outroRetangulo) {
        this(outroRetangulo.getComprimento(),
                outroRetangulo.getLargura(),
                outroRetangulo.getCor());
    }

    /**
     * Devolve o comprimento do retângulo.
     *
     * @return comprimento do retângulo
     */
    public double getComprimento() {
        return this.comprimento;
    }

    /**
     * Devolve a largura do retângulo.
     *
     * @return largura do retângulo
     */
    public double getLargura() {
        return this.largura;
    }

    /**
     * Modifica o comprimento do retângulo.
     *
     * @param comprimento o novo comprimento do retângulo
     */
    public void setComprimento(double comprimento) {
        this.comprimento = comprimento;
    }

    /**
     * Modifica a largura do retângulo.
     *
     * @param largura a nova largura do retângulo
     */
    public void setLargura(double largura) {
        this.largura = largura;
    }

    /**
     * Devolve a descrição textual do retângulo.
     *
     * @return caraterísticas do retângulo
     */
    @Override
    public String toString() {
        return String.format("Retângulo: comprimento=%.1f largura=%.1f %s",
                this.comprimento, this.largura, super.toString());
    }

    /**
     * Devolve a área do retângulo.
     *
     * @return a área do retângulo
     */
    @Override
    public double area() {
        return this.comprimento * this.largura;
    }

    /**
     * Compara o retângulo com o objeto recebido.
     *
     * @param outroObjecto o objeto a comparar com o retângulo
     * @return true se o objeto recebido representar outro retângulo equivalente
     *         ao retângulo. Caso contrário, retorna false.
     */
    @Override
    public boolean equals(Object outroObjecto) {
        if (!super.equals(outroObjecto)) {
            return false;
        }
        Retangulo r = (Retangulo) outroObjecto;
        return this.comprimento == r.getComprimento() && this.largura == r.getLargura();
    }
}
