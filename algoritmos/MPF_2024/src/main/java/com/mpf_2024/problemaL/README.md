# Problem L – Molecular Scissors

Within the universe of molecular biology, there exist special molecules called enzymes that act as catalysts for biochemical reactions. A specific family of enzymes, known as restriction enzymes, have a unique affinity for specific sequences of nucleotides on a strand of DNA. These enzymes “read” the DNA strand and cut it at their respective recognition sites, acting as molecular scissors.

Scientists have discovered a unique characteristic of the recognition sites of certain enzymes, particularly restriction enzymes. The nucleotide sequence on one strand, when read from a specific direction, matches the sequence on the complementary strand, read in the opposite direction.

For example:

- **Strand:** AAGCTT  
- **Complementary:** TTCGAA  

As shown, reading the strand from left to right is identical to reading the complementary strand from right to left.

Conversely, a strand like the following does not exhibit this characteristic:

- **Strand:** AAGG  
- **Complementary:** TTCC  

Restriction enzymes can cut sequences like **AAGCTT** and its complementary **TTCGAA**, but not sequences like **AAGG** and **TTCC**.

As real examples, the restriction enzyme **EcoRI** recognizes the sequence **GAATTC**, and its complementary strand would read **CTTAAG**. Similarly, the enzyme **HindIII** recognizes the sequence **AAGCTT**, and the complementary strand reading **TTCGAA**.

These enzymes are crucial in molecular biology, allowing scientists to cut DNA strands at specific locations, facilitating various genetic engineering and research applications.

As a Bioinformatics intern, your task is to develop a program to assist researchers in identifying potential recognition sites (inside of a strand) for such a type of enzyme. The program should identify sequences that exhibit the aforementioned characteristic.

---

## Input

The input consists of multiple lines, each representing a DNA sequence composed of the characters **A**, **T**, **C**, and **G**, representing the nucleotides Adenine, Thymine, Cytosine, and Guanine respectively.

- The maximum length of each DNA sequence is **10⁵**.
- The input ends with **EOF**.

---

## Output

For each DNA sequence:

- If no site (part of the sequence) can be matched by a restriction enzyme, output: false

- If such a site is found, output **two integers**:
  - The starting position (1-indexed)
  - The length of the longest such site

If more than one site presents the same length, print the starting position and the length of the **first one**.

---

## Example

### Input

```
GAATTC
AAGCTTTCGAAGCTTAAAAAA
CCGGAAGGCCGG
ATT
AAGCTCAA
AA
AAGG
```

## Output

```
1 6
1 6
1 4
false
2 4
false
false
```

