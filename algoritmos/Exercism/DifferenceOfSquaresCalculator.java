class DifferenceOfSquaresCalculator {

    int computeSquareOfSumTo(int input) {
        int soma = 0;
        for(int i = 1; i<= input; i++){
            soma += i;
        }

        return soma * soma;
    }

    int computeSumOfSquaresTo(int input) {
        int soma = 0;
        for(int i = 1; i<= input; i++){
            soma += i*i;
        }
        return soma;
    }

    int computeDifferenceOfSquares(int input) {
        int squareOfSum = computeSquareOfSumTo(input);
        int sumOfSquares = computeSumOfSquaresTo(input);

        return (squareOfSum) - (sumOfSquares);
    }

}
