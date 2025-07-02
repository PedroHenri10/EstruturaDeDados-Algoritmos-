/* nome: caixaEletronico.cpp
author: Pedro Henrique
date: 12/03/2025
description: programa para simular as operações em um caixa eletronico com recursividade*/

#include <stdio.h>
#include <string.h>
#include <stdlib.h>

void verSaldo(char*, float);
void realizarSaque(float*);
void fazerDeposito(float*);
void verLogin();
void verSenha();
void menu();
void trocarSenha();

char nome[15] = "thiago";
float saldo = 420;
int senha = 1234;
int numeroConta = 42;
int tentativas = 3;

int main(){
	printf("realizar seu login no sistema: \n");
	verLogin();
	menu();
}

void menu(){
     int op = 0;
    do{
		printf("digite qual das operações voçê deseja realizar: 1 - ver saldo, 2 - realizar um saque, 3 - fazer deposito, 4 - trocar senha, 5 - sair: ");
		scanf("%d", &op);
		
		switch(op){
			case 1:
				verSaldo(nome, saldo);
				break;
			case 2:
				realizarSaque(&saldo);
				break;
			case 3:
				fazerDeposito(&saldo);
				break;
			case 4:
				trocarSenha();
				break;
			 case 5:
			    printf("saindo...");
			    break;
			default:
				printf("opção invalida!");
		}
		
	}while(op != 5);
}
	
void verLogin(){
	int cod = 0;
	
	printf("codigo conta: ");
	scanf("%d", &cod);
	
	if( cod == numeroConta){
	    tentativas=3;
		verSenha();
	}else{
		verLogin();
	}
}
 
void verSenha(){
	int pwd = 0;
	
	  if (tentativas == 0) {
        printf("Conta bloqueada! Tente novamente mais tarde.\n");
        verLogin(); 
        return;
    }
	
	printf("senha: ");
	scanf("%d", &pwd);
	
	if(pwd == senha){
		printf("bem vindo ao sistema!");
	}else{
		tentativas--;
		printf("Senha incorreta! Tentativas restantes: %d\n", tentativas);
		verSenha();
    } 
}

void verSaldo(char* nome, float saldo){
	printf("%s, seu saldo atual é: R$ %.2f\n\n", nome, saldo);
}

void realizarSaque(float* saldo){
	float valor;
	printf("qual o valor voçê gostaria de sacar? ");
	scanf("%f", &valor);
	
	if (valor > 0 && valor <= *saldo) {
        *saldo -= valor;
        printf("Saque realizado! Novo saldo: R$ %.2f\n\n", *saldo);
    } else {
        printf("Saldo insuficiente ou valor inválido!\n\n");
    }
}

void fazerDeposito(float* saldo){
	float valorDepositado;
	printf("qual o valor voçê gostaria depositar ? " );
	scanf("%f", &valorDepositado);
	
	 if (valorDepositado > 0) {
        *saldo += valorDepositado;
        printf("Depósito realizado! Novo saldo: R$ %.2f\n\n", *saldo);
    } else {
        printf("Valor inválido!\n");
    }
}

void trocarSenha(){
	int novaSenha = 0;
	int novaSenhaDeNovo;
	
	printf("digite a nova senha: ");
	scanf("%d", &novaSenha);
	
	printf("digite a nova senha novamente: ");
	scanf("%d", &novaSenhaDeNovo);
	
	if(novaSenha == novaSenhaDeNovo){
		printf("senha alterada com sucesso!");
		senha = novaSenha;
	}else{
		printf("senhas n�o est�o iguais, refa�a novamente!\n");
		trocarSenha();
	}
}
