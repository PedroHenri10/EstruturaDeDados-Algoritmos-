/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mpf_2024.problemaL;

import java.util.Scanner;

/**
 *
 * @author pedro henrique
 */
public class Main {
    static char comp(char c){
        switch(c){
            case 'A': return 'T';
            case 'T': return 'A';
            case 'C': return 'G';
            case 'G': return 'C';
        }
        return ' ';
    }
    
    static boolean match(String s, int l, int r){
        return s.charAt(l) == comp(s.charAt(r));
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        while(sc.hasNext()){
            String dna = sc.next();
            int n = dna.length();
            
            int maxLen = 0;
            int pos = -1;
            
            for(int  c=0; c < n -1 ; c++){
                int l =c;
                int r = c+1;
                
                while(l >=0 && r<n && match(dna, l,r)){
                    int tam = r - l + 1;

                    if (tam >= 4 && tam > maxLen) {
                        maxLen = tam;
                        pos = l + 1;
                    }
                        l--;
                        r++;
                    }
                }
            
                if(maxLen == 0){
                    System.out.println("false");
                }else{
                    System.out.println(pos + " " + maxLen);
                }
            }
           
        sc.close();
    }
}
