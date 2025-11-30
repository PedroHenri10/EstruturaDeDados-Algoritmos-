/*
Name: BubbleSort.cpp
Author: PH
Date: 16/04/25 11:16
Description: Programa para demonstrar o método de ordenação bubble sort
*/
 
# include <stdio.h>
 
main()
  {
      int tam, i, aux;
      int vetor[] = {35, 72, 17, 3, 28, 93, 54, 12, 21, 45};
      tam = sizeof(vetor)/sizeof(int);
      puts("\nVetor desordenado:");
    
      for(i = 0; i < tam; i++)
      {
        printf(" %.2d |", vetor[i]);
      }
      while(tam > 0)
      {
        for(int i = 0; i < tam-1; i++)
        {
        
          if(vetor[i] > vetor[i+1])
          {
            aux = vetor[i+1];
            vetor[i+1] = vetor[i];
            vetor[i] = aux;
          }
        }
      tam--;
      } //fim do while
      tam = sizeof(vetor)/sizeof(int);
       
      puts("\nVetor ordenado com bubble sort: ");
      for(i = 0; i < tam; i++)
      {
        printf(" %.2d |", vetor[i]);
  }
} //fim do programa
