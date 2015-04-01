/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eleicoes;

/**
 *
 * @author dnamorim
 */
public abstract class Voto {
    /**
     * Candidato escolhido no boletim de voto
     */
    private Candidato candidato;
    /**
     * Data de Voto
     */
    private int data;
    /**
     * Data Limite de Voto a partir da qual não é considerado
     */
    private int dataLim;
    
    /**
     * Constrói uma instância de Voto, sendo passado o candidato e a data de Voto e data Limite por parâmetro
     * @param candidato candidato seleccionado no boletim de voto
     * @param data data do voto
     * @param dataLim  data limite do voto
     */
    public Voto(Candidato candidato, int data, int dataLim) {
        this.candidato = candidato;
        this.data = data;
        this.dataLim = dataLim;
    }
    
    /**
     * Valida um Voto, implementado pelas subclasses de Voto
     * @return true se válido / false se inválido 
     */
    public abstract boolean eValido();
    
    /**
     * Devolve uma representação textual do boletim de voto
     * @return nome_do_candidato - validade_do_voto
     */
    @Override
    public String toString() {
        String valid = this.eValido() ? "válido" : "inválido";
        return String.format("%s - > %s", this.candidato.getNome(), valid);
    }  
    
    //Métodos "supostamente" existentes
    
    /**
     * Devolve o Candidato seleccionado no Boletim de Voto
     * @return candidato
     */
    public Candidato getCandidato() {
        return this.candidato;
    }
    
    /**
     * Devolve a data do voto
     * @return data de voto
     */
    public int getData() {
        return this.data;
    }
    
    /**
     * Devolve a data limite para o voto ser considerado
     * @return data limite do voto
     */
    public int getDataLimite() {
        return this.dataLim;
    }
}
