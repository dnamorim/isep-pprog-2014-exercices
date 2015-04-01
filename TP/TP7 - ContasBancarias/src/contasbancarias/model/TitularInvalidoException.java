package contasbancarias.model;

public class TitularInvalidoException extends IllegalArgumentException {

    public TitularInvalidoException() {
        super("Titular Inválido!!");
    }
    
    public TitularInvalidoException(String mensagem) {
        super(mensagem);
    }
 
}
