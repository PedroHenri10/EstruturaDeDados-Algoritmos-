/*
nome: listaLigada.cpp
author: pedro henrique
date: 19/03/2025
description: implementação de lista ligada (encadeada)
*/
 
#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include <string.h>
#include <windows.h>
 
// criando varios nós, struct, lista que liga um com outro.
 
 
typedef struct No{
		char *nome;
		int idade;
		float altura;
		struct No *proximo;
};
 
typedef struct
{
	No *inicio, *fim;
	int tamanho;
}Lista;
 
//funcao para inserir um (elemento) No no inicio da lista
void inserirInicioLista(Lista *lista, char *n, int ida, float alt){
	No *novo = (No*)malloc(sizeof(No)); // reserva espacos na memoria para armazenar um No (bytes)
	novo->nome = strdup(n);  // Aloca memória para o nome
	novo->idade = ida;
	novo->altura = alt;
	if(lista->inicio == NULL)// a lista está vazia
	{
		novo->proximo = NULL;
		lista->inicio = novo;
		lista->fim = novo;
	}else{ //lista não está vazia
		novo->proximo = lista->inicio; // a struct no  no campo proximo recebe incio para armezenar a nova struct
		lista->inicio = novo;
	}
	lista->tamanho++;
	puts("elemento inserido com sucesso!!");
}
 
void inserirFimLista(Lista *lista, char *nome, int ida, float alt){
	No *novo = (No*)malloc(sizeof(No));
	novo->nome = strdup(nome);
	novo->idade = ida;
	novo->altura = alt;
	novo->proximo =  NULL;
	if(lista->inicio == NULL){
		lista->inicio = novo;
		lista->fim = novo;
	}else{
		lista->fim->proximo = novo;
		lista->fim = novo;
	}
	lista->tamanho++;
	puts("elemento inserido no FIM com sucesso!");
}
 
void exibirLista(Lista *lista){
	HANDLE hConsole = GetStdHandle(STD_OUTPUT_HANDLE);
	CONSOLE_SCREEN_BUFFER_INFO consoleInfo;
	WORD saved_attributes;
	// salvar os atributos de cores
	GetConsoleScreenBufferInfo(hConsole, &consoleInfo);
	saved_attributes = consoleInfo.wAttributes;
	No *inicio = lista->inicio; // posiciona no primeiro no da lista
	printf("\n Tamanho da Lista: %d elementos \n\n", lista->tamanho);
	while(inicio != NULL){
		printf("%s", inicio->nome);
		SetConsoleTextAttribute(hConsole, FOREGROUND_GREEN);
		printf(" -> ");
		SetConsoleTextAttribute(hConsole, saved_attributes);
		inicio = inicio->proximo;
	}
	printf("NULL\n");
}
 
//funcao para excluir um elemento da lista
void retirarNoLista(Lista *lista, char *nomeRemover){
	No *inicio = lista->inicio; // ponteiro para o primeiro No da lista
	No *noRemover = NULL;
	if(inicio != NULL && strcmp(lista->inicio->nome, nomeRemover) == 0) // REMOVE O PRIMEIRO ELEMENTO DA LISTA
	{
		noRemover = lista->inicio;
		lista->inicio = noRemover->proximo;
		if(lista->inicio == NULL)
			lista->fim == NULL;
		}else{ // remover nos no meio da lista ou no fim delas
			while(inicio != NULL && inicio->proximo !=NULL && strcmp(inicio->proximo->nome, nomeRemover) != 0){
				inicio = inicio->proximo;
			}
			if(lista->inicio !=NULL && inicio->proximo != NULL){
				noRemover = inicio->proximo;
				inicio->proximo = noRemover->proximo;
				if(inicio->proximo == NULL) // se o ultimo elemento for removido
					lista->fim = inicio;
			}
		}
		if(noRemover) // testa se ele é NULL
		{
			free(noRemover); // libera o espaço de memoria reservado para o no
			lista->tamanho--;
		}
	}
 
int main(){
	Lista pessoas;
	pessoas.inicio = NULL;
	pessoas.fim = NULL;
	pessoas.tamanho = 0;
	char *nome = NULL;
	int idade;
	float altura;
	nome = "pedro";
	idade = 23;
	altura = 1.74;
	nome = (char *)malloc(100 * sizeof(char)); // Alocação inicial para o nome
    if (nome == NULL) {
        printf("Erro ao alocar memória para o nome.\n");
        exit(1);
    }
	int opc = 0; 
	while(1)
	{
		system("cls");
		puts("1 - Inserir no INICIO \n2 - Inserir no FIM\n3 -Exibir Lista\n4 - Remover Elemento\n5 - Sair: ");
		printf("\nEscolha sua opcao: ");
		scanf("%d", &opc);
		getchar(); 
	
		switch(opc){
			case 1:
				puts("\nINICIO da lista");
				puts("================");
				printf("Nome: "); 

				fgets(nome, 100, stdin);
                nome[strcspn(nome, "\n")] = '\0'; 
				printf("Idade: "); scanf("%d", &idade);
				printf("Altura: "); scanf("%f", &altura);
				inserirInicioLista(&pessoas, nome, idade, altura);
				break;
			case 2:
				puts("FIM da lista");
				puts("================");
				printf("Nome: "); scanf("%s", nome);
				scanf("%c" );
				printf("Idade: "); scanf("%d", &idade);
				printf("Altura: "); scanf("%f", &altura);
				inserirFimLista(&pessoas, nome, idade, altura);
				break;
			case 3:
				puts("Conteudo da lista");
				exibirLista(&pessoas);
				break;
			case 4:
				puts("Remocao da lista");
				printf("\n digite o nome da pessoa que deseja listar da lista: ");
				fgets(nome, 100, stdin);
                nome[strcspn(nome, "\n")] = '\0';
				retirarNoLista(&pessoas, nome);
				break;
			case 5: 
				puts("Saindo...");
				free(nome);
				exit(0);
				break;
			default:
				printf("\n opcao invalida!!");
		}//fim do switch
		puts("Pressione qualquer tecla para continuar...");
		getchar();
 
	}//fim do loop infinito	
	/*
	inserirInicioLista(&pessoas, nome, idade, altura);
	nome = "Lisca doido";
	idade = 57;
	altura = 1.70;
	inserirFimLista(&Pessoa, nome, idade, altura);

	nome = "Mariana";
	idade = 27;
	altura = 1.62;
	inserirInicioLista(&Pessoa, nome, idade, altura);
 
	nome = "Luana";
	idade = 27;
	altura = 1.67;
	inserirFimLista(&Pessoas, nome, idade, altura);
	nome = "cleiton rasta";
	idade = 32;
	altura = 1.71;
	inserirFimLista(&Pessoas, nome, idade, altura);
 
	nome = "deyverson";
	idade = 29;
	altura = 1.78;
	inserirInicioLista(&Pessoa, nome, idade, altura);
	nome = "Amanda";
	idade = 22;
	altura = 1.64;
	inserirInicioLista(&Pessoa, nome, idade, altura);
	exibirLista(&pessoas);
	retirarNoLista(&pessoas, "pedro");
	exibirLista(&pessoas);
	*/
	return 0;
} // fim do programa
 
