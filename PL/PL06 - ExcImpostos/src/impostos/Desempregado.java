/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package impostos;

/**
 *
 * @author Duarte Nuno Amorim <1130674@isep.ipp.pt> 
 */
public class Desempregado extends Contribuinte {
    private int mesesParagem;
    
    private static float taxaOR = 2;
    
    private static final int MESES_POR_OMISSAO = 1;
    
    public Desempregado(String nome, String morada, int nif, float or, int mesesParagem) {
        super(nome, morada, nif, Contribuinte.RT_POR_OMISSAO, or);
        this.mesesParagem = mesesParagem;
    }
    
    public Desempregado() {
        this(Contribuinte.NOME_POR_OMISSAO, Contribuinte.MORADA_POR_OMISSAO, Contribuinte.NIF_POR_OMISSAO, Contribuinte.OR_POR_OMISSAO, Desempregado.MESES_POR_OMISSAO);
    }
    
    public Desempregado(Desempregado outroDesempregado) {
        this(outroDesempregado.getNome(), outroDesempregado.getMorada(), outroDesempregado.getNIF(), outroDesempregado.getOR(), outroDesempregado.getMesesParagem());
    }

    public int getMesesParagem() {
        return mesesParagem;
    }

    public void setMesesParagem(int mesesParagem) {
        this.mesesParagem = mesesParagem;
    }
    
    public String toString() {
        return String.format("Descrição Desempregado:%n%s Meses Paragem: %d%n", super.toString(), this.mesesParagem);
    }

    public static float getTaxaOR() {
        return taxaOR;
    }

    public static void setTaxaOR(float taxaOR) {
        Desempregado.taxaOR = taxaOR;
    }
    
    public float taxaRT() {
        return 0;
    }
    
    public float taxaOR() {
        return Desempregado.taxaOR;
    }
    
    @Override
    public boolean equals(Object outroObjecto) {
        if(!super.equals(outroObjecto)) {
            return false;
        }
        Desempregado d = (Desempregado) outroObjecto;
        return (this.mesesParagem != d.getMesesParagem());
    }
    
}
