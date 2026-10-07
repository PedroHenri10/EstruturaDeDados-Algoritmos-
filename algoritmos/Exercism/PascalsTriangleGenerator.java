class PascalsTriangleGenerator {

    int[][] generateTriangle(int rows) {
        int[][] matriz = new int[rows][];

        for (int i = 0; i < rows; i++) {
            matriz[i] = new int[i + 1];

            for (int j = 0; j < i + 1; j++) {
                if(j == 0 || j == i){
                    matriz[i][j] = 1;
                }else{
                    matriz[i][j] = matriz[i - 1][j - 1] + matriz[i - 1][j];
                }
            }
        }
        return matriz;
    }
}
/*
class PascalsTriangleGenerator {

    int[][] generateTriangle(int rows) {
        int[][] triangle = new int[rows][];

        for (int row = 0; row < rows; row++) {
            triangle[row] = new int[row + 1];

            triangle[row][0] = 1;
            triangle[row][row] = 1;

            for (int column = 1; column < row; column++) {
                triangle[row][column] =
                        triangle[row - 1][column - 1]
                        + triangle[row - 1][column];
            }
        }

        return triangle;
    }
}
*/
