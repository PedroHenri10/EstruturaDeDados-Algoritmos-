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
