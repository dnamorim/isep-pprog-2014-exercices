/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package disciplinas;

/**
 * Classe que representa um Objecto Disciplina.
 * @author Duarte Nuno Amorim <1130674@isep.ipp.pt>
 */
public class Disciplina {
    /**
     * Designação de uma Disciplina
     */
    private String designacao;
    /**
     * Abreviatura da Designação de uma Disciplina
     */
    private String abreviatura;
    /**
     * Ano de Curso de uma Disciplina
     */
    private int anoCurso;
    /**
     * Professor Regente de uma Disciplina
     */ 
    private Professor regente;
    
    /**
     * Designação de uma Disciplina por defeito
     */
    private static final String DESIGNACAO_POR_DEFEITO = "Sem Designação";
    /**
     * Abreviatura da Designação de uma Disciplina por defeito
     */
    private static final String ABREVIATURA_POR_DEFEITO = "Sem Abreviatura";
    /**
     * Ano de Curso de uma Disciplina por defeito
     */
    private static final int ANOCURSO_POR_DEFEITO = 0;
    /**
     * Professor Regente de uma Disciplina por defeito
     */    
    private static final Professor REGENTE_POR_DEFEITO = new Professor();
    
    /**
     * Cria uma instância de Disciplina, sendo todos os atributos passados por parâmetro
     * @param designacao Designação da Disciplina
     * @param abreviatura Abreviatura da Designação da Disciplina
     * @param anoCurso Ano de Curso da Disciplina
     * @param regente Referência do Professor-Regente da Disciplina
     */
    public Disciplina(String designacao, String abreviatura, int anoCurso, Professor regente) {
        this.designacao = designacao;
        this.abreviatura = abreviatura;
        this.anoCurso = anoCurso;
        this.regente = regente;
    }
    
    /**
     * Constrói uma instância de Disciplina com os valores por defeito
     */
    public Disciplina() {
        this(Disciplina.DESIGNACAO_POR_DEFEITO, Disciplina.ABREVIATURA_POR_DEFEITO, Disciplina.ANOCURSO_POR_DEFEITO, Disciplina.REGENTE_POR_DEFEITO);
    }
    
    /**
     * Constrói uma instância de Disciplina, sem ter sido atríbuido o Regente
     * @param designacao Designação da Disciplina
     * @param abreviatura Abreviatura da disciplina
     * @param anoCurso Ano de curso da disciplina
     */
    public Disciplina(String designacao, String abreviatura, int anoCurso) {
        this(designacao, abreviatura, anoCurso, Disciplina.REGENTE_POR_DEFEITO);
    }
    
    /**
     * Constrói uma instância de Disciplina, sendo um clone da Disciplina passada por parâmetro
     * @param outraDisciplina disciplina a ser clonada
     */
    public Disciplina(Disciplina outraDisciplina) {
        this(outraDisciplina.designacao, outraDisciplina.abreviatura, outraDisciplina.anoCurso, outraDisciplina.regente);
    }

    /**
     * Devolve a Descrição de uma Disciplina
     * @return designacao Disciplina
     */
    public String getDesignacao() {
        return this.designacao;
    }

    /**
     * Devolve a Abreviatura de uma Disciplina
     * @return abreviatura Disciplina
     */
    public String getAbreviatura() {
        return this.abreviatura;
    }

    /**
     * Devolve o Ano de Curso de uma Disciplina
     * @return anoCurso Disciplina
     */
    public int getAnoCurso() {
        return this.anoCurso;
    }

    /**
     * Devolve o Professor Regente de uma Disciplina
     * @return regente disciplina
     */
    public Professor getRegente() {
        return this.regente;
    }

    /**
     * Altera a Designação de uma Disciplina
     * @param designacao nova designação da Disciplina
     */
    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    /**
     * Altera a Designação de uma Disciplina
     * @param abreviatura nova abreviatura da disciplina
     */
    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    /**
     * Altera o Ano de Curso de uma Disciplina
     * @param anoCurso novo ano de curso da disciplina
     */
    public void setAnoCurso(int anoCurso) {
        this.anoCurso = anoCurso;
    }

    /**
     * Altera o Regente de uma Disciplina
     * @param regente novo regente da disciplina
     */
    public void setRegente(Professor regente) {
        this.regente = regente;
    }
    
    /**
     * Devolve a descrição textual de uma disciplina
     * @return atributos de uma disciplina
     */
    @Override
    public String toString() {
        return String.format("A Disciplina %s - %s pertence ao ano de Curso %d e o seu regente é:%n - %s", this.designacao, this.abreviatura, this.anoCurso, this.regente);
    }
    
    /**
     * Compara a Disciplina com outro objecto enviado por parâmetro.
     * @param outroObjecto objecto a ser comparado
     * @return true se ambos representarem a mesma disciplina. Caso contrário, false.
     */
    @Override
    public boolean equals(Object outroObjecto) {
        if (this == outroObjecto) {
            return true;
        }
        if (outroObjecto == null || this.getClass() != outroObjecto.getClass()) {
            return false;
        }
        
        Disciplina d = (Disciplina) outroObjecto;
        return (this.designacao.equalsIgnoreCase(d.getDesignacao()) && this.abreviatura.equalsIgnoreCase(d.getAbreviatura()) && this.anoCurso == d.getAnoCurso() && this.regente == d.getRegente());
    }
    
    

}
