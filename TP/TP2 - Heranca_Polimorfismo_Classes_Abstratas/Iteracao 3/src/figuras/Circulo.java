package figuras;

/**
 * Representa um círculo através da sua cor e raio.
 *
 * @author ISEP-DEI-PPROG
 */
public class Circulo extends Figura {
    
    /**
     * O raio do círculo
     */
    private double raio;

    /**
     * O raio usado por omissão.
     */
    protected static final int RAIO_POR_OMISSAO = 1;
    
    /**
     * Constrói uma instância de Circulo recebendo o raio e a cor.
     *
     * @param raio o raio do círculo
     * @param cor a cor do círculo
     */
    public Circulo(double raio, String cor) {
        super(cor);
        this.raio = raio;
    }

    /**
     * Constrói uma instância de Circulo recebendo o raio e atribuindo a cor
     * por omissão.
     *
     * @param raio o raio do círculo
     */
    public Circulo(double raio) {
        super();
        this.raio = raio;
        // Alternativa: this(raio, Figura.COR_POR_OMISSAO);
    }

    /**
     * Constrói uma instância de Circulo recebendo a cor e atribuindo o raio 
     * por omissão.
     *
     * @param cor a cor do círculo
     */
    public Circulo(String cor) {
        this(Circulo.RAIO_POR_OMISSAO, cor);
    }

    /**
     * Constrói uma instância de Circulo com o raio e a cor por omissão.
     */
    public Circulo() {
        this(Circulo.RAIO_POR_OMISSAO, Figura.COR_POR_OMISSAO);
    }

    /**
     * Constrói uma instância de Circulo que é um clone do círculo recebido
     * por parâmetro.
     *
     * @param outroCirculo o círculo a clonar
     */
    public Circulo(Circulo outroCirculo) {
        super(outroCirculo);
        this.raio = outroCirculo.getRaio();
        
        // Alternativa: this(outroCirculo.getRaio(), outroCirculo.getCor());
    }

    /**
     * Devolve o raio do círculo.
     *
     * @return raio do círculo
     */
    public double getRaio() {
        return this.raio;
    }

    /**
     * Modifica o raio do círculo.
     *
     * @param raio o novo raio do círculo
     */
    public void setRaio(double raio) {
        this.raio = raio;
    }

    /**
     * Devolve a descrição textual do círculo.
     *
     * @return caraterísticas do círculo
     */
    @Override
    public String toString() {
        return String.format("Círculo: raio=%.1f %s", this.raio, super.toString());
    }

    /**
     * Devolve a área do círculo.
     *
     * @return a área do círculo
     */
    @Override
    public double area() {
        return Math.PI * this.raio * this.raio;
    }
    
}
