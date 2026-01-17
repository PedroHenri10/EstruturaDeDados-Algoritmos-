/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mpf_2024.problemaI;

import java.util.Scanner;

/**
 *
 * @author pedro henrique
 */
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        
        int[] est = new int[N];
        for(int i =0; i<N; i++){
            est[i] = sc.nextInt();
        }
        
        boolean tipo1 = true;
        boolean tipo2 = true;
        
        for (int i = 0; i <N; i++){
            int left = 2 * i +1;
            int right = 2 * i +2;
            
            if( left < N){
                if(est[i] > est[left]) tipo1 = false;
                if(est[i] < est[left]) tipo2 = false;
            }
            
            if( right < N){
                if(est[i] > est[right]) tipo1 = false;
                if(est[i] < est[right]) tipo2 = false;
            }
            
        }
        
        if((tipo1 && tipo2) || (!tipo1 && !tipo2)) {
            System.out.println(0);
        }else if (tipo1){
            System.out.println(1);
        }else{
            System.out.println(2);
        }
    }
}
