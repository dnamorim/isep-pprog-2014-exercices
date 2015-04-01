package automovel;

/**
 * Representa um automóvel através da sua matrícula, marca e cilindrada.
 * @author ISEP-DEI-PPROG
 */
public class Automovel {
    
    /**
     * A matrícula do automóvel.
     */
    private String matricula;
    
    /**
     * A marca do automóvel.
     */
    private String marca;
    
    /**
     * A cilindrada do automóvel.
     */
    private int cilindrada;
    
    /**
     * A quantidade de instâncias Automovel criadas.
     */
    private static int totalAutomoveis = 0;

    /**
     * Constrói uma instância de Automovel recebendo a matrícula, a marca e a
     * cilindrada.
     * @param matricula  a matrícula do automóvel
     * @param marca      a marca do automóvel
     * @param cilindrada a cilindrada do automóvel
     */
    public Automovel(String matricula, String marca, int cilindrada) {
        this.matricula = matricula;
        this.marca = marca;
        this.cilindrada = cilindrada;      
        Automovel.totalAutomoveis++;
    }

    /**
     * Constrói uma instância de Automovel recebendo a matrícula e a marca e
     * assumindo a cilindrada zero.
     * @param matricula a matrícula do automóvel
     * @param marca     a marca do automóvel
     */
    public Automovel(String matricula, String marca) {
        this(matricula, marca, 0);
    }

    /**
     * Constrói uma instância de Automovel com a matrícula "sem matrícula", a
     * marca "sem marca" e cilindrada zero.
     */
    public Automovel() {
        this("sem matrícula", "sem marca", 0);
    }

    /**
     * Constrói uma instância de Automovel com as mesmas caraterísticas do
     * automóvel recebido por parâmetro.
     * @param outroAutomovel o automóvel com as características a copiar
     */
    public Automovel(Automovel outroAutomovel) {          
        this.matricula = outroAutomovel.getMatricula();
        this.marca = outroAutomovel.getMarca();
        this.cilindrada = outroAutomovel.getCilindrada();
        Automovel.totalAutomoveis++;
    }

    /**
     * Devolve a matrícula do automóvel.
     * @return matrícula do automóvel
     */
    public String getMatricula() {
        return this.matricula;
    }

    /**
     * Devolve a marca do automóvel.
     * @return marca do automóvel
     */
    public String getMarca() {
        return this.marca;
    }

    /**
     * Devolve a cilindrada do automóvel.
     * @return cilindrada do automóvel
     */
    public int getCilindrada() {
        return this.cilindrada;
    }

    /**
     * Modifica a matrícula do automóvel.
     * @param matricula a nova matrícula do automóvel
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * Modifica a marca do automóvel.
     * @param marca a nova marca do automóvel
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Modifica a cilindrada do automóvel.
     * @param cilindrada a nova cilindrada do automóvel
     */
    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    /**
     * Devolve a descrição textual do automóvel.
     * @return caraterísticas do automóvel
     */
    public String toString() {
        return "Automóvel com matrícula " + this.matricula + " é um "
                + this.marca + " e tem cilindrada de " + this.cilindrada
                + " cc";
        // Alternativa: return String.format("Automóvel com matrícula %s é um %s
        // e tem cilindrada de %d cc", this.matricula, this.marca,
        // this.cilindrada);
    }

    /**
     * Devolve a diferença de cilindrada entre dois automóveis.
     * @param  outroAutomovel o automóvel com o qual calcular a diferença de
     *         cilindrada
     * @return diferença de cilindrada entre os dois automóveis
     */
    public int diferencaCilindrada(Automovel outroAutomovel) {
        return this.cilindrada - outroAutomovel.getCilindrada();
        // alternativa: this.cilindrada - outroAutomovel.cilindrada;
    }

    /**
     * Devolve true se a cilindrada for maior do que a cilindrada do automóvel
     * recebido por parâmetro. Se a cilindrada for menor ou igual à cilindrada
     * do automóvel recebido por parâmetro, devolve false.
     * @param  outroAutomovel o automóvel com o qual comparar a cilindrada
     * @return true se a cilindrada for maior do que a cilindrada do automóvel
     *         recebido por parâmetro, caso contrário devolve false
     */
    public boolean isCilindradaMaior(Automovel outroAutomovel) {
        return this.cilindrada > outroAutomovel.getCilindrada();
    }

    /**
     * Devolve true se a cilindrada for maior do que a cilindrada recebida por
     * parâmetro. Se a cilindrada for menor ou igual à cilindrada recebida por
     * parâmetro, devolve false.
     * @param  cilindrada a cilindrada a comparar
     * @return true se a cilindrada for maior do que a cilindrada recebida por
     *         parâmetro, caso contrário devolve false
     */
    public boolean isCilindradaMaior(int cilindrada) {
        return this.cilindrada > cilindrada;
    }

    /**
     * Devolve a quantidade de instâncias Automovel criadas
     * @return quantidade de instâncias Automovel criadas
     */
    public static int getTotalAutomoveis() {
        return Automovel.totalAutomoveis;
    }

}
