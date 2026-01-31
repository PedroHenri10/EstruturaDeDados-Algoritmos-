# Problema J — Purrinha

**Arquivo fonte:** purrinha.c | purrinha.cpp | purrinha.java | purrinha.py  
**Autor:** Prof. Sérgio Luiz Banin (Fatec São Paulo e Fatec São Caetano)

---

## Descrição

Purrinha é um jogo tradicional muito praticado em botecos entre goles de cerveja. Nesse jogo usam-se pequenos objetos que podem ser pedaços de papel, moedas, feijões ou palitos quebrados, ou seja, algo pequeno que possa ficar facilmente escondido dentro da mão. Vamos ficar com os palitos, por ser mais comum.

Pode ser jogado com várias pessoas.

Cada pessoa terá 3 palitos consigo e terá que escolher uma quantidade de zero a três — e colocar na mão. Depois, todos deixam a mão fechada sobre a mesa e cada jogador deve fazer um palpite. Com esse palpite o jogador tem o objetivo de acertar o total da soma dos palitos escondidos nas mãos de todos os jogadores.

Os palpites são anunciados um por vez iniciando no jogador inicial da rodada, que pode escolher qualquer valor. Seguindo um sentido horário os jogadores farão seus palpites sucessivamente, sendo proibida a repetição dos palpites já escolhidos pelos jogadores anteriores. A cada rodada o jogador inicial é trocado (essa informação está aqui apenas para que conheçam o jogo e não deve ser levada em conta no programa).

O jogador que acertar o total de palitos na rodada com isso ganha um ponto. Ao final das rodadas o jogador que tiver o maior número de pontos é o campeão.

Por outro lado, se ao final das rodadas, se dois ou mais jogadores tiverem o mesmo número de pontos, então houve empate. Escreva um programa para calcular o resultado final de um Jogo Purrinha.

---

## Entrada
A entrada contém um caso de teste e é composta por várias linhas. Na primeira linha há um número inteiro que é a quantidade de jogadores QJ (2 ≤ QJ ≤ 6), seguida de QJ linhas contendo os nomes dos jogadores. Em seguida, há uma linha contendo um número inteiro que é a quantidade de rodadas NR (5 ≤ NR ≤ 50), seguida de NR pares de linhas. Em cada par a linha de cima contém a mão de cada jogador e a linha de baixo contém o palpite de cada jogador. Cada uma das linhas das rodadas tem QJ números inteiros, referentes aos jogadores conforme a ordem de nomes listados na parte inicial dessa entrada de dados.

---

## Saída
O programa deve calcular os pontos obtidos pelos jogadores e determinar quem é o vencedor ou se houve empate. Em caso de haver um vencedor imprima o nome do vencedor seguido da palavra GANHOU, com um espaço em branco entre eles. Em caso de empate imprima EMPATE. Não se esqueça do pulo de linha.

---

## Exemplos

### Exemplo de Entrada 1
```
2
LILO
STITCH
3
2 0
3 2
1 0
4 1
2 1
3 1
```

### Exemplo de Saída 1
```
STITCH GANHOU
```

---

### Exemplo de Entrada 2
```
2
LILO
STITCH
3
2 3
5 6
2 2
2 3
1 3
2 4
```

### Exemplo de Saída 2
```
EMPATE
```

---

### Exemplo de Entrada 3
```
3
HOUSE
MONK
SHELDON
6
1 2 0
6 3 5
0 3 1
2 4 5
0 0 3
6 1 8
1 3 3
5 7 9
2 0 0
2 1 6
2 3 2
5 3 7
```

### Exemplo de Saída 3
```
MONK GANHOU
```
