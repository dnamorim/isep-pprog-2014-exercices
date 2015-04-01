/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Exc;

/**
 * Permite criar um objecto representativo de um triângulo e permite calcular a sua área e perímetro.
 * @author Duarte Nuno Amorim
 */
public class Rectangle {
    /**
     * Variáveis de Instância que representam um Rectângulo: a largura (width) e a altura (height).
     */
    private float width;
    private float height;
    
    /**
     * Construtor de um objecto do tipo Rectangulo em que a Altura e Largura são inicializados a 0.
     */
    public Rectangle() {
        this.width=0;
        this.height=0;
    }
    
    /**
     * Construtor de um objecto do tipo Rectangulo em que a Altura e Largura são passadas por parâmetro.
     * @param width Largura do Rectângulo a criar
     * @param height Altura do Rectângulo a criar
     */
    public Rectangle(float width, float height) {
        this.width=width;
        this.height=height;
    }

    /** 
     * Construtor de um objecto do tipo Rectangulo em que é passado apenas um valor, gerando um Quadrado.
     * @param size valor do lado.
     */
    public Rectangle(float size) {
        this.width=size;
        this.height=size;
    }
    
    /**
     * Método que permite obter a Largura de um Rectângulo
     * @return valor da largura de um objecto Rectângulo
     */
    public float getWidth() {
        return this.width;
    }
    
    /**
     * Método que permite obter a Altura de um Rectângulo
     * @return valor da altura de um objecto Rectângulo
     */
    public float getHeight() {
        return this.height;
    }
    
    
    /** 
     * Método que permite alterar a Largura de um Rectângulo
     * @param width novo valor da Largura de um Rectângulo
     */
    public void setWidth(float width) {
        this.width=width;
    }
    
    /**
     * Método que permite alterar a Altura de um Rectângulo
     * @param height novo valor da Altura de um Rectângulo
     */
    public void setHeight(float height) {
        this.height=height;
    }
    
    /**
     * Metodo que permite alterar ao mesmo tempo os valores de largura e altura de um Rectângulo
     * @param width Nova Largura do Rectângulo
     * @param height Nova Altura do Rectângulo
     */
    public void setWidthHeight(float width, float height) {
        setWidth(width);
        setHeight(height);
    }
    
    /**
     * Método que retorna uma descrição textual relativamente ao Objecto Rectângulo
     * @return descrição com os valores actuais do Rectângulo (Ex: RECTÂNGULO  Largura: 5   Altura: 6)
     */
    public String toString() {
        return("-- RECTÂNGULO --\n Largura: "+this.width+"  Altura: "+this.height);
    }
    
     /**
     * Método que permite obter o valor do Perímetro de um Rectângulo
     * @return valor do perímetro de um objecto Rectângulo
     */
    public float perimeter() {
        return 2*(this.height+this.width);
    }
    
    /**
     * Método que permite obter o valor da Área de um Rectângulo
     * @return valor da área de um rectângulo
     */
    public float area() {
        return(this.height*this.width); 
    }
    
}
