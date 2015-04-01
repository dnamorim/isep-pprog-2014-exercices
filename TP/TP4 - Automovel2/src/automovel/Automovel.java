/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package automovel;

import utilitarios.Data;

/**
 *
 * @author Duarte Nuno Amorim <1130674@isep.ipp.pt>
 */
public class Automovel {
    private String matricula, marca;
    private Data dataRegisto;
    
    private static final String MATRICULA_POR_OMISSAO = "sem matrícula";
    private static final String MARCA_POR_OMISSAO = "sem marca";
    
    public Automovel(String matricula, String marca, Data dataRegisto) {
        this.matricula = matricula;
        this.marca = marca;
        this.dataRegisto = new Data(dataRegisto);
    }

    public Automovel() {
        this(Automovel.MATRICULA_POR_OMISSAO, Automovel.MARCA_POR_OMISSAO, MinhaData.dataActual());

    }
    
    public Automovel(Automovel outroAutomovel) {
        this(outroAutomovel.matricula,outroAutomovel.marca, outroAutomovel.dataRegisto);
    }
    
    public String getMatricula() { 
        return this.matricula; 
    }
    
    public String getMarca() { 
        return this.marca; 
    }
    
    public Data getDataRegisto() {
        return new Data(this.dataRegisto);
    }
    
    public void setMatricula(String matricula) { 
        this.matricula = matricula; 
    }
    
    public void setMarca(String marca) { 
        this.marca = marca;
    }
    
    public void setDataRegisto(Data dataRegisto) {
        this.dataRegisto.setData(dataRegisto.getAno(), dataRegisto.getMes(), dataRegisto.getDia());
    }
    
    public String toString() {
        return "Automóvel com matrícula " + this.matricula + ", marca " + this.marca + " e data de registo " + this.dataRegisto.toAnoMesDiaString();
    }
}
