/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mpf_2024.problemaE;

import java.util.Scanner;

/**
 *
 * @author pedro henrique
 */
public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int Q = sc.nextInt();
        
        int[] requisitos = new int[15];
        
        for(int i =0; i< Q; i++){
            requisitos[i] = sc.nextInt();
        }
        
        int V = sc.nextInt();
        
        for(int i =0; i < V; i++){
            int[] voluntarios = new int[15];
            String regiao = sc.next();
            
            for(int j =0; j<Q; j++){
                voluntarios[j] = sc.nextInt();
            }
            
            int grupos = voluntarios[0] / requisitos[0];
            
            for(int j =0; j<Q;j++){
                int pode = voluntarios[j] / requisitos[j];
                
                if(pode < grupos){
                    grupos = pode;
                }
            }
            
            System.out.println(regiao + " " + grupos);
        }
        sc.close();
    }
}
