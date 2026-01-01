# Calcetis

Autor: Prof. Dr. Leandro Luque  
Instituição: Fatec Mogi das Cruzes  

Embalado por um movimento crescente de investimento em startups orientais, o neto de Munarinho, Tikomo Nakama, decidiu abrir uma startup chamada Calcetis, com a ideia de vender calcinhas usadas por musas do cinema, televisão e redes sociais.

Ele está em uma etapa importante do desenvolvimento em que precisa sugerir novos produtos aos compradores que já possuem itens no carrinho de compras. A ideia é que o valor total do carrinho atinja R$ 200,00, permitindo que o comprador tenha a opção de não pagar o frete.

Por uma questão de simbologia oriental, que supostamente trará sorte para a startup, Nakama deseja ofertar exatamente 3 produtos diferentes que, somados ao valor atual do carrinho, atinjam exatamente o valor necessário.

Ajude Nakama (e conte com a gratidão de Munarinho) escrevendo um programa eficiente para resolver esse problema.

--------------------------------------------------

ENTRADA

A entrada é composta por um único caso de teste.

A primeira linha contém dois inteiros V e N (30 ≤ V < 200, 3 ≤ N ≤ 10^5), separados por espaço em branco:
V representa o valor atual do carrinho de compras
N representa o número de produtos disponíveis que ainda não estão no carrinho

As próximas N linhas contêm um inteiro P (30 ≤ P ≤ 200), indicando o preço de cada produto disponível.

--------------------------------------------------

SAÍDA

| Saída | Significado |
|------|-------------|
| fretegratis | É possível escolher 3 produtos diferentes que somem exatamente R$ 200,00 |
| fretepago | Não é possível atingir o valor exato |

--------------------------------------------------

EXEMPLOS

| Entrada | Saída |
|--------|-------|
| 52 10<br>50<br>30<br>33<br>91<br>68<br>40<br>30<br>32<br>41<br>39 | fretegratis |
| 34 10<br>50<br>30<br>33<br>91<br>68<br>40<br>30<br>32<br>41<br>38 | fretepago |

--------------------------------------------------
