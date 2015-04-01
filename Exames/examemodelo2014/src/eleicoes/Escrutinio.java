/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eleicoes;

import java.util.ArrayList;
import java.util.Collections;

/**
 * (Questão 2) 
 * Responsável por efectuar a eleição de um líder
 * @author dnamorim
 */
public class Escrutinio {
    /**
     * Conjunto de todos os candidatos a lider
     */
    public ArrayList<Candidato> candidatos;
    /**
     * Número Máximo de Elementos (todos os membros do partido)
     */
    private int numEleitores;
    /**
     * Número de Votantes
     */
    private int numVot;
    /**
     * Data(Dia) da Eleição
     */
    private int data;
    
    /**
     * Constrói uma instância de {@link Escrutinio}, responsável pela eleição de um lider
     * @param candidatos lista de {@link Candidato}s a lider do partido
     * @param numEleitores Número de Eleitores
     * @param data Data de Eleição
     */
    public Escrutinio(ArrayList<Candidato> candidatos, int numEleitores, int data) {
        this.candidatos = candidatos;
        this.numEleitores = numEleitores;
        this.data = data;
        this.numVot = 0;
    }
    
    /**
     * Constrói uma instância de {@link Escrutinio}, responsável pela eleição de um lider sem passagem de lideres por parâmetro
     * @param numEleitores Número de Eleitores
     * @param data Data de Eleição
     */
    public Escrutinio(int numEleitores, int data) {
        this.candidatos = new ArrayList();
        this.numEleitores = numEleitores;
        this.data = data;
        this.numVot = 0;
    }
    
    /**
     * Adicionar um novo Candidato à Lista de Candidatos
     * @param c candidato a adicionar
     */
    public void adicionarCandidato(Candidato c) {
        this.candidatos.add(c);
    }
    
    /**
     * Define o número de votantes de todos os candidatos ao atributo {@code numVot}
     */
    public void calcularVotantes() {
        for (Candidato c : this.candidatos) {
            this.numVot += c.getNumVotos();
        }
    }
    
    /**
     * Inicializa a zero (0) o número de Votos de todos os Candidatos
     */
    public void inicializarVotosCandidatos() {
        for (Candidato c : this.candidatos) {
            c.inicializarNumVotos();
        }
    }
    
    /**
     * Devolve o(s) Candidatos que venceram a eleição
     * @return arraylist dos candidatos
     */
    public ArrayList<Candidato> vencedor() {
        ArrayList<Candidato> maisVotados = new ArrayList();
        int maxVotos=0;
        for (Candidato c : this.candidatos) {
            if(c.getNumVotos() > maxVotos) {
                maisVotados.clear();
                maisVotados.add(c);
                maxVotos = c.getNumVotos();
            } else if(c.getNumVotos() == maxVotos) {
                maisVotados.add(c);
            }
        }
        
        return maisVotados;
    }
    
    
 
}
