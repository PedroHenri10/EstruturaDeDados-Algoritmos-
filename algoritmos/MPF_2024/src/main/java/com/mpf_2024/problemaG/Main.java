/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mpf_2024.problemaG;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author pedro henrique
 */
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int V = sc.nextInt();
        
        sc.nextLine();
        
        List<String>[] categorias = new ArrayList[6];
        for(int i =0; i < 6 ; i++){
            categorias[i] = new ArrayList<>();
        }
        
        List<String> espera = new ArrayList<>();
        
        int atendidos =0;
        
        while(sc.hasNextLine()){
             String linha = sc.nextLine().trim();
             if(linha.isEmpty()) continue;
             
             String[] partes = linha.split(" ");
             String nome = partes[0];
             
             if(atendidos < V){
                 atendidos++;
                 
                 for(int i =1; i <partes.length; i++){
                     int cat = Integer.parseInt(partes[i]);
                     
                     categorias[cat - 1].add(nome);
                 }
             }else{
                 espera.add(nome);
             }
        }
        
        String[] nomesCat = {
            "ALGORITMOS",
            "BOAS PRATICAS",
            "DESEMPENHO",
            "FLUOXGRAMAS",
            "INTERPRETACAO DE ENUNCIADOS",
            "SINTAXE DA LINGUAGEM"
        };
        
        for(int i=0;i<6;i++){
            System.out.println("---------------------------------------------------------");
            System.out.println(nomesCat[i]);
            System.out.println("---------------------------------------------------------");
            
            Collections.sort(categorias[i]);
            for(String nome : categorias[i]){
                System.out.println(nome);                
            }
            
            if(i<5) System.out.println();
        }
        
        if(!espera.isEmpty()){
            System.out.println();
            System.out.println("---------------------------------------------------------");
            System.out.println("FICA PARA A PROXIMA");
            System.out.println("---------------------------------------------------------");
            
            for(String nome : espera){
                System.out.println(nome); 
            }
        }
        
        sc.close();
    }
}
