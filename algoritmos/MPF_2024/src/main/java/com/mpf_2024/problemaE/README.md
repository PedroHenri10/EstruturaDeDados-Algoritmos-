# Problema E

## Grupos de apoio tático voluntário

**Arquivo fonte:** apoio.{c cpp java py}  
**Autor:** Prof Antonio Cesar de Barros Munari (Fatec Sorocaba)

Preocupado com os recentes e trágicos eventos climáticos que causaram tantos danos e vítimas nos últimos meses em várias regiões do país, o prefeito de uma cidade paulista planeja criar grupos de voluntários que possam ser mobilizados para auxiliar em casos de inundações, vendavais e deslizamentos de terra mais sérios. Sua ideia é instituir esses tais "grupos de apoio tático voluntário" de maneira que possam ser treinados pela Defesa Civil para agilizar determinadas ações requeridas pelo atendimento aos cidadãos afetados pelos eventos. Um grupo de apoio desses combinaria pessoas com determinados perfis específicos estipulados pelos órgãos de planejamento municipal, como por exemplo habilidades na área da saúde (médicos. enfermeiros, paramédicos), resgate (bombeiros e profissionais com treinamento na área da segurança), aco Thimento (pessoal capacitado em psicologia, serviço social), etc. Em um primeiro momento serão definidos os perfis requeridos e a quantidade de profissionais de cada perfil necessária para compor um grupo. Em seguida, após uma campanha de mobilização nos meios de comunicação, os voluntários se cadastram em um site produzido pela prefeitura e então se analisará os dados dos inscritos para decidir quantos grupos poderão ser formados em cada região do município, considerando os requisitos e a disponibilidade de voluntários. Sua tarefa será construir o programa que, dados os requisitos dos perfis e as quantidades dos voluntários em cada região, definirá quantos grupos de apoio poderão ser criados. Por exemplo, suponhamos que temos 4 perfis identificados como necessários pela prefeitura, onde o primeiro requer 2 pessoas para formar um grupo, o segundo demanda 1 pessoa, o terceiro precisa de 3 e o último tem que ter 1 pessoa. Agora suponha que uma região apresentou 7 voluntários com o primeiro perfil, 9 com o segundo, 8 com o terceiro perfil e 4 com o último perfil. Considerando os requisitos e as disponibilidades de voluntários, será possível formar. apenas 2 grupos de apoio nessa região.

## Entrada

A entrada se inicia com um valor inteiro Q (0 < Q ≤ 15), que indica a quantidade de perfis distintos requeridos para a composição de um grupo. Seguem-se então Q inteiros P (0 < P ≤ 30 ; 0, i ≤ Q), onde o i-ésimo valor de P indica a quantidade de pessoas requeridas com o i-ésimo perfil. A entrada continua com um inteiro V (0 <V≤50) que indica a quantidade de regiões do município que tiveram voluntários cadastrados. Em seguida temos V linhas, cada uma descrevendo as quantidades de voluntários de cada região. Uma linha dessas se inicia com uma string R composta por uma combinação de até 10 letras e dígitos numéricos (sem espaços em branco ou outros caracteres especiais) referente ao código da região, seguida de Q inteiros D, (0 ≤ D≤300;0 < i ≤Q) indicando a quantidade de voluntários que possuem o i-ésimo perfil.

## Saída

O programa deverá imprimir V linhas, cada uma contendo o código da região e um inteiro expressando a quantidade de grupos de apoio tático voluntário que poderão ser formados ali. Um espaço em branco deve separar esses dois itens de dado em cada linha da saída.

## Exemplo de Entrada 1
|Entrada (Voluntários por Perfil) | Saída (Grupos Formados) |
|------------------------------------------|--------------------------|
| 4
| 3 1 3 1
| 3
| ABC01   5 3 8 1                          | ABC01 1                        |
| DRG32   7 9 8 4                          | DRG32 2                        |
| o2932   3 3 2 9                          | O2932 0                        |

