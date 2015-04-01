package contasbancarias.model;

public final class Conta {

    private int nrConta;
    private String titular;
    private double saldo;

    private static final String TITULAR_POR_OMISSAO = "sem titular";
    private static final int DEPOSITO_POR_OMISSAO = 0;

    private static int totalContas = 0;

    public Conta(String titular, double deposito) {
        this.setTitular(titular);
        this.depositar(deposito);
        this.nrConta = ++Conta.totalContas;
    }

    public Conta(String titular) {
        this.setTitular(titular);
        this.saldo = Conta.DEPOSITO_POR_OMISSAO;
        this.nrConta = ++Conta.totalContas;
    }

    public Conta() {
        this.titular = Conta.TITULAR_POR_OMISSAO;
        this.saldo = Conta.DEPOSITO_POR_OMISSAO;
        this.nrConta = ++Conta.totalContas;
    }

    public Conta(Conta c) {
        this.nrConta = c.nrConta;
        this.titular = c.titular;
        this.saldo = c.saldo;
    }

    public int getNrConta() {
        return this.nrConta;
    }

    public String getTitular() {
        return this.titular;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public final void setTitular(String titular) {
        if (titular == null || titular.isEmpty()) {
            throw new TitularInvalidoException("O titular da conta deve ter um nome!!");
        }
        this.titular = titular;
    }

    public final void depositar(double montante) {
        if (montante < 0) {
            String mensagem = String.format("Depósito de %.2f € é inválido!!", montante);
            throw new DepositoInvalidoException(mensagem);
        }
        this.saldo += montante;
    }

    public final double levantar(double montante) {
        if (montante < 0 || montante > this.saldo) {
            String mensagem = String.format("Levantamento de %.2f € é inválido!!", montante);
            throw new LevantamentoInvalidoException(mensagem);
        }
        this.saldo -= montante;
        return this.saldo;
    }

    @Override
    public String toString() {
        return String.format("Nr Conta: %d - Titular: %s - Saldo: %.2f€", nrConta, titular, saldo);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Conta c = (Conta) obj;
        return this.nrConta == c.nrConta
                && this.titular.equalsIgnoreCase(c.titular)
                && this.saldo == c.saldo;
    }

}
