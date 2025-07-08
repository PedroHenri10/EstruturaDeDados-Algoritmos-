/* nome: PILHA.cpp
author: Pedro Henrique
date: 09/04/2025
description: programa para a implementação da estrutura de dados pilha LIFO (Last in First Out)*/

// sessao importacao
#include <stdio.h>
#include <stdlib.h>
#include <windows.h>
#include <conio.h>

//sessão protatipação
void push (int); // insere elemento  na pilha
int pop(); // retira elemento na pilha
int isEmpty(); // retorna 1 quando esta vazia, e 0 quando nao esta
int isFull(); // retorna 1 quando esta cheia e  0 quando tem espço de armazenamento
void showLIFO(); // exibir elementos na pilha, nem sempre vc quer mostrar o lifo
int topo(); // retorna o elemento que esta no topo da pilha

//variaveis globais
int pilha[10];
int topo = -1;

int main(){
	
	while(1){
	int menu = 0;
	printf("1 - inserir na pilha\n2 Remover na pilha\n3 Exibir pilha\n4 Retornar elemento do topo\n5 Conversor binario\n6 Sair: ");
	printf("\n Opcao: ");
	scanf("%d", &menu);
	
	switch(menu){
		case 1:
			int e;
			e = 0;
			printf("Digite um numero inteiro");
			scanf("%d", &e);
			push(e);
		break;
		case 2:
			pop();
		break;
		case 3:
			showLIFO();
		break;
		case 4:
			printf("\nelemento do topo %d", topo());
		break;
		case 5:
			printf("aluno fazer conversor");
		break;
		case 6:
			puts("\nSaindo...");
			exit(0);
		break;
		default:
			puts("opcao invalida!");
	}//fim do switch
	
	puts("\n\n pressiona qualquer tecla para continuar");
	getch();
	system("cls");
}//fim do while
	/*
	push(24);
	push(300);
	push(400);
	push(69);
	push(700);
	push(800);
	push(71);
	push(900);
	push(1000);
	push(101);
	showLIFO();
	push(707);
	push(44);
	
	pop();
	pop();
	pop();
	pop();
	pop();
	showLIFO();
	pop();
	pop();
	pop();
	pop();
	pop();
	pop();
	pop();
	pop();
	showLIFO();
	*/
	
	return 0;
} // fim do programa

// insere 
void push(int elem){
	if(isFull() == 1){
		puts("\nPilha esta cheia -> Stack Overflow");
	}else{
		topo++;
		pilha[topo] = elem;
	}
}

//retira
int pop(){
	if(isEmpty() == 1){
		puts("\nPilha esta vazia");
	}else{
		int elemento;
		elemento = pilha[topo];
		topo--;
		return elemento;
	}
}//

// testa se esta vazip
int isEmpty(){
	if(topo == -1){
		return 1;
	}else{
		return 0;
	}
}

// testa se esta cheia
int isFull(){	
	if(topo == 9){
		return 1;
	}else{
		return 0;
	}
}

//exibe o conteudo da pilha
void showLIFO(){
	puts("\n Conteudo da pilha: ");
	if(isEmpty() == 1){
		puts("\n A pilha ja esta vazia!\n");
	}else{
		for(int i = topo; i >= 0; i++){
			printf(" %d ", pilha[i]);
		}
		printf("\n");
	}
}

//return o elemento que esta no topo da filha
int topo(){
	return pilha[topo];
} 
