/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package torreshanoi;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Duarte Nuno Amorim <1130674@isep.ipp.pt>
 */
public class TorresHanoi {

    static Stack[] towers = new Stack[3];
    static Scanner in = new Scanner(System.in);
    static Formatter out = new Formatter(System.out);
    static int size;
    
    public static void main(String[] args) {
        out.format("--- TORRES DE HANOI ---%n%n");
        
        do {
            out.format("Quantidade de discos? ");
            size = in.nextInt();
            in.nextLine();
        } while(size<3);   
        createTowers();
        
        int a, b;
        
        while(!validateEndGame()) {
            showTowers();
            boolean validTower = true;
            do {
                out.format("Mover Peça da Torre? ");
                a = in.nextInt();
                out.format("Mover Peça para Torre? ");
                b = in.nextInt();
                
                if(a < 1 || a > 3 || b < 1 || a > 3) {
                    validTower = false;
                }
                out.format("%n");
            } while(!validTower);
            moveDisk(a-1,b-1);
        }
        if(validateEndGame()) {
            showTowers();
            System.out.println("Parabéns! Dominou o jogo Torres de Hanói");
        }
        
    }
    
    public static void showTowers() {
        out.format("%n");
        for (int i = 0; i < towers.length; i++) {
            out.format("Torre %d: %s%n", i+1, towers[i]);
        }
        out.format("%n");
    }
    
    public static void createTowers() {
        towers[0] = new Stack();
        towers[1] = new Stack();
        towers[2] = new Stack();
        for(int i = size; i > 0; i--) {
            towers[0].push(i);
        }
    }
    
    public static boolean validateEndGame() {
        if(towers[2].size() == size) {
            return true;
        } 
        return false;
    }
    
    public static void moveDisk(int a, int b) {
        if(towers[b].isEmpty()) {
            towers[b].push(towers[a].pop());
        } else if((int) (towers[a].peek()) < (int)(towers[b].peek())) {
            towers[b].push(towers[a].pop());
        }
    }
    

            
    
}
