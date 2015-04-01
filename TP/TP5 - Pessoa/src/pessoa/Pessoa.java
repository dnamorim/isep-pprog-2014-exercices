/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pessoa;

/**
 *
 * @author Duarte Nuno Amorim <1130674@isep.ipp.pt>
 */
public class Pessoa {

    private String nome;
    private int numeroBI;
    
    private final static String NOME_POR_OMISSAO = "Sem nome";
    
    public Pessoa(String nome, int numeroBI) {
        setNome(nome);
        setNumeroBI(numeroBI);
    }
    
    public Pessoa() {
        this(Pessoa.NOME_POR_OMISSAO, 0);
    }
    
    public Pessoa(Pessoa outraPessoa) {
        this(outraPessoa.nome, outraPessoa.numeroBI);
    }

    public String getNome() {
        return this.nome;
    }

    public int getNumeroBI() {
        return this.numeroBI;
    }

    public void setNome(String nome) {
        if(nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome é Inválido");
        }
        this.nome = nome;
    }

    public void setNumeroBI(int numeroBI) {
        if(numeroBI<0 || numeroBI > 999999999) {
            throw new IllegalArgumentException("Número BI inválido");
        }
        this.numeroBI = numeroBI;
    }
    
    @Override
    public String toString() {
        return this.nome + " tem o BI número "+ this.numeroBI;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
            
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
            
        }
        Pessoa p = (Pessoa) obj;
        return this.nome.equalsIgnoreCase(p.nome) && this.numeroBI == p.numeroBI;
    }
}
