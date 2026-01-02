/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mpf_2024.problemaD;

import java.util.Scanner;

/**
 *
 * @author pedro henrique
 */
public class Main {
    static final double PI =3.1415;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int N;
        double grau;
        
        N = sc.nextInt();
        grau = sc.nextDouble();
        
        double rad = grau * PI / 180.0;
        
        double cosT = Math.cos(rad);
        double sinT = Math.sin(rad);
        
        for(int i =0; i <N; i++){
            double x = sc.nextDouble();
            double y = sc.nextDouble();
            
            double x2 = x * cosT - y * sinT; 
            double y2 = x * sinT + y * cosT; 
            
            System.out.printf("%.2f %.2f%n", x2, y2);
        }
        
        sc.close();
    }
}
