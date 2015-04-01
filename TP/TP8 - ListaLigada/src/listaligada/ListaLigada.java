/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package listaligada;

import java.util.NoSuchElementException;

/**
 *
 * @author Duarte Nuno Amorim <1130674@isep.ipp.pt>
 */
public class ListaLigada {

    private No primeiro;
    private int tamanho;
    
    public ListaLigada() {
        this.primeiro = null;
        this.tamanho = 0;
    }
    
    public int getTamanho() {
        return this.tamanho;
    }
    
    public void adicionarPrimeiro(Object elemento) {
        No novoNo = new No(elemento, this.primeiro);
        this.primeiro = novoNo;
        this.tamanho++;
    }
    
    public Object obterPrimeiro() {
        if(this.primeiro == null) {
            throw new NoSuchElementException();
        }
        return this.primeiro.elemento;
    }
    
    public Object removerPrimeiro() {
        if(this.primeiro == null) {
            throw new NoSuchElementException();
        }
        Object elemento = this.primeiro.elemento;
        this.primeiro = this.primeiro.seguinte;
        this.tamanho--;
        return elemento;
    }
    
    public Object obter(int indice) {
        verificarIndiceElemento(indice);
        return obterNo(indice).elemento;
    }
    
    public void adicionar(int indice, Object elemento) {
        verificarIndicePosicao(indice);
        if(indice == 0) {
            adicionarPrimeiro(elemento);
        } else {
            No noAnterior = obterNo(indice-1);
            No novoNo = new No(elemento, noAnterior.seguinte);
            noAnterior.seguinte = novoNo;
            this.tamanho++;
        }
    }
    
    public Object remover(int indice) {
        verificarIndiceElemento(indice);
        if(indice == 0) {
            return removerPrimeiro();
        }
        No no = obterNo(indice);
        No noAnterior = obterNo(indice - 1);
        noAnterior.seguinte = no.seguinte;
        return no;
    }
    
    public Object substituir(int indice, Object elemento) {
        verificarIndiceElemento(indice);
        No x = obterNo(indice);
        Object elementoAnterior = x.elemento;
        x.elemento = elemento;
        return elementoAnterior;
    }
    
    private No obterNo(int indice) {
        No no = this.primeiro;
        for (int i = 0; i < indice; i++) {
            no = no.seguinte;
        }
        return no;
    }
    
    private void verificarIndiceElemento(int indice) {
        if(indice < 0 || indice >= this.tamanho) {
            throw new IndexOutOfBoundsException("Indice: "+indice+", Tamanho: "+this.tamanho);
        }
    }
    
    private void verificarIndicePosicao(int indice) {
        if(indice < 0 || indice > this.tamanho) {
            throw new IndexOutOfBoundsException("Indice: "+indice+", Tamanho: "+this.tamanho);
        }
    }
        
    
    private static class No {
        public Object elemento;
        public No seguinte;
        
        public No(Object elemento, No seguinte) {
            this.elemento = elemento;
            this.seguinte = seguinte;
        }
    }
}
