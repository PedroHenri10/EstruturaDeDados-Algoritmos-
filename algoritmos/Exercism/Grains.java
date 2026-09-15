import java.math.BigInteger;

class Grains {

    BigInteger grainsOnSquare(final int square) {

        if (square < 1 || square > 64) {
            throw new IllegalArgumentException("square must be between 1 and 64");
        }
        
        BigInteger grainsOnSquare = BigInteger.valueOf(2);

        return grainsOnSquare.pow(square - 1);
    }

    BigInteger grainsOnBoard() {
        BigInteger soma = BigInteger.valueOf(0);

        for(int i= 0; i<64; i++ ){
            soma = soma.add(BigInteger.valueOf(2).pow(i));
        }

        return soma;
    }

}
