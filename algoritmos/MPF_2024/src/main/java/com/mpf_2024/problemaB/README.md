# 📱 Problema B — Teclado de Celular

**Autor:** Prof. Dr. Reinaldo Arakaki  
**Instituição:** Fatec São José dos Campos  

---

## 📝 Descrição

O teclado de um celular possui letras associadas a números, como nos celulares antigos.
Dada uma lista de palavras, o objetivo é descobrir qual número de telefone cada palavra representa.

Cada letra maiúscula deve ser convertida para o dígito correspondente no teclado do celular.

---

## 🔢 Mapeamento do Teclado

| Letras           | Número |
|------------------|--------|
| A, B, C          | 2      |
| D, E, F          | 3      |
| G, H, I          | 4      |
| J, K, L          | 5      |
| M, N, O          | 6      |
| P, Q, R, S       | 7      |
| T, U, V          | 8      |
| W, X, Y, Z       | 9      |

---

## 📥 Entrada

- A primeira linha contém um número inteiro **N** (1 ≤ N ≤ 100)
- As próximas **N linhas** contêm palavras formadas apenas por **letras maiúsculas**

---

## 📤 Saída

- Para cada palavra, imprima o **número de telefone correspondente**, um por linha

---

## 📌 Exemplos

### Exemplo 1

#### Entrada
| Linha | Valor |
|------:|-------|
| 1 | 3 |
| 2 | PORTOSEGURO |
| 3 | TRICOLOR |
| 4 | CENTROPAULASOUZA |

#### Saída
| Palavra | Telefone |
|---------|----------|
| PORTOSEGURO | 76786734876 |
| TRICOLOR | 87426567 |
| CENTROPAULASOUZA | 23687677265276892 |

---

### Exemplo 2

#### Entrada
| Linha | Valor |
|------:|-------|
| 1 | 1 |
| 2 | FATEC |

#### Saída
| Palavra | Telefone |
|---------|----------|
| FATEC | 32832 |

---

### Exemplo 3

#### Entrada
| Linha | Valor |
|------:|-------|
| 1 | 2 |
| 2 | SOS |
| 3 | AMBULANCIA |

#### Saída
| Palavra | Telefone |
|---------|----------|
| SOS | 767 |
| AMBULANCIA | 2628526242 |

