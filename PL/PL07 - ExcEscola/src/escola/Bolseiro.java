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
public class Bolseiro extends Aluno implements Encargos {

    private float valorBolsa;
    
    public Bolseiro(String nome, String email, int nif, int nrMec, float valorBolsa) {
        super(nome, email, nif, nrMec);
        this.valorBolsa = valorBolsa;
    }
    
    public Bolseiro() {
        this("Sem Nome", "Sem E-Mail", 999999999, 1234567, 0f);
    }
    
    public Bolseiro (Bolseiro outroBols) {
        this(outroBols.getNome(), outroBols.getEmail(), outroBols.getNif(), outroBols.getNrMec(), outroBols.getValorBolsa());
    }

    public float getValorBolsa() {
        return valorBolsa;
    }

    public void setValorBolsa(float valorBolsa) {
        this.valorBolsa = valorBolsa;
    }
    
    @Override
    public String toString() {
        return String.format("%sValor Bolsa: %.2f €%n", super.toString(), this.valorBolsa);
    }
    
    @Override
    public float encargo() {
        return this.valorBolsa;
    }
}
