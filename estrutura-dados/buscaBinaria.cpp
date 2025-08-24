/*nome: buscaBinaria.cpp
author: Pedro Henrique
date: 04/06/2025
description: implementação da busca binaria ou logaritmica
*/

#include <stdio.h>
#include <stdlib.h>
 
int main(){
	
	int i = 0;
	int inicio, fim, meio;
	int elem;
	int seek;
	int comp = 0;
	//int vet [] = {35, 72, 17, 3, 28, 93, 54, 12, 21, 45};
	 //int vet[] = {93, 72, 54, 45, 35, 28, 21, 17, 12, 3};
	int vet[] = {3, 12, 17, 21, 28, 35, 45,54,72,93};
	
	int tam = sizeof(vet)/sizeof(int);

	printf("\n vetor desordenado:");
	for(i =0; i<tam;i++){
		printf(" %d |", vet[i]);
	}
	
	printf("\n\ndigite o numero que vc quer buscar: ");
	scanf("%d", &seek);
	
	int flag = 0;
	inicio = 0;
	fim = tam - 1; 
	
	while(flag != 1 && inicio <= fim){
		meio = (inicio + fim)/2;
		
		comp++;
		if(vet[meio] == seek)
			flag = 1;
		if(vet[meio] > seek)
			fim = meio - 1;
		else
			inicio = meio + 1;
		
	}//fim do while
	
	if(flag == 1){
		printf("O %d buscado esta na posicao %d", vet[meio], meio +1);
		printf("\n ====> comparacoes %d", comp);	
	}else{
		puts("o elemento não foi encontrado");
	}
}//fim do programa
 
