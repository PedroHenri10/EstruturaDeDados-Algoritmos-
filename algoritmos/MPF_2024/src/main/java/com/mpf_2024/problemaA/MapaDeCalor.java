/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mpf_2024.problemaA;

import java.util.Scanner;

/**
 *
 * @author pedro henrique
 */
public class MapaDeCalor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        
        int[][] matriz = new int[6][3];
        int[] regioes = new int[5];
        
        for(int user = 0; user < N; user++){
            for(int i = 0; i <6 ; i++){
                for( int j = 0; j <3; j++){
                    int valor = sc.nextInt();
                    
                    if(i == 0){
                        regioes[0] += valor;
                    }else if(i >= 1 && i <=4){
                        if(j==0){
                            regioes[1] += valor;
                        }else if(j == 1){
                            regioes[2] += valor;
                        }else{
                           regioes[3] +=valor; 
                        }
                    }else{
                        regioes[4] +=valor;
                    }
                }
            }
        }
        
        int max =0;
        for(int i = 1; i<5; i++){
            if(regioes[i]> regioes[max]){
                max = i;
            }
        }
        
        String[] nomes = {
            "Superior",
            "esquerda",
            "centro",
            "direita",
            "inferior"
        };
        
        System.out.println(nomes[max]);
        sc.close();
    }
}
