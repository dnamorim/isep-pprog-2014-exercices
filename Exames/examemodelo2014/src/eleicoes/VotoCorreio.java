/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eleicoes;

/**
 * Representação de um Boletim de Voto enviado por correio
 * @author dnamorim
 */
public class VotoCorreio extends Voto implements ValidaVotos {
    
    /**
     * Indicação assinatura do Boletim (true = sim / false = não)
     */
    private boolean assinatura;
    
    /**
     * Constrói uma instãncia de um Voto enviado por correio, passando o candidato, data e data Limite do boletim de Voto
     * @param candidato candidato votado
     * @param data data do voto
     * @param dataLimite data limite do voto
     * @param assinado assinatura no boletim de voto (true = sim / false = não)
     */
    public VotoCorreio(Candidato candidato, int data, int dataLimite, boolean assinado) {
        super(candidato, data, dataLimite);
        this.assinatura = assinado;
    }
    

    /**
     * Valida se o voto é válido
     * @return true se válido / false se inválido
     */
    @Override
    public boolean eValido() {
        return (this.assinatura && verificaData());
    }

    /**
     * Valida as datas de um Voto.
     * inválido se a data for estritamente maior que o prazo limite
     * @return true se válido / false se inválido
     */
    @Override
    public boolean verificaData() {
        return (this.getData() <= (this.getDataLimite()));
    }

    /**
     * Devolve a descrição textual de um {@link VotoCorreio}
     * @return envio de voto em papel para o nome_candidato - validade_voto
     */
    @Override
    public String toString() {
        return String.format("envio de voto em papel para %s", super.toString());
    }
}
