/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mpf_2024.problemaJ;

import java.util.Scanner;

/**
 *
 * @author pedro henrique
 */
public class Main {
    
    static final int MAX = 6;
    static final int MAX_NOME = 20;
    
    public static void main(String[] args){
         Scanner sc = new Scanner(System.in);
         int QJ, NR;
         String[] nomes = new String[MAX];
         
         int[] pontos = new int[MAX];
         
         QJ = sc.nextInt();
         
         for(int i = 0; i <QJ; i++){
             nomes[i] = sc.next();
         }
         
         NR = sc.nextInt();
         
         for(int r =0; r <NR; r++){
             int[] palitos = new int[MAX];
             int[] palpites = new int[MAX];
             int total =0;
             
             for(int i =0; i <QJ; i++){
                 palitos[i] = sc.nextInt();
                 total += palitos[i];
                 
             }
             
             for(int i = 0; i < QJ; i++){
                 palpites[i] = sc.nextInt();
             }
             
             for(int i = 0; i < QJ; i++){
                 if(palpites[i] == total){
                     pontos[i]++;
                     break;
                 }
             }
         }
         
         int max = -1;
         int empates = 0;
         int ganhador = -1;
         
         for(int i =0; i < QJ;i++){
             if(pontos[i] > max){
                 max = pontos[i];
                 ganhador = i;
                 empates = 0;
             }else if(pontos[i] == max){
                 empates = 1;
             }
         }
         
         if(empates == 1 || max ==0){
             System.out.println("EMPATE");
         }else{
             System.out.println(nomes[ganhador] + " GANHOU");
         }
         sc.close();
    }
}
