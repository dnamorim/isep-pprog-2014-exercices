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
public class Moradia implements Cores, Tributavel, Comparable {

        private String morada;
        private float area;
        private String cor;
        
    
        public Moradia(String morada, float area, String cor) {
            this.morada = morada;
            this.area = area;
            this.cor = cor;
        }
        
        public String getMorada() {
            return this.morada;
        }

        public float getArea() {
            return this.area;
        }

        public String getCor() {
            return this.cor;
        }

        public void setMorada(String morada) {
            this.morada = morada;
        }

        public void setArea(float area) {
            this.area = area;
        }

        public void setCor(String cor) {
            this.cor = cor;
        }

        @Override
        public String toString() {
            return String.format("Moradia situada na rua %s com área de %.1f tem cor %s", this.morada, this.area, this.cor);
        }
        
        @Override 
        public float calcularImposto() {
            return (this.area*2);
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
}
