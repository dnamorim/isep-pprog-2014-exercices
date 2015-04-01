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
public class TrabContaOutrem extends Contribuinte {
    private String empresa;
    
    private static final String EMPRESA_POR_OMISSAO = "Empresa Sem Nome";
    
    private static float taxaRT1 = 1;
    
    private static float taxaRT2 = 2;
    
    private static float taxaOR = 2;
    
    private static float escalaoRT = 30000;
    
    public TrabContaOutrem(String nome, String morada, int nif, float rt, float or, String nomeEmpresa) {
        super(nome, morada, nif, rt, or);
        this.empresa = nomeEmpresa;
    }
    
    public TrabContaOutrem() {
        this(Contribuinte.NOME_POR_OMISSAO, Contribuinte.MORADA_POR_OMISSAO, Contribuinte.NIF_POR_OMISSAO, Contribuinte.RT_POR_OMISSAO, Contribuinte.OR_POR_OMISSAO, TrabContaOutrem.EMPRESA_POR_OMISSAO);
    }
    
    public TrabContaOutrem(TrabContaOutrem outroTCO) {
        this(outroTCO.getNome(), outroTCO.getMorada(), outroTCO.getNIF(), outroTCO.getRT(), outroTCO.getOR(), outroTCO.getEmpresa());
    }
    
    public String getEmpresa() {
        return this.empresa;
    }
    
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
    
    @Override
    public String toString() {
        return String.format("Descrição Trabalhador Conta Outrém:%n%s Nome da Empresa: %s%n", super.toString(), this.empresa);
    }
    
    public static float getTaxaRT1() {
        return TrabContaOutrem.taxaRT1;
    }
    
    public static float getTaxaRT2() {
        return TrabContaOutrem.taxaRT2;
    }
    
    public static float getTaxaOR() {
        return TrabContaOutrem.taxaOR;
    }
    
    public static void setTaxaRT1(float taxa) {
        TrabContaOutrem.taxaRT1 = taxa;
    }
    
    public static void setTaxaRT2(float taxa) {
        TrabContaOutrem.taxaRT2 = taxa;
    }
    
    public static void setTaxaOR(float taxa) {
        TrabContaOutrem.taxaOR = taxa;
    }
    
    protected float taxaRT() {
        if(this.getRT() > TrabContaOutrem.escalaoRT) {
            return TrabContaOutrem.taxaRT2;
        } else {
            return TrabContaOutrem.taxaRT1;
        }
    }
    
    protected float taxaOR() {
        return TrabContaOutrem.taxaOR;
    }
    
    @Override
    public boolean equals(Object outroObjecto) {
        if(!super.equals(outroObjecto)) {
            return false;
        } 
        TrabContaOutrem tco = (TrabContaOutrem) outroObjecto;
        return this.empresa.equalsIgnoreCase(tco.getEmpresa());
    }
}
