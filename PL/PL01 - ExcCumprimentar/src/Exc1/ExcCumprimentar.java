package Exc1;

/*-
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;
import java.util.Formatter;

/**
 *
 * @author Duarte Nuno Amorim
 */
public class ExcCumprimentar {
    static Scanner in = new Scanner(System.in, "ISO8859-1");
    static Formatter out = new Formatter(System.out);
    
    private static String askName() {
        out.format("%s%n","Defina um Nome:");
        String name = in.nextLine();
        return name;
    }
    
    private static void outHello(String name) {
        out.format("%nAhoy %s!%n", name);   
    }
    
    public static void main (String[] args) {
        String name=askName();
        outHello(name);
    } 

}
