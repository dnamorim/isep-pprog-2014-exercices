/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package listaligada;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.NoSuchElementException;

/**
 *
 * @author Duarte Nuno Amorim <1130674@isep.ipp.pt>
 */
public class ListaLigada<E> {
    
    private No<E> primeiro;
    private int tamanho;
    
    public ListaLigada() {
        this.primeiro = null;
        this.tamanho = 0;
    }
    
    public ListaLigada(Collection <? extends E> c) {
        this();
        adicionarTodos(c);
    }
    
    public int getTamanho() {
        return this.tamanho;
    }
    
    public void adicionarPrimeiro(E elemento) {
        No<E> novoNo = new No(elemento, this.primeiro);
        this.primeiro = novoNo;
        this.tamanho++;
    }
    
    public E obterPrimeiro() {
        if(this.primeiro == null) {
            throw new NoSuchElementException();
        }
        return this.primeiro.elemento;
    }
    
    public E obter(int indice) {
        verificarIndiceElemento(indice);
        return obterNo(indice).elemento;
    }
    
    private No<E> obterNo(int indice) {
        No<E> no = this.primeiro;
        for (int i = 0; i < indice; i++) {
            no = no.seguinte;
        }
        return no;
    }
    
    public final void adicionarTodos(Collection<? extends E> c) {
        for (E e : c) {
            adicionar(this.tamanho, e);
        }
    }
    
    public void adicionar(int indice, E elemento) {
        verificarIndicePosicao(indice);
        if(indice == 0) {
            adicionarPrimeiro(elemento);
        } else {
            No<E> noAnterior = obterNo(indice-1);
            No<E> novoNo = new No<>(elemento, noAnterior.seguinte);
            noAnterior.seguinte = novoNo;
            this.tamanho++;
        }
    }
    
    public Object remover(int indice) {
        verificarIndiceElemento(indice);
        if(indice == 0) {
            return removerPrimeiro();
        }
        No<E> no = obterNo(indice);
        No<E> noAnterior = obterNo(indice-1);
        noAnterior.seguinte = no.seguinte;
        this.tamanho--;
        return no.elemento;        
    }
    
    public Object substituir(int indice, E elemento) {
        verificarIndiceElemento(indice);
        No<E> x = obterNo(indice);
        E elementoAnterior = x.elemento;
        x.elemento = elemento;
        return elementoAnterior;
    }
    
    public E removerPrimeiro() {
        if(this.primeiro == null) {
            throw new NoSuchElementException();
        }
        E elemento = this.primeiro.elemento;
        this.primeiro = this.primeiro.seguinte;
        this.tamanho--;
        return elemento;
    }
    
    private void verificarIndiceElemento(int indice) {
        if(indice < 0 || indice >= this.tamanho) {
            throw new IndexOutOfBoundsException();
        }
    }
    
    private void verificarIndicePosicao(int indice) {
        if(indice < 0 || indice > this.tamanho) {
            throw new IndexOutOfBoundsException("Indice: "+indice+", Tamanho: "+this.tamanho);
        }
    }
    
    public <T> T[] paraVector(T[] v) {
        if(v.length < this.tamanho) {
            v = (T[]) Array.newInstance(v.getClass().getComponentType(), this.tamanho);
        }
        
        No<E> no = this.primeiro;
        for (int i = 0; i < this.tamanho; i++) {
            v[i] = (T) no.elemento;
            no = no.seguinte;
        }
        
        if(v.length > this.tamanho) {
            v[this.tamanho] = null;
        } 
        
        return v;
    }
    
    public static class No<E> {
        public E elemento;
        public No<E> seguinte;
        
        public No(E elemento, No<E> seguinte) {
            this.elemento = elemento;
            this.seguinte = seguinte;
        }
    }

}
