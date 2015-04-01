package datagui.model;

/**
 * Representa uma exceção para ser lançada quando uma aplicação tenta 
 * criar/modificar uma instância de Data para representar um dia inválido.
 * 
 * @author ISEP-DEI-PPROG
 */
public class DiaInvalidoException extends IllegalArgumentException {

    /**
      * Constrói uma DiaInvalidoException com a mensagem "Dia é inválido!".
     */
    public DiaInvalidoException() {
        super("Dia é inválido!!");
    }
    
     /**
      * Constrói uma DiaInvalidoException contendo a mensagem recebida.
      * 
      * @param mensagem a mensagem transmitida pela exceção 
      */
    public DiaInvalidoException(String mensagem) {
        super(mensagem);
    }

}
