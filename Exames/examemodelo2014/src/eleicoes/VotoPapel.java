/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eleicoes;

/**
 * Representação de um Boletim de Voto em Papel
 * @author dnamorim
 */
public class VotoPapel extends Voto {

    /**
     * Informa se Boletim está assinado (true = sim / false = não)
     */
    private boolean assinado;
    
    /**
     * Constrói uma instãncia de um Voto em Papel, passando o candidato, data e data Limite do boletim de Voto
     * @param candidato candidato votado
     * @param data data do voto
     * @param dataLim data limite do voto
     * @param ass assinatura de um voto (true = sim / false = não)
     */
    public VotoPapel(Candidato candidato, int data, int dataLim, boolean ass) {
        super(candidato, data, dataLim);
        this.assinado = ass;
    }
    
    /**
     * Valida se o voto é válido.
     * Um voto é válido se estiver assinado.
     * @return true se válido / false se inválido
     */
    @Override
    public boolean eValido() {
        return this.assinado;
    }
    
    /**
     * Devolve a descrição textual de um {@link VotoPapel}
     * @return voto em papel para nome_candidato - validade_voto
     */
    @Override
    public String toString() {
        return String.format("voto em papel para %s", super.toString());
    }
}
