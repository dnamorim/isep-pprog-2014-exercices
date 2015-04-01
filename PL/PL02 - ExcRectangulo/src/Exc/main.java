/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Exc;

import java.util.*;

/**
 *
 * @author Duarte Nuno Amorim
 */
public class main {
    static Scanner in = new Scanner(System.in);
    
    public static void main (String[] args) {
        
        
        int opt1, opt2=0;
        float width, height;
        Rectangle rec=new Rectangle();
        
        do {
            opt1=showMenu();
            switch(opt1) {
                    case 1:
                        break;
                    case 2: 
                        width = askValue("Largura do Rectângulo");
                        height = askValue("Altura do Rectângulo");
                        rec = new Rectangle(width, height);
                        break;
                    case 3:
                        width = askValue("Lado do Quadrado");
                        rec = new Rectangle(width);
                        break;
                    case 4:
                        break;
                    default: 
                        System.out.println("\nInseriu uma Opção Inválida. Tente novamente.\n");
           }
        } while (opt1>4 || opt1<1);
        
        
        if(opt1>=1 && opt1<=3) { 
               pause();
               do {
                    opt2=showMenuOp();
                    switch(opt2) {
                    case 1:
                        width = askValue("Largura do Rectângulo");
                        height = askValue("Altura do Rectângulo");
                        rec.setWidthHeight(width, height);
                        break;
                    case 2: 
                        System.out.println("Área Rectângulo: "+rec.area());
                        break;
                    case 3:
                        System.out.println("Perímetro Rectângulo: "+rec.perimeter());
                        break;
                    case 4:
                        System.out.println(rec.toString());
                        break;
                    case 5:
                        System.out.println("Altura Rectângulo: " + rec.getHeight());
                        break;
                    case 6:
                        System.out.println("Largura Rectângulo: " + rec.getWidth());
                        break;
                    case 7:
                        break;
                    default: 
                        System.out.println("\nInseriu uma Opção Inválida. Tente novamente.\n");
                }
                pause();
               } while(opt2!=7);
        }
    }
    
    private static int showMenuOp() {
        System.out.print("\n\n1. Re-definir Valores\n2. Calcular Área\n3. Calcular Perímetro\n4. Descrição Textual\n5. Obter Altura\n6. Obter Largura\n7. Sair do Programa\nInsira a sua Opção: ");
        int opt = in.nextInt();
        in.nextLine();
        return opt;
    }
    
    private static int showMenu() {
        System.out.print("1. Criar um Rectângulo Sem-Valores\n2. Criar um Rectângulo\n3. Criar um Quadrado\n4. Sair\nInsira a sua Opção: ");
        int opt = in.nextInt();
        in.nextLine();
        return opt;
    }
    
    private static float askValue(String msg) {
        System.out.printf("%s? ", msg);
        float val = in.nextFloat();
        in.nextLine();
        return val;
    }
    
    private static void pause() {
        System.out.print("\n---- Pressione qualquer tecla para continuar. ----\n");
        in.nextLine();
    }
}

