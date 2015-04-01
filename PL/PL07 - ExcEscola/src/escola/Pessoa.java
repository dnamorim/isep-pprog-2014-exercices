/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package escola;

import java.util.Objects;

/**
 *
 * @author Duarte Nuno Amorim <1130674@isep.ipp.pt>
 */
public class Pessoa {
    
    private String nome;
    
    private String email;
    
    private int nif;
    
    public Pessoa(String nome, String email, int nif) {
        this.nome=nome;
        this.email=email;
        this.nif=nif;
    }
    
    public Pessoa() {
        this("Sem nome", "Sem E-Mail", 999999999);
    }
    
    public Pessoa(Pessoa outraPessoa) {
        this(outraPessoa.getNome(), outraPessoa.getEmail(), outraPessoa.getNif());
    }

    /**
     * @return nome da Pessoa
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * @return email da Pessoa
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * @return nif da Pessoa
     */
    public int getNif() {
        return this.nif;
    }

    /**
     * @param nome novo nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @param email novo email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @param nif novo nif
     */
    public void setNif(int nif) {
        this.nif = nif;
    }
    
    @Override
    public String toString() {
        return String.format("Nome: %s  E-Mail: %s  NIF: %d", this.nome, this.email, this.nif);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.nome);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }
    
    
}
