/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utilitarios;

/**
 *
 * @author Duarte Nuno Amorim <1130674@isep.ipp.pt> 
 */
public class Tempo {
    /**
     * Hora de um Tempo
     */
    private int hora;
    /**
     * Minutos de um Tempo
     */
    private int minuto;
    /**
     * Segundos de um Tempo
     */
    private int segundo;
    
    
    /**
     * Constói uma instância de um tempo, sendo fornecido todos os parâmetros (hora, minutos e segundos).
     * @param hora Hora de um Tempo
     * @param minuto Minuto de um Tempo
     * @param segundo Segundos de um Tempo
     */
    public Tempo(int hora, int minuto, int segundo) {
        this.hora=hora;
        this.minuto=minuto;
        this.segundo=segundo;
    }
    
    public Tempo() {
        this(0,0,0);
    }
    
    public Tempo(Tempo outroTempo) {
        this(outroTempo.getHora(), outroTempo.getMinuto(), outroTempo.getSegundo());
    }
    
    public Tempo(long segundos) {
        segundosParaTempo(segundos, this);
    }
    
    public Tempo(int horas, int minutos) {
        this(horas,minutos,0);
    }
    
    public int getHora() {
        return this.hora;
    }
    
    public int getMinuto() {
        return this.minuto;
    }
    
    public int getSegundo() {
        return this.segundo;
    }
    
    public void setHora(int hora) {
        this.hora=hora;
    }
    
    public void setMinuto(int minuto) {
        this.minuto=minuto;
    }
    
    public void setSegundo(int segundo) {
        this.segundo=segundo;
    }
    
    public String toString() {
        return String.format("%02d:%02d:%02d",this.hora, this.minuto, this.segundo);
    }
    
    public String toStringAMPM() {
        String desc;
        int hora=this.hora;
        
        if(this.hora < 12) {
            desc="AM";
        } else {
            desc="PM";
            hora-=12;
        }
        
        if(hora==0) {
            hora=12;
        }
        return String.format("%02d:%02d:%02d %s",(this.hora==0 || this.hora==12) ? 12 : this.hora % 12, this.minuto, this.segundo, this.hora > 12 ? "PM" : "AM");
        
    }
    
    
    public void setTempo(int hora, int minuto, int segundo) {
        this.setHora(hora);
        this.setMinuto(minuto);
        this.setSegundo(segundo);
    }
    
    public void addOneSecond() {
        long tSegundos=tempoParaSegundos()+1;
        segundosParaTempo(tSegundos);
    }
    
    public boolean isTempoMaior(int hora, int minuto, int segundo) {
        long hSegundos1 = tempoParaSegundos();
        long hSegundos2 = tempoParaSegundos(hora, minuto, segundo);
        return hSegundos1>hSegundos2;
    }
    
    public boolean isTempoMaior(Tempo novoTempo) {
        long tSegundos1 = tempoParaSegundos();
        long tSegundos2 = tempoParaSegundos(novoTempo);
        return tSegundos1>tSegundos2;
    }
    
    public int diferencaTempoSegundos(Tempo tmp) {
        long tSegundos1 = tempoParaSegundos();
        long tSegundos2 = tempoParaSegundos(tmp);
        return (int) Math.abs(tSegundos1-tSegundos2);
        
    }
    
    public Tempo diferencaTempo(Tempo tmp) {
        long difSegundos = Math.abs(tempoParaSegundos() - tempoParaSegundos(tmp));
        Tempo difTempo = new Tempo(difSegundos);
        return difTempo; 
    }
      
    
    private long tempoParaSegundos(int hora, int minuto, int segundo) {
        return segundo + minuto*60 + hora*3600;
    }
    
    private long tempoParaSegundos() {
        return tempoParaSegundos(this.hora, this.minuto, this.segundo);
    }
    
    private long tempoParaSegundos(Tempo tmp) {
        return tempoParaSegundos(tmp.hora, tmp.minuto, tmp.segundo);
    }
    
    private void segundosParaTempo(long tSegundos, Tempo tmp) {
        if(tSegundos >= 3600) {
            tmp.hora = (int) tSegundos/3600;
            tSegundos -= tmp.hora*3600;
        }
        
        if(tSegundos >= 60) {
            tmp.minuto = (int) tSegundos/60;
            tSegundos -= tmp.minuto*60;
        }
        
        tmp.segundo = (int)tSegundos;
    }
    
    private void segundosParaTempo(long tSegundos) {
        segundosParaTempo(tSegundos, this);
    }
    
      
 }
