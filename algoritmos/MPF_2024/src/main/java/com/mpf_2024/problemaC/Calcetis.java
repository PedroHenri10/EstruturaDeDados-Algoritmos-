/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mpf_2024.problemaC;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author pedro henrique
 */
public class Calcetis {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int V = sc.nextInt();
        int N = sc.nextInt();
        
        int[] precos = new int[N];
        for(int i=0; i <N; i++){
            precos[i] = sc.nextInt();
        }
        
        int alvo =200 -V;
        
        Arrays.sort(precos);
        
        Boolean encontrado = false;
        
        for(int i=0; i<N -2 && !encontrado; i++){
            int inicio = i+1;
            int fim= N -1;
            
            while(inicio<fim){
                int soma = precos[i] + precos[inicio] + precos[fim];
                
                if(soma == alvo){
                    encontrado = true;
                    break;
                }else if(soma < alvo){
                    inicio++;
                }else{
                    fim--;
                }
            }
        }
        if(encontrado){
            System.out.println("fretegratis");
        }else{
            System.out.println("fretepago");
        }
        
        sc.close();
    }
}
