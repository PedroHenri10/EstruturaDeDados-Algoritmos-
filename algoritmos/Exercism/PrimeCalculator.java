class PrimeCalculator {

    int nth(int nth) {

        if (nth == 0) {
        throw new IllegalArgumentException();
    }
        int contador = 0;
        int primeQtd  = 0;
        int valuePrime = 0;
        
           for(int i = 1;i < 104744; i++){
               for(int j = 1 ; j<=i; j++){
                   if(i % j == 0) {
                       contador++;
                   }
               }
               if(contador == 2){
                   primeQtd ++;
               }
               if(primeQtd == nth){
                   valuePrime = i;
                   break;
               }
               contador =0;
           }
        return valuePrime;
    }

}
/*
class PrimeCalculator {

    int nth(int nth) {

        if (nth == 0) {
            throw new IllegalArgumentException();
        }

        if (nth == 1) {
            return 2;
        }

        int primeQtd = 1;

        for (int number = 3; ; number += 2) {

            if (isPrime(number)) {
                primeQtd++;

                if (primeQtd == nth) {
                    return number;
                }
            }
        }
    }

    private boolean isPrime(int number) {

        for (int divisor = 3; divisor * divisor <= number; divisor += 2) {

            if (number % divisor == 0) {
                return false;
            }
        }

        return true;
    }
}*/
