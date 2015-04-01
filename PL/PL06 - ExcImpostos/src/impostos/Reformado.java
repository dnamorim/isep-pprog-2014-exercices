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
public class Reformado extends Contribuinte {
    
    private static float taxaRT=1;
    
    private static float taxaOR=3;
    
    public Reformado(String nome, String morada, int nif, float rt, float or) {
        super(nome, morada, nif, rt, or);
    }
    
    public Reformado() {
        super();
    }
    
    public Reformado(Reformado outroReformado) {
        this(outroReformado.getNome(), outroReformado.getMorada(), outroReformado.getNIF(), outroReformado.getRT(), outroReformado.getOR());
    }
    
    @Override
    public String toString() {
        return String.format("Descrição Reformado:%n%s%n", super.toString());
    }
    
    public static float getTaxaRT() {
        return Reformado.taxaRT;
    }
    
    public static float getTaxaOR() {
        return Reformado.taxaOR;
    }
    
    public static void setTaxaRT(float taxa) {
        Reformado.taxaRT = taxa;
    }
    
    public static void setTaxaOR(float taxa) {
        Reformado.taxaOR = taxa;
    }
    
    @Override
    protected float taxaRT() {
        return Reformado.taxaRT;
    }
    
    @Override
    protected float taxaOR() {
        return Reformado.taxaOR;
    }
    
    @Override
    public boolean equals(Object outroObjecto) {
        if (!super.equals(outroObjecto)) {
            return false;
        }
        return true;
    }   

}
