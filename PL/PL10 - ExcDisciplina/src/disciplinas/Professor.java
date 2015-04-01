/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package disciplinas;

/**
 * Classe que Representa um Objecto Professor
 * @author Duarte Nuno Amorim <1130674@isep.ipp.pt>
 */
public class Professor {
    
    /**
     * Nome do Professor
     */
    private String nome;
    /**
     * Habilitações Académicas do Professor (Tipo Enumerado)
     */
    private HabilitacoesAcademicas habilitacao;
    
    /**
     * Nome do Professor por defeito
     */
    private static final String NOME_POR_DEFEITO = "Sem Nome";
    /**
     * Habilitações Académicas por Defeito
     */
    private static final HabilitacoesAcademicas HABILITACAO_POR_DEFEITO = HabilitacoesAcademicas.NAODEFINIDO;
    
    /**
     * Constrói uma instância de Professor, sendo passado todos os atributos por parâmetro
     * @param nome Nome do Professor
     * @param habilitacao Habilitações do Professor
     */
    public Professor(String nome, HabilitacoesAcademicas habilitacao) {
        this.nome = nome;
        this.habilitacao = habilitacao;
    }
    
    /**
     * Constrói uma instância de Professor com os valores por defeito.
     */
    public Professor() {
        this(Professor.NOME_POR_DEFEITO, Professor.HABILITACAO_POR_DEFEITO);
    }
    
    /**
     * Constrói uma instância de Professor, sendo um clone do Professor recebido por Parâmetro
     * @param outroProfessor Professor a ser clonado
     */
    public Professor(Professor outroProfessor) {
        this(outroProfessor.nome, outroProfessor.habilitacao);
    }

    /**
     * Retorna o Nome do Professor
     * @return Nome do Professor
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Retorna a Habilitação Académica de um Professor, do tipo HabilitacoesAcademicas
     * @return habilitação do professor
     */
    public HabilitacoesAcademicas getHabilitacao() {
        return this.habilitacao;
    }

    /**
     * Permite alterar um Nome de um Professor
     * @param nome novo nome do professor
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Permite alterar a habilitação de um professor
     * @param habilitacao nova habilitação de um professor
     */
    public void setHabilitacao(HabilitacoesAcademicas habilitacao) {
        this.habilitacao = habilitacao;
    }
    
    /**
     * Devolve a descrição textual de um Professor
     * @return atributos de um Professor
     */
    @Override
    public String toString() {
        return String.format("O professor %s tem %s como habilitações académicas.", this.nome, this.habilitacao.descricaoHabilitacao());
    }
    
    /**
     * Permite comparar um objecto com um Professor
     * @param outroObjecto Objecto a ser comparado
     * @return true se identificar o mesmo Professor. Caso contrário, false.
     */
    @Override
    public boolean equals(Object outroObjecto) {
        if(this == outroObjecto) {
            return true;
        }
        if(outroObjecto == null || this.getClass() != outroObjecto.getClass()) {
            return false;
        }
        Professor p = (Professor) outroObjecto;
        return (this.nome.equalsIgnoreCase(p.getNome()) && this.habilitacao == p.getHabilitacao());
    }

}

