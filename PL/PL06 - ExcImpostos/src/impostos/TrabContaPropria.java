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
public class TrabContaPropria extends Contribuinte {
    
    private String profissao;
    
    private static String PROFISSAO_POR_OMISSAO = "Sem Profissão";
    
    private static float taxaRT=3;
    
    private static float taxaOR1=2;
    
    private static float taxaOR2=5;
    
    private static float escalaoOR=50000; 
    
    public TrabContaPropria(String nome, String morada, int nif, float rt, float or, String nomeEmpresa) {
        super(nome, morada, nif, rt, or);
        this.profissao = profissao;
    }
    
    public TrabContaPropria() {
        this(Contribuinte.NOME_POR_OMISSAO, Contribuinte.MORADA_POR_OMISSAO, Contribuinte.NIF_POR_OMISSAO, Contribuinte.RT_POR_OMISSAO, Contribuinte.OR_POR_OMISSAO, TrabContaPropria.PROFISSAO_POR_OMISSAO);
    }
    
    public TrabContaPropria(TrabContaPropria outroTCP) {
        this(outroTCP.getNome(), outroTCP.getMorada(), outroTCP.getNIF(), outroTCP.getRT(), outroTCP.getOR(), outroTCP.getProfissao());
    }
    
    public String getProfissao() {
        return this.profissao;
    }
    
    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }
    
    @Override
    public String toString() {
        return String.format("Descrição Trabalhador Conta Própria:%n%s Profissão: %s%n", super.toString(), this.profissao);
    }
    
    public float taxaRT() {
        return TrabContaPropria.taxaRT;
    }
    
    public float taxaOR() {
        if(this.getOR() > TrabContaPropria.escalaoOR) {
            return TrabContaPropria.taxaOR2;
        } else {
            return TrabContaPropria.taxaOR1;
        }
    }
    
    @Override
    public boolean equals(Object outroObjecto) {
        if(!super.equals(outroObjecto)) {
            return false;
        }
        TrabContaPropria tcp = (TrabContaPropria) outroObjecto;
        return this.profissao.equalsIgnoreCase(tcp.getProfissao());
    }
}
