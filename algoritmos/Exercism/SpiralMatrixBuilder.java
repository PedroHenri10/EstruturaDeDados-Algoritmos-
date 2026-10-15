class SpiralMatrixBuilder {
    int[][] buildMatrixOfSize(int size) {
        int[][] matrix = new int[size][size];

        int topo = 0;
        int base = size - 1;
        int esquerda = 0;
        int direita = size - 1;
        int num = 1;

        while (topo <= base && esquerda <= direita) {
            for (int j = esquerda; j <= direita; j++) {
                matrix[topo][j] = num;
                num++;
            }
            topo++;

            for (int j = topo; j <= base; j++){
                matrix[j][direita] = num;
                num++;
            }
            direita--;

            for (int j = direita; j >= esquerda; j--) {
                matrix[base][j] = num;
                num++;
            }
            base--;

            for (int j = base; j >= topo; j--){
                matrix[j][esquerda] = num;
                num++;
            }
            esquerda++;
        }

        return matrix;
    }
}
/*
class SpiralMatrixBuilder {

    int[][] buildMatrixOfSize(int size) {
        int[][] matrix = new int[size][size];

        int firstRow = 0;
        int lastRow = size - 1;
        int firstColumn = 0;
        int lastColumn = size - 1;
        int value = 1;

        while (firstRow <= lastRow && firstColumn <= lastColumn) {

            for (int column = firstColumn; column <= lastColumn; column++) {
                matrix[firstRow][column] = value++;
            }
            firstRow++;

            for (int row = firstRow; row <= lastRow; row++) {matrix[row][lastColumn] = value++;
            }
            lastColumn--;

            if (firstRow <= lastRow) {
                for (int column = lastColumn; column >= firstColumn; column--) {
                    matrix[lastRow][column] = value++;
                }
                lastRow--;
            }

            if (firstColumn <= lastColumn) {
                for (int row = lastRow; row >= firstRow; row--) {
                    matrix[row][firstColumn] = value++;
                }
                firstColumn++;
            }
        }

        return matrix;
    }
}

*/
