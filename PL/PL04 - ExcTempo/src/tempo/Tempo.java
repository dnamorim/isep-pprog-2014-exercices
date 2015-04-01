/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tempo;

/**
 * Representa uma Instância de {@code Tempo}
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
     * Constói uma instância de um {@code Tempo}, sendo fornecido todos os parâmetros (hora, minutos e segundos).
     * @param hora Hora de um Tempo
     * @param minuto Minuto de um Tempo
     * @param segundo Segundos de um Tempo
     */
    public Tempo(int hora, int minuto, int segundo) {
        this.hora=hora;
        this.minuto=minuto;
        this.segundo=segundo;
    }
    
    /**
     * Constrói uma instância de {@code Tempo} com os valores por omissão (a 0's).
     */
    public Tempo() {
        this(0,0,0);
    }
    
    /**
     * Constrói uma instância de {@code Tempo} com as mesmas características que o Tempo recebido por parâmetro.
     * @param outroTempo o tempo com as características a copiar
     */
    public Tempo(Tempo outroTempo) {
        this(outroTempo.getHora(), outroTempo.getMinuto(), outroTempo.getSegundo());
    }
    
    /**
     * Constrói uma instância de {@code Tempo} com os segundos recebidos por parâmetros
     * @param segundos segundos totais do tempo a criar
     */
    public Tempo(long segundos) {
        segundosParaTempo(segundos, this);
    }
    
    /**
     * Constrói uma instância de {@code Tempo}, sendo fornecido apenas as horas e os minutos por parâmetro.
     * @param horas horas do Tempo
     * @param minutos minutos do Tempo
     */
    public Tempo(int horas, int minutos) {
        this(horas,minutos,0);
    }
    
    /**
     * Devolve a Hora de um Tempo
     * @return hora do tempo
     */
    public int getHora() {
        return this.hora;
    }
    
    /**
     * Devolve os Minutos de um Tempo
     * @return minutos do tempo
     */
    public int getMinuto() {
        return this.minuto;
    }
    
    /**
     * Devolve os Segundos de um Tempo
     * @return segundos do tempo
     */
    public int getSegundo() {
        return this.segundo;
    }
    
    /**
     * Modifica a Hora de um Tempo
     * @param hora a nova hora do Tempo
     */
    public void setHora(int hora) {
        this.hora=hora;
    }
    
    /**
     * Modifica os Minutos de um Tempo
     * @param minuto os novos minutos de um Tempo
     */
    public void setMinuto(int minuto) {
        this.minuto=minuto;
    }
    
    /**
     * Modifica os Segundos de um Tempo
     * @param segundo os novos segundos de um Tempo
     */
    public void setSegundo(int segundo) {
        this.segundo=segundo;
    }
    
    /**
     * Devolve a descrição textual do Tempo no formato: hh:mm:ss
     * Exemplo: "08:10:59".
     * 
     * @return atributos de um Tempo
     */
    public String toString() {
        return String.format("%02d:%02d:%02d",this.hora, this.minuto, this.segundo);
    }
    
    /**
     * Devolve a descrição textual do Tempo no formato de 12h: hh:mm:ss AM/PM
     * Exemplo: "08:10:59 AM"
     * 
     * @return atributos do Tempo no sistema horário de 12h
     */
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
    
    /**
     * Adiciona um Segundo ao {@code Tempo}
     */
    public void addOneSecond() {
        long tSegundos=tempoParaSegundos()+1;
        segundosParaTempo(tSegundos);
    }
    
    /**
     * Verifica se o {@code Tempo} é maior que um Tempo em horas, minutos e segundos passados por parâmetro.
     * 
     * @param hora hora do Tempo a comparar
     * @param minuto minuto do Tempo a comparar
     * @param segundo segundo do Tempo a comparar
     * @return true se o Tempo for maior do que o passado por parâmetro. Caso contrário, retorna false.
     */
    public boolean isTempoMaior(int hora, int minuto, int segundo) {
        long hSegundos1 = tempoParaSegundos();
        long hSegundos2 = tempoParaSegundos(hora, minuto, segundo);
        return hSegundos1>hSegundos2;
    }
    
    /**
     * Verifica se o {@code Tempo} é maior que um Tempo passado por parâmetro.
     * 
     * @param novoTempo o Tempo a comparar
     * @return true se o Tempo for maior que o Tempo passado por parâmetro. Caso contrário, retorna false.
     */
    public boolean isTempoMaior(Tempo novoTempo) {
        long tSegundos1 = tempoParaSegundos();
        long tSegundos2 = tempoParaSegundos(novoTempo);
        return tSegundos1>tSegundos2;
    }
    
    /**
     * Calcula a Diferença entre dois Tempos, um deles passado por parâmetro, em Segundos.
     * 
     * @param tempo Tempo a ser calculado a diferença
     * @return diferença dos Tempos em Segundos
     */
    public int diferencaTempoSegundos(Tempo tempo) {
        long tSegundos1 = tempoParaSegundos();
        long tSegundos2 = tempoParaSegundos(tempo);
        return (int) Math.abs(tSegundos1-tSegundos2);
        
    }
    
    /**
     * Calcula a Diferença entre dois Tempos, um deles passado por parâmetro, em {@code Tempo}.
     * 
     * @param tmp Tempo a ser calculado a diferença
     * @return diferença em formato {@code Tempo}
     */
    public Tempo diferencaTempo(Tempo tmp) {
        long difSegundos = Math.abs(tempoParaSegundos() - tempoParaSegundos(tmp));
        Tempo difTempo = new Tempo(difSegundos);
        return difTempo; 
    }
      
    /**
     * Transforma um Tempo em hora, minutos e segundos só em Segundos.
     * 
     * @param hora hora do Tempo a ser transformado
     * @param minuto minuto do Tempo a ser transformado
     * @param segundo segundo do Tempo a ser transformado
     * @return segundos do Tempo dado por parâmetro
     */
    private long tempoParaSegundos(int hora, int minuto, int segundo) {
        return segundo + minuto*60 + hora*3600;
    }
    
    /**
     * Transforma o {@code Tempo} em Segundos.
     * @return o Tempo em Segundos
     */
    private long tempoParaSegundos() {
        return tempoParaSegundos(this.hora, this.minuto, this.segundo);
    }
    
    /**
     * Transforma um Tempo dado por parâmetro em segundos.
     * @param tempo Tempo a ser transformado
     * @return segundos do tempo dado
     */
    private long tempoParaSegundos(Tempo tempo) {
        return tempoParaSegundos(tempo.hora, tempo.minuto, tempo.segundo);
    }
    
    /**
     * Transforma segundos no formato {@code Tempo} e armazena-os num objecto Tempo passado por parâmetro.
     * 
     * @param tSegundos Tempo em Segundos
     * @param tempo local onde vai ser armazenado os segundos em formato Tempo
     */
    private void segundosParaTempo(long tSegundos, Tempo tempo) {
        if(tSegundos >= 3600) {
            tempo.hora = (int) tSegundos/3600;
            tSegundos -= tempo.hora*3600;
        }
        
        if(tSegundos >= 60) {
            tempo.minuto = (int) tSegundos/60;
            tSegundos -= tempo.minuto*60;
        }
        
        tempo.segundo = (int)tSegundos;
    }
    
    /**
     * Transforma segundos e guarda-os no {@code Tempo}.
     * @param tSegundos Tempo em segundos
     */
    private void segundosParaTempo(long tSegundos) {
        segundosParaTempo(tSegundos, this);
    }
    
      
 }
