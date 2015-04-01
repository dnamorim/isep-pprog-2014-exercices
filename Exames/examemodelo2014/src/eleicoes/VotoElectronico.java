/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eleicoes;

/**
 * Voto representado por Boletim Electrónico
 * @author dnamorim
 */
public class VotoElectronico extends Voto implements ValidaVotos {
    
    /**
     * Constrói uma instãncia de um Voto Electrónico, passando o candidato, data e data Limite do boletim de Voto
     * @param candidato candidato votado
     * @param data data do voto
     * @param dataLimite data limite do voto
     */
    public VotoElectronico(Candidato candidato, int data, int dataLimite) {
        super(candidato, data, dataLimite);
    }

    /**
     * Valida se o voto é válido
     * @return true se válido / false se inválido
     */
    @Override
    public boolean eValido() {
        return verificaData();
    }

    /**
     * Valida as datas de um Voto.
     * inválido se a data for estritamente maior que o prazo limite subtraído de dois dias (devem ser enviados antes dos outros tipos de votos)
     * @return true se válido / false se inválido
     */
    @Override
    public boolean verificaData() {
        return (this.getData() <= (this.getDataLimite() -2));
    }

    /**
     * Devolve a descrição textual de um {@link VotoElectronico}
     * @return voto electrónico para nome_candidato - validade_voto
     */
    @Override
    public String toString() {
        return String.format("voto electrónico para %s", super.toString());
    }
}
