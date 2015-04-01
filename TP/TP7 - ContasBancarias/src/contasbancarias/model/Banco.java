package contasbancarias.model;

import java.util.ArrayList;

public class Banco {

    private static ArrayList<Conta> contas = new ArrayList<>();

    private Banco() {
    }

    public static Conta[] getContas() {
        return contas.toArray(new Conta[contas.size()]);
    }

    public static Conta obterConta(int nrConta) {
        for (Conta c : Banco.contas) {
            if (c.getNrConta() == nrConta) {
                return c;
            }
        }
        return null;
    }

    public static void adicionarConta(String titular, double deposito) {
        Banco.contas.add(new Conta(titular, deposito));
    }

    public static boolean removerConta(Conta c) {
        return Banco.contas.remove(c);
    }

    public static int quantidadeDeContas() {
        return Banco.contas.size();
    }

    public static String[] listaDeTitulares() {
        ArrayList<String> titulares = new ArrayList();
        for (Conta c : Banco.contas) {
            if (!titulares.contains(c.getTitular())) {
                titulares.add(c.getTitular());
            }
        }
        return titulares.toArray(new String[titulares.size()]);
    }

    public static String[] listaDeSaldos() {
        String[] saldos = new String[Banco.contas.size()];
        for (int i = 0; i < Banco.contas.size(); i++) {
            Conta c = Banco.contas.get(i);
            saldos[i] = String.format("%-30d%.2f", c.getNrConta(), c.getSaldo());
        }
        return saldos;
    }

    public static String[] listaDeNumerosETitulares() {
        String[] nrEtitulares = new String[Banco.contas.size()];
        for (int i = 0; i < Banco.contas.size(); i++) {
            Conta c = Banco.contas.get(i);
            nrEtitulares[i] = c.getNrConta() + " - " + c.getTitular();
        }
        return nrEtitulares;
    }
}
