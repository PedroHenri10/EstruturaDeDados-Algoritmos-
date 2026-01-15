## Problema G  
### Plantão de Dúvidas  

**Arquivo fonte:** `plantaoduvidas.{ c | cpp | java | py }`  
**Autor:** Prof. Lucio Nunes de Lira (Fatec Diadema e Fatec Ferraz de Vasconcelos)  

Megan é uma excelente aluna, tanto que além de cumprir suas tarefas adequadamente também tenta ajudar seus colegas nas aulas de programação. Aliás, tomara que os colegas reconheçam isso e a agradeçam no final do semestre! Sugestão: comprem uma pizza para ela.  

Depois de tantos apoios, Megan percebeu que poderia oferecer alguns plantões de dúvidas à turma, de modo que estaria disposta a fazer algumas reuniões com aqueles que solicitassem sua ajuda. Todos da turma ficaram bem empolgados e até começaram uma "vaquinha coletiva" para comprar a tal da pizza.  

Entretanto, a jovem altruísta percebeu que precisaria organizar a forma como o plantão de dúvidas seria conduzido, para que seus colegas pudessem ser atendidos eficientemente. Assim, estabeleceu que quem tivesse interesse em participar precisaria fazer uma inscrição prévia, em que o aluno colocaria o nome e as categorias em que suas dúvidas se encaixam.  

Com a categorização, será mais simples agrupar dúvidas semelhantes de vários alunos e chamá-los para o mesmo horário dentro do plantão de dúvidas, pois a resposta para a dúvida de um poderia ajudar o outro. Essas são as categorias disponíveis:  

1. Algoritmos;  
2. Boas práticas;  
3. Desempenho;  
4. Fluxogramas;  
5. Interpretação de enunciados;  
6. Sintaxe da linguagem.  

Alguns dias antes de cada plantão de dúvidas, Megan disponibilizará um formulário de inscrição e, após o encerramento do prazo, divulgará uma postagem com a relação de atendimentos, que é um relatório com todas as categorias de dúvidas e os nomes dos alunos que as indicaram no formulário e que serão atendidos. Para facilitar a conferência dos atendimentos, os nomes dos alunos serão exibidos em ordem alfabética em cada categoria.  

Cada colega realizará uma única inscrição, porém poderá indicar quantas categorias quiser, sendo que a inscrição sempre é feita começando com o nome do aluno seguido pelos números das categorias em que ele deseja atendimento. É importante notar que não há ordem definida nas categorias que são informadas por um aluno. Por exemplo, não há garantia de que um aluno que precisa de ajuda nas categorias 2, 3 e 6, coloque as categorias nessa ordem, ele poderia inserir 6, 2 e 3 ou qualquer outra permutação.  

Como Megan ainda é humana, ela possui uma característica comum a esses seres, algo chamado 'cansaço'. Por isso, Megan indicará antecipadamente o limite de vagas para o próximo plantão de dúvidas, sendo que se a quantidade de inscrições ultrapassar esse limite, os excedentes não serão atendidos e ficarão na última categoria do relatório: 'FICA PARA A PROXIMA!'. Neste caso, esses inscritos não atendidos serão dispostos não em ordem alfabética, mas sim na ordem de inscrição. O preenchimento das vagas será por ordem de inscrição e a categoria 'FICA PARA A PROXIMA!' só deverá aparecer no relatório se houver alguém que não será atendido.  

Você gostou da iniciativa de Megan e quer ajudá-la nessa aventura! Como suas habilidades em programação são lendárias, você prometeu desenvolver um programa que: (I) coletará o limite de vagas, (II) as inscrições dos alunos, na ordem em que foram feitas, um aluno por linha e (III) irá gerar um relatório no formato que ela deseja. Contamos com você!  

### Entrada  

A primeira linha da entrada conterá um único número natural V ( V>0  ) que indicará o limite de vagas para o próximo plantão de dúvidas. As próximas linhas conterão as inscrições dos colegas de Megan que estarão sempre no formato  
NA CD [CD CD…], em que NA é o nome do aluno e cada CD repetidos na mesma inscrição e todos estão no intervalo [1..6]. Note que NA é uma string composta apenas de caracteres do alfabeto latino minúsculo e sem acentuação, todos alunos farão a inscrição usando apenas o primeiro nome e há garantia que não existirão nomes repetidos. A quantidade de inscrições é, a princípio, indeterminada, isto é, o programa deverá solicitar novas entradas até que não existam mais (EOF), porém o relatório de atendimento conterá apenas os V primeiros inscritos.  

### Saída  

A saída deverá ser conforme os casos de teste de exemplo, em que cada categoria é exibida em letras maiúsculas do alfabeto latino, sem acentuação e seguida pelos nomes dos alunos que serão atendidos e indicaram ter dúvidas nela. Note que na linha anterior e na linha posterior ao nome de cada categoria existem trinta hifens ('-') e que entre as categorias há uma única linha em branco.  

### Exemplo de Entrada 1  

```text
5
joao 1 2 3 4
maria 5 4 3 2
jose 5 1
carlos 5 2 1 6 4
ana 5
```

### Exemplo de Saída 1

```
------------------------------
ALGORITMOS
------------------------------
carlos
joao
jose

------------------------------
BOAS PRATICAS
------------------------------
carlos
joao
maria

------------------------------
DESEMPENHO
------------------------------
joao
maria

------------------------------
FLUXOGRAMAS
------------------------------
carlos
joao
maria

------------------------------
INTERPRETACAO DE ENUNCIADOS
------------------------------
ana
carlos
jose
maria

------------------------------
SINTAXE DA LINGUAGEM
------------------------------
carlos
```

### Exemplo de Entrada 2

```text
2
joao 1
maria 1
jose 1
carlos 1
ana 1
```

### Exemplo de Saída 2

```
------------------------------
ALGORITMOS
------------------------------
joao
maria

------------------------------
BOAS PRATICAS
------------------------------

------------------------------
DESEMPENHO
------------------------------

------------------------------
FLUXOGRAMAS
------------------------------

------------------------------
INTERPRETACAO DE ENUNCIADOS
------------------------------

------------------------------
SINTAXE DA LINGUAGEM
------------------------------

------------------------------
FICA PARA A PROXIMA!
------------------------------
jose
carlos
ana
```
