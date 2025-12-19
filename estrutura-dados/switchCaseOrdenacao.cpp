/*nome: switchCaseOrdenacao.cpp
author: Pedro Henrique
date: 21/05/2025
description: implementação do switch case dos metodos de ordenanção feitos em sala.
*/

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
 
// Prototipação dos métodos de ordenação
void heapfy(int *, int, int);
void heapSort(int *, int);
void mergeSort(int *, int, int);
void merge(int *, int, int, int);
void insertionSort(int *, int);
void selectionSort(int *, int);
void bubbleSort(int *, int);
void printVetor(int *, int);
void quickSort(int *, int, int);
int partition(int *, int, int);
void printVetor(int *, int);
 
//variaveis globais
int copia = 0; 
 
int main() {
    int opcao;
    int tam = 1000;
    int vet[tam];
    int vetAux[tam];
    int i;
    int inicioMerge, fimMerge;
    inicioMerge = 0;
    fimMerge = tam-1;
    char continuar;
 
 	for(i = 0; i < tam; i++){
        vet[i] = rand() % 1000;  
    }
 
do {
        // Copia do vetor original para auxiliar antes de cada ordenação
        for(i = 0; i < tam; i++){
            vetAux[i] = vet[i];
        }
 
        printf("Escolha o algoritmo de ordenacao:\n");
        printf("1 - Heap Sort\n");
        printf("2 - Merge Sort\n");
        printf("3 - Insertion Sort\n");
        printf("4 - Selection Sort\n");
        printf("5 - Bubble Sort\n");
        printf("6 - Quick Sort\n");
        printf("0 - Sair\n");
        printf("Opcao: ");
        scanf("%d", &opcao);
 
        if(opcao == 0){
            printf("\nSaindo...\n");
            break;
        }
 
        printf("\nVetor desordenado:");
        printVetor(vetAux, tam);
 
        clock_t start, end;
        double cpu_time_used;
 
        start = clock();
 
        switch (opcao) {
            case 1:
                printf("\nHeap Sort:\n");
                heapSort(vetAux, tam);
                break;
            case 2:
                printf("\nMerge Sort:\n");
                mergeSort(vetAux, inicioMerge, fimMerge);
                break;
            case 3:
                printf("\nInsertion Sort:\n");
                insertionSort(vetAux, tam);
                break;
            case 4:
                printf("\nSelection Sort:\n");
                selectionSort(vetAux, tam);
                break;
            case 5:
                printf("\nBubble Sort:\n");
                bubbleSort(vetAux, tam);
                break;
            case 6:
                printf("\nQuick Sort:\n");
                quickSort(vetAux, 0, tam -1);
                break;
            default:
                printf("\nOpcao invalida.\n");
                continue; 
        }
 
        end = clock();
        cpu_time_used = ((double) (end - start)) / CLOCKS_PER_SEC;
 
        printf("\nVetor ordenado: ");
        printVetor(vetAux, tam);
 
        printf("\nTempo de ordenacao: %f segundos\n", cpu_time_used);
 
        printf("\nDeseja testar outro algoritmo? (s/n): ");
        scanf(" %c", &continuar); 
 
    } while(continuar == 's' || continuar == 'S');
 
    return 0;
}//fim do main
 
void printVetor(int *vet, int tam) {
    for (int i = 0; i < tam; i++) {
        printf(" %d |", vet[i]);
    }
    printf("\n");
}

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

//funcao recursiva que quebra até chegar em uma única unidade
void mergeSort(int vetor[],int inicioMerge, int fimMerge){
	if(inicioMerge < fimMerge){
		int meio = (inicioMerge + fimMerge)/2;
		mergeSort(vetor, inicioMerge, meio); //esquerdo
		mergeSort(vetor, meio + 1, fimMerge); //direito
		merge(vetor, inicioMerge, meio, fimMerge);
	}
}

//funcao que junta tudo, mesclando os elementos
void merge(int V[], int inicioMerge, int meio, int fimMerge){
	int esq, dir, aux, tam;
	esq = inicioMerge;
	dir = meio +1;
	aux = 0;
	tam = fimMerge - inicioMerge + 1;
	int vetAux[tam];
	
	while(esq <= meio && dir <= fimMerge){
		if(V[esq] < V[dir]){
			copia++;
			vetAux[aux] = V[esq];
			esq++;
		}else{
			copia++;
			vetAux[aux] = V[dir];
			dir++;
		}
		aux++;
	}
	
	//Caso ainda haja elementos na PRIMEIRA METADE, copiará todo o restante para vetAux
	while(esq <= meio){
		copia++;
		vetAux[aux] = V[esq];
		aux++;
		esq++;
	}
	
	//Caso ainda haja elementos na SEGUNDA METADE, copiará todo o restante para vetAux
	while(dir <=fimMerge){
		copia++;
		vetAux[aux] = V[dir];
		aux++;
		dir++;
	}
	
	for (aux = inicioMerge; aux <= fimMerge; aux++)
	{
		copia++;
		V[aux] = vetAux[aux - inicioMerge];
		
	}
}
	
void insertionSort(int vet[], int tam){
	int i, j,k, chave;
	int comp =0;
	int troca = 0;
	
	for(i=1; i<tam;i++){
		chave = vet[i];
		j = i - 1;
		comp++;
		while(j >= 0 && vet[j] > chave){
		troca++;
			vet[j+1] = vet[j];
			j = j - 1;
		}
		vet[j+1] = chave;
	}
	printf("\n\n ====> Trocas %d", troca);
	printf("\n\n ====> comparacoes %d", comp);
}

void selectionSort(int vet[] , int tam){
	int i, menor,aux, chave;
	int comp, troca;
	i = 0;
	troca =0;
	
	while(i < tam){
		menor = i;
		int j = i + 1;
		do{
			comp++;
			if(vet[j] < vet[menor]){
				menor = j;
			}
			j++;
		}while(j < tam);
		
		if(i != menor){
			troca++;
			aux = vet[i];
			vet[i] = vet[menor];
			vet[menor] = aux;
		}
		i++;
	}//fim do while
	
	printf("\n\n ====> Trocas %d", troca);
	printf("\n\n ====> comparacoes %d", comp);
}

void bubbleSort(int vet[], int tam){
	int aux;
	while(tam > 0)
	{
		for(int i = 0; i < tam - 1; i++)
		{
			if(vet[i] > vet[i+1])
			{
			aux = vet[i+1];
			vet[i+1] = vet[i];
			vet[i] = aux;
			}
		}
		tam--;
	} //fim do while
	tam = sizeof(vet)/sizeof(int);
}

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

