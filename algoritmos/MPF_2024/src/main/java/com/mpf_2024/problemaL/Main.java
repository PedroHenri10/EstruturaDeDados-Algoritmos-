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
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        while(sc.hasNext()){
            String dna = sc.next();
            int len = dna.length();
            
            int maxLen = 0;
            int pos = -1;
            
            for(int i =0; i < len; i++){
                for(int j =0; j < len; j++){
                    boolean ok = true;
                    
                    int l =i;
                    int r = j;
                    
                    while(l <= r){
                        if(dna.charAt(l) != comp(dna.charAt(r))){
                            ok = false;
                            break;
                        }
                        j++;
                        r--;
                    }
                    
                    int tam = j - i +1;
                    
                    if(ok && tam > maxLen){
                        maxLen = tam;
                        pos = i +1;
                    }
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
