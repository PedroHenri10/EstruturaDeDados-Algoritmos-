package com.mpf_2024.problemaG;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (!sc.hasNextInt()) return;
        int V = sc.nextInt();
        sc.nextLine(); 
        
        List<String>[] categorias = new ArrayList[6];
        for (int i = 0; i < 6; i++) {
            categorias[i] = new ArrayList<>();
        }
        
        List<String> espera = new ArrayList<>();
        int atendidos = 0;
        
        while (sc.hasNextLine()) {
            String linha = sc.nextLine().trim();
            
            if (linha.isEmpty()) break; 
            
            String[] partes = linha.split("\\s+");
            String nome = partes[0];
            
            if (atendidos < V) {
                atendidos++;
                for (int i = 1; i < partes.length; i++) {
                    int cat = Integer.parseInt(partes[i]);
                    categorias[cat - 1].add(nome);
                }
            } else {
                espera.add(nome);
            }
        }
        
        String[] nomesCat = {
            "ALGORITMOS", "BOAS PRATICAS", "DESEMPENHO", 
            "FLUXOGRAMAS", "INTERPRETACAO DE ENUNCIADOS", "SINTAXE DA LINGUAGEM"
        };
        
        String hifens = "------------------------------";
        
        for (int i = 0; i < 6; i++) {
            System.out.println(hifens);
            System.out.println(nomesCat[i]);
            System.out.println(hifens);
            Collections.sort(categorias[i]);
            for (String nome : categorias[i]) {
                System.out.println(nome);                
            }
            if (i < 5) System.out.println();
        }
        
        if (!espera.isEmpty()) {
            System.out.println();
            System.out.println(hifens);
            System.out.println("FICA PARA A PROXIMA!");
            System.out.println(hifens);
            for (String nome : espera) {
                System.out.println(nome); 
            }
        }
        sc.close();
    }
}
