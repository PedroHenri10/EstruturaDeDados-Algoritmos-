# Rotação

Autor: Prof. Dr. Reinaldo Arakaki  
Instituição: Fatec São José dos Campos  

A empresa GeoFatec trabalha com Geoprocessamento e necessita de um programa capaz de rotacionar uma figura no plano cartesiano.

Dado um conjunto de pontos da figura e um ângulo de rotação em graus, o programa deve calcular as novas coordenadas após a rotação.

Para realizar a rotação, utiliza-se a seguinte matriz de rotação bidimensional:

cos(ang)   -sen(ang)  
sen(ang)    cos(ang)  

Onde ang é o ângulo de rotação em graus.  
Considere pi = 3,1415.

Dado um conjunto de pontos da figura, determine as novas coordenadas após a rotação.

--------------------------------------------------

ENTRADA

A entrada é composta por um único caso de teste.

A primeira linha contém dois valores:
- Um número inteiro N (1 ≤ N ≤ 100), representando a quantidade de pontos da figura
- Um ângulo θ (0 ≤ θ ≤ 180), em graus, representando o valor da rotação

As próximas N linhas contêm dois valores reais x e y, representando as coordenadas dos pontos da figura, onde:
- −1000 ≤ x, y ≤ 1000

--------------------------------------------------

SAÍDA

Imprima as novas coordenadas (x, y) da figura após a rotação, com duas casas decimais, uma coordenada por linha, mantendo a ordem de entrada.

--------------------------------------------------

EXEMPLOS

| Entrada | Saída |
|--------|-------|
| 5 40<br>20 50<br>10 50<br>35 75<br>-5 -7<br>-2 4 | -16.82 51.16<br>-24.48 44.73<br>-21.40 79.95<br>0.67 -8.58<br>-4.10 1.78 |

