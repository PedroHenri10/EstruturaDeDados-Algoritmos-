
class Matrix {
    private int[][] matrizGuardada;

    Matrix(String matrixAsString) {
        String[] linhas = matrixAsString.trim().split("\n");

        this.matrizGuardada = new int[linhas.length][];

        for(int i = 0; i < linhas.length; i++){
            String[] colunas = linhas[i].trim().split("\\s+");

            this.matrizGuardada[i] =new int[colunas.length];

            for(int j = 0; j<colunas.length; j++){
                this.matrizGuardada[i][j] = Integer.parseInt(colunas[j]);
            }
        }
    }

    int[] getRow(int rowNumber) {
        rowNumber = rowNumber - 1;

        int[] row = new int[matrizGuardada[rowNumber].length];
        for(int i= 0; i <matrizGuardada[rowNumber].length; i++){
            row[i] = matrizGuardada[rowNumber][i]; 
        }

        return row;
    }

    int[] getColumn(int columnNumber) {
        columnNumber = columnNumber - 1;

        int[] column = new int[matrizGuardada.length];
        for(int i= 0; i< matrizGuardada.length; i++){
            column[i] = matrizGuardada[i][columnNumber]; 
        }

        return column;
    }

}
