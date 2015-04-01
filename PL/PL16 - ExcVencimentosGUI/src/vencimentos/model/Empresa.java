/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vencimentos.model;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Duarte Nuno Amorim <1130674@isep.ipp.pt>
 */
public class Empresa {

    private static ArrayList<Trabalhador> workers = new ArrayList<>();
    
    private Empresa() {
    }
    
    public static Trabalhador[] getTrabalhadores() {
        return workers.toArray(new Trabalhador[workers.size()]);
    }
 
    public static String[] getTrabalhadoresAbrv() {
        String[] trab = new String[workers.size()];
        for (int i=0; i < Empresa.workers.size(); i++) {
            Trabalhador t = Empresa.workers.get(i);
            
            if(t instanceof TrabPeca) {
                trab[i] = String.format("Trabalhador à Peça: %s", t.getNome());
            }
            if(t instanceof TrabHora) {
                trab[i] = String.format("Trabalhador à Hora: %s", t.getNome());
            }
            if(t instanceof TrabCom) {
                trab[i] = String.format("Trabalhador à Comissão: %s", t.getNome());
            }
        }
        return trab;
    }
    
    public static Trabalhador obterTrabalhador(String nome) {
        for (Trabalhador t : workers) {
            if (t.getNome().equalsIgnoreCase(nome)) {
                return t;
            }
        }
        return null;
    }
    
    public static void addWorker(Trabalhador t) {
        Empresa.workers.add(t);
    }
    
    public static boolean removeWorker(Trabalhador t) {
        return Empresa.workers.remove(t);
    }
    
    public static int qtyWorkers() {
        return Empresa.workers.size();
    }
    
    public static String[] listaTrabalhadores() {
        String[] trab = new String[Empresa.workers.size()];
        for (int i = 0; i < Empresa.workers.size(); i++) {
            Trabalhador t = Empresa.workers.get(i);
            if(t instanceof TrabPeca) {
                trab[i] = String.format("Trabalhador à Peça: %s", t.getNome());
            }
            if(t instanceof TrabHora) {
                trab[i] = String.format("Trabalhador à Hora: %s", t.getNome());
            }
            if(t instanceof TrabCom) {
                trab[i] = String.format("Trabalhador à Comissão: %s", t.getNome());
            }}
       
        return trab;
    }
    
    public static void saveFile() throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data.bin"));
        out.writeObject(Empresa.workers);
        out.close();
    }
    
    public static void readFile() throws IOException, ClassNotFoundException  {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("data.bin"));
        Empresa.workers = (ArrayList<Trabalhador>) in.readObject();
        in.close();
    }
    
    public static void readFileText(String file) throws FileNotFoundException {
        Scanner in = new Scanner(new File(file), "UTF-8");
        
        while(in.hasNext()) {
            String[] aux = in.nextLine().split(";");
            
            if(aux[0].equals("TrabPeca")) {
                TrabPeca tp = new TrabPeca(aux[1], Integer.parseInt(aux[2]), Integer.parseInt(aux[3]));
                Empresa.addWorker((Trabalhador) tp);
            }
            if(aux[0].equals("TrabHora")) {
                TrabHora th = new TrabHora(aux[1], Integer.parseInt(aux[2]), Float.parseFloat(aux[3]));
                Empresa.addWorker((Trabalhador) th);
            }
            if(aux[0].equals("TrabCom")) {
                TrabCom tc = new TrabCom(aux[1], Float.parseFloat(aux[2]), Float.parseFloat(aux[3]), Float.parseFloat(aux[4]));
                Empresa.addWorker((Trabalhador) tc);

            }
            
        }
        
    }
    
    public static void saveToTextFile(String f) throws FileNotFoundException, UnsupportedEncodingException {
            PrintWriter out = new PrintWriter(new File(f), "UTF-8");

            for (Trabalhador t : Empresa.workers) {
                if(t instanceof TrabPeca) {
                    TrabPeca tp = (TrabPeca) t;
                    out.format("Trabalhador à Peça: %s%nNº de Peças 1: %d%nNº de Peças 2: %d%n", tp.getNome(), tp.getNumPecas1(), tp.getNumPecas2());
                }
                if(t instanceof TrabHora) {
                    TrabHora th = (TrabHora) t;
                    out.format("Trabalhador à Hora: %s%nNº de Horas: %d%nPagamento p/ Hora: %.2f €%n", th.getNome(), th.getNumHoras(), th.getPagHora());
                }
                if(t instanceof TrabCom) {
                    TrabCom tc = (TrabCom) t;
                    out.format("Trabalhador à Comissão: %s%nSalário: %.2f €%nVendas: %.2f €%nComissão: %.2f %% %n", tc.getNome(), tc.getSalarioBase(), tc.getVendas(), tc.getComissao());
                }
                out.format("%n");
            }
            
            out.close();
    }
        
}
