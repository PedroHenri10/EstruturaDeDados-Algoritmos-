/*
nome: fila.cpp
author: pedro henrique
data 02/04/2025
descricao: programa para implementar conceito de fifo
*/

// sessão de importação
#include<stdio.h>
#include<stdlib.h>
#include<windows.h>
#include<string.h>

//sessão prototipação

void enqueue(int); // inserir elementos na fila
int dequeue();  // retirar elemento da fila

int isFull(); // verificar se esta cheia
int isEmpty(); // verificar se esta vazio

//variaveis globais
int inicio, fim, total, tam;
int senhas[7];



void showFIFO(); // exibir fila

int main(){
	
	tam = sizeof(senhas)/sizeof(int);
	//printf("tamanho do vetor em bytes: %d", sizeof(senhas));
	inicio = 0;
	fim = 0;
	total = 0;
	
	enqueue(446);
	enqueue(15);
	enqueue(69);
	enqueue(24);
	showFIFO();
	printf("saindo: %d \n", dequeue());
	printf("saindo: %d \n", dequeue());
	printf("saindo: %d \n", dequeue());
	printf("saindo: %d \n", dequeue());
	printf("saindo: %d \n", dequeue());
	showFIFO();
	//dequeue();
	
	return 0;
}// fim do programa

	void enqueue(int elem){
		
		if(isFull() == 1){
		
			puts("\na fila esta cheia \n");
		}else{
			senhas[fim] = elem;
			fim++;
			total++;	
		}
	}
	
	int dequeue(){
		
		if(isEmpty() == 1){
			puts("\na fila esta vazia!");
		}else{
			int elemento;
			elemento = senhas[inicio];
			
			inicio++;
			total--;
			return elemento;
		}
	}

	int isFull(){
		
		if(total == tam){
			return 1;
		}else{
			return 0;
		}
	}
	
	int isEmpty(){
		if(total == 0){
			return 1;
		}else{
			return 0;
		}
	} 	
	
		
	void showFIFO(){
		int cont, i;
		puts("\n\nConteudo da fila: \n");
		for(cont = 0, i = inicio; cont < total; cont++){
			printf("%d | ", senhas[i++]);
			if(i == tam){
				i = 0;
			}
		}
		printf("\n\n");
	}
