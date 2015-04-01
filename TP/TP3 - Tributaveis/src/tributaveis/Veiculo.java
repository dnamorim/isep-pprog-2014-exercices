/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tributaveis;

/**
 *
 * @author Duarte Nuno Amorim <1130674@isep.ipp.pt>  
 */
public class Veiculo implements Cores, Tributavel, Comparable {
    private String matricula;
    private int cilindrada;
    private String cor;
    
    
    private static int limiteEscalao1 = 1500;
    private static float impostoEscalao1 = 15;
    private static float impostoEscalao2 = 40;
    
    public Veiculo(String matricula, int cilindrada, String cor) {
        this.matricula = matricula;
        this.cilindrada = cilindrada;
        this.cor = cor;
    }
    
    public String getMatricula() {
        return this.matricula;
    }
    
    public int getCilindrada() {
        return this.cilindrada;
    }
    
    public String getCor() {
        return this.cor;
    }
    
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }
    
    public void setCor(String cor) {
        this.cor = cor;
    }
    
    @Override
    public String toString() {
        return String.format("Veículo com matrícula %s e cilindrada %d tem cor %s", this.matricula, this.cilindrada, this.cor);
    }
    
    @Override
    public float calcularImposto() {
        return (this.cilindrada < Veiculo.limiteEscalao1) ? Veiculo.impostoEscalao1 : Veiculo.impostoEscalao2;
    }
    
    @Override
    public int compareTo (Object outroObj) {
        double outroImposto = ((Tributavel) outroObj).calcularImposto();
        double esteImposto = this.calcularImposto();
        
        if(esteImposto < outroImposto) {
            return -1;
        } else if(esteImposto > outroImposto) {
            return 1;
        } else  {
            return 0;
        }
    }
    
    public static int getLimiteEscalao1() {
        return Veiculo.limiteEscalao1;
    }
    
    public static float getImpostoEscalao1() {
        return Veiculo.impostoEscalao1;
    }
    
    public static float getImpostoEscalao2() {
        return Veiculo.impostoEscalao2;
    }
    
    public static void setLimiteEscalao1(int novoLimite) {
        Veiculo.limiteEscalao1 = novoLimite;
    }
    
    public static void setImpostoEscalao1(float novoImposto) {
        Veiculo.impostoEscalao1 = novoImposto;
    }
    
    public static void setImpostoEscalao2(float novoImposto) {
        Veiculo.impostoEscalao2 = novoImposto;
    }
    
    
    
}
