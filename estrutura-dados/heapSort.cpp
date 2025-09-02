/*nome: heapSort.cpp
author: Pedro Henrique
date: 21/05/2025
description: implementação do algoritmo do método de ordenação heap sort
*/

#include <stdio.h>
#include <stdlib.h>

//prototipacao
void heapfy(int *, int, int); //heapfy(int vet[], tam, i)
void heapSort(int *, int);//heapSort(int vet[], tam);

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
	
	heapSort(vet, tam); // involke da função
	
	printf("\n vetor ordenado com heap sort: ");
	for(i =0; i<tam;i++){
		printf(" %d |", vet[i]);
	}
		
	return 0;
}

//funcao recursiva que sempre testa se o no pai é MAIOR que seus filhos no cado do MAX heap
	void heapfy(int vet[], int tam, int i){
		int maior = i;
		int esq = 2 * i +1; //filho da esquerda
		int dir = 2 * i + 2; // filho da direita
		
		if(esq < tam && vet[esq] > vet[maior]){
			maior = esq;
		}
		
		if(dir < tam && vet[dir] > vet[maior])
			maior = dir;
			
		if(maior != i){
			int aux = vet[i];
			vet[i] = vet[maior];
			vet[maior] = aux;
			
			heapfy(vet, tam, maior);
		}
		
	}//fim da funcao recursiva heapfy

//funcao do HeapSort
void heapSort(int vet[], int tam){
	for(int i = tam/2 - 1; i>=0;i--){
		heapfy(vet, tam, i);
	}
	
	//faz o swap
	for(int i = tam -1; i >0; i--){
		int aux = vet[0];
		vet[0] = vet[i];
		vet[i] = aux;
		
		heapfy(vet, i, 0);
	}
		
}
