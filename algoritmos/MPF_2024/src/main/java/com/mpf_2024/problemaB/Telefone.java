/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mpf_2024.problemaB;

import java.util.Scanner;

/**
 *
 * @author pedro henrique
 */
public class Telefone {
    
    static char letraParaNumero(char c){
        c = Character.toUpperCase(c);
        
        if(c >= 'A' && c <= 'C') return '2';
        if(c >= 'D' && c <= 'F') return '3';
        if(c >= 'G' && c <= 'I') return '4';
        if(c >= 'J' && c <= 'L') return '5';
        if(c >= 'M' && c <= 'O') return '6';
        if(c >= 'P' && c <= 'S') return '7';
        if(c >= 'T' && c <= 'V') return '8';
        if(c >= 'W' && c <= 'Z') return '9';
        return '0';
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        
        for(int i =0; i<N; i++){
            String palavra = sc.next();
            
            StringBuilder resultado = new StringBuilder();
            
            for(int j =0; j<palavra.length();j++){
                resultado.append(letraParaNumero(palavra.charAt(j)));
                
            }
            
            System.out.println(resultado);
        }
        
        sc.close();
    }
    
}
