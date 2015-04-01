package contasbancarias.model;

public class DepositoInvalidoException extends IllegalArgumentException {
    
    public DepositoInvalidoException() {
        super("Depósito Inválido!!");
    }
    
    public DepositoInvalidoException(String mensagem) {
        super(mensagem);
    }
}
