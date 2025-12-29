# Mapa de Calor

**Autor:** Prof. Dr. Leandro Luque  
**Instituição:** Fatec Mogi das Cruzes  

Munarinho descobriu recentemente sua paixão por design e não para de pensar sobre como o diálogo estabelecido entre um observador e um objeto observado diz muito sobre ambos. Antes um pouco desleixado com o aspecto visual das coisas e com a aparência, decidiu agora cuidar de cada detalhe. Recentemente, fez um corte de cabelo em homenagem ao Cascão, assim como fez Ronaldo Fenômeno na Copa de 2002.

Em uma de suas explorações sobre a área, Munarinho descobriu a análise do comportamento de usuários em páginas web. Após estudar os artigos do Nielsen Norman Group, resolveu prontamente analisar o comportamento do olhar dos usuários na página de sua Fatec. Estava convencido de que o padrão **F-Shaped** estava presente em muitas interações e receava que isso não fosse algo positivo.

Um padrão de leitura de uma página web pode ser obtido a partir do rastreamento do olhar de vários usuários enquanto interagem com a página e da produção de um mapa de calor como o seguinte:

Esse mapa de calor indica um padrão conhecido como **F-Shaped**, em que o olhar dos usuários forma, algumas vezes, um formato semelhante à letra **F**.

Buscando realizar uma primeira avaliação do site de sua Fatec, Munarinho está desenvolvendo um sistema que procura identificar a área da página que os usuários mais observaram: **superior, esquerda, centro, direita ou inferior**.

Para simplificar o processamento, ele projetou os pontos observados pelos usuários em uma matriz **6x3**.  
Nesta matriz:
- `1` representa um ponto observado
- `0` representa um ponto não observado

As seguintes regiões são de interesse:

- **Região:** (coluna inicial, linha inicial, coluna final, linha final)
- **Superior:** (0, 0, 2, 0)
- **Esquerda:** (0, 1, 0, 4)
- **Centro:** (1, 1, 1, 4)
- **Direita:** (2, 1, 2, 4)
- **Inferior:** (0, 5, 2, 5)

---

## Entrada

A entrada é composta por um único caso de teste.

- A primeira linha contém um inteiro **N** (3 ≤ N ≤ 100), indicando o número de usuários que interagiram com a página.
- As próximas **N × 6** linhas contêm **3 inteiros P** (0 ≤ P ≤ 1), separados por espaço em branco, indicando se o usuário olhou ou não para aquela posição da matriz.

---

## Saída

Imprima o nome da região, em **minúsculas** e **sem caracteres especiais**, que recebeu mais olhares dos usuários (cada olhar soma 1 na região).

Em caso de empate, imprima a região que aparece primeiro conforme a ordem apresentada no enunciado.

---


## Exemplos

| Entrada | Saída |
|--------|-------|
| 3<br>0 1 0<br>0 0 0<br>1 0 0<br>1 0 0<br>0 0 0<br>1 1 1<br>0 0 1<br>1 0 0<br>1 0 0<br>0 0 0<br>0 0 0<br>0 1 0<br>0 0 0<br>0 0 0<br>0 0 0<br>0 0 0<br>0 0 0<br>1 1 1 | inferior |
