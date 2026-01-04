/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mpf_2024.problemaF;

import java.util.Scanner;

/**
 *
 * @author pedro henrique
 */
public class Main {
    static boolean isDigitStr(String str){
        for(int i =0; i<str.length(); i++){
          if(!Character.isDigit(str.charAt(i))){
              return false;
          }  
        }
        return true;
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        String placa = sc.next();
        int len = placa.length();
        
        if((placa.charAt(0) == 'A' || placa.charAt(0) == 'P') && len >= 2 && len <=6){
            boolean ok = true;
            for(int i =1; i < len;i++){
                if(!Character.isDigit(placa.charAt(i))){
                    ok = false;
                    break;
                }
            }
            
            if(ok){
                System.out.println("Placa muito antiga");
                return;
            }
        }
            
            if(len <=7 && isDigitStr(placa)) {
                System.out.println("Placa numerica");
                return;
            }
            
            if(len ==6 && Character.isLetter(placa.charAt(0)) &&
               Character.isLetter(placa.charAt(1)) && Character.isDigit(placa.charAt(2)) &&
               Character.isDigit(placa.charAt(3)) && Character.isDigit(placa.charAt(4)) &&
               Character.isDigit(placa.charAt(5))) 
            {
                System.out.println("Placa AA-9999");
                return;
            }
            
            if(len ==7 && Character.isLetter(placa.charAt(0)) &&
               Character.isLetter(placa.charAt(1)) && Character.isLetter(placa.charAt(2)) &&
               Character.isDigit(placa.charAt(3)) && Character.isDigit(placa.charAt(4)) &&
               Character.isDigit(placa.charAt(5)) &&
               Character.isDigit(placa.charAt(6))) 
            {
                System.out.println("Placa AAA-9999");
                return;
            }
            
            if(len ==7 && Character.isLetter(placa.charAt(0)) &&
               Character.isLetter(placa.charAt(1)) && Character.isLetter(placa.charAt(2)) &&
               Character.isDigit(placa.charAt(3)) && Character.isLetter(placa.charAt(4)) &&
               Character.isDigit(placa.charAt(5)) &&
               Character.isDigit(placa.charAt(6))) 
            {
                System.out.println("Placa Mercosul");
                return;
            }
        
            System.out.println("Placa Invalida");
    }
    
}
