/*nome: buscaBinaria.cpp
author: Pedro Henrique
date: 04/06/2025
description: implementação do metodo de recuperação de informação com o algoritmo da busca linear ou sequencial
*/

#include <stdio.h>
#include <stdlib.h>
 
int main(){
	//int vet [] = {35, 72, 17, 3, 28, 93, 54, 12, 21, 45};
	//int vet[] = {93, 72, 54, 45, 35, 28, 21, 17, 12, 3};
	int vet[] = {3, 12, 17, 21, 28, 35, 45,54,72,93};
	
	int seek, i;
	int tam = sizeof(vet)/sizeof(int);

	printf("\n vetor desordenado:");
	
	for(i =0; i<tam;i++){
		printf(" %d |", vet[i]);
	}
	
	printf("\n\ndigite o numero que vc quer buscar: ");
	scanf("%d", &seek);
	
	int flag = 0;
	int indiceAchado;
	int comp = 0;
	
	while(flag != 1){
		for(i = 0; i<tam; i++){
			comp++;
			if(vet[i] == seek){
				flag =1;
				indiceAchado = i;
				break;
			}
			
		}//fim do for
	}//fim do while
	
	
	if(flag == 1){
		printf("O %d buscado esta na posicao %d\n\n", vet[indiceAchado], indiceAchado +1);		
	}else{
		puts("o elemento não foi encontrado");
	}
	
	printf("\n ====> comparacoes %d", comp);	
	
	return 0;
}//fim do prograna
