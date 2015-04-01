package utilitarios;

/**
 * Representa uma exceção para ser lançada quando uma aplicação tenta 
 * criar/modificar uma instância de Data para representar um dia cujo  
 * mês é inválido.
 * 
 * @author ISEP-DEI-PPROG
 */
public class MesInvalidoException extends IllegalArgumentException {

    /**
      * Constrói uma MesInvalidoException com a mensagem "Mês é inválido!".
     */    
    public MesInvalidoException() {
        super("Mês é inválido!!");
    }
    
    /**
     * Constrói uma MesInvalidoException contendo a mensagem recebida.
     * 
     * @param mensagem a mensagem transmitida pela exceção
     */
    public MesInvalidoException(String mensagem) {
        super(mensagem);
    }

}
