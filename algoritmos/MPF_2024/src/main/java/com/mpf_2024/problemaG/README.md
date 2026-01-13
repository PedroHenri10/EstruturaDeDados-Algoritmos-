# Problema G: Plantão de Dúvidas

**Arquivo fonte:** `Main.java`  
**Autor:** Prof. Lucio Nunes de Lira (Fatec Diadema e Fatec Ferraz de Vasconcelos)

## Descrição

Megan é uma excelente aluna, tanto que além de cumprir suas tarefas adequadamente também tenta ajudar seus colegas nas aulas de programação. Aliás, tomara que os colegas reconheçam isso e a agradeçam no final do semestre! Sugestão: comprem uma pizza para ela.

Depois de tantos apoios, Megan percebeu que poderia oferecer alguns plantões de dúvidas à turma, de modo que estaria disposta a fazer algumas reuniões com aqueles que solicitassem sua ajuda. Todos da turma ficaram bem empolgados e até começaram uma "vaquinha coletiva" para comprar a tal da pizza.

Entretanto, a jovem altruísta percebeu que precisaria organizar a forma como o plantão de dúvidas seria conduzido, para que seus colegas pudessem ser atendidos eficientemente. Assim, estabeleceu que quem tivesse interesse em participar precisaria fazer uma inscrição prévia, em que o aluno colocaria o nome e as categorias em que suas dúvidas se encaixam.

### Categorias Disponíveis
1. **ALGORITMOS**
2. **BOAS PRATICAS**
3. **DESEMPENHO**
4. **FLUXOGRAMAS**
5. **INTERPRETACAO DE ENUNCIADOS**
6. **SINTAXE DA LINGUAGEM**

### Regras de Negócio
- O relatório exibe as categorias em ordem fixa (1 a 6).
- Dentro de cada categoria, os nomes dos alunos atendidos devem estar em **ordem alfabética**.
- Existe um limite de vagas $V$. Apenas os $V$ primeiros inscritos são atendidos.
- Alunos que se inscreverem após o limite $V$ vão para a categoria **FICA PARA A PROXIMA!**.
- Na categoria "FICA PARA A PROXIMA!", os nomes devem aparecer na **ordem de inscrição** (não alfabética).
- Cada categoria é cercada por exatamente **30 hifens** (`------------------------------`).
- Deve haver uma **linha em branco** entre as categorias.

---

## Especificações de Entrada

A primeira linha contém um número natural $V$ (limite de vagas). As linhas seguintes contêm as inscrições no formato:
`NOME_ALUNO CAT_1 CAT_2 ...`
O programa deve ler até o fim do arquivo (**EOF**).

## Especificações de Saída

Relatório formatado conforme os exemplos abaixo.

---

## Exemplos de Teste

### Exemplo 1 (Conforme imagem do problema)

**Entrada:**
```text
5
joao 1 2 3 4
maria 5 4 3 2
jose 5 1
carlos 5 2 1 6 4
ana 5
