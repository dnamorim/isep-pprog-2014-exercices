package contasbancarias.model;

public class LevantamentoInvalidoException extends IllegalArgumentException {

    public LevantamentoInvalidoException() {
        super("Levantamento Inválido!!");
    }
    
    public LevantamentoInvalidoException(String mensagem) {
        super(mensagem);
    }

}
