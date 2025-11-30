/*nome: quickSort.cpp
author: Pedro Henrique
date: 28/05/2025
description: implementação do metodo de ordenanção quick sort feitos em sala.
*/

#include <stdio.h>
#include <stdlib.h>
 
// Prototipação
void quickSort(int *, int, int);
int partition(int *, int, int);

int main(){
	
	int i = 0;
	int vet [] = {35, 72, 17, 3, 28, 93, 54, 12, 21, 45};
	 //int vet[] = {93, 72, 54, 45, 35, 28, 21, 17, 12, 3};
	// int vet[] = {3, 12, 17, 21, 28, 35, 45,54,72,93};
	
	int tam = sizeof(vet)/sizeof(int);

	printf("\n vetor desordenado:");
	for(i =0; i<tam;i++){
		printf(" %d |", vet[i]);
	}
	
	quickSort(vet, 0, tam -1); // involke da função
	
	printf("\n vetor ordenado com quick Sort: ");
	for(i =0; i<tam;i++){
		printf(" %d |", vet[i]);
	}
		
	return 0;
}//fim do main

//funcao Quick Sort para a esquerda e direita das partições
void quickSort(int *vet, int inicio, int fim){
	int pivot = 0;
	
	if(inicio < fim){
		pivot = partition(vet, inicio, fim);
		quickSort(vet, inicio, pivot - 1); //quick Sort para lado esquerdo
		quickSort(vet,pivot +1, fim); //lado direito
	}
}

//funcao para particionar o conjunto de dados(vetor)
int partition(int *vet, int inicio, int fim){
	int pivot, aux;	
	pivot = vet[inicio];
	int indicePivot = inicio;
	while(fim > inicio){
		while(vet[inicio] <= pivot)
			inicio++;
		while(vet[fim] > pivot)
			fim--;
			
		if(inicio < fim){
			aux = vet[inicio];
			vet[inicio] = vet[fim];
			vet[fim] = aux;
		}
	}//fim do while que caminha para as duas direções
		vet[indicePivot] = vet[fim];
		vet[fim] = pivot;
		return fim;
}
