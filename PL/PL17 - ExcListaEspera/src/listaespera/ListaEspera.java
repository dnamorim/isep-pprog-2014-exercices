/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package listaespera;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 *
 * @author Duarte Nuno Amorim <1130674@isep.ipp.pt>
 */
public class ListaEspera {
    private LinkedList<String> list;
    
    public ListaEspera() {
        this.list = new LinkedList<>();
    }
    
    public void addLista(String nome) {
        this.list.add(nome);
    }
    
    public void removeLastLista() {
        if(list.size() != 0) {
            this.list.remove();
        } else {
            throw new NoSuchElementException();
        }
    }
    
    public String showLista() {
        if(list.isEmpty()) {
            throw new NoSuchElementException();
        }
        String strList = "";
        for (String str : this.list) {
            strList += String.format("%s%n",str);
        }
        return strList;
    }
    
}
