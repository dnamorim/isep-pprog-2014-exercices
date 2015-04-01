/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package empregado;

import utilitarios.Data;
import utilitarios.Tempo;

/**
 *
 * @author Duarte Nuno Amorim <1130674@isep.ipp.pt>
 */
public class Empregado {
    
    private String primeiroNome;
    
    private String ultimoNome;
    
    private Data dataContrato;
    
    private Tempo horaEntrada;
    
    private Tempo horaSaida;
    
    private static int diasTrabalhoSemana = 5;
    
    protected static final String PRIMEIRONOME_POR_OMISSAO = "Sem Nome";
    
    protected static final String ULTIMONOME_POR_OMISSAO = "Sem Apelido";
    
    protected static final Data DATACONTRATO_POR_OMISSAO = new Data(1995,2,8);
    
    protected static final Tempo HORAENTRADA_POR_OMISSAO = new Tempo(9);
    
    protected static final Tempo HORASAIDA_POR_OMISSAO = new Tempo(5,30);
    
    public Empregado(String primeiroNome, String ultimoNome, Data dataContrato, Tempo horaEntrada, Tempo horaSaida) {
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
        this.dataContrato = new Data(dataContrato);
        this.horaEntrada = new Tempo(horaEntrada);
        this.horaSaida = new Tempo(horaSaida);
    }
    
    public Empregado() {
        this(Empregado.PRIMEIRONOME_POR_OMISSAO, Empregado.ULTIMONOME_POR_OMISSAO, Empregado.DATACONTRATO_POR_OMISSAO, Empregado.HORAENTRADA_POR_OMISSAO, Empregado.HORASAIDA_POR_OMISSAO);
    }
    
    public Empregado(Empregado outroEmpregado) {
        this();
    }

    /**
     * @return primeiroNome
     */
    public String getPrimeiroNome() {
        return this.primeiroNome;
    }

    /**
     * @return ultimoNome
     */
    public String getUltimoNome() {
        return this.ultimoNome;
    }

    /**
     * @return dataContrato
     */
    public Data getDataContrato() {
        return this.dataContrato;
    }

    /**
     * @return horaEntrada
     */
    public Tempo getHoraEntrada() {
        return this.horaEntrada;
    }

    /**
     * @return horaSaida
     */
    public Tempo getHoraSaida() {
        return this.horaSaida;
    }

    /**
    * @return the diasTrabalhoSemana
    */
    public static int getDiasTrabalhoSemana() {
        return diasTrabalhoSemana;
    }

    /**
     * @param aDiasTrabalhoSemana the diasTrabalhoSemana to set
     */
    public static void setDiasTrabalhoSemana(int aDiasTrabalhoSemana) {
        diasTrabalhoSemana = aDiasTrabalhoSemana;
    }
    
    /**
     * @param primeiroNome novo primeiroNome do Empregado
     */
    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    /**
     * @param ultimoNome novo ultimoNome do Empregado
     */
    public void setUltimoNome(String ultimoNome) {
        this.ultimoNome = ultimoNome;
    }

    /**
     * @param dataContrato the dataContrato to set
     */
    public void setDataContrato(Data dataContrato) {
        this.dataContrato = dataContrato;
    }

    /**
     * @param horaEntrada the horaEntrada to set
     */
    public void setHoraEntrada(Tempo horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    /**
     * @param horaSaida the horaSaida to set
     */
    public void setHoraSaida(Tempo horaSaida) {
        this.horaSaida = horaSaida;
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public String toString() {
       return String.format("Apelido, Nome: %s, %s  Data Contrato: %s  Horário: %s - %s", this.ultimoNome, this.primeiroNome, this.dataContrato.toAnoMesDiaString(), this.horaEntrada.toString(), this.horaSaida.toString());
    }
    
    @Override
    public boolean equals(Object outroObjecto) {
        if(this == outroObjecto) {
            return true;
        }
        if(outroObjecto == null || this.getClass() != outroObjecto.getClass()) {
            return false;
        }
        Empregado e = (Empregado) outroObjecto;
        return (this.primeiroNome.equalsIgnoreCase(e.getPrimeiroNome()) && this.ultimoNome.equalsIgnoreCase(e.getUltimoNome()) && this.dataContrato.equals(e.getDataContrato()) && this.horaEntrada.equals(e.getHoraEntrada()) && this.horaSaida.equals(e.getHoraSaida()));
    }
    
    public Tempo calculoHorasSemanais() {
        int seg = this.horaEntrada.diferencaTempoSegundos(this.horaSaida);
        Tempo t = new Tempo(seg*Empregado.diasTrabalhoSemana);
        return t;
    }
    
    public int tempoContrato() {
        int dias = this.dataContrato.diferenca(TodayDate.dataActual());
        return dias/365;
    }
    
}
