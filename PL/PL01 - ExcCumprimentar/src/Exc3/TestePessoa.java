/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Exc3;

/**
 *
 * @author Duarte Nuno Amorim
 */
import java.util.Scanner;

public class TestePessoa {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in, "ISO8859-1");
        
        System.out.printf("%s: ","Defina um Nome");
        String nome = in.nextLine();
        
        System.out.printf("%s %s: ", "Defina a Idade da Pessoa", nome);
        int idade = in.nextInt();
        
        Pessoa p1 = new Pessoa(nome, idade); //criar objecto
        
        System.out.printf("%s %n Nome: %s%n Idade: %d%n", "DADOS ACTUAIS DO OBJECTO:", p1.getNome(), p1.getIdade());
        
        in.nextLine();
        
        System.out.printf("%n%s: ","Defina um novo Nome");
        nome = in.nextLine();
        
        System.out.printf("%s %s: ", "Defina uma nova idade da Pessoa", nome);
        idade = in.nextInt();
        
        p1.setNome(nome);
        p1.setIdade(idade);
        
        System.out.printf("%n%s%n",p1.toString());
    }
}
