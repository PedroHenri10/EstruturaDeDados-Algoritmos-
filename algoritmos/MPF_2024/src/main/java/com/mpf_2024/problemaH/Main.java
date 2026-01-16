/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mpf_2024.problemaH;

import java.util.Scanner;

/**
 *
 * @author pedro henrique
 */
public class Main {
    
    public static int pivo(int a, int b, int c){
        if ((a >= b && a <= c) || (a<=b && a >= c)){
            return a;
        }
        if ((b >= a && b <= c) || (b <= a && b >= c)){
            return b;
        }
        return c;
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        
        System.out.println(pivo(a , b, c));
        
        sc.close();
    }
}
