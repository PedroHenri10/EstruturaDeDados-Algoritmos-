import java.util.ArrayList;
import java.util.List;

class DiamondPrinter {

    List<String> printToList(char a) {
        List<Character> alfabeto = new ArrayList<>();
        for (char letra = 'A'; letra <= 'Z'; letra++) {
            alfabeto.add(letra);
        }

        List<String> rows = new ArrayList<>();
        int alvoIndex = alfabeto.indexOf(a);
        int tamanhoMatriz = (alvoIndex * 2) + 1;

        for (int i = 0; i <= alvoIndex; i++) {
            char letraAtual = alfabeto.get(i);
            StringBuilder linha = new StringBuilder();

            for (int j = 0; j < tamanhoMatriz; j++) {
                if (j == alvoIndex - i || j == alvoIndex + i) {
                    linha.append(letraAtual);
                } else {
                    linha.append(' ');
                }
            }
            rows.add(linha.toString());
        }

        for (int i = alvoIndex - 1; i >= 0; i--) {
            rows.add(rows.get(i));
        }

        return rows;
    }
}
