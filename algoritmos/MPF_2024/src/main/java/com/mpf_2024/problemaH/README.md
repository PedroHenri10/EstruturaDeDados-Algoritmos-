# Problema H - Quem é o pivô?

**Autor:** Prof. Antonio Cesar de Barros Munari - Fatec Sorocaba

Zequinha está estudando métodos de ordenação na escola e ficou muito empolgado com o **Quick Sort** devido à sua rapidez. Ele fez até uma implementação em sua linguagem de programação favorita. Pesquisando um pouco mais sobre os detalhes de implementação, ficou sabendo que a escolha do valor de referência utilizado para processar uma partição dos dados, o famoso **pivô**, é um aspecto crítico para o desempenho.

Se uma implementação descuidada do método tiver o azar de encontrar sequências particularmente ruins de dados em uma ordenação, o desempenho será degradado a ponto de, no limite, o Quick Sort se comparar ao **Bubble Sort**. Claro que isso seria um caso extremo para alguém muito azarado, mas o alerta foi suficiente para que Zequinha resolvesse melhorar sua escolha de pivôs.

Dentre várias abordagens possíveis, ele se interessou pela que escolhe **três valores** contidos na partição a ser processada e seleciona como pivô aquele valor que **não seja sozinho o menor nem o maior dos três**. Por exemplo: entre os valores `33`, `42` e `37`, o pivô será `37` , para os valores `15`, `30` e `15`, o pivô será `15`, dada a repetição

Sua tarefa é ajudar seu amigo Zequinha a determinar o valor do pivô com base em **3 valores inteiros** fornecidos para análise.

---

## 📥 Entrada
A entrada é composta por **3 inteiros** separados por espaço em branco.  
Cada valor encontra-se na faixa de: -2000000000 ≤ valor ≤ +2000000000


---

## 📤 Saída
Imprimir o valor selecionado como **pivô** pelo critério exposto anteriormente.

---

## 🧪 Exemplos

| Exemplo de Entrada | Exemplo de Saída |
|-------------------|-----------------|
| `23 42 37` | `37` |
| `15 30 15` | `15` |
| `10 20 30` | `20` |

