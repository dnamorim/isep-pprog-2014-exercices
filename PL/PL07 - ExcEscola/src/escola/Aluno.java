/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package escola;

/**
 *
 * @author Duarte Nuno Amorim <1130674@isep.ipp.pt>
 */
public class Aluno extends Pessoa {

    /**
     * Número Mecanográfico do Aluno
     */
    private int nrMec;
    
    public Aluno(String nome, String email, int nif, int nrMec) {
        super(nome, email, nif);
        this.nrMec=nrMec;
    }
    
    public Aluno() {
        this("Sem Nome", "Sem E-Mail", 999999999, 1234567);
    }
    
    public Aluno(Aluno outroAluno) {
        this(outroAluno.getNome(), outroAluno.getEmail(), outroAluno.getNif(), outroAluno.getNrMec());
    }

    public int getNrMec() {
        return nrMec;
    }

    public void setNrMec(int nrMec) {
        this.nrMec = nrMec;
    }

    @Override
    public String toString() {
        return String.format("ALUNO%n%s%nNr. Mecanográfico: %d%n", super.toString(), this.nrMec);
    }

    
}
